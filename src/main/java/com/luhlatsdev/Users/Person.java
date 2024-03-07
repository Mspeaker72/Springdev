package com.luhlatsdev.Users;

public class Person {

    private String Password;
    private String name;

    private String email;

    public Person(String name, String Password,String email){
        this.name = name;
        this.Password = Password;
        this.email = email;

    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return Password;
    }
}
