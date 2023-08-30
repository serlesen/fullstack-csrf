package com.sergio.csrf.backend.services;

import com.sergio.csrf.backend.dtos.SignInDto;
import com.sergio.csrf.backend.dtos.UserDto;
import com.sergio.csrf.backend.exceptions.AppException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;

@RequiredArgsConstructor
@Service
public class AuthService {

    private final PasswordEncoder passwordEncoder;
    private static final String HASHED_PASSWORD = "$2a$10$I6li6W7Tli6KVv5535YlHe.CeG.YuEW3VPwMogylpxWxKsYt5OaGq"; // password

    public UserDto signIn(SignInDto signInDto) {
        if (passwordEncoder.matches(CharBuffer.wrap(signInDto.password()), HASHED_PASSWORD)) {
            return new UserDto(1L, "login", "Sergio");
        }
        throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);
    }

}
