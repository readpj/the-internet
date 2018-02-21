package com.herokuapp.theinternet.steps;

import com.herokuapp.theinternet.domain.CurrentUser;
import com.herokuapp.theinternet.domain.User;
import com.herokuapp.theinternet.pages.Pages;
import cucumber.api.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;

public class TheInternetPreConditions {

    @Autowired
    private Pages pages;

    @Autowired
    private CurrentUser currentUser;

    @Given("^I want to test the drop down page$")
    public void iWantToTestTheDropDownPage() throws Throwable {
        currentUser.get().setExamples(User.Examples.DROPDOWN);
    }

    @Given("^I want to test form authentication$")
    public void iWantToTestFormAuthentication() throws Throwable {
        currentUser.get().setExamples(User.Examples.FORM_AUTHENTICATION);
    }

    @Given("^I want to test data tables$")
    public void iWantToTestDataTables() throws Throwable {
        currentUser.get().setExamples(User.Examples.DATA_TABLES);
    }

    @Given("^I want to test forgot password$")
    public void iWantToTestForgotPassword() throws Throwable {
        currentUser.get().setExamples(User.Examples.FORGOT_PASSWORD);
    }
}
