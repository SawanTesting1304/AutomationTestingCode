package RRMMS.modules;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import jxl.Sheet;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import RRMMS.Test.CreateProspect;
import RRMMS.TestData.ExcelData;
import RRMMS.locators.CreateProspectLocator;
import RRMMS.locators.LeaseLocator;
import RRMMS.utility.Common;
import RRMMS.utility.ScreenShots;

public class CommonLeaseFunction {
	static WebDriver driver;
	static int result;
	static Logger log = Logger.getLogger(CreateProspect.class.getClass());
	
	public static WebDriver LeasePopUp(WebDriver driver) throws Exception {
		// -----------ProspectButton------------//
		Thread.sleep(2000);
		LeaseLocator.CreateLeaseButton(driver).click();
		// ------------Tract --------------//

		log.info("Tract info popup loaded sucessfully");
		ScreenShots.screenshots(driver, "Lease");

		// CreateProspectLocator.HeadCount(driver, i).getText();
		Thread.sleep(2000);
		List<WebElement> head_table = driver.findElements(By.xpath("//div/div/div/div/form/table/thead"));
		int thCount = head_table.size();
		System.out.println("Total Tract County: " + (thCount));
		log.info("Total Tract County: " + (thCount));
		for (int i = 0; i < thCount; i++) {
			Thread.sleep(2000);
			//CreateProspectLocator.HeadCount(driver, i).click();
			try{
			String TotalRecord = CreateProspectLocator.HeadCount(driver, i)
					.getText();
			String Count = Common.Trim(TotalRecord);
			int num = Integer.parseInt(Count);
			System.out.println("ROW: " + num);
			log.info("Total Row Found: " + num);

			// ---------Select Subsection Pop up-----------------//
			for (int r = 0; r <= num - 1; r++) {
				Thread.sleep(2000);
				CreateProspectLocator.QtrCallClick(driver, i, r + 1).click();
				Thread.sleep(2000);
				CreateProspectLocator.subsectionSelect(driver,
						(Common.randomNumber2to10() - 1)).click();
				Thread.sleep(2000);
				CreateProspectLocator.subsectionOKButton(driver).click();
			}
			}catch(org.openqa.selenium.NoSuchElementException e)
			{
				System.out.println("Catch");
			}
			log.info("Tract Subsection Updated");
			ScreenShots.screenshots(driver, "Lease");
			// ---------Select Subsection Pop up End-----------------//
		}
		log.info("Tract Created Sucessessfully");
		// ------------Tract End--------------//

		// ------------Tract Header--------------//
		log.info("Switch to Tract header sucessfully");
		ScreenShots.screenshots(driver, "Lease");
		Thread.sleep(1000);
		LeaseLocator.Header(driver, 3).click();
		// CreateProspectLocator.ElementID(driver,
		// "fullname").sendKeys("Test "+Common.randomNumber());
		LeaseLocator.TextBoxName(driver, "Lessor_input").click();
		Common.selectFromList();
		Thread.sleep(1000);
		LeaseLocator.TextBoxName(driver, "Operator_input").click();
		Common.selectFromList();
		LeaseLocator.TextBoxName(driver, "Lessee_input").click();
		Common.selectFromList();
		LeaseLocator.TextBoxName(driver, "Status_input").click();
		Common.selectFromList();
		LeaseLocator.TextBoxName(driver, "TermUnit_input").click();
		Common.selectFromList();
		LeaseLocator.ElementID(driver, "Royalty").sendKeys(
				"" + Common.randomDecimalNumber());

		LeaseLocator.ElementID(driver, "Term").sendKeys(
				"" + Common.randomNumber2to10());
		LeaseLocator.ElementID(driver, "LDescription").sendKeys(
				"Test Description " + Common.randomNumber());
		ScreenShots.screenshots(driver, "Lease");
		for (int r = 0; r < thCount - 3; r++) {
			LeaseLocator.ElementIDint(driver, "Volume", r).sendKeys(
					"" + Common.randomNumber2to10());
			LeaseLocator.ElementIDint(driver, "PageNo", r).sendKeys(
					"" + Common.randomNumber2to10());
			ScreenShots.screenshots(driver, "Lease");
		}
		log.info("Tract header filled sucessfully");
		// ------------Tract Header End--------------//

		LeaseLocator.SaveLease(driver).click();

		log.info("Tract Created Sucessessfully");
		Thread.sleep(2000);
		Common.loader();
		// ------------Tract End--------------//
		return driver;
	}
    
    public static WebDriver SearchLocation(WebDriver driver) throws Exception 
    {
    for (int k = 1; k <=1; k++) {
		if(k!=1)
		{
			driver.get("http://rrmms.dev.verdico.com/index");
		}
	Robot rb = new Robot();
	Actions action = new Actions(driver);
	Thread.sleep(2000);
	Common.loader();
	WebElement map = driver.findElement(By
			.xpath("//div[@id='map']/div[2]/canvas"));
	
	ScreenShots.screenshots(driver, "Lease");
	Thread.sleep(2000);
	Common.loader();
	
		System.out.println("Loop"+k);
		Common.loader();
		CreateProspectLocator.ElementID(driver, "smartsearchbox").click();
		Thread.sleep(2000);
		for (int i = 1; i <= 5; i++) {
			rb.keyPress(KeyEvent.VK_DOWN);
			rb.keyRelease(KeyEvent.VK_DOWN);
		}
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		Sheet sheet = ExcelData.GetData("Location");
		int row = Common.randomNumber2to10();
		System.out.println(row);
		CreateProspectLocator.ElementID(driver, "smartsearchbox").sendKeys(
				" " + sheet.getCell(2, row).getContents());
		Thread.sleep(4000);
		CreateProspectLocator.ElementID(driver, "smartsearchbox").sendKeys(
				" " + sheet.getCell(3, row).getContents());
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(10000);
		Common.waitUntilLoads(driver);
		CreateProspectLocator.ElementID(driver, "smartsearchbox").sendKeys(
				" " + sheet.getCell(4, row).getContents());
		Thread.sleep(4000);
		Common.waitUntilLoads(driver);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(4000);
		ScreenShots.screenshots(driver, "Lease");
		for (int i = 0; i <= 1; i++) {
			action.moveToElement(map, 688, 382).doubleClick().perform();
		}
		/*
		 * Thread.sleep(4000); action.moveToElement(map, 923,
		 * 337).click().perform();
		 */
		Thread.sleep(2000);
		action.moveToElement(map, 969, 271).click().perform();

		log.info("Location found");
		ScreenShots.screenshots(driver, "Lease");
		// ----------Right Click for selected area--------------//
		Thread.sleep(3000);
		action.moveToElement(map, 969, 271).contextClick().perform();
		ScreenShots.screenshots(driver, "Work Flow");
		// ----------Right Click for selected area end--------------//
		
    }
	return driver;
		
		
	}
    
    public static WebDriver searchLease(WebDriver driver) throws Exception {
		log.info("Search Lease By Smart Search Start");
		ScreenShots.screenshots(driver, "Lease");
		String LeaseName=LeaseLocator.LesaeName(driver).getText();
		LeaseName=Common.Trim(LeaseName);
		Thread.sleep(2000);
		driver.get("http://rrmms.dev.verdico.com/index");
		Thread.sleep(2000);
		Common.loader();
		Robot rb = new Robot();
		CreateProspectLocator.ElementID(driver, "smartsearchbox").click();
		CreateProspectLocator.ElementID(driver, "smartsearchbox").clear();
		Thread.sleep(2000);
		for (int i = 1; i <= 6; i++) {
			rb.keyPress(KeyEvent.VK_DOWN);
			rb.keyRelease(KeyEvent.VK_DOWN);
		}
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		
		CreateProspectLocator.ElementID(driver, "smartsearchbox").sendKeys(""+LeaseName);
		
		ScreenShots.screenshots(driver, "Lease");
		Thread.sleep(2000);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		/*List<WebElement> List_size = driver.findElements(By
				.xpath("//li[@id='lientity']/a"));
		int thCount = List_size.size();
		System.out.println("Total Tract in List: " + (thCount));
		log.info("Total Tract County: " + (thCount));
		for (int i = 0; i < thCount; i++) {
			Common.selectFromList();
		}
		ScreenShots.screenshots(driver, "Lease");
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);*/
		log.info("Lease Search By Smart Search Completed");
		return driver;

	}
    
    public static WebDriver EditLeaseTract(WebDriver driver)throws Exception {
		Thread.sleep(15000);
		Common.loader();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,800)", "");
		// AddTractByMaP();
		// Thread.sleep(25000);
		// LeaseLocator.OpenTract(driver).click();
		try {
			for (int j = 0; j <= 3; j++) {
				try {
					Thread.sleep(1000);
					// CreateProspectLocator.OpenCounty(driver, j).click();
					result = 1;

				} catch (org.openqa.selenium.NoSuchElementException e) {
					result = 0;
				}

				for (int i = 1; i <= 3; i++) {

					if (result == 1) {
						LeaseLocator.LeaseQuad(driver, j, i).click();
						Thread.sleep(2000);
						jse.executeScript("window.scrollBy(0,100)", "");
						// LeaseLocator.ClearQuad(driver).click();
						Thread.sleep(2000);
						CreateProspectLocator.subsectionSelect(driver,
								(Common.randomNumber2to10() - 1)).click();
						Thread.sleep(2000);
						CreateProspectLocator.subsectionOKButton(driver)
								.click();

					}
					ScreenShots.screenshots(driver, "Prospect");

				}
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
			log.info("All tract updated");
		}
		log.info("Tract Result updated Sucessfully");
		return driver;

	}
    
    public static int CountyCount() {
		List<WebElement> Table_Row = driver
				.findElements(By
						.xpath("html/body/div[1]/div/div[3]/div/ui-view/main/div/div[1]/div/div/div[2]/div/div/div/div/div[3]/div/div/div/div/div/div[1]/table/tbody/tr"));
		int County = Table_Row.size();
		System.out.println("Total County: " + (County - 1));
		return County - 1;
	}

}
