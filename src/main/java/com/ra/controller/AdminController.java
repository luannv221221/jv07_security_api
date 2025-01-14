package com.ra.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin/")
public class AdminController {
    @GetMapping("/accounts")
    public ResponseEntity<?> account(){
        return new ResponseEntity<>("Trang quan ly tai khoan", HttpStatus.OK);
    }
    @GetMapping("/blogs")
    public ResponseEntity<?> blog(){
        return new ResponseEntity<>("Trang quan ly baif viet", HttpStatus.OK);
    }
}
