package org.xrave.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.xrave.repository.UserRepository;
import org.xrave.model.User;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userDao;
    @Override
    public void create(User usr) {
        userDao.save(usr);
    }

    @Override
    public Iterable<User> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    public void update(User usr) {
        userDao.save(usr);
    }

    @Override
    public void delete(User usr) {
        userDao.delete(usr);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDao.findByName(username);
    }
}
