package com.herokuapp.theinternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DropDownPage extends BasePage{

    private static final By HEADING_IDENTIFIER = By.cssSelector(BasePage.PAGE_HEADING_IDENTIFIER);
    private static final By DROPDOWN_LIST_IDENTIFIER = By.id("Dropdown");

    public DropDownPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getHeaderText() {
        return getDriver().findElement(HEADING_IDENTIFIER).getText();
    }

}
