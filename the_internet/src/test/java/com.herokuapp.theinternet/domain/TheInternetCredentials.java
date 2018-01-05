package com.herokuapp.theinternet.domain;

import lombok.Value;

@Value
public class TheInternetCredentials {

    private String username;
    private String password;

    public TheInternetCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
