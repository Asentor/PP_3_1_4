package org.xrave.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.xrave.repository.UserRepository;
import org.xrave.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    final UserRepository userDao;
    final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void createUser(User usr) {
        usr.setPassword(passwordEncoder.encode(usr.getPassword()));
        userDao.save(usr);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    public void updateUser(User usr) {
        if(! usr.getPassword().equals(userDao.findById(usr.getId()).get().getPassword())) {
            usr.setPassword(passwordEncoder.encode(usr.getPassword()));
        }
        userDao.save(usr);
    }

    @Override
    public void deleteUser(User usr) {
        userDao.delete(usr);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //return userDao.findByName(username);
        return userDao.findByEmail(username);
    }

}
