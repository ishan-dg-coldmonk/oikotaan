package com.example.backend.model;

public class User {
    private String email;
    private String type;
    private String name;
    private String leaderName;
    private String phoneNumber;
    private String city;
    private String details;
    private String accommodationRequired;
    private String driveLink;

    public User() {}

    public User(String email, String type, String name, String leaderName, String phoneNumber, String city,
                String details, String accommodationRequired, String driveLink) {
        this.email = email;
        this.type = type;
        this.name = name;
        this.leaderName = leaderName;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.details = details;
        this.accommodationRequired = accommodationRequired;
        this.driveLink = driveLink;
    }

    // Getters and Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getAccommodationRequired() {
        return accommodationRequired;
    }

    public void setAccommodationRequired(String accommodationRequired) {
        this.accommodationRequired = accommodationRequired;
    }

    public String getDriveLink() {
        return driveLink;
    }

    public void setDriveLink(String driveLink) {
        this.driveLink = driveLink;
    }
}
