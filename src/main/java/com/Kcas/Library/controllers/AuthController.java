package com.Kcas.Library.controllers;

import com.Kcas.Library.dtos.CredentialsDto;
import com.Kcas.Library.dtos.SignUpDto;
import com.Kcas.Library.dtos.UserDto;
import com.Kcas.Library.security.config.UserAuthProvider;
import com.Kcas.Library.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserService userService;
    private final UserAuthProvider userAuthProvider;

    @GetMapping("/")
    public String home(){
        return "ok";
    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody @Valid CredentialsDto credentialsDto){
       UserDto user = userService.login(credentialsDto);
       user.setToken(userAuthProvider.createToken(user.getEmail()));
       return ResponseEntity.ok(user);
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody @Valid SignUpDto signUpDto){
        UserDto createdUser = userService.register(signUpDto);
        createdUser.setToken(userAuthProvider.createToken(createdUser.getEmail()));
        return ResponseEntity.created(URI.create("/api/users/"+createdUser.getId()))
                .body(createdUser);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@AuthenticationPrincipal UserDto userDto){
        userAuthProvider.addTokenToBlackList(userDto.getToken());
        return new ResponseEntity<>("Logged out",
                HttpStatus.OK);
    }

}
