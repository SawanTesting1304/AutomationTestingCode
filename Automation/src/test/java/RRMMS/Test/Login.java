package RRMMS.Test;

import java.awt.AWTException;
import java.io.File;
import java.lang.reflect.Method;

import junit.framework.Assert;
import RRMMS.locators.LoginLocator;
//import RRMMS.locators.LoginLocator;
import RRMMS.start.*;
import RRMMS.utility.Common;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;








//import testBase.TestBase;





//import org.apache.log4j.Logger;
//import BusinessLib.Articles;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.ExtentTestInterruptedException;

public class Login extends RRMMS.utility.TestBase{
	// private static Object userName;
	Logger log = Logger.getLogger(Login.class.getClass());
	WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static ExtentTestInterruptedException testexception;
	public Login() {
		this.driver = Start.getDriverInstance();
		this.driver = Start.InitilizeBrowser7();
	}

	
	@Test
	public void logIN() throws AWTException, InterruptedException {
		Thread.sleep(5000);
		/*LoginLocator.txtFld_rrmms(driver, "Username").sendKeys(
				"buyerrrm");
		LoginLocator.txtFld_rrmms(driver, "Password").sendKeys("Password@123");*/
		LoginLocator.txtFld_rrmms(driver, "Username").sendKeys("hlavergne");
		LoginLocator.txtFld_rrmms(driver, "Password").sendKeys("Uat@2017");
		LoginLocator.Loginbutton(driver).click();
		log.info("Logged In sucessfully");
		System.out.println("Login pass");
		//extent.addSystemInfo("","");
		// SendKey(Login.userName,"rrmms@yopmail.com");
		Common.loader();
		Common.loader();
		try{
			driver.findElement(By.xpath("//form//label[contains(text(),'Rock River Minerals')]")).click();
		}
		catch(org.openqa.selenium.NoSuchElementException e)
		{
			Common.loader();
			driver.findElement(By.xpath("//div[@id='main']//header/div[2]/div/button")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[contains(text(),'Rock River Minerals')]")).click();
			Common.loader();
			Common.loader();
		}		

	}
	
}
