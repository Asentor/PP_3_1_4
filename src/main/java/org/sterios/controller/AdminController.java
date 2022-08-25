package org.sterios.controller;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.sterios.model.User;
import org.sterios.service.RoleService;
import org.sterios.service.UserService;

@Controller
public class AdminController {

    final UserService userService;
    final RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/admin")
    @Secured("ADMIN")
    public String getAdminPage(ModelMap model,@RequestParam(required = false) String error) {
        model.addAttribute("usersList", userService.getAllUsers());
        model.addAttribute("userModel", new User());
        model.addAttribute("isAdmin", true);
        model.addAttribute("roles", roleService.getAllRoles());
        model.addAttribute("error", error);
        return "indexajax";
    }
    @PostMapping("/addUser")
    public String addUser(@ModelAttribute User usr, @RequestParam(required = false, value = "roles") Long[] roles) {
        usr.setRoles(roleService.getRolesByIdArr(roles));
        try {
            userService.createUser(usr);
        } catch (DataIntegrityViolationException e) {
            return ("redirect:/admin?error='user with email "+usr.getEmail()+" exists'");
        }
        return "redirect:/admin";
    }

    @PostMapping("/delete")
    public String deleteUser(@ModelAttribute User usr) {
        userService.deleteUser(usr);
        return "redirect:/admin";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute User usr, @RequestParam(required = false, value = "roles") Long[] roles) {
        usr.setRoles(roleService.getRolesByIdArr(roles));
        userService.updateUser(usr);
        return "redirect:/admin";
    }

}
