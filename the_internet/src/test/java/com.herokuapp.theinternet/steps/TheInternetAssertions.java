package com.herokuapp.theinternet.steps;

import com.herokuapp.theinternet.pages.Pages;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

public class TheInternetAssertions {

    @Autowired
    private Pages pages;


    @Then("^the drop down page is displayed$")
    public void theDropDownPageIsDisplayed() throws Throwable {
    pages.dropDownPage();
    }
}
