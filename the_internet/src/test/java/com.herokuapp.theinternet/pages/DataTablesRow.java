package com.herokuapp.theinternet.pages;

import org.openqa.selenium.WebElement;

import java.util.List;

import static com.herokuapp.theinternet.pages.DataTablesPage.getRowDataAsList;

public class DataTablesRow {

    private String lastname;
    private String firstname;
    private String email;
    private String amountDue;
    private String website;

    public DataTablesRow(WebElement tableRow) {
        List<String> rowDataAsList = getRowDataAsList(tableRow.getText());
        lastname = rowDataAsList.get(0);
        firstname = rowDataAsList.get(1);
        email = rowDataAsList.get(2);
        amountDue = rowDataAsList.get(3);
        website = rowDataAsList.get(4);
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getEmail() {
        return email;
    }

    public String getAmountDue() {
        return amountDue;
    }

    public String getWebsite() {
        return website;
    }
}
