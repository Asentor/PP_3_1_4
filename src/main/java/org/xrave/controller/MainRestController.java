package org.xrave.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xrave.model.User;
import org.xrave.service.UserService;

import java.util.List;

@RestController
public class MainRestController {
    final UserService userService;

    public MainRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/userlist")
    public List<User> getUsersList(){
        return userService.getAllUsers();
    }
}
