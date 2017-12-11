package com.herokuapp.theinternet.pages;

import com.herokuapp.theinternet.ProjectWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Pages {
    private final ProjectWebDriver projectWebDriver;

    @Value("${baseURL}")
    private String baseURL;

    @Autowired
    public Pages(ProjectWebDriver projectWebDriver) {
        this.projectWebDriver = projectWebDriver;
    }

    public IndexPage indexPage() {
        return new IndexPage(projectWebDriver.getWebDriver(), baseURL);
    }

    public DropDownPage dropDownPage() {
        return new DropDownPage(projectWebDriver.getWebDriver());
    }

}
