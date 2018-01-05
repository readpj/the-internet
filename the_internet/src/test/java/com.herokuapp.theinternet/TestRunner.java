package com.herokuapp.theinternet;

import com.relevantcodes.extentreports.NetworkMode;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import lombok.extern.slf4j.Slf4j;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.cucumber.listener.ExtentCucumberFormatter.addSystemInfo;
import static com.cucumber.listener.ExtentCucumberFormatter.initiateExtentCucumberFormatter;
import static com.cucumber.listener.ExtentCucumberFormatter.loadConfig;
import static org.apache.log4j.helpers.LogLog.error;

@Slf4j
@RunWith(Cucumber.class)
@CucumberOptions(
        glue = ("com/herokuapp/theinternet/steps"),
        features = {"src/test/resources/com.herokuapp.theinternet"},
        tags = "@form_authentication",
        plugin = {
                "pretty",
                "com.cucumber.listener.ExtentCucumberFormatter:output/the-internet/Report.html",
                "json:target/cucumber.json"
        }
)

public class TestRunner {
    private static final String REPORT_LOCATION = "output/the-internet/";

    @BeforeClass
    public static void setUp() {
        File reportLocation = new File(REPORT_LOCATION);
        reportLocation.mkdirs();

        clearDownPreviousReportInformation();

        initiateExtentCucumberFormatter(new File(reportLocation, "Report.html"), true, NetworkMode.OFFLINE);

        loadConfig(new File("src/test/resources/extent-config.xml"));

        Map<String, String> systemInfo = new HashMap<String, String>();
        systemInfo.put("Project", "The Internet");
        systemInfo.put("Cucumber version", "v1.2.3");
        systemInfo.put("Extent Cucumber Reporter version", "v1.1.0");
        addSystemInfo(systemInfo);

    }

    private static void clearDownPreviousReportInformation() {
        try {
            org.apache.commons.io.FileUtils.cleanDirectory(new File(REPORT_LOCATION));
        } catch (IOException e) {
            error("Clear down of report directory failed", e);
        }
    }
}
