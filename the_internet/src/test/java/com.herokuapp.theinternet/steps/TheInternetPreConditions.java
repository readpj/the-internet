package com.herokuapp.theinternet.steps;

import com.herokuapp.theinternet.pages.Pages;
import cucumber.api.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;

public class TheInternetPreConditions {

    @Autowired
    private Pages pages;

    @Given("^I want to test the drop down page$")
    public void iWantToTestTheDropDownPage() throws Throwable {
    pages.indexPage().clickDropDown();
    }
}
