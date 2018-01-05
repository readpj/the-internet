package com.herokuapp.theinternet.steps;

import com.herokuapp.theinternet.pages.Pages;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TheInternetAssertions {

    @Autowired
    private Pages pages;


    @Then("^the drop down page is displayed$")
    public void theDropDownPageIsDisplayed() throws Throwable {
    pages.dropDownPage();
    }

    @Then("^I can successfully login$")
    public void iCanSuccessfullyLogin() throws Throwable {
        assertThat("Unsuccessful login", pages.formAuthenticationPage().getSuccessfulLoginText(),
                is("Welcome to the Secure Area. When you are done click logout below."));
    }
}
