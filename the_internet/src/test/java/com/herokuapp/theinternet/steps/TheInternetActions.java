package com.herokuapp.theinternet.steps;

import com.herokuapp.theinternet.domain.CurrentUser;
import com.herokuapp.theinternet.domain.TheInternetCredentials;
import com.herokuapp.theinternet.domain.User;
import com.herokuapp.theinternet.pages.Pages;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class TheInternetActions {

    @Autowired
    private CurrentUser currentUser;

    @Autowired
    private Pages pages;

    @When("^I test form authentication$")
    public void iTestFormAuthentication() throws Throwable {
        selectAvailableExamples();
        TheInternetCredentials theInternetCredentials = currentUser.get().getTheInternetCredentials();
        pages.formAuthenticationPage().enterUsername(theInternetCredentials.getUsername());
        pages.formAuthenticationPage().enterPassword(theInternetCredentials.getPassword());
        pages.formAuthenticationPage().clickLoginButton();
    }

    private void selectAvailableExamples() {
        if (currentUser.get().getExamples() == User.Examples.FORM_AUTHENTICATION) {
            pages.indexPage().clickFormAuthentication();
        }
        if (currentUser.get().getExamples() == User.Examples.DROPDOWN) {
            pages.indexPage().clickDropDown();
        }
        if (currentUser.get().getExamples() == User.Examples.DATA_TABLES) {
            pages.indexPage().clickSortableDataTables();
        }
    }

    @When("^I test the data table$")
    public void iTestTheDataTable() throws Throwable {
        selectAvailableExamples();
    }

}
