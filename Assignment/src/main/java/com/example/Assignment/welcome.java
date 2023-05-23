package com.example.Assignment;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class welcome {

    @GetMapping("/")
    public String welcome(

        @RequestParam(value = "name",
        defaultValue = "World") String name) {
            return String.format("Hello %s!", name);
    }


}
