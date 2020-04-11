package com.vytrack.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
//@RunWith => comes from Junit. It allows to have custom test configuration
//cucumber has it's own flow to run test - during runtime turns into executable test
//@CucumberOptions => stands for parameterization for test execution
//glue => trigger of cucumber test. Runner class needs to know where are step definition and feature file
//path to step definition, right click on step_definitions - copy from source root
//features => specifies path to the feature files right click on features - copy from content root

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com/vytrack/step_definitions",
        features = "src/test/resources/features",
        dryRun = true

)
public class CucumberRunner {

}
