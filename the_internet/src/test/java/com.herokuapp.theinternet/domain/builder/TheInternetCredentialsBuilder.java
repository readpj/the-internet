package com.herokuapp.theinternet.domain.builder;

import com.herokuapp.theinternet.domain.TheInternetCredentials;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component

public class TheInternetCredentialsBuilder {

    public TheInternetCredentials build() {
        return new TheInternetCredentials(username, password);
    }

    @Value("${valid.user.username}")
    private String username;

    @Value("${valid.user.password}")
    private String password;
}
