package org.xrave.service;


import org.springframework.security.core.userdetails.UserDetailsService;
import org.xrave.model.User;

public interface UserService extends UserDetailsService {
    void create(User usr);
    Iterable<User> getAllUsers();
    void update(User usr);
    void delete(User usr);
}
