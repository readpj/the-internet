package com.herokuapp.theinternet.steps;

import com.herokuapp.theinternet.domain.CurrentUser;
import com.herokuapp.theinternet.domain.TheInternetCredentials;
import com.herokuapp.theinternet.pages.Pages;
import cucumber.api.DataTable;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

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
            case KEY_PRESSES:
                pages.indexPage().clickKeyPresses();
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

    @When("^I press the \"([^\"]*)\" key$")
    public void iPressTheKey(String key) throws Throwable {
        selectAvailableExamples();
        pages.keyPressesPage().enterKey(key);
    }

    @When("^I enter the credentials$")
    public void iEnterTheCredentials(DataTable userCredentials) throws Throwable {
        selectAvailableExamples();
        List<List<String>> data = userCredentials.raw();
        pages.formAuthenticationPage().enterUsername(data.get(0).get(0));
        pages.formAuthenticationPage().enterPassword(data.get(0).get(1));
        pages.formAuthenticationPage().clickLoginButton();
    }

    @When("^I enter the following credentials$")
    public void iEnterTheFollowingCredentials(DataTable userCredentials) throws Throwable {
        selectAvailableExamples();
        for (Map<String, String> data : userCredentials.asMaps(String.class, String.class)) {
            pages.formAuthenticationPage().enterUsername(data.get("Username"));
            pages.formAuthenticationPage().enterPassword(data.get("Password"));
            pages.formAuthenticationPage().clickLoginButton();
            assertThat("Login was not invalid", pages.formAuthenticationPage().getInvalidPasswordText(),
                    is("Your password is invalid!\n×"));
            System.out.println(pages.formAuthenticationPage().getInvalidPasswordText());
        }
    }
}
