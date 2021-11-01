package com.bridgelabz.greetingappdevelopment.service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.bridgelabz.greetingappdevelopment.model.Greeting;
import com.bridgelabz.greetingappdevelopment.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bridgelabz.greetingappdevelopment.repository.GreetingRepository;

@Service
public class GreetingService implements IGreetingService {

    private static String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private GreetingRepository greetingRepository;

    @Override
    public Greeting addGreeting(User user) {
        String message = String.format(template, (user.toString().isEmpty()) ? "Hello World" : user.toString());
        return greetingRepository.save(new Greeting(counter.incrementAndGet(), message));
    }

    @Override
    public Greeting getGreetingById(long id) {
        return greetingRepository.getById(id);
    }

    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }
}
