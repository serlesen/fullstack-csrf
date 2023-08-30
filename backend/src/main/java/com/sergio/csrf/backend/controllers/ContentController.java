package com.sergio.csrf.backend.controllers;

import com.sergio.csrf.backend.dtos.ContentDto;
import com.sergio.csrf.backend.dtos.UserDto;
import com.sergio.csrf.backend.services.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ContentController {

    private final ContentService contentService;

    @GetMapping("/content")
    public ResponseEntity<ContentDto> getContent(@AuthenticationPrincipal UserDto user) {
        return ResponseEntity.ok(contentService.getContent(user));
    }

    @GetMapping("/messages")
    public ResponseEntity<List<ContentDto>> messages() {
        return ResponseEntity.ok(contentService.getMessages());
    }

    @PostMapping("/messages")
    public ResponseEntity<ContentDto> addMessage(@RequestBody ContentDto message) {
        return ResponseEntity.ok(contentService.addMessage(message.message()));
    }
}
