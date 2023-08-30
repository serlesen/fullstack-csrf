package com.sergio.csrf.backend.services;

import com.sergio.csrf.backend.dtos.ContentDto;
import com.sergio.csrf.backend.dtos.UserDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContentService {

    private final List<String> messages = new ArrayList<>();

    public ContentDto getContent(UserDto user) {
        return new ContentDto("Hi " + user.getName());
    }

    public List<ContentDto> getMessages() {
        return messages.stream()
                .map(ContentDto::new)
                .toList();
    }

    public ContentDto addMessage(String message) {
        messages.add(message);
        return new ContentDto(message);
    }
}
