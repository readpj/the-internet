package com.herokuapp.theinternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class KeyPressesPage extends BasePage {

    private static final By LOGIN_BUTTON_IDENTIFIER = By.cssSelector(".radius");
    private static final By SUCCESSFUL_LOGIN_IDENTIFIER = By.cssSelector(".subheader");
    private static final String SECTION_HEADING = "Key Presses";
    private static final By DOM_IDENTIFIER = By.xpath("//html");
    private static final By KEY_PRESSED_IDENTIFIER = By.id("result");

    public KeyPressesPage(WebDriver webDriver) {
        super(webDriver);
        waitForSectionHeading(SECTION_HEADING);
    }

    public void clickLoginButton() {
        getDriver().findElement(LOGIN_BUTTON_IDENTIFIER).click();
    }

    public String getSuccessfulLoginText() {
        return getDriver().findElement(SUCCESSFUL_LOGIN_IDENTIFIER).getText();
    }

    public void enterKey(String key) {getDriver().findElement(DOM_IDENTIFIER).sendKeys(Keys.valueOf(key));}

    public String getEnteredKey() {return getDriver().findElement(KEY_PRESSED_IDENTIFIER).getText();}
}