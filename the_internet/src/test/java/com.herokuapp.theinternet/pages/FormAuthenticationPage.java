package com.herokuapp.theinternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormAuthenticationPage extends BasePage {

    private static final By HEADING_IDENTIFIER = By.cssSelector(BasePage.PAGE_HEADING_IDENTIFIER);
    private static final By DROPDOWN_LIST_IDENTIFIER = By.id("Dropdown");
    private static final By USERNAME_INPUT_IDENTIFIER = By.id("username");
    private static final By PASSWORD_INPUT_IDENTIFIER = By.id("password");
    private static final By LOGIN_BUTTON_IDENTIFIER = By.cssSelector(".radius");
    private static final By SUCCESSFUL_LOGIN_IDENTIFIER = By.cssSelector(".subheader");

    public FormAuthenticationPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getHeaderText() {
        return getDriver().findElement(HEADING_IDENTIFIER).getText();
    }

    public void enterUsername(String username) {
        getDriver().findElement(USERNAME_INPUT_IDENTIFIER).sendKeys(username);
    }

    public void enterPassword(String password) {
        getDriver().findElement(PASSWORD_INPUT_IDENTIFIER).sendKeys(password);
    }

    public void clickLoginButton() {
        getDriver().findElement(LOGIN_BUTTON_IDENTIFIER).click();
    }

    public String getSuccessfulLoginText() {
        return getDriver().findElement(SUCCESSFUL_LOGIN_IDENTIFIER).getText();
    }
}
