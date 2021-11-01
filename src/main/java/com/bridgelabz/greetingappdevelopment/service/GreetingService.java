package com.bridgelabz.greetingappdevelopment.service;

import java.util.concurrent.atomic.AtomicLong;

import com.bridgelabz.greetingappdevelopment.model.Greeting;
import com.bridgelabz.greetingappdevelopment.model.User;
import org.springframework.stereotype.Service;

@Service
public class GreetingService implements IGreetingService {

    private static String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Override
    public Greeting addGreeting(User user) {
        String message = String.format(template, (user.toString().isEmpty()) ? "Hello World" : user.toString());
        return new Greeting(counter.incrementAndGet(), message);
    }

    @Override
    public Greeting getGreetingById(long id) {
        return null;
    }
}
