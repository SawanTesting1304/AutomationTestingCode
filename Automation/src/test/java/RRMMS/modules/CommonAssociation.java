package RRMMS.modules;

import java.awt.AWTException;
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
import RRMMS.TestData.RRMMS_Urls;
import RRMMS.locators.AssociationLocator;
import RRMMS.locators.CreateProspectLocator;
import RRMMS.locators.LeaseLocator;
import RRMMS.locators.WorkFlowLocator;
import RRMMS.utility.Common;
import RRMMS.utility.ScreenShots;

public class CommonAssociation {
	static WebDriver driver;
	static Logger log = Logger.getLogger(CreateProspect.class.getClass());
	static int result, row, num;
	static String ProspectName;
	
	public static WebDriver SearchLocation(WebDriver driver) throws Exception
	{
		Robot rb = new Robot();
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		
		Common.loader();
		WebElement map = driver.findElement(By
				.xpath("//div[@id='map']/div[2]/canvas"));
		Thread.sleep(7000);
		ScreenShots.screenshots(driver, "Work Flow");
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
		row = Common.randomNumber2to10();
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
		CreateProspectLocator.ElementID(driver, "smartsearchbox").sendKeys(
				" " + sheet.getCell(4, row).getContents());
		Common.loader();
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Common.loader();
		CreateProspectLocator.ElementID(driver, "smartsearchbox").sendKeys(
				" " + sheet.getCell(5, row).getContents());
		Common.loader();
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		
		for (int i = 0; i <= 1; i++)
		{
			action.moveToElement(map, 688, 382).doubleClick().perform();
		}

		Thread.sleep(7000);
		action.moveToElement(map, 923, 337).click().perform();

		log.info("Location found");
		// ----------Right Click for selected area--------------//
		Thread.sleep(3000);
		action.moveToElement(map, 923, 337).contextClick().perform();
		ScreenShots.screenshots(driver, "Work Flow");
		// ----------Right Click for selected area end--------------//
		return driver;
	}

	
	public static WebDriver ProspectPopUp(WebDriver driver) throws Exception {
		// -----------ProspectButton------------//
		Thread.sleep(3000);
		CreateProspectLocator.CreateProspectButton(driver).click();

		// ------------Tract --------------//
		log.info("Tract info popup loaded sucessfully");
		ScreenShots.screenshots(driver, "Work Flow");

		// CreateProspectLocator.HeadCount(driver, i).getText();
		Thread.sleep(2000);
		List<WebElement> head_table = driver.findElements(By.xpath("//div/div/div/div/form/table/thead"));
		int thCount = head_table.size();
		System.out.println("Total Tract County: " + (thCount));
		log.info("Total Tract County: " + (thCount));
		for (int i = 0; i < thCount; i++) {
			Thread.sleep(2000);
			String TotalRecord = CreateProspectLocator.HeadCount(driver, i)
					.getText();
			String Count = Common.Trim(TotalRecord);
			int num = Integer.parseInt(Count);
			System.out.println("ROW: " + num);
			log.info("Total Row Found: " + num);

			// ---------Select Subsection Pop up-----------------//
			for (int r = 0; r <= num - 1; r++) {
				Thread.sleep(2000);
				CreateProspectLocator.QtrCallClick(driver, i , r+1).click();
				Thread.sleep(2000);
				CreateProspectLocator.subsectionSelect(driver,
						5).click();
				Thread.sleep(2000);
				CreateProspectLocator.subsectionOKButton(driver).click();
				Thread.sleep(2000);
				/*WorkFlowLocator.ProspectNetRoyAcer(driver, r).sendKeys(
						"" + Common.randomNumber());*/
				Thread.sleep(2000);
				WorkFlowLocator.ProspectDecInt(driver, r+1).clear();
				WorkFlowLocator.ProspectDecInt(driver, r+1).sendKeys(
						"" + Common.randomDecimalNumber());
				Thread.sleep(2000);
			}
			log.info("Tract Subsection Updated");
			ScreenShots.screenshots(driver, "Prospect");
			// ---------Select Subsection Pop up End-----------------//
			ScreenShots.screenshots(driver, "Work Flow");
		}
		log.info("Tract Created Sucessessfully");
		// ------------Tract End--------------//

		// ------------Tract Header--------------//
		log.info("Switch to Tract header sucessfully");
		ScreenShots.screenshots(driver, "Work Flow");
		Thread.sleep(1000);
		CreateProspectLocator.Header(driver, 3).click();
		CreateProspectLocator.ElementID(driver, "fullname").sendKeys(
				"Test " + Common.randomNumber());
		CreateProspectLocator.TextBoxName(driver, "Source_input").click();
		Common.selectFromList();
		Thread.sleep(1000);
		CreateProspectLocator.TextBoxName(driver, "play_input").click();
		Common.selectFromList();
		CreateProspectLocator.TextBoxName(driver, "seller_input").click();
		Common.selectFromList();
		CreateProspectLocator.TextBoxName(driver, "buyer_input").click();
		Common.selectFromList();
		CreateProspectLocator.TextBoxName(driver, "Landman_input").click();
		Common.selectFromList();
		CreateProspectLocator.ElementID(driver, "EstPurchasePrice").sendKeys(
				"" + Common.randomNumber());
		CreateProspectLocator.ElementID(driver, "LegalDescription").sendKeys(
				"Test Description" + Common.randomDecimalNumber());

		ScreenShots.screenshots(driver, "Work Flow");
		log.info("Tract header filled sucessfully");
		// ------------Tract Header End--------------//

		CreateProspectLocator.ElementID(driver, "btnSaveProspect").click();

		log.info("Tract Created Sucessessfully");
		// ------------Tract End--------------//
		Common.loader();
		Common.loader();
		ProspectName=CreateProspectLocator.ProspectName(driver).getText();
		Common.loader();
		ProspectName=CreateProspectLocator.ProspectName(driver).getText();
		return driver;
	}
	
	public static WebDriver createLease(WebDriver driver) throws Exception {
		Thread.sleep(2000);
		driver.navigate().to(RRMMS_Urls.baseUrl);

		Robot rb = new Robot();
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		Common.loader();
		WebElement map = driver.findElement(By
				.xpath("//div[@id='map']/div[2]/canvas"));
		Thread.sleep(7000);
		ScreenShots.screenshots(driver, "Work Flow");
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
		//row = Common.randomNumber2to10();
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
		CreateProspectLocator.ElementID(driver, "smartsearchbox").sendKeys(
				" " + sheet.getCell(4, row).getContents());
		Common.loader();
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Common.loader();
		CreateProspectLocator.ElementID(driver, "smartsearchbox").sendKeys(
				" " + sheet.getCell(5, row).getContents());
		Common.loader();
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		
		for (int i = 0; i <= 1; i++)
		{
			action.moveToElement(map, 688, 382).doubleClick().perform();
		}

		Thread.sleep(7000);
		action.moveToElement(map, 923, 337).click().perform();

		log.info("Location found");
		// ----------Right Click for selected area--------------//
		Thread.sleep(3000);
		action.moveToElement(map, 923, 337).contextClick().perform();
		ScreenShots.screenshots(driver, "Work Flow");
		// ----------Right Click for selected area end--------------//

		// -----------ProspectButton------------//
		Thread.sleep(3000);
		LeaseLocator.CreateLeaseButton(driver).click();
		// ------------Tract --------------//

		log.info("Tract info popup loaded sucessfully");
		ScreenShots.screenshots(driver, "Lease");

		// CreateProspectLocator.HeadCount(driver, i).getText();
		// CreateProspectLocator.HeadCount(driver, i).getText();
		Thread.sleep(2000);
		List<WebElement> head_table = driver.findElements(By
				.xpath("//div/div/div/div/form/table/thead"));
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
			//============Temp code Start============//
			//CreateProspectLocator.HeadCount(driver, i).click();
			//============Temp code End============//
			// ---------Select Subsection Pop up-----------------//
			for (int r = 0; r <= num - 1; r++) {
				Common.loader();
				CreateProspectLocator.QtrCallClick(driver, i, r+1 ).click();
				Thread.sleep(2000);
				CreateProspectLocator.subsectionSelect(driver,
						5).click();
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
		// ------------Tract End--------------//
		Thread.sleep(2000);
		Common.loader();
		return driver;
	}

	public static WebDriver searchLease(WebDriver driver) throws Exception {
		log.info("Search Lease By Smart Search Start");
		ScreenShots.screenshots(driver, "Lease");
		Thread.sleep(4000);
		Robot rb = new Robot();
		CreateProspectLocator.ElementID(driver, "smartsearchbox").click();
		Thread.sleep(500);
		CreateProspectLocator.ElementID(driver, "smartsearchbox").clear();
		Thread.sleep(2000);
		CreateProspectLocator.ElementID(driver, "smartsearchbox").sendKeys("Lease");
		/*for (int i = 1; i <= 6; i++) {
			rb.keyPress(KeyEvent.VK_DOWN);
			rb.keyRelease(KeyEvent.VK_DOWN);
		}*/
		Thread.sleep(2000);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		ScreenShots.screenshots(driver, "Lease");
		Thread.sleep(2000);
		List<WebElement> List_size = driver.findElements(By
				.xpath("//li[@id='lientity']/a"));
		int thCount = List_size.size();
		System.out.println("Total Tract in List: " + (thCount));
		log.info("Total Tract County: " + (thCount));
		for (int i = 0; i < thCount; i++) {
			rb.keyPress(KeyEvent.VK_DOWN);
			rb.keyRelease(KeyEvent.VK_DOWN);
		}
		ScreenShots.screenshots(driver, "Lease");
		Thread.sleep(1000);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		log.info("Lease Search By Smart Search Completed");
		return driver;

	}

	public static WebDriver Association(WebDriver driver) throws InterruptedException {
		/*
		 * ================================Association============================
		 * ================
		 */
		
		Thread.sleep(2000);
		Common.loader();
		log.info("Association Start");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,950)", "");
		Thread.sleep(1000);
		Common.loader();
		AssociationLocator.AssociationOpenLink(driver).click();
		Thread.sleep(2000);
		
		/*  List<WebElement> List_size =
		  driver.findElements(By.xpath("//li[@id='lientity']/a")); 
		  int thCount= List_size.size(); System.out.println("Total Tract in List: " +(thCount));*/
		 
		try {
			for (int i = 1; i <= 5; i++) {
				Thread.sleep(500);
				AssociationLocator.ProspectCheck(driver, i).click();
				log.info("Prospects are checked");
			}
		} catch (org.openqa.selenium.NoSuchElementException exception) {
			System.out.println("All prospects are checked");
			log.info("All prospects are checked");
		} catch (org.openqa.selenium.ElementNotVisibleException exception) {
			System.out.println("All prospects are checked");
			log.info("All prospects are checked");
		}

		Thread.sleep(1000);
		AssociationLocator.AssetTabClick(driver).click();
		Thread.sleep(2000);
		try {
			for (int i = 1; i <= 5; i++) {
				Thread.sleep(500);
				AssociationLocator.AssetCheck(driver, i).click();
				log.info("Asset are checked");
			}
		} catch (org.openqa.selenium.NoSuchElementException exception) {
			System.out.println("All Asset are checked");
			log.info("All Asset are checked");
		} catch (org.openqa.selenium.ElementNotVisibleException exception) {
			System.out.println("All prospects are checked");
			log.info("All Asset are checked");
		}
		Thread.sleep(2000);
		AssociationLocator.ProspectTabClick(driver).click();

		Thread.sleep(2000);
		AssociationLocator.SaveButton(driver).click();
		Thread.sleep(2000);
		log.info("Association Completed");
		Thread.sleep(2000);
		return driver;
	}
	
	
	//*[@id="LeaseRoyalty"]
	public static WebDriver LeaseRoyality(WebDriver driver) throws InterruptedException, AWTException {
		Common.loader();
		Robot rb = new Robot();
		CreateProspectLocator.ElementID(driver, "smartsearchbox").click();
		for (int i = 1; i <= 1; i++) {
			rb.keyPress(KeyEvent.VK_DOWN);
			rb.keyRelease(KeyEvent.VK_DOWN);
		}
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(500);
		CreateProspectLocator.ElementID(driver, "smartsearchbox").sendKeys(""+ProspectName);
		Common.loader();
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		System.out.println(ProspectName);
		Common.loader();
		Common.loader();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,950)", "");
		Common.loader();
		try{
			AssociationLocator.LeaseRoyaltyClick(driver).click();
			Thread.sleep(1000);
			AssociationLocator.LeaseGrossRoyalty(driver).click();
			Common.loader();
			AssociationLocator.LeaseGrossRoyaltySave(driver).click();
			log.info("Lease Gross Royality Applied Sucessfully");
			Common.loader();
			AssociationLocator.LeaseRoyaltyClick(driver).click();
			Thread.sleep(1000);
			AssociationLocator.SplitIntrest(driver).click();
			Common.loader();
			String TractDecimalIntrest=AssociationLocator.TractDecimalIntrest(driver).getText();
			double DI=Double.parseDouble(TractDecimalIntrest);
			double Tract1_DI, Tract2_DI;
			
			Tract1_DI=DI-0.00045;
			Tract2_DI=0.00045;
			
			AssociationLocator.DecimalIntrest(driver, 0).sendKeys(""+TractDecimalIntrest);
			Thread.sleep(500);
		/*	AssociationLocator.DecimalIntrest(driver, 1).sendKeys(""+Tract2_DI);
			Thread.sleep(500);*/
			
			AssociationLocator.LeaseGrossRoyaltySave(driver).click();
			log.info("Split Intrest Applied Sucessfully");
		}catch(org.openqa.selenium.NoSuchElementException e)
		{
			System.out.println("Element not found");
		}
		
		
		Common.loader();
		return driver;
		
	}
	
}
