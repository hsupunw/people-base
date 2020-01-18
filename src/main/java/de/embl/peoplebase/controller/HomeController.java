package de.embl.peoplebase.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {
    @GetMapping
    public Message home() {
        return new Message("Welcome People Base");
    }

    @Data
    @AllArgsConstructor
    private static class Message {
        private String message;
    }

}
