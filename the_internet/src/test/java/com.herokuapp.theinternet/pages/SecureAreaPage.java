package com.herokuapp.theinternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage extends BasePage {

    private static final By LOGIN_BUTTON_IDENTIFIER = By.cssSelector(".radius");
    private static final By SUCCESSFUL_LOGIN_IDENTIFIER = By.cssSelector(".subheader");
    private static final String SECTION_HEADING = "Secure Area";

    public SecureAreaPage(WebDriver webDriver) {
        super(webDriver);
        waitForSectionHeadingTwo(SECTION_HEADING);
    }

    public void clickLoginButton() {
        getDriver().findElement(LOGIN_BUTTON_IDENTIFIER).click();
    }

    public String getSuccessfulLoginText() {
        return getDriver().findElement(SUCCESSFUL_LOGIN_IDENTIFIER).getText();
    }
}
