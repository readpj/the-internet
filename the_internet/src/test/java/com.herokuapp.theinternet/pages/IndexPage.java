package com.herokuapp.theinternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IndexPage extends BasePage{

    private static final By HEADING_IDENTIFIER = By.cssSelector(".heading");
    private static final By DROPDOWN_LINK = By.linkText("Dropdown");
    private static final By FORM_AUTHENTICATION_LINK = By.linkText("Form Authentication");
    private static final By SORTABLE_DATA_TABLES_LINK = By.linkText("Sortable Data Tables");

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
    public void clickFormAuthentication() {
        getDriver().findElement(FORM_AUTHENTICATION_LINK).click();
    }
    public void clickSortableDataTables() {
        getDriver().findElement(SORTABLE_DATA_TABLES_LINK).click();
    }

}
