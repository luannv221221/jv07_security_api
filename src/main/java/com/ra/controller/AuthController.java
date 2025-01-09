package com.ra.controller;

import com.ra.model.User;
import com.ra.model.dto.UserLoginRequestDTO;
import com.ra.model.dto.UserLoginResponse;
import com.ra.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    private AuthService authService;
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginRequestDTO requestDTO){
        UserLoginResponse userLoginResponse = authService.login(requestDTO);
        return new ResponseEntity<>(userLoginResponse, HttpStatus.OK);
    }
}
