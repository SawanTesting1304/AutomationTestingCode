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
import RRMMS.TestData.RRMMS_Urls;
import RRMMS.locators.AssociationLocator;
import RRMMS.locators.CreateProspectLocator;
import RRMMS.locators.LeaseLocator;
import RRMMS.locators.ProductionUnitLocator;
import RRMMS.start.Start;
import RRMMS.utility.Common;
import RRMMS.utility.Log;
import RRMMS.utility.ScreenShots;

public class CommonProductionUnit {
	
	static WebDriver driver;
	static Robot rb;
	static int result, row, n=1;
	static String ProspectName;
	static Logger log = Logger.getLogger(CreateProspect.class.getClass());
	public static WebDriver location(WebDriver driver) throws Exception
	{
		/*driver.navigate().to(RRMMS_Urls.baseUrl);*/
		Robot rb = new Robot();
		Actions action = new Actions(driver);
		Thread.sleep(3000);
		Common.loader();
		// Common.waitUntilLoads(driver);
		
		WebElement map = driver.findElement(By
				.xpath("//div[@id='map']/div[2]/canvas"));
		//Thread.sleep(3000);
		Common.loader();
		// Common.waitUntilLoads(driver);
		CreateProspectLocator.ElementID(driver, "smartsearchbox").click();
		Thread.sleep(2000);
		try {
			System.out.println("try");
			/*CreateProspectLocator.ElementID(driver, "smartsearchbox").sendKeys(
					"Tract");*/
			for (int i = 1; i <= 5; i++) {
				rb.keyPress(KeyEvent.VK_DOWN);
				rb.keyRelease(KeyEvent.VK_DOWN);
			}

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
		int row = Common.randomNumber2to10();
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
		Thread.sleep(1000);
		CreateProspectLocator.ElementID(driver, "smartsearchbox").sendKeys(
				" " + sheet.getCell(5, row).getContents());
		Thread.sleep(1000);
		CreateProspectLocator.ElementID(driver, "smartsearchbox").sendKeys(
				"" + sheet.getCell(6, row).getContents());
		Common.loader();
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		CreateProspectLocator.ElementID(driver, "smartsearchbox").sendKeys(
				" " + sheet.getCell(7, row).getContents());
		Common.loader();
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Common.loader();
		
		
		action.moveToElement(map, 675, 268).click().perform();

		log.info("Location found");
		// ----------Right Click for selected area--------------//
		Thread.sleep(3000);
		action.moveToElement(map, 675, 268).contextClick().perform();
		ScreenShots.screenshots(driver, "Work Flow");
		
		return driver;
	}

	
	public static WebDriver createLease(WebDriver driver) throws Exception {
		Thread.sleep(2000);
		driver.navigate().to(RRMMS_Urls.baseUrl);

		CommonProductionUnit.location(driver);
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
				Thread.sleep(2000);
				CreateProspectLocator.QtrCallClick(driver, i, r+1 ).click();
				Thread.sleep(2000);
				CreateProspectLocator.subsectionSelect(driver,
						(Common.randomNumber2to10() - 1)).click();
				Thread.sleep(2000);
				CreateProspectLocator.subsectionOKButton(driver).click();
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
	
	/*public static WebDriver Association(WebDriver driver) throws InterruptedException {
		
		 * ================================Association============================
		 * ================
		 
		
		Thread.sleep(2000);
		Common.loader();
		log.info("Association Start");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,950)", "");
		Thread.sleep(1000);
		Common.loader();
		AssociationLocator.AssociationOpenLink(driver).click();
		Thread.sleep(2000);
		
		  List<WebElement> List_size =
		  driver.findElements(By.xpath("//li[@id='lientity']/a")); 
		  int thCount= List_size.size(); System.out.println("Total Tract in List: " +(thCount));
		 
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
	}*/	
	public static WebDriver ProductionUnit(WebDriver driver) throws Exception {
		// -----------ProductionUnit button click start------------//
		Thread.sleep(2000);
		driver.navigate().to(RRMMS_Urls.baseUrl);
		Actions action = new Actions(driver);
		Thread.sleep(3000);
		Common.loader();
		// Common.waitUntilLoads(driver);
		WebElement map = driver.findElement(By
				.xpath("//div[@id='map']/div[2]/canvas"));
		CommonProductionUnit.location(driver);
		Common.loader();
		// -----------ProspectButton------------//
		Thread.sleep(3000);
		ProductionUnitLocator.CreateProductionUnitButtonClick(driver).click();
		//String NoWellFoundMessage;
		Common.loader();
		try
		{
			String NoWellFoundMessage=driver.findElement(By.xpath("html/body/div[2]/div[2]/p")).getText();
			System.out.println(NoWellFoundMessage);
			log.info(NoWellFoundMessage);
			if(NoWellFoundMessage.contains("Well found"))
			{
				driver.quit();
			}
			
			
		}catch(org.openqa.selenium.NoSuchElementException exception)
		{
			System.out.println("Wells are available on this section");
			log.info("Wells are available on this section");	
			/*int x=Common.randomNumberX();
			int y=Common.randomNumberX();
			action.moveToElement(map, x, y).click().perform();*/
			
		}
		
		
		log.info("Production Unit Well selection Start");
		Common.loader();
		//driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='production-unit-modal']")));
		try{
		ProductionUnitLocator.SelectProductionUnitWell(driver).click();
		}catch(org.openqa.selenium.NoSuchElementException exception)
		{
			Log.info("No Production Wells available");
		}
		Thread.sleep(3000);
		ProductionUnitLocator.AllSectionCheck(driver).click();
		Thread.sleep(3000);
		ProductionUnitLocator.NextButtonClick(driver).click();
		Common.loader();
		//if Already production unit exist
				try
				{
					String ProductionunitMessage=driver.findElement(By.xpath("html/body/div[2]/div[2]/p")).getText();
					System.out.println(ProductionunitMessage);
					log.info(ProductionunitMessage);
					if(ProductionunitMessage.contains("Production Unit already created!"))
					{
						driver.quit();
					}
					
				}catch(org.openqa.selenium.NoSuchElementException exception)
				{
					log.info("Production Unit Selected sucessfully ");
					log.info("Production Unit Create pop up Start");
				}
		
		// ------------Tract --------------//

		log.info("Tract info popup loaded sucessfully");
		
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
			String TotalRecord = ProductionUnitLocator.HeadCount(driver, i)
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
				ProductionUnitLocator.QtrCallClick(driver, i, r+1 ).click();
				Thread.sleep(2000);
				ProductionUnitLocator.subsectionSelect(driver,5).click();
				Thread.sleep(2000);
				ProductionUnitLocator.subsectionOKButton(driver).click();
			}
			}catch(org.openqa.selenium.NoSuchElementException e)
			{
				System.out.println("Catch");
			}
			log.info("Tract Subsection Updated");
			
			// ---------Select Subsection Pop up End-----------------//
		}
		log.info("Tract Created Sucessessfully");
		// ------------Tract End--------------//
		Common.loader();
		ProductionUnitLocator.PuHeader(driver).click();
		Thread.sleep(2000);
		ProductionUnitLocator.Putype(driver).click();
		Thread.sleep(700);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		ProductionUnitLocator.PuRelationShip(driver).click();
		Common.selectFromPUList();
		Thread.sleep(2000);
		Common.loader();
		Thread.sleep(2000);
		try{
		ProductionUnitLocator.PuSave(driver).click();
		}catch(org.openqa.selenium.NoSuchElementException exception)
		{
			log.info("Production unit Created Sucessessfully");
		}catch(org.openqa.selenium.ElementNotVisibleException e)
		{
			log.info("Production unit Created Sucessessfully");
		}
		
		log.info("Production unit Created Sucessessfully");
		
		return driver;
		
		
		// ------------Tract --------------//
		// -----------ProductionUnit button click end------------//
		
	}
	
	public static WebDriver EditProductionUnit(WebDriver driver)throws Exception
	{
		Common.loader();
		Robot rb=new Robot();
		// Common.waitUntilLoads(driver);
		/*WebElement map = driver.findElement(By
				.xpath("//div[@id='map']/div[2]/canvas"));*/
		CreateProspectLocator.ElementID(driver, "smartsearchbox").click();
		Common.loader();
		CreateProspectLocator.ElementID(driver, "smartsearchbox").sendKeys("ProductionUnit ");
		
			/*for (int i = 1; i <= 7; i++) {
				Thread.sleep(200);
				rb.keyPress(KeyEvent.VK_DOWN);
				rb.keyRelease(KeyEvent.VK_DOWN);
			}*/
			Thread.sleep(2000);
			//Start.getDriverInstance();
			
			Common.loader();
			Common.selectAnyFromList(30);
			//Common.selectFromList();
			Thread.sleep(2000);
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
			Common.loader();
			Common.loader();
			CreateProspectLocator.ActionButtonClick(driver).click();
			Actions action = new Actions(driver);
	    	WebElement we = ProductionUnitLocator.ActionListClick(driver, 1);
			action.moveToElement(we).build().perform();
			// ----------Mouse Hover to Clone option END-----//
			Thread.sleep(2000);
			ProductionUnitLocator.EditPUOptinoClick(driver).click();
			Thread.sleep(2000);
			
			//Edit production unit pop up
			
			Common.loader();
			ProductionUnitLocator.PuHeader(driver).click();
			Thread.sleep(2000);
			ProductionUnitLocator.Putype(driver).click();
			Thread.sleep(700);
			rb.keyPress(KeyEvent.VK_DOWN);
			rb.keyRelease(KeyEvent.VK_DOWN);
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			ProductionUnitLocator.PuRelationShip(driver).click();
			Thread.sleep(2000);
			Common.selectFromPUList();
			Thread.sleep(2000);
			Common.loader();
			Thread.sleep(2000);
			try{
			ProductionUnitLocator.PuSave(driver).click();
			}catch(org.openqa.selenium.NoSuchElementException exception)
			{
				log.info("Production unit Updated Sucessessfully");
			}catch(org.openqa.selenium.ElementNotVisibleException e)
			{
				log.info("Production unit Updated Sucessessfully");
			}
			
			log.info("Production unit Updated Sucessessfully");
			Common.loader();
		return driver;
	}
	
	public static WebDriver PU_MathDownload(WebDriver driver)throws Exception
	{
		Robot rb=new Robot();
		Common.loader();
		// Common.waitUntilLoads(driver);
		Common.loader();
			CreateProspectLocator.ActionButtonClick(driver).click();
			Actions action = new Actions(driver);
			Thread.sleep(2000);
	    	ProductionUnitLocator.ActionListClick(driver, 2).click();
			Common.loader();
			Thread.sleep(2000);
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			
			log.info("Production unit math Downloaded Sucessessfully");
			
			
		return driver;
	}
}
