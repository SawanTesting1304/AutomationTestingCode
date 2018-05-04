package RRMMS.modules;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import jxl.Sheet;
import RRMMS.Test.CreateProspect;
import RRMMS.TestData.ExcelData;
import RRMMS.TestData.RRMMS_Urls;
import RRMMS.locators.AssociationLocator;
import RRMMS.locators.CreateProspectLocator;
import RRMMS.locators.DivisionOrderLocators;
import RRMMS.locators.LoginLocator;
import RRMMS.start.Start;
import RRMMS.utility.Common;
import RRMMS.utility.ScreenShots;

public class CommonDivisionOrder {
	
	static WebDriver driver;
	static int result;
	static Logger log = Logger.getLogger(CreateProspect.class.getClass());
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
		Common.selectAnyFromList(Common.randomNumber1to5());
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
	public static WebDriver DoWorkFlow(WebDriver driver)throws Exception{
	//DivisionOrderLocators.ElementID(driver, "chkSideMenuBar").click();
	ScreenShots.screenshots(driver, "Division Order");
	DivisionOrderLocators.DivisionOrderMenuClick(driver).click();
	DivisionOrderLocators.MenuViewDo(driver).click();
	Thread.sleep(1000);
	Common.loader();
	log.info("Division Order List Opened");
	//------------- DO Work Flow Start---------------------//
	DivisionOrderLocators.OpenFirstDOFromList(driver).click();
	Common.loader();
	
	//String winHandleBefore = driver.getWindowHandle();
	//-------------Marked as Verified--------//
	for (String winHandle : driver.getWindowHandles()) {
		driver.switchTo().window(winHandle);
	}
	Common.loader();
	DivisionOrderLocators.ActionButtonClick(driver).click();
	Thread.sleep(2000);
	DivisionOrderLocators.MarkAsVerifiedClick(driver).click();
	Common.logout(driver);
	//-------------Marked as Verified End--------//
	
	//-------------Pending Management approval--------//
	PendingApproval(driver);
	Common.loader();
	
	//-------------Pending Management approval end--------//
	Thread.sleep(3000);
	//DivisionOrderLocators.ElementID(driver, "chkSideMenuBar").click();
	ScreenShots.screenshots(driver, "Division Order");
	DivisionOrderLocators.DivisionOrderMenuClick(driver).click();
	DivisionOrderLocators.MenuViewDo(driver).click();
	Thread.sleep(1000);
	Common.loader();
	log.info("Division Order List Opened");
	
	DivisionOrderLocators.OpenFirstDOFromList(driver).click();
	Common.loader();
	DivisionOrderLocators.ActionButtonClick(driver).click();
	Thread.sleep(2000);
	DivisionOrderLocators.InPayClick(driver).click();
	Common.loader();
	log.info("Do Status In pay Completed");
	return driver;
	}
	
	public static WebDriver PendingApproval(WebDriver driver) throws Exception {
		log.info("DO pending Approval");
		String winHandleBefore = driver.getWindowHandle();
		Thread.sleep(2000);
		Sheet sheet = ExcelData.GetData("Login");
		Common.NewTab();
		Thread.sleep(2000);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(1000);
		driver.navigate().to(RRMMS_Urls.baseUrl);
		for (int i = 14; i <= 14; i++) {
			log.info("DO Pending Approval Start");
			// this.driver= Start.InitilizeBrowser12();
			Common.loader();
			LoginLocator.txtFld_rrmms(driver, "Username").sendKeys(
					sheet.getCell(2, i).getContents());
			LoginLocator.txtFld_rrmms(driver, "Password").sendKeys(
					sheet.getCell(3, i).getContents());
			LoginLocator.Loginbutton(driver).click();
			System.out.println("LoggedIn User:"
					+ sheet.getCell(2, i).getContents());
			log.info("LoggedIn User:" + sheet.getCell(2, i).getContents());
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
			
			Common.loader();
			// -----------------View Notification-----------------//
			/*CreateProspectLocator.NotificationIconClick(driver).click();
			// ScreenShots.screenshots(driver, "Prospect");
			Common.loader();
			String NotificationText = CreateProspectLocator
					.NotificationListClick(driver).getText();
			ScreenShots.screenshots(driver, "Work Flow");
			log.info("" + NotificationText);*/
			log.info("DO Pending Management Approval");
			//System.out.println(NotificationText);
			Thread.sleep(3000);
			//DivisionOrderLocators.ElementID(driver, "chkSideMenuBar").click();
			ScreenShots.screenshots(driver, "Division Order");
			DivisionOrderLocators.DivisionOrderMenuClick(driver).click();
			DivisionOrderLocators.MenuViewDo(driver).click();
			Thread.sleep(1000);
			Common.loader();
			log.info("Division Order List Opened");
			
			DivisionOrderLocators.OpenFirstDOFromList(driver).click();
			Common.loader();
			// --------------Management Approval--------------//
			if (i == 5) {
				//CreateProspectLocator.NotificationListClick(driver).click();
				//Thread.sleep(1000);
				Common.loader();
				ScreenShots.screenshots(driver, "DO Work Flow");
				int j = 1;
				DivisionOrderLocators.ActionButtonClick(driver).click();
				
				if (j == 2) {
					DivisionOrderLocators.DeniedDOClick(driver).click();
					log.info("Price Decline by: "
							+ sheet.getCell(2, i).getContents());
				} else{
					DivisionOrderLocators.ApproveDOClick(driver).click();
					log.info("Approved by: "
							+ sheet.getCell(2, i).getContents());
				}
					
			}
			Common.logout(driver);
			// --------------Price Approval--------------//
			// ScreenShots.screenshots(driver, "Prospect");
			Thread.sleep(2000);
			Thread.sleep(2000);
			log.info("Division Order Approved sucessfully");
			driver.navigate().to(RRMMS_Urls.baseUrl);
			Common.loader();
			Start.logIN();
			log.info("Logged In sucessfully");

		}
		return driver;
	}
}
