package com.bridgelabz.greetingappdevelopment.controller;

import java.util.concurrent.atomic.AtomicLong;

import com.bridgelabz.greetingappdevelopment.model.User;
import com.bridgelabz.greetingappdevelopment.service.IGreetingService;
import com.bridgelabz.greetingappdevelopment.model.Greeting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class GreetingController {

    private static String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private IGreetingService greetingService;

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "firstName", defaultValue = "") String firstName,
            @RequestParam(value = "lastName", defaultValue = "") String lastName) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        return greetingService.addGreeting(user);
    }

    @GetMapping("/get/{id}")
    public String getMessageById(@PathVariable Long id) {
        return greetingService.getGreetingById(id).getMessage();
    }

    @PostMapping("/post")
    public Greeting setUser(@RequestBody Greeting greeting) {
        return new Greeting(counter.incrementAndGet(), String.format(template, greeting.getMessage()));
    }

    @PutMapping("/put/{firstName}")
    public Greeting sayHelloPutMethod(@PathVariable String firstName,
            @RequestParam(value = "lastName", defaultValue = "S A") String lastName) {
        return new Greeting(counter.incrementAndGet(), String.format(template, firstName + " " + lastName));
    }

    @GetMapping("/getAll")
    public List<Greeting> getMessages() {
        return greetingService.getAllGreetings();
    }
}