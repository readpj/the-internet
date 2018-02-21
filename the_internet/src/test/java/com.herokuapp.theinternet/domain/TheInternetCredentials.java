package com.herokuapp.theinternet.domain;

import lombok.Value;

@Value
public class TheInternetCredentials {

    private String username;
    private String password;
    private String email;

    public TheInternetCredentials(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
