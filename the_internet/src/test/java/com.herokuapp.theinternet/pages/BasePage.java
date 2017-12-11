package com.herokuapp.theinternet.pages;

import org.openqa.selenium.WebDriver;

public class BasePage {

    private final WebDriver webDriver;
    private static final int DEFAULT_TIME_OUT = 20;

    protected static final String PAGE_HEADING_IDENTIFIER = ".example>h3";
    protected static final String PAGE_HEADING_XPATH_FORMAT = "//h3[text()='$s']";

    public BasePage(WebDriver driver) {
        this.webDriver = driver;
    }

    protected WebDriver getDriver() {
        return webDriver;
    }

//    protected void waitForPageHeading(String sectionHeading) {
//        waitForVisibilityOf(By.cssSelector(format(PAGE_HEADING_XPATH_FORMAT, sectionHeading)));
//    }
}
