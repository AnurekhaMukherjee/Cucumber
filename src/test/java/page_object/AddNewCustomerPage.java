package page_object;

import static org.testng.Assert.assertTrue;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewCustomerPage {
	public WebDriver ldriver;
	
	//constructor
	public  AddNewCustomerPage(WebDriver rDriver)  {
	 ldriver = rDriver;
	PageFactory.initElements(rDriver, this);
	}
	//Find web elements on the web page
	//locator for customers menu
	@FindBy(xpath="//a[@href='#']//p[contains(text(),'Customers')]")
	WebElement lnkCustomers_menu;
	
	//locator by customers menu item
	@FindBy(xpath="//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")
	WebElement lnkCustomers_menuitem;
	
	//locator for add new button
	@FindBy(xpath="//a[@class='btn btn-primary']")
	WebElement btnAddnew;
	
	//locator for email
	@FindBy(xpath="//input[@id='Email']")
	WebElement txtEmail;
	
	//locator for password
	@FindBy(xpath="//input[@id='Password']")
	WebElement txtPassword;
	
	//locator for customer roles
	@FindBy(xpath="//div[@class='k-multiselect-wrap k-floatmap']")
	WebElement txtCustomerRoles;
	
	//locator for administrators
	@FindBy(xpath="//li[contains(text(),'Administrators')]")
	WebElement listItemAdministrators;
	
	//locator for registered
	@FindBy(xpath="//li[contains(text(),'Registered')]")
	WebElement listItemRegistered;
	
	//locator for guests
	@FindBy(xpath="//li[contains(text(),'Guests')]")
	WebElement listItemGuests;
	
	//locator for vendor
	@FindBy(xpath="//li[contains(text(),'Guests')]")
	WebElement listItemVendors;
	//VendorId
	
	//locator for drop down
	@FindBy(xpath="//*[@id='VendorId']")
			WebElement dropdownVendorMgr;
	
	//locator for gender
	@FindBy(id="Gender_Male")
	WebElement MaleGender;
	@FindBy(id="Gender_Female")
	WebElement FeMaleGender;
	
	//locator for first name
	@FindBy(xpath= "//input[@id='FirstName']")
	WebElement txtFirstName;
	
	//locator for last name
	@FindBy(xpath= "//input[@id='LastName']")
	WebElement txtLastName;
	
	//locator for dob
	@FindBy(xpath= "//input[@id='DateOfBirth']")
	WebElement txtDob;
	
	//locator for company name
	@FindBy(xpath="//input[@id='Company']")
	WebElement txtCompanyName;
	
	//locator for Admin
	@FindBy(xpath="//textarea[@id='AdminComment']")
	WebElement txtAdminContent;
	
	//locator for save button
	@FindBy(xpath="//button[@name='save']")
	WebElement btnSave;
	
	//Actions method for web elements
	
	public String getPageTitle() {
		return ldriver.getTitle();
	}
	public void clickOnCustomersMenu() {
		lnkCustomers_menu.click();
	}
	public void clickOnCustomersMenuItem() {
		lnkCustomers_menuitem.click();
	}
	
	public void clickOnAddnew() {
		btnAddnew.click();
	}
	
	public void enterEmail(String email) {
		txtEmail.sendKeys(email);
	}
	public void enterPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void enterFirstName(String firstName) {
		txtFirstName.sendKeys(firstName);
	}
	public void enterLastName(String lastName) {
		txtLastName.sendKeys(lastName);
	}
	
	public void enterDob(String dob) {
		txtDob.sendKeys(dob);
	}
	
	public void enterCompanyName(String coName) {
		txtCompanyName.sendKeys(coName);
	}
	
	public void enterAdminContent(String content) {
		txtAdminContent.sendKeys(content);
	}
	/*public void enterCustomerRoles(String role) {
		
	}*/
	public void enterManagerOfVendor(String value) {
		Select drp= new Select(dropdownVendorMgr);
		drp.selectByVisibleText(value);
	}
	public void enterGender(String gender) {
		if(gender.equals("Male")) {
			MaleGender.click();
		}else if(gender.equals("Female")) {
			FeMaleGender.click();
		}else { //default set male gender
			MaleGender.click();
	}
	}
	public void clickOnSave() {
		btnSave.click();
	}
	public void  verify_Page() {

 String actual= ldriver.getTitle();
 String expected = "Add a new customer / nopCommerce administration";
 if(actual.equals(expected)) {
	 Assert.assertTrue(true);
 }else {
	 Assert.assertTrue(false);
 }
		
	}
}
	