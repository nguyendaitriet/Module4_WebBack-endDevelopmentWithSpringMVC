package com.tr.demo.model;

import java.util.List;

public class User {
    private int id;
    private String name;
    private String gender;
    private boolean admin;
    private String country;
    private String type;
    private List<String> hobbies;

    public User() {
    }

    public User(int id, String name, String gender, boolean admin, String country, String type, List<String> hobbies) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.admin = admin;
        this.country = country;
        this.type = type;
        this.hobbies = hobbies;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }
}
