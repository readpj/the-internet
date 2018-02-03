package com.herokuapp.theinternet.pages;

import com.google.common.base.Splitter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.collect.Lists.newArrayList;

public class DataTablesPage extends BasePage {

    private static final By EXAMPLE_ONE_TABLE_IDENTIFIER = By.xpath("//table[1]/tbody/tr");

    public DataTablesPage(WebDriver webDriver) {
        super(webDriver);
    }

    public static List<String> getRowDataAsList(String tableRowText) {
        checkArgument(
                tableRowText.contains(" "),
                "tableRowText does not contain %s", " ");
        return Splitter.on(" ").splitToList(tableRowText);
    }

    public List<DataTablesRow> getTableRowData() {
        List<WebElement> webElements = getDriver().findElements(EXAMPLE_ONE_TABLE_IDENTIFIER);
        List<DataTablesRow> dataTablesRows = newArrayList();
        for (WebElement webElement : webElements) {
            dataTablesRows.add(new DataTablesRow(webElement));
        }
        return dataTablesRows;
    }

}
