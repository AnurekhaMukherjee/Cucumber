package StepDefinition;

//import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import page_object.AAD_LoginPage_PageObject;
import page_object.AddNewCustomerPage;
import page_object.SearchCustomerPage;
import Utitlities.ReadConfig;
/*Parent class*/
public class BaseClass {
	public WebDriver driver;
	public AAD_LoginPage_PageObject lp;
	public AddNewCustomerPage customPage;
	public SearchCustomerPage SearchCustPg;
	public static Logger log; 
	public ReadConfig readConfig;
//	public Properties Configprop;
	//generate unique email id
	public String generateEmailId() {
		return (RandomStringUtils.randomAlphabetic(5));
	}
}
