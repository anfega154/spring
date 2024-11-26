package com.anfega.spring.controllers;

import com.anfega.spring.models.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
@Validated
public class BookController {

    private final ObjectMapper objectMapper = new ObjectMapper();
    @PostMapping("/book")
    public String createBook(@Valid @RequestBody Book book) {
        try {
            return objectMapper.writeValueAsString(book);
        } catch (Exception e) {
            return "Error converting to JSON";
        }
    }
}
