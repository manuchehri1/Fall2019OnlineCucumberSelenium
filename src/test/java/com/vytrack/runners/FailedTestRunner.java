package com.vytrack.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com/vytrack/step_definitions",
        features = "@target/rerun.txt",
        strict = false,
        plugin = {
                "html:target/failed-default-html-report",
                "json:target/failed_test_report.json",


        }
)

public class FailedTestRunner {
}
