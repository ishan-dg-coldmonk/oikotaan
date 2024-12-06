package com.example.backend.model;

public class User {
    private String email;
    private String type;
    private String name;
    private String phoneNumber;
    private String city;
    private String members;
    private String accommodationRequired;
    private String videoLink;
    private String lyricsLink;

    public User() {}

    public User(String email, String type, String name, String phoneNumber, String city, String members,
                String accommodationRequired, String videoLink, String lyricsLink) {
        this.email = email;
        this.type = type;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.members = members;
        this.accommodationRequired = accommodationRequired;
        this.videoLink = videoLink;
        this.lyricsLink = lyricsLink;
    }

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

    public String getMembers() {
        return members;
    }

    public void setMembers(String members) {
        this.members = members;
    }

    public String getAccommodationRequired() {
        return accommodationRequired;
    }

    public void setAccommodationRequired(String accommodationRequired) {
        this.accommodationRequired = accommodationRequired;
    }

    public String getVideoLink() {
        return videoLink;
    }

    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink;
    }

    public String getLyricsLink() {
        return lyricsLink;
    }

    public void setLyricsLink(String lyricsLink) {
        this.lyricsLink = lyricsLink;
    }
}
