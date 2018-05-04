package RRMMS.modules;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import RRMMS.Test.CreateProspect;
import RRMMS.Test.Login;
import RRMMS.TestData.RRMMS_Urls;
import RRMMS.locators.DivisionOrderLocators;
import RRMMS.locators.ProductionUnitLocator;
import RRMMS.utility.Common;
import RRMMS.utility.Log;
import RRMMS.utility.ScreenShots;

public class CommonCreatePU {
	static WebDriver driver;
	Login l1 = new Login();
	String Location;
	static String Production_Unit_Name;
	static Logger log = Logger.getLogger(CreateProspect.class.getClass());
	public static WebDriver ProductionUnit(WebDriver driver) throws Exception {
		// -----------ProductionUnit button click start------------//
		
		Common.loader();
		// -----------ProspectButton------------//
		Robot rb = new Robot();
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
		Production_Unit_Name=ProductionUnitLocator.PuName(driver).getText();
		Common.loader();
		return driver;
		
		
		// ------------Tract --------------//
		// -----------ProductionUnit button click end------------//
		
	}
	
	public static WebDriver CreateDO(WebDriver driver)throws Exception{
		Robot rb = new Robot();
		Common.loader();
		//Thread.sleep(3000);
		//DivisionOrderLocators.ElementID(driver, "chkSideMenuBar").click();
		ScreenShots.screenshots(driver, "Division Order");
		Common.loader();
		DivisionOrderLocators.DivisionOrderMenuClick(driver).click();
		DivisionOrderLocators.MenuAddDo(driver).click();
		Thread.sleep(1000);
		Common.loader();
		/*log.info("Division Order List Opened");
		DivisionOrderLocators.AddDO(driver).click();*/
		log.info("Creating Division Order Start");
		Common.loader();
		//Header Section DO//
		log.info("Header section Start");
		Thread.sleep(800);
		DivisionOrderLocators.IssureInput(driver).click();
		Common.selectFromList();
		
		
		DivisionOrderLocators.ElementID(driver, "OwnerNumber").sendKeys(""+Common.randomNumber());
		DivisionOrderLocators.ElementID(driver, "Property").sendKeys(""+Common.randomNumber());
		DivisionOrderLocators.ElementID(driver, "doDecInt").sendKeys(""+Common.randomDecimalNumber());
		DivisionOrderLocators.ElementID(driver, "doProdNri").sendKeys(""+Common.randomDecimalNumber());
		Thread.sleep(800);
		DivisionOrderLocators.Source(driver).click();
		Common.selectFirstFromList();
		Thread.sleep(800);
		DivisionOrderLocators.Type(driver).click();
		Common.selectFirstFromList();
		log.info("Header section completed");
		//Header Section DO End//
		
		
		
		
		//-------Search And Select-------//
		log.info("Search And Select County");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,200)", "");
		
	/*	DivisionOrderLocators.state_input(driver).click();
		Common.selectFirstFromList();
		Common.loader();
		
		DivisionOrderLocators.County_input(driver).click();
		Common.selectFirstFromList();
		Common.loader();
		
		DivisionOrderLocators.Block_input(driver).click();
		Common.selectFirstFromList();
		Common.loader();
		
		DivisionOrderLocators.Section_input(driver).click();
		Common.selectFirstFromList();
		Common.loader();*/
		Common.loader();
		DivisionOrderLocators.Asset_input(driver).click();
		Thread.sleep(2000);
		DivisionOrderLocators.Asset_input(driver).sendKeys(""+Production_Unit_Name);
		Common.loader();
		
		/*DivisionOrderLocators.Lease_input(driver).click();
		Common.selectFirstFromList();
		Common.loader();*/
		DivisionOrderLocators.ElementID(driver, "searchBtn").click();
		Common.loader();
		log.info("Search and Select County section Completed");
		try
		{
			String text=DivisionOrderLocators.SearchNoResult(driver).getText();
			if(text.contains("No Records available. Please initiate search."))
				log.info("No Records available. Please initiate search.");
			driver.close();
				
		}catch(org.openqa.selenium.InvalidSelectorException e){
			//DivisionOrderLocators.AppylButtonClick(driver).click();
			log.info("Division Order created sucessfully");
			//-------Search And Select End-------//
			
			//*[@id='porTable0000']/table/tbody/tr[1]/th[1]/label
			
			try {
				for (int i = 0; i <= 2; i++) {
					Thread.sleep(500);
					jse.executeScript("window.scrollBy(0,200)", "");
					if(i==0 || driver.findElement(By.xpath("//div[@id='collapsemePlus000']/div["+i+1+"]/div[1]/a")).equals(driver.findElement(By.xpath("//div[@id='collapsemePlus000']/div["+i+2+"]/div[1]/a"))))
						DivisionOrderLocators.CheckBox(driver, i).click();
					log.info("Tract is Checked");
				}
			} catch (org.openqa.selenium.NoSuchElementException exception) {
				System.out.println("All Tract are checked");
				log.info("All Tract are checked");
			} 
			
		}catch(org.openqa.selenium.NoSuchElementException e){
		//	DivisionOrderLocators.AppylButtonClick(driver).click();
			log.info("Division Order created sucessfully");
			//-------Search And Select End-------//
			
			//*[@id='porTable0000']/table/tbody/tr[1]/th[1]/label
			
			try {
				for (int i = 0; i <= 2; i++) {
					Thread.sleep(500);
					jse.executeScript("window.scrollBy(0,200)", "");
					if(i==0 || driver.findElement(By.xpath("//div[@id='collapsemePlus000']/div["+i+1+"]/div[1]/a")).equals(driver.findElement(By.xpath("//div[@id='collapsemePlus000']/div["+i+2+"]/div[1]/a"))))
					DivisionOrderLocators.CheckBox(driver, i).click();
					log.info("Tract is Checked");
				}
			} catch (org.openqa.selenium.NoSuchElementException exception) {
				System.out.println("All Tract are checked");
				log.info("All Tract are checked");
			} 
			
		}catch (org.openqa.selenium.ElementNotVisibleException exception) {
			//DivisionOrderLocators.AppylButtonClick(driver).click();
			log.info("Division Order created sucessfully");
			//-------Search And Select End-------//
			
			//*[@id='porTable0000']/table/tbody/tr[1]/th[1]/label
			
			try {
				for (int i = 0; i <= 2; i++) {
					Thread.sleep(500);
					jse.executeScript("window.scrollBy(0,200)", "");
					if(i==0 || driver.findElement(By.xpath("//div[@id='collapsemePlus000']/div["+i+1+"]/div[1]/a")).equals(driver.findElement(By.xpath("//div[@id='collapsemePlus000']/div["+i+2+"]/div[1]/a"))))
					DivisionOrderLocators.CheckBox(driver, i).click();
					log.info("Tract is Checked");
				}
			} catch (org.openqa.selenium.NoSuchElementException e) {
				System.out.println("All Tract are checked");
				log.info("All Tract are checked");
			} 
			}
			
			
			
			//Apply button Click'//
			jse.executeScript("window.scrollBy(0,-900)", "");
			Common.loader();
			DivisionOrderLocators.AppylButtonClick(driver).click();
			log.info("Division Order created sucessfully");
		
		return driver;
		
	}
	

}
