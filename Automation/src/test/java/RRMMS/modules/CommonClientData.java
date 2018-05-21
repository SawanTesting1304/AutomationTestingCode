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
import RRMMS.locators.ClientDataLocator;
import RRMMS.locators.CreateProspectLocator;
import RRMMS.locators.LeaseLocator;
import RRMMS.locators.ProductionUnitLocator;
import RRMMS.locators.WorkFlowLocator;
import RRMMS.start.Start;
import RRMMS.utility.Common;
import RRMMS.utility.Log;
import RRMMS.utility.ScreenShots;

public class CommonClientData {

	static WebDriver driver;
	static int result, i=1;
	static Logger log = Logger.getLogger(CreateProspect.class.getClass());
	static String State, County, Blk, Tshp, Sect, Legal_Description,ProductionUnitName="GERMANIA SPRABERRY UNIT", wellName2, wellName1, Gross,Price,Term,LeaseNote, LeaseQtrCall, DecimalInt, SearchState,FirstName, LastName, Entity, Play, LegalDescription, SellerDetails;

	public static WebDriver GetClientData(WebDriver driver)
			throws InterruptedException {

		System.out.println("Client Data Loading...");
		driver.navigate().to(RRMMS_Urls.ClientDataURL);
		// Common.ClientDataloader();
		/*
		 * ClientDataLocator.RegNoClick(driver,
		 * Common.randomNumber2to10()+20).click();
		 */
		Common.loader();
		
		//Reg No. 27, 95, 173, 
		wellName2=ClientDataLocator.RegNoClick(driver, 192).getText();
		ClientDataLocator.RegNoClick(driver, 192).click();

		Common.loader();
		State = ClientDataLocator.State(driver).getAttribute("value");
		County = ClientDataLocator.County(driver).getAttribute("value");
		Blk = ClientDataLocator.Blk(driver).getAttribute("value");
		Tshp = ClientDataLocator.Tshp(driver).getAttribute("value");
		Sect = ClientDataLocator.Sect(driver).getAttribute("value");
		Legal_Description = ClientDataLocator.Legal_Description(driver)
				.getAttribute("value");
		Gross=ClientDataLocator.Gross(driver).getAttribute("value");
		DecimalInt=ClientDataLocator.DecimalInt(driver).getAttribute("value");
		
		LeaseQtrCall= ClientDataLocator.LeaseQtrCall(driver).getAttribute("value");
		LeaseNote=ClientDataLocator.LeaseNotes(driver).getText();
		Term=ClientDataLocator.Term(driver).getAttribute("value");
		
		
		SellerDetails=ClientDataLocator.SellerDetails(driver).getText();
		ClientDataLocator.SellerDetails(driver).click();
		Common.loader();
		FirstName=ClientDataLocator.FirstName(driver).getAttribute("value"); 
		LastName=ClientDataLocator.LastName(driver).getAttribute("value"); 
		Entity=ClientDataLocator.Entity(driver).getAttribute("value"); 
		Play=ClientDataLocator.Play(driver).getAttribute("value"); 
		LegalDescription=ClientDataLocator.LegalDescription(driver).getText();
		Price=ClientDataLocator.Price(driver).getAttribute("value");

		wellName1=ClientDataLocator.Wellname1(driver,ProductionUnitName).getText();
		
		
		System.out.println("State: " + State + " County:" + County + " Block: "
				+ Blk + " TownShip: " + Tshp + " Section: " + Sect
				+ " Legal Description: " + Legal_Description);
		
		System.out.println("SellerDetails: "+SellerDetails+" FirstName:"+FirstName+" LastName: "+ LastName+" Entity: "+Entity+" Play: "+Play+" LegalDescription: "+ LegalDescription);
		Common.loader();
		
		System.out.println("Decimal Int: "+DecimalInt+" Gross: "+Gross);
		System.out.println("WellName: "+wellName2+wellName1);
		return driver;
	}

	public static WebDriver searchProspectLocation(WebDriver driver)
			throws Exception {
		driver.navigate().to(RRMMS_Urls.baseUrl); 
		Common.loader();
		if(i==1)
		{
			Common.logIN();
			i++;
		}
		Robot rb = new Robot();
		Actions action = new Actions(driver);
		Thread.sleep(3000);
		Common.loader();
		// Common.waitUntilLoads(driver);

		WebElement map = driver.findElement(By
				.xpath("//div[@id='map']/div[2]/canvas"));
		// Thread.sleep(3000);
		Common.loader();
		// Common.waitUntilLoads(driver);
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
		/*
		Sheet sheet = ExcelData.GetData("Location");
		int row = Common.randomNumber2to10();
		System.out.println(row);*/
		if(State.contentEquals("Texas"))
			SearchState ="TX";
		
		CreateProspectLocator.ElementID(driver, "smartsearchbox").sendKeys(
				" " + SearchState);
		Common.loader();
		CreateProspectLocator.ElementID(driver, "smartsearchbox").sendKeys(
				" " + County);
		Common.loader();
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Common.loader();
		CreateProspectLocator.ElementID(driver, "smartsearchbox").sendKeys(
				" " + Blk+" T");
		Thread.sleep(2000);
		CreateProspectLocator.ElementID(driver, "smartsearchbox").sendKeys(
				"1");
		Thread.sleep(2000);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Common.loader();
		CreateProspectLocator.ElementID(driver, "smartsearchbox").sendKeys(
				" " + Sect);
		
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Common.loader();
		

		
		action.moveToElement(map, 675, 268).click().perform();

		log.info("Location found");
		// ----------Right Click for selected area--------------//
		Thread.sleep(3000);
		action.moveToElement(map, 675, 268).contextClick().perform();
		ScreenShots.screenshots(driver, "Work Flow");
		// ----------Right Click for selected area end--------------//
		return driver;
	}

	public static WebDriver ProspectPopUp(WebDriver driver) throws Exception {
		// -----------ProspectButton------------//
		Thread.sleep(3000);
		CreateProspectLocator.CreateProspectButton(driver).click();
		Robot rb = new Robot();
		// ------------Tract --------------//
		log.info("Tract info popup loaded sucessfully");
		ScreenShots.screenshots(driver, "Work Flow");

		// CreateProspectLocator.HeadCount(driver, i).getText();
		Thread.sleep(2000);
		List<WebElement> head_table = driver.findElements(By
				.xpath("//div/div/div/div/form/table/thead"));
		int thCount = head_table.size();
		System.out.println("Total Tract County: " + (thCount));
		log.info("Total Tract County: " + (thCount));
		for (int i = 0; i < thCount; i++) {
			Thread.sleep(2000);
			try {
				String TotalRecord = CreateProspectLocator.HeadCount(driver, i)
						.getText();
				String Count = Common.Trim(TotalRecord);
				int num = Integer.parseInt(Count);
				System.out.println("ROW: " + num);
				log.info("Total Row Found: " + num);

				// ---------Select Subsection Pop up-----------------//
				for (int r = 0; r <= num - 1; r++) {
					Thread.sleep(2000);
					CreateProspectLocator.QtrCallClick(driver, i, r + 1)
							.click();
					Thread.sleep(2000);
					/*CreateProspectLocator.subsectionSelect(driver,
							(Common.randomNumber2to10() - 1)).click();*/
					CreateProspectLocator.subsectionSelect(driver, 5).click();
					Thread.sleep(2000);
					CreateProspectLocator.subsectionOKButton(driver).click();
					Thread.sleep(2000);
					/*
					 * WorkFlowLocator.ProspectNetRoyAcer(driver, r).sendKeys(
					 * "" + Common.randomNumber());
					 */
					Thread.sleep(2000);
					WorkFlowLocator.ProspectDecInt(driver, r + 1).clear();
					WorkFlowLocator.ProspectDecInt(driver, r + 1).sendKeys(
							"" + DecimalInt);
					/*Thread.sleep(2000);
					WorkFlowLocator.ProspectGross(driver, r+1).clear();
					WorkFlowLocator.ProspectGross(driver, r+1).sendKeys("" + Gross+".00");
					Thread.sleep(1000);
					WorkFlowLocator.ProspectDecInt(driver, r + 1).click();*/
					Thread.sleep(2000);
				}
			} catch (org.openqa.selenium.NoSuchElementException e) {
				System.out.println("Catch");
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
				" "+Entity+" "+ + Common.randomNumber());
		CreateProspectLocator.TextBoxName(driver, "Source_input").click();
		CreateProspectLocator.TextBoxName(driver, "Source_input").sendKeys(""+FirstName+" "+LastName);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		CreateProspectLocator.TextBoxName(driver, "play_input").click();
		//CreateProspectLocator.TextBoxName(driver, "play_input").sendKeys(""+Play);
		Common.selectFromList();
		CreateProspectLocator.TextBoxName(driver, "seller_input").click();
		Common.selectFromList();
		CreateProspectLocator.TextBoxName(driver, "buyer_input").click();
		Common.selectFromList();
		CreateProspectLocator.TextBoxName(driver, "Landman_input").click();
		Common.selectFromList();
		CreateProspectLocator.ElementID(driver, "EstPurchasePrice").sendKeys(
				"" + Price );
		CreateProspectLocator.ElementID(driver, "LegalDescription").sendKeys(
				" " + LegalDescription);

		ScreenShots.screenshots(driver, "Work Flow");
		log.info("Tract header filled sucessfully");
		// ------------Tract Header End--------------//

		CreateProspectLocator.ElementID(driver, "btnSaveProspect").click();
		Common.loader();
		log.info("Prospect Created Sucessessfully");
		// ------------Tract End--------------//
		return driver;
	}
	
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
				Common.loader();
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
		LeaseLocator.TextBoxName(driver, "TermUnit_input");
		LeaseLocator.ElementID(driver, "Royalty").sendKeys(
				"" + Common.randomDecimalNumber());
		LeaseLocator.ElementID(driver, "Term").clear();
		LeaseLocator.ElementID(driver, "Term").sendKeys(""+Term);
		LeaseLocator.ElementID(driver, "LDescription").sendKeys(
				" " + LeaseNote);
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
	
	
	public static WebDriver ProductionUnit(WebDriver driver) throws Exception {
		Robot rb=new Robot();
		// -----------ProductionUnit button click start------------//
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
		WebElement Current_element = driver.findElement(By.xpath(".//*[@id='production-unit-modal']"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		driver.switchTo().activeElement();
		jse.executeScript("window.scrollBy(0,800)", "");
		Common.loader();
		
		//driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='production-unit-modal']")));
		try{
		ClientDataLocator.SelectProductionUnitWell(driver, wellName2+wellName1).click();
		//ProductionUnitLocator.SelectProductionUnitWell(driver).click();
		}catch(org.openqa.selenium.NoSuchElementException exception)
		{
			Log.info("No Production Wells available");
		}
		Common.loader();
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
	
}
