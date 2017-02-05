package com.yayiktereyagi.www.yayiktereyagi.model;

/**
 * Created by WİN8.1 on 2/5/2017.
 */

public class User {
    public String username;
    public String email;
    String Uid;
    String phoneNumber;
    String password;
    String companyPostalAddress;

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }
}
