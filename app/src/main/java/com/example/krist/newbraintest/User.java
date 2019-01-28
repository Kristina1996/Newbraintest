package com.example.krist.newbraintest;

/**
 * Created by krist on 04.06.2018.
 */

public class User {

    private String LoginName;
    private String Name;
    private String Surname;
    private String Password;

    public User(){

    }

    public User(String name, String surname, String password){
        Name = name;
        Surname = surname;
        Password = password;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
