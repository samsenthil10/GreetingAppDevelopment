package com.bridgelabz.greetingappdevelopment.service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.bridgelabz.greetingappdevelopment.model.Greeting;
import com.bridgelabz.greetingappdevelopment.model.User;
import com.bridgelabz.greetingappdevelopment.repository.GreetingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService implements IGreetingService {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private GreetingRepository greetingRepository;

    @Override
    public Greeting addGreeting(User user) {
        String message = String.format(template, (user.toString().isEmpty()) ? "Hello world" : user.toString());
        return greetingRepository.save(new Greeting(counter.incrementAndGet(), message));
    }

    @Override
    public Greeting getGreetingById(long id) {

        return greetingRepository.findById(id).get();
    }

    @Override
    public List<Greeting> getGreetingList() {
        return greetingRepository.findAll();

    }

    @Override
    public Greeting editGreeting(String name1, String name2) {
        List<Greeting> greetingList = greetingRepository.findAll();
        Greeting greetingToEdit = null;
        for (int index = 0; index < greetingList.size(); index++) {
            if (greetingList.get(index).getMessage().contains(name1)) {
                greetingToEdit = greetingList.get(index);
                break;
            }
        }
        String message = String.format(template, (name2.isEmpty()) ? "Hello world" : name2);
        greetingToEdit.setMessage(message);
        return greetingRepository.save(greetingToEdit);

    }

    @Override
    public List<Greeting> deleteGreeting(String name) {
        List<Greeting> greetingList = greetingRepository.findAll();
        Greeting greetingToDelete = null;
        for (int index = 0; index < greetingList.size(); index++) {
            if (greetingList.get(index).getMessage().contains(name)) {
                greetingToDelete = greetingList.get(index);
                break;
            }
        }

        greetingRepository.delete(greetingToDelete);
        return getGreetingList();
    }

}
