package com.example.atmmachine.utils;

import com.example.atmmachine.models.Customer;

public class Session {
    private static Customer loggedInUser;

    public static void setLoggedInUser(Customer user) {
        loggedInUser = user;
    }

    public static Customer getLoggedInUser() {
        return loggedInUser;
    }
}
