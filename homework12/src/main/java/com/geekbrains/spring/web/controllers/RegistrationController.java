package com.geekbrains.spring.web.controllers;

import com.geekbrains.spring.web.converters.UserConverter;
import com.geekbrains.spring.web.dto.UserDto;
import com.geekbrains.spring.web.entities.User;
import com.geekbrains.spring.web.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class RegistrationController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final UserConverter userConverter;

    @PostMapping("/registration")
    public UserDto registerNewUser(@RequestBody UserDto registeredUserDto) {
        String hashedPassword = passwordEncoder.encode(registeredUserDto.getPassword());
        UserDto registeredUserDtoWithHashedPassword = new UserDto(null, registeredUserDto.getUsername(), hashedPassword, registeredUserDto.getEmail());
        User newUser = userConverter.dtoToEntity(registeredUserDtoWithHashedPassword);
        userService.saveUser(newUser);
        return userConverter.entityToDto(userService.saveUser(newUser));
    }
}
