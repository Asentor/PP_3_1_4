package org.xrave.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.xrave.model.Role;
import org.xrave.model.User;
import org.xrave.service.RoleService;
import org.xrave.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MainRestController {
    final UserService userService;
    final RoleService roleService;

    public MainRestController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/userlist")
    public List<User> getUsersList(){
        return userService.getAllUsers();
    }
    @GetMapping("/rolelist")
    public List<Role> getRolesList(){
        return roleService.getAllRoles();
    }
    @PostMapping("/addUser")
    public ResponseEntity<User> createUser(@RequestBody User user){
        userService.createUser(user);
        return new ResponseEntity(user, HttpStatus.CREATED);
    }
    @PutMapping("/editUser")
    public ResponseEntity<User> editUser(@RequestBody User user){
        userService.updateUser(user);
        return new ResponseEntity(user, HttpStatus.OK);
    }
    @DeleteMapping("/deleteUser")
    public ResponseEntity<String> deleteUser(@RequestBody User user){
        userService.deleteUser(user);
        return  new ResponseEntity("User deleted", HttpStatus.OK);
    }
}
