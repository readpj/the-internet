package com.herokuapp.theinternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IndexPage extends BasePage{

    private static final By HEADING_IDENTIFIER = By.cssSelector(".heading");
    private static final By DROPDOWN_LINK = By.linkText("Dropdown");

    public IndexPage(WebDriver webDriver, String baseURL) {
        super(webDriver);
        webDriver.get(baseURL);
    }

    public String getHeaderText() {
        return getDriver().findElement(HEADING_IDENTIFIER).getText();
    }
    public void clickDropDown() {
        getDriver().findElement(DROPDOWN_LINK).click();
    }
}
