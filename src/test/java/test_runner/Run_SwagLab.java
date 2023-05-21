package test_runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = ".//Feature_file/SwagLab_LoginPage.feature",
		glue = "StepDefinition",
		dryRun = false,
		monochrome = true,
		plugin = {"pretty","html:target/cucumber-reports/SwagLab_LoginPage_reports.html"}
		)

public class Run_SwagLab {

}
