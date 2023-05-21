package StepDefinition;
import java.io.File;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


import org.apache.commons.io.FileUtils;

import org.apache.logging.log4j.LogManager;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Assert;

import Utitlities.ReadConfig;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import page_object.AAD_LoginPage_PageObject;
import page_object.AddNewCustomerPage;
import page_object.SearchCustomerPage;
// AAD_StepDef child class
public class AAD_StepDef extends BaseClass {
	//public Properties Configprop;
	//it will execute first
	@Before (order=2)
	public void setup1() {
		log= LogManager.getLogger("AAD_StepDef");
//		System.out.println("setup method executed");
//		 WebDriverManager.chromedriver().setup();
//		  ChromeOptions options = new ChromeOptions();
//	  options.addArguments("--remote-allow-origins=*");
//		   driver = new ChromeDriver(options);
		   log.info("setup1 executed");
		readConfig = new ReadConfig();
		String browser = readConfig.getBrowser();
//		launch browser
		switch(browser.toLowerCase())
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			  ChromeOptions options = new ChromeOptions();
			  options.addArguments("--remote-allow-origins=*");
			   driver = new ChromeDriver(options);
			   break;
				   
		case "edge":
			
			WebDriverManager.edgedriver().setup();
			   driver = new EdgeDriver();
			 
			   break;
			   
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			   driver = new FirefoxDriver();
			   break;
			   
			   default:
				   driver= null;
				   break;
		}	
		
	}
	@Before (order=1)
	public void setup2() {
		System.out.println("setup method executed");
		 WebDriverManager.edgedriver().setup();
		   driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	
	}
	
	
	@Given("User use Chrome browser")
	public void user_use_chrome_browser() {
	 //Login Page:
	  lp = new AAD_LoginPage_PageObject(driver);
	 //customer page:
	  customPage = new AddNewCustomerPage(driver);
	 //search customer page:
	  SearchCustPg= new SearchCustomerPage(driver);
	  log.info("launch the browser");
	}

	@When("User open URL {string}")
	public void user_open_url(String url) {
		driver.get(url);
		 driver.manage().window().maximize();
		 log.info("url open");
	}

	@When("User enter email as {string} and password as {string}")
	public void user_enter_email_as_and_password_as(String emailAdd, String password) {
	 lp.enterEmail(emailAdd);
	 lp.enterpassword(password);
	 log.info("enter username and password");
	}

	@When("click on login button")
	public void user_click_on_login_button() {
	  lp.clickOnLoginBtn();  
	  lp.takeScreenShot();
	  log.info("login button");
	}
  /******************Login Features********************/
	@Then("User verify Title as {string}")
	public void user_verify_title_as(String expected) {
	 String actual = driver.getTitle();
	 if(actual.equals(expected)) {
		 log.warn("test passed:login feature: page title match");
		 Assert.assertTrue(true);  //pass
		 
	 }else if(actual.equals(expected)) {
		 Assert.assertTrue(false);  //fail
		 log.warn("test failed:login feature: page title not match");
		 lp.takeScreenShot();
	 }
	}
	@Then("User click on logout button")
	public void user_click_on_logout() {
		lp.clickOnLogoutBtn();
		 log.info("logout");
	}
	@Then("User close the browser")
	public void user_close_the_browser() {
		driver.quit();
		 log.info("closing browser");
	}
	
	/**************Add new customer***************/
	@When("User click on customers Menu")
	public void user_click_on_customers_menu()  {
		customPage.clickOnCustomersMenu();
		log.info("click on customer menu");
	}

	@When("click on customers Menu Item")
	public void click_on_customers_menu_item() {
		customPage.clickOnCustomersMenuItem();
		log.info("click customer menu item");
	}

	@When("click on Add New button")
	public void click_on_add_new_button() {
		customPage.clickOnAddnew();
		log.info("click on add new");
	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
	  customPage.verify_Page();
	  log.info("view add new customer page");
	}

	@When("User enter customer Info")
	public void user_enter_customer_info()  {
		//customPage.enterEmail("rimyrim@gmail.com");
		customPage.enterEmail(generateEmailId()+ "@gmail.com");
		customPage.enterPassword("admin");
		customPage.enterFirstName("Anurekha");
		customPage.enterLastName("Mukherjee");
		customPage.enterGender("Female");
		customPage.enterDob("2/12/2000");
		customPage.enterCompanyName("XYZ");
		customPage.enterManagerOfVendor("Vendor 1");
		log.info("entering customer info");
		
	}
	

	@When("Click on Save button")
	public void click_on_save_button() {
		customPage.clickOnSave();
		log.info("click on save");
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String string) {
		log.info("view confirmation message");
	  
	}
	@Then("close browser")
	public void close_browser() {
		driver.close();
		driver.quit();
		log.info("closing browser");
	}
		/*******************Search by email******************/
	@When("Enter Customer Email")
	public void enter_customer_email() {
		SearchCustPg.enterEmailAdd("victoria_victoria@nopCommerce.com");
		log.info("enter customer email");
	}

	@When("Click on Search button")
	public void click_on_search_button() {
		SearchCustPg.clickOnSearchButton();
		log.info("click on search button");
		try {
			Thread.sleep(2000);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("User should found Email in the Search table")
	public void user_should_found_email_in_the_search_table() {
		String expectedEmail = "victoria_victoria@nopCommerce.com";
		if(SearchCustPg.searchCustomerByEmail(expectedEmail)== true)
		{
			 log.warn("test passed:Search feature: email match");
			Assert.assertTrue(true);
		}else {
			
			Assert.assertTrue(false);
			 log.warn("test failed:Search feature: email not  match");
		}

	}
	/*******Search Name*************/
	@When("Enter customer FirstName")
	public void enter_customer_first_name() {
	   SearchCustPg.enerFirstName("Victoria");
	   log.info("enter firstname");
	}
	@When("Enter customer LastName")
	public void enter_customer_last_name() {
		SearchCustPg.enterLastName("Terces");
		  log.info("enter lastname");
	}
	@Then("User should found Name in the Search table")
	public void user_should_found_name_in_the_search_table() {
	    String expectedName= "Victoria Terces";
	    if(SearchCustPg.searchCustomerByName(expectedName)== true) {
	    	 log.warn("test passed:Search feature: name  match");
	    	Assert.assertTrue(true);
	    }else {
	    	Assert.assertTrue(false);
	    	 log.warn("test failed:Search feature: name not  match");
	    }
	    	
	}
	@After (order=2)
	public void teardown1(Scenario sc) {
		System.out.println("Tear down method executed");
		if(sc.isFailed()== true) {
			 log.warn("test faied:teardown feature: teardown executed");
//		lp.takeScreenShot();
 //convert webdriver object to takescreensot
			 String fileWithPath="C:\\Users\\lenovo\\eclipse-workspace\\Cucumber_BDD\\target\\screenshot\\failedScreenshot.png";
			 TakesScreenshot srcShot = ((TakesScreenshot)driver);
			 //call getScreenshotAs method to create image file
			 File SrcFile= srcShot.getScreenshotAs(OutputType.FILE);
			//move image file to new destination
			 File DestFile = new File(fileWithPath);
			 //copy file at destination
			 try {
				 FileUtils.copyFile(SrcFile, DestFile);
			 }catch (IOException e) {
				 e.printStackTrace();
			 }
		}
		
		
		driver.quit();
	}
	@AfterStep
	public void addascreenshot(Scenario scenario) {
		System.out.println("Tear down method executed");
		
		final byte[] screenshot =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", scenario.getName());
//		if(sc.isFailed()== true) {
//			 log.warn("test faied:teardown feature: teardown executed");
////		lp.takeScreenShot();
////convert webdriver object to takescreensot
//			 String fileWithPath="C:\\Users\\lenovo\\eclipse-workspace\\Cucumber_BDD\\target\\screenshot\\failedScreenshot.png";
//			 TakesScreenshot srcShot = ((TakesScreenshot)driver);
//			 //call getScreenshotAs method to create image file
//			 File SrcFile= srcShot.getScreenshotAs(OutputType.FILE);
//			//move image file to new destination
//			 File DestFile = new File(fileWithPath);
//			 //copy file at destination
//			 try {
//				 FileUtils.copyFile(SrcFile, DestFile);
//			 }catch (IOException e) {
//				 e.printStackTrace();
//			 }
//		}
//		
//		driver.quit();
	}
	@BeforeStep
	public void beforestepmethod() {
		System.out.println("This is before step");
		 log.info("before step");
	}
	@AfterStep
	public void afterstepmethod() {
		System.out.println("This is after step");
		 log.info("this is afterstep");
	}

}
	