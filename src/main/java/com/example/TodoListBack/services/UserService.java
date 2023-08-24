package com.example.TodoListBack.services;

import com.example.TodoListBack.entities.Task;
import com.example.TodoListBack.entities.User;
import com.example.TodoListBack.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUserByEmail(String email) {
        return userRepository.findFirstByEmail(email);
    }
}
