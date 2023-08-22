package com.example.TodoListBack.services.auth;

import com.example.TodoListBack.dto.SignupDTO;
import com.example.TodoListBack.dto.UserDTO;


public interface AuthService {
    UserDTO createUser(SignupDTO signupDTO);
}
