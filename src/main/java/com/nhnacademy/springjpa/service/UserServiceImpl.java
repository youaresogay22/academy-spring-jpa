package com.nhnacademy.springjpa.service;

import com.nhnacademy.springjpa.domain.User;
import com.nhnacademy.springjpa.exception.UserModifyFailedException;
import com.nhnacademy.springjpa.exception.UserRegisterFailedException;
import com.nhnacademy.springjpa.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUser(String id) {
        return userRepository.getUser(id);
    }

    @Transactional
    @Override
    public User createUser(String id, String password) {
        if (!userRepository.addUser(id, password)) {
            throw new UserRegisterFailedException();
        }

        return userRepository.getUser(id);
    }

    @Transactional
    @Override
    public User modifyUser(User user) {
        if (!userRepository.modifyUser(user.getId(), user.getPassword())) {
            throw new UserModifyFailedException();
        }

        return userRepository.getUser(user.getId());
    }

}
