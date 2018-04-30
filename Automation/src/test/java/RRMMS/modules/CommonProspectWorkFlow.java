package RRMMS.modules;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
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
import RRMMS.locators.LoginLocator;
import RRMMS.locators.WorkFlowLocator;
import RRMMS.start.Start;
import RRMMS.utility.Common;
import RRMMS.utility.ScreenShots;

public class CommonProspectWorkFlow {
	static WebDriver driver;
	static int result;
	static String ProspectName;
	static Logger log = Logger.getLogger(CreateProspect.class.getClass());
	
	public static WebDriver SearchLocation(WebDriver driver) throws Exception
	{
		
		Robot rb = new Robot();
		
		Actions action = new Actions(driver);
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
		Common.loader();
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Common.loader();
		CreateProspectLocator.ElementID(driver, "smartsearchbox").sendKeys(
				" " + sheet.getCell(5, row).getContents());
		Common.loader();
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Common.loader();
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
		Thread.sleep(3000);
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
							CreateProspectLocator.QtrCallClick(driver, i , r+1).click();
							Thread.sleep(2000);
							CreateProspectLocator.subsectionSelect(driver,
									(Common.randomNumber2to10() - 1)).click();
							Thread.sleep(2000);
							CreateProspectLocator.subsectionOKButton(driver).click();
							//Thread.sleep(2000);
							//WorkFlowLocator.ProspectNetRoyAcer(driver, r).sendKeys("" + Common.randomNumber());
							Thread.sleep(2000);
							WorkFlowLocator.ProspectDecInt(driver, r+1).clear();
							WorkFlowLocator.ProspectDecInt(driver, r+1).sendKeys(
									"" + Common.randomDecimalNumber());
							Thread.sleep(2000);
						}
						}catch(org.openqa.selenium.NoSuchElementException e)
						{
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
					ProspectName=CreateProspectLocator.ProspectName(driver).getText();
					log.info(ProspectName);
					System.out.println(ProspectName);
					return driver;
	}
	

	public static WebDriver Price(WebDriver driver) throws Exception {
		// --------------Add Payment----------------//
		Thread.sleep(4000);
		
		Common.loader();
		ProspectName=CreateProspectLocator.ProspectName(driver).getText();
		log.info(ProspectName);
		System.out.println(ProspectName);
		log.info("Price");
		// ScreenShots.screenshots(driver, "Prospect");
		CreateProspectLocator.ActionButtonClick(driver).click();
		Thread.sleep(3000);
		CreateProspectLocator.ActionListClick(driver, 3).click();
		// ScreenShots.screenshots(driver, "Prospect");
		Thread.sleep(4000);
		WorkFlowLocator.ElementID(driver, "pApprovalAmount").sendKeys(
				"" + Common.randomNumber());
		Thread.sleep(2000);
		ScreenShots.screenshots(driver, "Work Flow");
		WorkFlowLocator.PriceApprovalSubmit(driver).click();
		log.info("Price Approval sent to management Sucessfully");
		// --------------Add Payment End----------------//
		return driver;
	}

	public static WebDriver ManagenmentPricApproval(WebDriver driver) throws Exception {
		log.info("ManagenmentPricApproval");
	
		String winHandleBefore = driver.getWindowHandle();
		Thread.sleep(2000);
		Sheet sheet = ExcelData.GetData("Login");
		Common.NewTab();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(1000);
		driver.get("http://rrmms.dev.verdico.com/");
		for (int i = 6; i <= 6; i++) {
			log.info("Managenment Price Approval");
			// this.driver= Start.InitilizeBrowser12();
			Thread.sleep(8000);
			LoginLocator.txtFld_rrmms(driver, "Username").sendKeys(
					sheet.getCell(2, i).getContents());
			LoginLocator.txtFld_rrmms(driver, "Password").sendKeys(
					sheet.getCell(3, i).getContents());
			LoginLocator.Loginbutton(driver).click();
			System.out.println("LoggedIn User:"
					+ sheet.getCell(2, i).getContents());
			log.info("LoggedIn User:" + sheet.getCell(2, i).getContents());
			// -----------------View offer Notification-----------------//
			Common.loader();
			Common.loader();
			try{
				driver.findElement(By.xpath("//form/div[1]/div/label")).click();
			}
			catch(org.openqa.selenium.NoSuchElementException e)
			{
				driver.findElement(By.xpath("//div[@id='main']//header/div[2]/div/button")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//a[contains(text(),'Rock River Minerals')]")).click();
				Common.loader();
				Common.loader();
			}
			Common.loader();
			CreateProspectLocator.NotificationIconClick(driver).click();
			// ScreenShots.screenshots(driver, "Prospect");
			Thread.sleep(10000);
			String NotificationText = CreateProspectLocator
					.NotificationListClick(driver).getText();
			ScreenShots.screenshots(driver, "Work Flow");
			log.info("" + NotificationText);
			log.info("Managenment Price Approval");
			System.out.println(NotificationText);
			// --------------Price Approval--------------//
			if (i == 6) {
				CreateProspectLocator.NotificationListClick(driver).click();
				Thread.sleep(9000);
				Common.loader();
				WorkFlowLocator.PriceApprovalButton(driver).click();
				Thread.sleep(3000);
				ScreenShots.screenshots(driver, "Work Flow");
				int j = 1;
				WorkFlowLocator.PriceApproveReject(driver, j).click();
				if (j == 2) {
					Thread.sleep(2000);
					WorkFlowLocator.ElementID(driver, "rejectReason").sendKeys(
							"Test");
					Thread.sleep(2000);
					WorkFlowLocator.RejectReason(driver).click();
					log.info("Price Approved by: "
							+ sheet.getCell(2, i).getContents());
				} else
					log.info("Price Decline by: "
							+ sheet.getCell(2, i).getContents());
			}

			// --------------Price Approval--------------//
			// ScreenShots.screenshots(driver, "Prospect");

			Common.logout(driver);
			Thread.sleep(2000);

		}
		driver.close();
		return driver;
		
	}
	public static WebDriver searchProspect(WebDriver driver) throws Exception {
		// this.driver= Start.InitilizeBrowser12();
		// ScreenShots.screenshots(driver, "Prospect");
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://rrmms.dev.verdico.com/login");
		Thread.sleep(2000);
		driver = Start.logIN();
		ScreenShots.screenshots(driver, "Work Flow");
		Common.loader();
		// --------Search Prospect------------------//
		driver.get("http://rrmms.dev.verdico.com/index");
		Thread.sleep(2000);
		Common.loader();
		Robot rb = new Robot();
		CreateProspectLocator.ElementID(driver, "smartsearchbox").click();
		CreateProspectLocator.ElementID(driver, "smartsearchbox").clear();
		Thread.sleep(2000);
		for (int i = 1; i <= 1; i++) {
			rb.keyPress(KeyEvent.VK_DOWN);
			rb.keyRelease(KeyEvent.VK_DOWN);
		}
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		
		CreateProspectLocator.ElementID(driver, "smartsearchbox").sendKeys(""+ProspectName);
		
		ScreenShots.screenshots(driver, "Prospect");
		Thread.sleep(2000);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		log.info("Prospect Search By Smart Search Completed");
		return driver;
		// --------Search Prospect End------------------//
	}
	
	
	public static WebDriver GenerateOfferPackage(WebDriver driver) throws Exception {
		log.info("Offer package Generation Start");
		Common.loader();
		Robot rb = new Robot();
		Common.loader();
		ProspectName=CreateProspectLocator.ProspectName(driver).getText();
		CreateProspectLocator.ActionButtonClick(driver).click();
		Common.loader();
		try {
			CreateProspectLocator.ActionListClick(driver, 4).click();
		} catch (org.openqa.selenium.NoSuchElementException exception) {
			Thread.sleep(2000);
			CreateProspectLocator.ActionListClick(driver, 4).click();
		} catch (org.openqa.selenium.ElementNotVisibleException exception) {
			Thread.sleep(2000);
		CreateProspectLocator.ActionListClick(driver, 4).click();
		}
		Common.loader();
		WorkFlowLocator.ElementID(driver, "pInterest").sendKeys(
				"" + Common.randomDecimalNumber());
		WorkFlowLocator.WorkFlowDate(driver, 1).click();

		Thread.sleep(2000);
		Thread.sleep(1000);
		try {
			CreateProspectLocator.SelectDate(driver).click();
		} catch (org.openqa.selenium.NoSuchElementException exception) {
			Thread.sleep(1000);
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
		}

		// CreateProspectLocator.SelectDate(driver).click();
		Thread.sleep(500);
		/* CreateProspectLocator.SelectDate(driver).click(); */

		log.info("Date Selected Sucessfully");
		Thread.sleep(2000);
		WorkFlowLocator.WorkFlowDate(driver, 2).click();
		Thread.sleep(3000);

		Thread.sleep(1000);
		try {
			CreateProspectLocator.SelectDate(driver).click();
		} catch (org.openqa.selenium.NoSuchElementException exception) {
			Thread.sleep(1000);
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
		} catch (org.openqa.selenium.ElementNotVisibleException exception) {
			Thread.sleep(1000);
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
		}

		/*
		 * CreateProspectLocator.SelectDate(driver).click();
		 * rb.keyPress(KeyEvent.VK_ENTER); rb.keyRelease(KeyEvent.VK_ENTER);
		 */
		ScreenShots.screenshots(driver, "Work Flow");
		Thread.sleep(2000);
		log.info("Efective Date Selected Sucessfully");
		Thread.sleep(2000);
		WorkFlowLocator.offerPackageNextButton(driver).click();

		Thread.sleep(2000);
		WorkFlowLocator.AttachmentCheckBox(driver, 1).click();

		ScreenShots.screenshots(driver, "Work Flow");
		WorkFlowLocator.GenerateButton(driver).click();
		log.info("Offer package Generated Sucessfully");
		return driver;
	}
	
	public static WebDriver offerPackageNotification(WebDriver driver) throws Exception {

		// ----------------Log Out RRMMS user-------------//
		// logout();

		// ----------------Log Out RRMMS user END-------------//

		// ----------------Log IN RRMMS user-------------//
		Thread.sleep(2000);
		String winHandleBefore = driver.getWindowHandle();
		Sheet sheet = ExcelData.GetData("Login");
		Common.NewTab();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(1000);

		driver.get("http://rrmms.dev.verdico.com/");
		for (int i = 6; i <= 6; i++) {
			log.info("Offer package Notification Start");
			Thread.sleep(5000);
			LoginLocator.txtFld_rrmms(driver, "Username").sendKeys(
					sheet.getCell(2, i).getContents());
			LoginLocator.txtFld_rrmms(driver, "Password").sendKeys(
					sheet.getCell(3, i).getContents());
			LoginLocator.Loginbutton(driver).click();
			System.out.println("LoggedIn User:"
					+ sheet.getCell(2, i).getContents());
			log.info("LoggedIn User:" + sheet.getCell(2, i).getContents());
			// -----------------View offer Notification-----------------//
			Thread.sleep(4000);
			Common.loader();
			Common.loader();
			try{
				driver.findElement(By.xpath("//form//label[contains(text(),'SDN QA')]")).click();
			}
			catch(org.openqa.selenium.NoSuchElementException e)
			{
				driver.findElement(By.xpath("//div[@id='main']//header/div[2]/div/button")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//a[contains(text(),'SDN QA')]")).click();
				Common.loader();
				Common.loader();
			}
			Common.loader();
			CreateProspectLocator.NotificationIconClick(driver).click();
			// ScreenShots.screenshots(driver, "Prospect");
			Thread.sleep(5000);
			Common.loader();
			String NotificationText = CreateProspectLocator
					.NotificationListClick(driver).getText();
			ScreenShots.screenshots(driver, "Work Flow");
			System.out.println(NotificationText);
			// ScreenShots.screenshots(driver, "Prospect");
			log.info("" + NotificationText);
			Common.logout(driver);
			Thread.sleep(2000);
			log.info("Offer package Notification Viewed Sucessfully");

		}

		driver.close();
		return driver;

		// ----------------Log In RRMMS user END-------------//

	}
	
	
	public static WebDriver uploadDocNotification(WebDriver driver) throws Exception {
		Thread.sleep(2000);
		String winHandleBefore = driver.getWindowHandle();
		Sheet sheet = ExcelData.GetData("Login");
		Common.NewTab();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(1000);

		driver.get("http://rrmms.dev.verdico.com/");
		for (int i = 3; i <= 7; i = i + 4) {
			log.info("Seller Upload Document Notification Start");

			Thread.sleep(5000);
			LoginLocator.txtFld_rrmms(driver, "Username").sendKeys(
					sheet.getCell(2, i).getContents());
			LoginLocator.txtFld_rrmms(driver, "Password").sendKeys(
					sheet.getCell(3, i).getContents());
			LoginLocator.Loginbutton(driver).click();
			System.out.println("LoggedIn User:"
					+ sheet.getCell(2, i).getContents());
			log.info("LoggedIn User:" + sheet.getCell(2, i).getContents());
			// -----------------View offer Notification-----------------//
			Common.loader();
			Common.loader();
			try{
				driver.findElement(By.xpath("//form//label[contains(text(),'SDN QA')]")).click();
			}
			catch(org.openqa.selenium.NoSuchElementException e)
			{
				driver.findElement(By.xpath("//div[@id='main']//header/div[2]/div/button")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//a[contains(text(),'SDN QA')]")).click();
				Common.loader();
				Common.loader();
			}
			Common.loader();
			CreateProspectLocator.NotificationIconClick(driver).click();
			// ScreenShots.screenshots(driver, "Prospect");
			Thread.sleep(5000);
			String NotificationText = CreateProspectLocator
					.NotificationListClick(driver).getText();
			ScreenShots.screenshots(driver, "Work Flow");
			System.out.println(NotificationText);
			// ScreenShots.screenshots(driver, "Prospect");
			log.info("" + NotificationText);
			log.info("Seller Upload Document Notification Viewed Sucessfully");
			Common.logout(driver);
			Thread.sleep(2000);

		}
		driver.close();
		return driver;
	}


	public static WebDriver uploadDoc(WebDriver driver) throws Exception {
		log.info("Upload Seller Documnet start");
		Robot rb = new Robot();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		Common.loader();
		jse.executeScript("window.scrollBy(0,9000)", "");

		WorkFlowLocator.uploadBrowse(driver).click();
		Common.loader();
		Sheet sheet = ExcelData.GetData("UploadDocLocation");
		String DocLoaction = sheet.getCell(3, 2).getContents();
		StringSelection ss = new StringSelection(DocLoaction);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		// Paste from clipboard
		Thread.sleep(5000);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(2000);
		log.info("Seller Document Attached Sucessfully");
		/*-------------------Dual diligience date selection---------------*/
		ScreenShots.screenshots(driver, "Work Flow");
		jse.executeScript("window.scrollBy(0,-9000)", "");
		Common.loader();
		WorkFlowLocator.DiligenceDateClick(driver).click();

		Thread.sleep(1000);
		WorkFlowLocator.DiligenceDateCalanderClick(driver).click();
		Thread.sleep(1000);
		try {
			CreateProspectLocator.SelectDate(driver).click();
		} catch (org.openqa.selenium.NoSuchElementException exception) {
			Thread.sleep(1000);
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
		}

		// CreateProspectLocator.SelectDate(driver).click();
		Thread.sleep(500);
		WorkFlowLocator.ClickOutsideOfInputBox(driver).click();
		/*
		 * Thread.sleep(1000); CreateProspectLocator.SelectDate(driver).click();
		 */
		ScreenShots.screenshots(driver, "Work Flow");

		/* WorkFlowLocator.DiligenceSubmit(driver).click(); */
		Thread.sleep(2000);
		log.info("Dual Diligence Date added Sucessfully");
		return driver;

	}
	
	// --------------Login Land And Title manager-----------------//
		public static WebDriver LoginLandAndTitleUser(WebDriver driver) throws Exception {
			Robot rb = new Robot();
			log.info("LoginLandAndTitleUser");
			Thread.sleep(2000);
			Sheet sheet = ExcelData.GetData("Login");
			// this.driver= Start.InitilizeBrowser12();
			Thread.sleep(10000);
		/*	LoginLocator.txtFld_rrmms(driver, "Username").sendKeys(
					sheet.getCell(2, 3).getContents());
			LoginLocator.txtFld_rrmms(driver, "Password").sendKeys(
					sheet.getCell(3, 3).getContents());*/
			LoginLocator.txtFld_rrmms(driver, "Username").sendKeys("srikarqa");
			LoginLocator.txtFld_rrmms(driver, "Password").sendKeys("Uat@9966");
			LoginLocator.Loginbutton(driver).click();
			System.out
					.println("LoggedIn User:" + sheet.getCell(2, 3).getContents());
			log.info("LoggedIn User:" + sheet.getCell(2, 3).getContents());
			
			 //-----------------View offer Notification-----------------//
			Common.loader();
			Common.loader();
			try{
				driver.findElement(By.xpath("//form//label[contains(text(),'MMS TEST')]")).click();
			}
			catch(org.openqa.selenium.NoSuchElementException e)
			{
				Common.loader();
				driver.findElement(By.xpath("//div[@id='main']//header/div[2]/div/button")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//a[contains(text(),'MMS TEST')]")).click();
				Common.loader();
				Common.loader();
			}
			Common.loader();
			  CreateProspectLocator.NotificationIconClick(driver).click();
			  //ScreenShots.screenshots(driver, "Prospect"); Thread.sleep(8000);
			  Common.loader();
			  String
			  NotificationText=CreateProspectLocator.NotificationListClick(driver
			  ).getText(); ScreenShots.screenshots(driver, "Work Flow");
			  log.info(""+NotificationText);
			  System.out.println(NotificationText); //Thread.sleep(2000);
			  CreateProspectLocator.NotificationListClick(driver).click();
			  Common.loader();
			  Common.loader();
			  //-----------------------Order Title-----------------------------//
			 
			// --------Search Prospect------------------//
			//Thread.sleep(15000);
			
//			driver.findElement(By.xpath("//div[@id='select-partnership']//div[1]/div/label")).click();
		/*	Thread.sleep(3000);
			CreateProspectLocator.ElementID(driver, "chkSideMenuBar").click();
			Thread.sleep(1000);
			CreateProspectLocator.ViewProspectButtonClick(driver).click();
			ScreenShots.screenshots(driver, "Work Flow");
			Thread.sleep(1000);
			CreateProspectLocator.ClickFirstProspect(driver).click();
			log.info("Prospect Viewed By Menu List");*/
			// search by smart search
			
		/*	CreateProspectLocator.ElementID(driver, "smartsearchbox").sendKeys(""+ProspectName);
			
			ScreenShots.screenshots(driver, "Prospect");
			Thread.sleep(2000);
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
			log.info("Prospect Search By Smart Search Completed");*/
			// --------Search Prospect End------------------//

			/*
			 * //-----------------------Order Title-------------------------//
			 * Thread.sleep(15000);
			 * CreateProspectLocator.ActionButtonClick(driver).click();
			 * Thread.sleep(6000);
			 * CreateProspectLocator.ActionListClick(driver,7).click();
			 * ScreenShots.screenshots(driver, "Work Flow"); Thread.sleep(2000);
			 * log.info("Order Title Generated Sucessfully");
			 * //-----------------------Order Title End-------------------------//
			 */

			// ----------------------Upload Ownership Report---------------------//
			/*Common.loader();
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			Thread.sleep(2000);
			jse.executeScript("window.scrollBy(0,1200)", "");
			Thread.sleep(2000);
			WorkFlowLocator.uploadBrowse(driver).click();
			sheet = ExcelData.GetData("UploadDocLocation");
			String DocLoaction = sheet.getCell(3, 2).getContents();
			StringSelection ss = new StringSelection(DocLoaction);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

			// Paste from clipboard
			Thread.sleep(3000);
			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_V);
			rb.keyRelease(KeyEvent.VK_V);
			rb.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(2000);
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);

			
			 * Thread.sleep(5000);
			 * WorkFlowLocator.DiligenceDateClick(driver).click();
			 * Thread.sleep(2000); Thread.sleep(1000); try{
			 * CreateProspectLocator.SelectDate(driver).click();
			 * }catch(org.openqa.selenium.NoSuchElementException exception ) {
			 * Thread.sleep(1000); rb.keyPress(KeyEvent.VK_ENTER);
			 * rb.keyRelease(KeyEvent.VK_ENTER); }
			 * 
			 * Thread.sleep(2000); WorkFlowLocator.DiligenceSubmit(driver).click();
			 * Thread.sleep(2000);
			 
			ScreenShots.screenshots(driver, "Work Flow");
			log.info("Ownership report Document Attached Sucessfully");
			jse.executeScript("window.scrollBy(0,-9000)", "");*/
			// ----------------------Upload Ownership Report
			// END---------------------//

			// div[@id='Mineral']/div/a/div/span/button

			
			return driver;
		}

		public static WebDriver ClearToPay(WebDriver driver) throws Exception {
			log.info("ClearToPay");
			Common.loader();
			CreateProspectLocator.ActionButtonClick(driver).click();
			Common.loader();
			CreateProspectLocator.ActionListClick(driver, 6).click();
			Common.loader(); /*
								 * String message
								 * =WorkFlowLocator.Message(driver).getText();
								 * System.out.println(message); Thread.sleep(2000);
								 * log.info(message);
								 */
			log.info("Payment send to management for Approval");
			return driver;

		}

		public static WebDriver RedFlag(WebDriver driver) throws Exception {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			Thread.sleep(10000);
			Common.loader();
			jse.executeScript("window.scrollBy(0,-9000)", "");
			Thread.sleep(5000);
			CreateProspectLocator.ActionButtonClick(driver).click();
			Thread.sleep(6000);
			CreateProspectLocator.ActionListClick(driver, 8).click();
			Thread.sleep(2000);
			CreateProspectLocator.ElementID(driver, "rejectReason").sendKeys(
					"Rejection Due to low budget");
			CreateProspectLocator.RedFlagRejectResaonSubmit(driver).click();
			log.info("Red Flag Generated");
			ScreenShots.screenshots(driver, "Work Flow");
			return driver;

			/*
			 * String message =WorkFlowLocator.Message(driver).getText();
			 * System.out.println(message); Thread.sleep(2000); log.info(message);
			 */
		}
		
		public static WebDriver ManagenmentClearToPayApproval(WebDriver driver) throws Exception {
			//String winHandleBefore = driver.getWindowHandle();
			Thread.sleep(3000);
			Common.NewTab();
			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
			}

			Thread.sleep(1000);
			driver.get("http://mmstest.piedrallc.com");

			Sheet sheet = ExcelData.GetData("Login");
			for (int i = 4; i <= 6; i++) {

				Thread.sleep(5000);
				/*LoginLocator.txtFld_rrmms(driver, "Username").sendKeys(
						sheet.getCell(2, i).getContents());
				LoginLocator.txtFld_rrmms(driver, "Password").sendKeys(
						sheet.getCell(3, i).getContents());*/
				LoginLocator.txtFld_rrmms(driver, "Username").sendKeys("srikarqa");
				LoginLocator.txtFld_rrmms(driver, "Password").sendKeys("Uat@9966");
				LoginLocator.Loginbutton(driver).click();
				System.out.println("Login pass");
				System.out.println("LoggedIn User:"
						+ sheet.getCell(2, i).getContents());
				log.info("LoggedIn User:" + sheet.getCell(2, i).getContents());
				// -----------------View offer Notification-----------------//
				Thread.sleep(4000);
				Common.loader();
				Common.loader();
				try{
					driver.findElement(By.xpath("//form//label[contains(text(),'MMS TEST')]")).click();
				}
				catch(org.openqa.selenium.NoSuchElementException e)
				{
					Common.loader();
					driver.findElement(By.xpath("//div[@id='main']//header/div[2]/div/button")).click();
					Thread.sleep(2000);
					driver.findElement(By.xpath("//a[contains(text(),'MMS TEST')]")).click();
					Common.loader();
					Common.loader();
				}
				Common.loader();
				Common.loader();
				CreateProspectLocator.NotificationIconClick(driver).click();
				// ScreenShots.screenshots(driver, "Prospect");
				Thread.sleep(4000);
				Common.loader();
				
				String NotificationText = CreateProspectLocator
						.NotificationListClick(driver).getText();
				log.info("" + NotificationText);
				System.out.println(NotificationText);
				// --------------Clear to Pay Approval--------------//
				CreateProspectLocator.NotificationListClick(driver).click();
				Thread.sleep(2000);
				Common.loader();
				Common.loader();
				WorkFlowLocator.FinalPriceApprovalButton(driver).click();
				int j = 1;
				Common.loader();
				WorkFlowLocator.FinalPriceApproveReject(driver, j).click();
				;
				if (j == 2) {
					Thread.sleep(2000);
					WorkFlowLocator.ElementID(driver, "rejectReason").sendKeys(
							"Test");
					Thread.sleep(2000);
					WorkFlowLocator.RejectReason(driver).click();
					log.info("Price Decline by: "
							+ sheet.getCell(2, i).getContents());
				} else
					log.info("Price Approved by: "
							+ sheet.getCell(2, i).getContents());

				// ---------------Clear to Pay Approval End--------------//
				ScreenShots.screenshots(driver, "Prospect");
				
				Common.loader();
				Common.logout(driver);

			}

			driver.close();
			log.info("Prospect Converted to Asset Sucessfully");
		
			return driver;
		}

}
