package io.github.vchu22.family_and_pets_health_tracker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping(path = "/")
    public String home() {
        return "Hello, welcome to Family and Pets Health Tracker! This is the backend for a full-stack application " +
                "to help you record the health conditions of your family and pets.";
    }
}
