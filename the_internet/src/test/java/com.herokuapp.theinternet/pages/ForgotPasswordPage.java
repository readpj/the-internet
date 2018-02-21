package com.herokuapp.theinternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage extends BasePage {

    private static final By EMAIL_INPUT = By.id("email");
    private static final By EMAIL_SENT_CONFIRMATION = By.id("content");
    private static final By RETRIEVE_PASSWORD_BUTTON = By.id("form_submit");
    private static final String SECTION_HEADING = "Forgot Password";

    public ForgotPasswordPage(WebDriver webDriver) {
        super(webDriver);
    }
    public void enterEmail(String email) {
        getDriver().findElement(EMAIL_INPUT).sendKeys(email);
    }

    public String getEmailSentText() {
        return getDriver().findElement(EMAIL_SENT_CONFIRMATION).getText();
    }

    public void clickRetrieveButton() {
        waitForElementToBeClickable(RETRIEVE_PASSWORD_BUTTON);
        getDriver().findElement(RETRIEVE_PASSWORD_BUTTON).click();
    }
}
