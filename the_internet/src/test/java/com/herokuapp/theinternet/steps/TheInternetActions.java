package com.herokuapp.theinternet.steps;

import com.herokuapp.theinternet.domain.CurrentUser;
import com.herokuapp.theinternet.domain.TheInternetCredentials;
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
        switch (currentUser.get().getExamples()) {
            case CONTEXT_MENU:
                break;
            case DROPDOWN:
                pages.indexPage().clickDropDown();
                break;
            case DATA_TABLES:
                pages.indexPage().clickSortableDataTables();
                break;
            case FORGOT_PASSWORD:
                pages.indexPage().clickForgotPassword();
                break;
            case FORM_AUTHENTICATION:
                pages.indexPage().clickFormAuthentication();
                break;
        }

    }

    @When("^I test the data table$")
    public void iTestTheDataTable() throws Throwable {
        selectAvailableExamples();
    }

    @When("^I test forgot password$")
    public void iTestForgotPassword() throws Throwable {
        selectAvailableExamples();
        TheInternetCredentials theInternetCredentials = currentUser.get().getTheInternetCredentials();
        pages.forgotPasswordPage().enterEmail(theInternetCredentials.getEmail());
        pages.forgotPasswordPage().clickRetrieveButton();
    }

    @When("^I test the drop down page$")
    public void iTestTheDropDownPage() throws Throwable {
        selectAvailableExamples();
    }
}
