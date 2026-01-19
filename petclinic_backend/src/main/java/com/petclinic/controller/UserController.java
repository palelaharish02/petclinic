package com.petclinic.controller;

import com.petclinic.dto.UserResponse;
import com.petclinic.service.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/me")
    public UserResponse getLoggedInUser() {
        return userService.getLoggedInUser();
    }
}
