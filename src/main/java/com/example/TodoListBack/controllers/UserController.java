package com.example.TodoListBack.controllers;

import com.example.TodoListBack.entities.Task;
import com.example.TodoListBack.entities.User;
import com.example.TodoListBack.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{email}")
    public ResponseEntity<User> getUserById(@PathVariable String email) {


            User user = userService.getUserByEmail(email);
            return new ResponseEntity<>(user,HttpStatus.OK);


    }
}
