package org.xrave.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.xrave.model.User;
import org.xrave.service.RoleService;
import org.xrave.service.UserService;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;

    @GetMapping("/admin")
    @Secured("ADMIN")
    public String adminPage(ModelMap model) {
        model.addAttribute("usersList",userService.getAllUsers());
        model.addAttribute("userModel",new User());
        model.addAttribute("isAdmin",true);
        model.addAttribute("roles", roleService.getAllRoles());
        return "adminPage";
    }
    @PostMapping("/addUser")
    public  String addUser(@ModelAttribute User usr, @RequestParam(required=false, value = "roles") List<Long> roles) {
        usr.setRoles(roleService.getRolesByIdList(roles));
        userService.create(usr);
        return "redirect:/admin";
    }
    @PostMapping("/delete")
    public  String deleteUser(@ModelAttribute User usr) {
        userService.delete(usr);
        return "redirect:/admin";
    }
    @PostMapping("/update")
    public  String updateUser(@ModelAttribute User usr, @RequestParam(required=false, value = "roles") List<Long> roles) {
        usr.setRoles(roleService.getRolesByIdList(roles));
        userService.update(usr);
        return "redirect:/admin";
    }
    @GetMapping("/user")
    public  String userPage(){
        return "userPage";
    }

}
