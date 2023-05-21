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

public class AAD_LoginPage_PageObject {
	
	WebDriver ldriver;
public  AAD_LoginPage_PageObject(WebDriver rDriver)  {
 ldriver = rDriver;
PageFactory.initElements(rDriver, this);
}

// for email 
@FindBy(xpath="//input[@id='Email']")
WebElement eml;

//action on user web element 
public void enterEmail(String email) {
	eml.clear();
	eml.sendKeys(email);
}

// for password
@FindBy(xpath="//input[@id='Password']")
WebElement pwd;

//action on password web element 
public void enterpassword(String password) {
	pwd.clear();
	pwd.sendKeys(password);
}

//for click button
@FindBy(xpath="//button[@type='submit']")
WebElement logn;

//action on login  web element 
public void clickOnLoginBtn() {
	
	logn.click();
}

// perform logout

	@FindBy(xpath = "//a[text()='Logout']")
	
	WebElement logout;
	public void clickOnLogoutBtn() {
		logout.click();
}
	public void takeScreenShot() {
		// TODO Auto-generated method stub
		TakesScreenshot srcShot = ((TakesScreenshot)ldriver);
		//Step 2 : Call getScreenshotAs method to create image in file
		File src = srcShot.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\lenovo\\eclipse-workspace\\Cucumber_BDD\\target\\cucumber-reports\\failedscenario.fullpages.png");
		//Step 3: Copy image file to destination
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
