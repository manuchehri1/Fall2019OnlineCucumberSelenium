package com.vytrack.runners;
//notes for profile :
//Maven profile : is used to create alternative build configurations. Currently we have only one.
//By using profiles we can have couple build presets.
//In Vasyl’s project they have profiles for smoke and reggession tests.
//How to create profile for smoketest ? -
//benefit is : whole configuration will be include inside pom file, no need long command
//Perform whenever you need it
//Tag build in pom is : build configuration - we have one currently
//With mvn test we configure default one
//How to ?
//Create separate runner class for smoke test
//create preset in pom,
//type in terminal one command and it’s id =>  mvn test -P Smoke
//Provides Advance configuration -Makes configuration easier
// mvn test -P Smoke => this command will use only Smoke, it will know based on profile id
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com/vytrack/step_definitions",
        features = "src/test/resources",
        dryRun = false,
        strict = false,
        tags = "@smoke_test",
        plugin = {
                "html:target/smoke_test_default-report",
                "json:target/cucumber1.json"
        }

)
public class SmokeTestRunner {
}