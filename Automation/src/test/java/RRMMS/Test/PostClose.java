package RRMMS.Test;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import jxl.Sheet;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import RRMMS.TestData.ExcelData;
import RRMMS.locators.CreateProspectLocator;
import RRMMS.locators.LeaseLocator;
import RRMMS.locators.PostCloseLocator;
import RRMMS.start.Start;
import RRMMS.utility.Common;
import RRMMS.utility.ScreenShots;

public class PostClose extends RRMMS.utility.TestBase{
	static WebDriver driver;
	Login l1 = new Login();
	String Location;
	static Logger log = Logger.getLogger(CreateProspect.class.getClass());
	static int result, num;

	public void Start() throws Exception {
		this.driver = Start.getDriverInstance();
		this.driver = Start.InitilizeBrowser7();
		ScreenShots.screenshots(driver, "Prospect");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void PostCloseAsset() throws Exception {
		this.driver = Start.logIN();
		log.info("Logged In sucessfully");
		ScreenShots.screenshots(driver, "Post Close");
		log.info("Executing Post Close start");
		Robot rb = new Robot();
		Actions action = new Actions(driver);
		Thread.sleep(10000);
		WebElement map = driver.findElement(By
				.xpath("//div[@id='map']/div[2]/canvas"));
		Thread.sleep(7000);
		searchAsset();

	}

	public void searchAsset() throws Exception {
		Thread.sleep(2000);
		Robot rb = new Robot();
		log.info("Seaxrh Assect by Smart Search");
		ScreenShots.screenshots(driver, "Post Close");
		CreateProspectLocator.ElementID(driver, "smartsearchbox").click();
		Thread.sleep(2000);
		for (int i = 1; i <= 3; i++) {
			rb.keyPress(KeyEvent.VK_DOWN);
			rb.keyRelease(KeyEvent.VK_DOWN);
		}
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);

		Common.selectFromList();
		Thread.sleep(2000);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		ScreenShots.screenshots(driver, "Post Close");
		Thread.sleep(2000);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		Common.loader();
		log.info("Asset opened sucessfully");
		CreateProspectLocator.ActionButtonClick(driver).click();
		Thread.sleep(2000);
		ScreenShots.screenshots(driver, "Post Close");
		CreateProspectLocator.ActionListClick(driver, 3).click();
		Thread.sleep(2000);

		PostCloseLocator.ElementID(driver, "specialnstruction").sendKeys(
				"Test Special Instruction" + Common.randomNumber());
		ScreenShots.screenshots(driver, "Post Close");
		Thread.sleep(1000);
		PostCloseLocator.NextButton(driver).click();

		Thread.sleep(2000);
		PostCloseLocator.ElementID(driver, "txtPageNo").sendKeys(
				"" + Common.randomNumber2to10());
		/*PostCloseLocator.ElementID(driver, "txtAmount").sendKeys(
				"" + Common.randomNumber());*/
		ScreenShots.screenshots(driver, "Post Close");
		Thread.sleep(2000);
		PostCloseLocator.GenerateCheckButton(driver).click();
		Thread.sleep(2000);
		/* PostCloseLocator.GenerateCheckCloseButton(driver).click(); */
		log.info("Check generated sucessfully");

	}
}
