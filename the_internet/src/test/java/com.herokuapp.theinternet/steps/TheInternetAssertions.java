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
        assertThat("Unsuccessful login", pages.secureAreaPage().getSuccessfulLoginText(),
                is("Welcome to the Secure Area. When you are done click logout below."));
        assertThat("Secure bar text incorrect", pages.secureAreaPage().getSecureAreaText(),
                is("You logged into a secure area!\n×"));
    }

    @Then("^the data displayed in the table is correct$")
    public void theDataDisplayedInTheTableIsCorrect() throws Throwable {
        assertThat("Incorrect last name in the first table row",
                pages.dataTablesPage().getTableRowData().get(0).getLastname(), is("Smith"));
        assertThat("Incorrect first name in the first table row",
                pages.dataTablesPage().getTableRowData().get(0).getFirstname(), is("John"));
        assertThat("Incorrect email in the first table row",
                pages.dataTablesPage().getTableRowData().get(0).getEmail(), is("jsmith@gmail.com"));
        assertThat("Incorrect amount due in the first table row",
                pages.dataTablesPage().getTableRowData().get(0).getAmountDue(), is("$50.00"));
        assertThat("Incorrect website in the first table row",
                pages.dataTablesPage().getTableRowData().get(0).getWebsite(), is("http://www.jsmith.com"));
        assertThat("Incorrect first name in the fourth table row",
                pages.dataTablesPage().getTableRowData().get(3).getFirstname(), is("Tim"));
    }

    @Then("^a reset password email is sent$")
    public void aResetPasswordEmailIsSent() throws Throwable {
        assertThat("No email confirmation",
                pages.forgotPasswordPage().getEmailSentText(), is("Your e-mail's been sent!"));
    }

    @Then("^the \"([^\"]*)\" key is displayed$")
    public void theKeyIsDisplayed(String key) throws Throwable {
        assertThat("You didn't press " + key, pages.keyPressesPage().getEnteredKey(), is("You entered: " + key));
    }
}
