package com.bridgelabz.greetingappdevelopment.service;

import java.util.List;

import com.bridgelabz.greetingappdevelopment.model.Greeting;
import com.bridgelabz.greetingappdevelopment.model.User;

public interface IGreetingService {
    Greeting addGreeting(User user);

    Greeting getGreetingById(long id);

    List<Greeting> getGreetingList();

    Greeting editGreeting(String name1, String name2);

}