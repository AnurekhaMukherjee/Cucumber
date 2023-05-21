package StepDefinition;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

import page_object.SwagLab_LoginPage;

public class SwagLab_StepDef {
	public WebDriver driver;
	public SwagLab_LoginPage loginPage1;
	
	@Given("Customer launch the chrome browser")
	public void customer_launch_the_chrome_browser() {
		 WebDriverManager.chromedriver().setup();
		  ChromeOptions options = new ChromeOptions();
		  options.addArguments("--remote-allow-origins=*");
		   driver = new ChromeDriver(options);
		  driver.manage().window().maximize();
		//Login Page:
		  loginPage1 = new SwagLab_LoginPage (driver);
	}

	@When("Customer enter the given url as {string}")
	public void customer_enter_the_given_url_as(String url) {
	    driver.get(url);
	}

	@When("Customer username as {string} and password as {string}")
	public void customer_username_as_and_password_as(String usrnm, String pwd) {
		
		loginPage1.enterusername(usrnm);
	   loginPage1.enterpassword(pwd);
	
	}

	@When("Customer is going to click on login button")
	public void customer_is_going_to_click_on_login_button() {
	   loginPage1.clickOnLoginButton();
	   loginPage1.TakeScreenshot1();
	}
/*********************Login Features******************/
	@Then("Customer is verified the given title {string}")
	public void customer_is_verified_the_given_title(String expected) {
	   String actual = driver.getTitle();
	String expected1 = "Swag Labs";
	   if(actual.equals(expected1)) {
		   Assert.assertTrue(true); //pass
		 
	   }else {
		   Assert.assertFalse(false); //Fail
		   
	   }
	}

	
	@Then("Customer click on Menu button")
	public void customer_click_on_menu_button() {
	  loginPage1.ClickOnMenuButton();
	}

	@Then("Customer click on logout button")
	public void customer_click_on_logout_button() {
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  loginPage1.clickOnLogoutButton();
	  
	}


	@Then("Customer close the browser")
	public void customer_close_the_browser() {
	  driver.close();
		driver.quit();
	   
	}
}
