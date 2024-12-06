package com.example.backend.service;

import com.example.backend.model.User;
import com.example.backend.repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RegisterService {

    @Autowired
    private RegisterRepository registerRepository;

    @Autowired
    private EmailService emailService;

    public String register(User user) throws Exception {
        validateUser(user);

        String existingRegId = registerRepository.findRegIdByEmail(user.getEmail());
        if (existingRegId != null) {
            registerRepository.updateUser(user, existingRegId);
            return "Updated successfully with existing Reg ID: " + existingRegId;
        }
        else {
            String regId = generateRegId();
            LocalDateTime timestamp = LocalDateTime.now();
            registerRepository.saveUser(user, regId, timestamp);

            emailService.sendRegistrationEmail(user.getEmail(), regId, user.getName());

            return "Registered successfully with new Reg ID: " + regId;
        }
    }

    private void validateUser(User user) throws Exception {
        if (user.getEmail() == null || user.getEmail().isEmpty() || !user.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new Exception("Invalid email");
        }
        if (user.getType() == null || user.getType().isEmpty()) {
            throw new Exception("You need to specify whether you are a band or an individual");
        }
        if (user.getName() == null || user.getName().isEmpty()) {
            throw new Exception("Name cannot be empty");
        }
        if (user.getPhoneNumber() == null || !user.getPhoneNumber().matches("\\d{10}")) {
            throw new Exception("Invalid phone number");
        }
        if (user.getCity() == null || user.getCity().isEmpty()) {
            throw new Exception("City cannot be empty");
        }
        if (user.getMembers() == null || user.getMembers().isEmpty()) {
            throw new Exception("Members List cannot be empty");
        }
        if (user.getAccommodationRequired() == null || (!user.getAccommodationRequired().equalsIgnoreCase("yes")
                && !user.getAccommodationRequired().equalsIgnoreCase("no"))) {
            throw new Exception("You need to specify whether you need accommodation");
        }
        if (user.getVideoLink() == null || user.getVideoLink().isEmpty()) {
            throw new Exception("No video link entered");
        }
        if (user.getLyricsLink() == null || user.getLyricsLink().isEmpty()) {
            throw new Exception("No lyrics link entered");
        }
    }

    private String generateRegId() {
        int currentCount = registerRepository.getUserCount();
        return String.format("2025O7%03d", currentCount + 1);
    }
}
