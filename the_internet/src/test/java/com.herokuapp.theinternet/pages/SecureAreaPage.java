package com.herokuapp.theinternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage extends BasePage {

    private static final By LOGIN_BUTTON_IDENTIFIER = By.cssSelector(".radius");
    private static final By SUCCESSFUL_LOGIN_IDENTIFIER = By.cssSelector(".subheader");
    private static final By LOGOUT_IDENTIFIER = By.linkText("Logout");
    private static final String SECTION_HEADING = "Secure Area";
    private static final By SECURE_AREA_BAR_IDENTIFIER = By.id("flash");

    public SecureAreaPage(WebDriver webDriver) {
        super(webDriver);
        waitForSectionHeadingTwo(SECTION_HEADING);
    }

    public void clickLogoutButton() {
        getDriver().findElement(LOGOUT_IDENTIFIER).click();
    }

    public String getSuccessfulLoginText() {
        return getDriver().findElement(SUCCESSFUL_LOGIN_IDENTIFIER).getText();
    }
    public String getSecureAreaText() {
        return getDriver().findElement(SECURE_AREA_BAR_IDENTIFIER).getText();
    }
}
