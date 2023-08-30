package com.sergio.csrf.backend.dtos;

public record SignUpDto(String login, char[] password, String name) {
}
