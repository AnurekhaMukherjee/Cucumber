package page_object;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLab_LoginPage {
	
	WebDriver ldriver;
public  SwagLab_LoginPage(WebDriver rDriver)  {
 ldriver = rDriver;
PageFactory.initElements(rDriver, this);
}

// for username 
@FindBy(xpath="//input[@id='user-name']")
WebElement usrnm;

//action on user web element 
public void enterusername(String username) {
usrnm.clear();
usrnm.sendKeys(username);
	
}

// for password
@FindBy(xpath="//input[@id='password']")
WebElement pwd;

//action on password web element 
public void enterpassword(String password) {
	pwd.clear();
	pwd.sendKeys(password);
}

//for click on login button
@FindBy(xpath="//input[@id=\"login-button\"]")
WebElement logn;


public void clickOnLoginButton() {
	
	logn.click();
}
//click on menu button
 @FindBy(xpath="//button[text()='Open Menu']")
 WebElement menu;
public void ClickOnMenuButton() {
	// TODO Auto-generated method stub
	menu.click();
}

// perform logout

	@FindBy(xpath = "//a[text()='Logout']")
	
	WebElement logout;
	public void clickOnLogoutButton() {
		logout.click();
}
	public void TakeScreenshot1() {
		// TODO Auto-generated method stub
		TakesScreenshot srcShot = ((TakesScreenshot)ldriver);
		//Step 2 : Call getScreenshotAs method to create image in file
		File src = srcShot.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\lenovo\\eclipse-workspace\\Cucumber_BDD\\target\\screenshot.fullpages.png");
		//Step 3: Copy image file to destination
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}