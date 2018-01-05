package com.herokuapp.theinternet.domain.builder;

import com.herokuapp.theinternet.domain.TheInternetCredentials;
import com.herokuapp.theinternet.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.google.common.base.MoreObjects.firstNonNull;

@Component
public class UserBuilder {

    @Autowired
    private TheInternetCredentialsBuilder theInternetCredentialsBuilder;

    private TheInternetCredentials theInternetCredentials;
    private User.Examples examples = User.Examples.DROPDOWN;

    public User build() {
        User user = new User(firstNonNull(theInternetCredentials, theInternetCredentialsBuilder.build()));
        user.setExamples(examples);
        return user;
    }

}
