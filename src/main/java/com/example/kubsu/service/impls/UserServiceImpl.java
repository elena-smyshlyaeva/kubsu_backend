package com.example.kubsu.service.impls;

import com.example.kubsu.model.User;
import com.example.kubsu.repository.UserRepository;
import com.example.kubsu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }
}
