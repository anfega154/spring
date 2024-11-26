package com.anfega.spring;

import com.anfega.spring.models.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.Enumeration;
import java.util.Map;

@RestController
public class Routes {

    private final ObjectMapper objectMapper = new ObjectMapper();


    @GetMapping("/")
    public String index() {
        return "Hello World!";
    }

    @GetMapping("/book/{id}")
    public String readBook(@PathVariable String id) {
        return "Reading book with id " + id;
    }


    @GetMapping("/book2/{id}")
    public String readBookPage(@PathVariable String id, HttpServletRequest request) {
        StringBuilder params = new StringBuilder();
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            String paramValue = request.getParameter(paramName);
            params.append(paramName).append("=").append(paramValue).append(" ");
        }
        return "Reading book with id " + id + " and params " + params.toString();
    }
}
