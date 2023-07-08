package com.electronicsshop.controllers;

import com.electronicsshop.dto.UserRequest;
import com.electronicsshop.dto.UserResponse;
import com.electronicsshop.services.IUserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

    protected final IUserService userService;

    @PostMapping("/sign-up")
    public void saveUser(@Valid @RequestBody UserRequest userDto){
        userService.save(userDto);
    }

    @GetMapping("/getAllUsers")
    public List<UserResponse> getAllUsers(){
        return userService.getAllUsers();
    }
}
