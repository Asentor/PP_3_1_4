package org.xrave.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.xrave.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    void createUser(User usr);

    List<User> getAllUsers();

    void updateUser(User usr);

    void deleteUser(User usr);
}
