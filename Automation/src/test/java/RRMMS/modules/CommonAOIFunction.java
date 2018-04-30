package RRMMS.modules;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import jxl.Sheet;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import RRMMS.Test.CreateProspect;
import RRMMS.TestData.ExcelData;
import RRMMS.locators.CreateAOILocator;
import RRMMS.locators.CreateProspectLocator;
import RRMMS.utility.Common;
import RRMMS.utility.ScreenShots;

public class CommonAOIFunction {
	
	static WebDriver driver;
	static Robot rb;
	static int result,i, row, n=1;
	static Logger log = Logger.getLogger(CreateProspect.class.getClass());
	
	public static WebDriver location(WebDriver driver) throws Exception
	{
		rb = new Robot();
		Actions action = new Actions(driver);
		Common.loader();
		// Common.waitUntilLoads(driver);
		WebElement map = driver.findElement(By
				.xpath("//div[@id='map']/div[2]/canvas"));
		CreateProspectLocator.ElementID(driver, "smartsearchbox").click();
		Thread.sleep(2000);
		try {
			System.out.println("try");
			CreateProspectLocator.ElementID(driver, "smartsearchbox").sendKeys(
					"Tract");

		} catch (org.openqa.selenium.NoSuchElementException exception) {
			for (int i = 1; i <= 5; i++) {
				rb.keyPress(KeyEvent.VK_DOWN);
				rb.keyRelease(KeyEvent.VK_DOWN);
			}

			System.out.println("Catch");
		}
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		Sheet sheet = ExcelData.GetData("Location");
		row= Common.randomNumber2to10();
			
		System.out.println(row);
		CreateProspectLocator.ElementID(driver, "smartsearchbox").sendKeys(
				" " + sheet.getCell(2, row).getContents());
		Common.loader();
		CreateProspectLocator.ElementID(driver, "smartsearchbox").sendKeys(
				" " + sheet.getCell(3, row).getContents());
		Common.loader();
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		
		Common.loader();
		action.moveToElement(map, 683, 330).doubleClick().perform();
		
		Common.loader();
		CreateAOILocator.polygon(driver).click();
		// Draw Polygon
		
		Common.loader();
		action.moveToElement(map, 384, 149).click().perform();
		System.out.println("1st Cordinate");
		Thread.sleep(2000);
		action.moveToElement(map, 932, 159).click().perform();
		System.out.println("2nd Cordinate");
		Thread.sleep(2000);
		action.moveToElement(map, 811, 459).click().perform();
		System.out.println("3rd Cordinate");
		Thread.sleep(2000);
		action.moveToElement(map, 466, 460).click().perform();
		System.out.println("4th Cordinate");
		Thread.sleep(2000);
		action.moveToElement(map,  466, 460).doubleClick().perform();
		System.out.println("Final Click");
		Thread.sleep(500);
		log.info("Polygon Drawn sucessfully");
		ScreenShots.screenshots(driver, "Prospect");
		// ---------Draw Polygon End----------------//
		log.info("Location found");
		// ----------Right Click for selected area--------------//
		Thread.sleep(3000);
		action.moveToElement(map, 601, 281).contextClick().perform();
		ScreenShots.screenshots(driver, "Work Flow");
		// ----------Right Click for selected area end--------------//
		return driver;
	}

	public static WebDriver AIOpopup(WebDriver driver) throws Exception {
		
		
		// -----------ProspectButton------------//
		
		Common.loader();
		CreateAOILocator.CreateAOIButton(driver).click();
		Thread.sleep(2000);
		CreateAOILocator.Header(driver, 2).click();
		i = Common.randomNumber();
		CreateAOILocator.ElementID(driver, "AOI_name").sendKeys("Test AOI " + i);

		CreateAOILocator.ElementID(driver, "Average EURs").sendKeys(
				"" + Common.randomNumber());
		CreateAOILocator.ElementID(driver, "Benches").sendKeys(
				"" + Common.randomNumber());
		CreateAOILocator.AOITypeClick(driver).click();
		Common.selectFirstFromList();
		ScreenShots.screenshots(driver, "AOI");
		log.info("Tract header filled sucessfully");
		// ------------Tract Header End--------------//
		Thread.sleep(2000);
		CreateAOILocator.ElementID(driver, "btnSaveAOI").click();
		log.info("AOI Created sucessfully");
		Common.loader();
		return driver;
	}
}
