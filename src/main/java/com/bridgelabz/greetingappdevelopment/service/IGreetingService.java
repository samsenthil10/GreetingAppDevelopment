package com.bridgelabz.greetingappdevelopment.service;

import java.util.List;

import com.bridgelabz.greetingappdevelopment.model.Greeting;
import com.bridgelabz.greetingappdevelopment.model.User;

import org.springframework.stereotype.Service;

@Service
public interface IGreetingService {
    Greeting addGreeting(User user);

    Greeting getGreetingById(long id);

    List<Greeting> getAllGreetings();
}
