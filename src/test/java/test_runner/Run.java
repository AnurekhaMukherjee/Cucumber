package test_runner;

import org.junit.runner.RunWith;

//import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
//@RunWith(Cucumber.class)
@CucumberOptions(
		//in order to run multiple feature files we need to mention their paths separated by comma inside curly braces
		//feature files runs alphabetically and not in the order we mention
		//features = {".//Feature_file/AddNewCustomer.feature",".//Feature_file/AAD_LoginPage.feature"} , 
		features = ".//Feature_file/AddNewCustomer.feature",
		//features = ".//Feature_file/AAD_LoginPage.feature",
		//features = ".//Feature_file/", //in order to run multiple feature file give only path of folder
		glue = "StepDefinition",
		dryRun = false , //true,--to check if any steps are skipped
		monochrome = true, //if we give false then also same result,
		//tags= "@sanity", //only sanity scenario will run
//		tags= "@Regression", //only regression scenario will run
//		tags= "@sanity and @Regression", //didn't run
		tags= "@sanity or @Regression", // both sanity & regression scenarios will run
		//if we write @2345 instead of @sanity or @regression then that part won't run and gives error
//		plugin = {"pretty","html:target/cucumber-reports/SearchCustomer_reports.html"}
		plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)

public class Run extends AbstractTestNGCucumberTests{

}
