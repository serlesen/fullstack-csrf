package com.sergio.csrf.backend.controllers;

import com.sergio.csrf.backend.dtos.SignInDto;
import com.sergio.csrf.backend.dtos.UserDto;
import com.sergio.csrf.backend.services.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RequiredArgsConstructor
@RestController
public class AuthController {

    private final AuthService authService;
    private final SecurityContextRepository securityContextRepository = new HttpSessionSecurityContextRepository();

    @PostMapping("/signIn")
    public ResponseEntity<UserDto> signIn(@RequestBody SignInDto signInDto, HttpServletRequest request, HttpServletResponse response) {
        UserDto userDto = authService.signIn(signInDto);

        SecurityContext context = SecurityContextHolder.getContext();
        context.setAuthentication(new UsernamePasswordAuthenticationToken(userDto, null, Collections.emptyList()));
        securityContextRepository.saveContext(context, request, response);

        return ResponseEntity.ok(userDto);
    }

    @PostMapping("/signOut")
    public ResponseEntity<Void> signOut() {
        SecurityContextHolder.clearContext();
        return ResponseEntity.noContent().build();
    }
}
