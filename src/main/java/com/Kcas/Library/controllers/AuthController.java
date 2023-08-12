package com.Kcas.Library.controllers;

import com.Kcas.Library.dtos.CredentialsDto;
import com.Kcas.Library.dtos.SignUpDto;
import com.Kcas.Library.dtos.UserDto;
import com.Kcas.Library.security.config.UserAuthProvider;
import com.Kcas.Library.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RequiredArgsConstructor
@RestController
public class AuthController {
    private final UserService userService;
    private final UserAuthProvider userAuthProvider;

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody CredentialsDto credentialsDto){
       UserDto user = userService.login(credentialsDto);
       user.setToken(userAuthProvider.createToken(user.getEmail()));
       return ResponseEntity.ok(user);
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody SignUpDto signUpDto){
        UserDto user = userService.register(signUpDto);
        user.setToken(userAuthProvider.createToken(user.getEmail()));
        return ResponseEntity.created(URI.create("/api/users/"+user.getId()))
                .body(user);
    }


}
