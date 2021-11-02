package com.bridgelabz.greetingappdevelopment.controller;

import java.util.List;
import com.bridgelabz.greetingappdevelopment.model.Greeting;
import com.bridgelabz.greetingappdevelopment.model.User;
import com.bridgelabz.greetingappdevelopment.service.IGreetingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @Autowired
    private IGreetingService greetingService;

    @PostMapping(value = { "", "/", "/add" })
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        User user = new User();
        user.setFirstName(name);
        return greetingService.addGreeting(user);
    }

    @GetMapping(value = { "/greetingid" })
    public Greeting getGreetingByID(@RequestParam(value = "id", defaultValue = "World") long id) {

        return greetingService.getGreetingById(id);
    }

    @GetMapping("/greetinglist")
    public List<Greeting> getGreetingList() {
        return greetingService.getGreetingList();
    }

    @PutMapping("/update/{name1}/{name2}")
    public Greeting editGreeting(@PathVariable String name1, @PathVariable String name2) {

        return greetingService.editGreeting(name1, name2);
    }

    @DeleteMapping("/delete/{name}")
    public List<Greeting> deleteGreeting(@PathVariable String name) {

        return greetingService.deleteGreeting(name);
    }

}
