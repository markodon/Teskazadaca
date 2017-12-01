package com.example.markodonovski.teskazadaca;

import java.io.Serializable;

/**
 * Created by markodonovski on 11/25/17.
 */

public class User implements Serializable {
    String name;
    String lastname;
    String username;
    char gender;

    public User(String name, String lastname, String username, char gender) {
        this.name = name;
        this.lastname = lastname;
        this.username = username;
        this.gender = gender;
    }



    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getUsername() {
        return username;
    }

    public char getGender() {
        return gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    @Override
    public String toString(){
        return this.username;

    }

}
