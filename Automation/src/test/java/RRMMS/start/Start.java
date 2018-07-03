package RRMMS.start;


import java.awt.AWTException;
import java.io.IOException;
//import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import jxl.Sheet;
import jxl.read.biff.BiffException;
import jxl.write.DateFormat;
import RRMMS.TestData.ExcelData;

import RRMMS.TestData.RRMMS_Urls;
import RRMMS.locators.LoginLocator;
import RRMMS.utility.Common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.codeborne.selenide.commands.GetDataAttribute;

public class Start{
	
	
	public static WebDriver driver;
	
	public static WebDriver getDriverInstance() 
	{
	    return driver;
	}
	public static WebDriver InitilizeBrowser7()
	{
		//String url="http://mmstest.piedrallc.com";
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		options.addArguments("--start-maximized");
		//options.addArguments("--headless");
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		driver = new ChromeDriver(options);
		//driver = new FirefoxDriver();
		try{
		driver.manage().window().maximize();
		}catch(org.openqa.selenium.WebDriverException e)
		{
			System.out.println("Browser Not Maxmize ");
		}
        driver.navigate().to(RRMMS_Urls.baseUrl);
		return driver;
	}
	public static WebDriver logIN() throws AWTException, InterruptedException, BiffException, IOException
	{
			Thread.sleep(5000);
			Common.loader();
			Sheet sheet=ExcelData.GetData("Login");
			LoginLocator.txtFld_rrmms(driver, "Username").sendKeys(sheet.getCell(2,11).getContents());
			LoginLocator.txtFld_rrmms(driver, "Password").sendKeys(sheet.getCell(3,11).getContents());
			/*LoginLocator.txtFld_rrmms(driver, "Username").sendKeys("hlavergne");
			LoginLocator.txtFld_rrmms(driver, "Password").sendKeys("Uat@2017");*/
			LoginLocator.Loginbutton(driver).click();
			System.out.println("Login pass");
			Common.loader();
			Common.loader();
			try{
				driver.findElement(By.xpath("//form//label[contains(text(),'"+RRMMS.TestData.RRMMS_Urls.partnership+"')]")).click();
			}
			catch(org.openqa.selenium.NoSuchElementException e)
			{
				Common.loader();
				driver.findElement(By.xpath("//div[@id='main']//header/div[2]/div/button")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//a[contains(text(),'"+RRMMS.TestData.RRMMS_Urls.partnership+"')]")).click();
				Common.loader();
				Common.loader();
			}	
			return driver;
	}


}
