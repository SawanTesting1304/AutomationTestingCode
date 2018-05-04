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
import RRMMS.locators.CreateProspectLocator;
import RRMMS.locators.WorkFlowLocator;
import RRMMS.utility.Common;
import RRMMS.utility.ScreenShots;

public class CommonProspectFunctions {
	static WebDriver driver;
	static int result;
	static Logger log = Logger.getLogger(CreateProspect.class.getClass());

	public static WebDriver searchProspectLocation(WebDriver driver)
			throws Exception {
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
		for (int i = 0; i <= 1; i++) {
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
				Thread.sleep(2000);
				/*WorkFlowLocator.ProspectNetRoyAcer(driver, r).sendKeys(
						"" + Common.randomNumber());*/
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
		Common.loader();
		log.info("Prospect Created Sucessessfully");
		// ------------Tract End--------------//
		return driver;
	}
	
	public static WebDriver ViewProspect(WebDriver driver) throws Exception {

		/*// ---------------View Prospect by Smart Search---------------------//
		Thread.sleep(15000);
		Robot rb = new Robot();
		CreateProspectLocator.ElementID(driver, "smartsearchbox").click();
		Thread.sleep(7000);
		Common.selectFromList();
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(7000);
		Common.selectFromList();
		ScreenShots.screenshots(driver, "Prospect");
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		ScreenShots.screenshots(driver, "Prospect");
		log.info("Prospect Viewed By Smart Search");

		// ---------------View Prospect by Smart Search
		// END---------------------//

		// ---------------View Prospect by notification---------------------//
		Thread.sleep(10000);
		CreateProspectLocator.NotificationIconClick(driver).click();
		ScreenShots.screenshots(driver, "Prospect");
		Thread.sleep(12000);
		// CreateProspectLocator.NotificationListClick(driver).click();
		ScreenShots.screenshots(driver, "Prospect");
		log.info("Prospect Viewed By Notification");
		// ---------------View Prospect by notification
		// END---------------------//
*/
		// ---------------View Prospect by Menu List---------------------//
		Common.loader();
		CreateProspectLocator.MenuClick(driver).click();
		Thread.sleep(3000);
		Common.loader();
		ScreenShots.screenshots(driver, "Prospect");
		//CreateProspectLocator.ViewProspectButtonClick(driver).click();
		Thread.sleep(1000);
		CreateProspectLocator.ClickFirstProspect(driver).click();
		ScreenShots.screenshots(driver, "Prospect");
		log.info("Prospect Viewed By Menu List");
		return driver;

		// ---------------View Prospect by Menu List END---------------------//

	}

	// =======================================================================================================================//
	public static WebDriver ProspectDelete(WebDriver driver) throws Exception {

		// --------Delete Prospect By menu List-----------//
		Thread.sleep(8000);
		CreateProspectLocator.MenuClick(driver).click();
		Thread.sleep(1000);
		//CreateProspectLocator.ViewProspectButtonClick(driver).click();
		ScreenShots.screenshots(driver, "Prospect");
		Thread.sleep(1000);
		CreateProspectLocator.KillButtonClick(driver).click();
		Thread.sleep(1000);
		ScreenShots.screenshots(driver, "Prospect");
		CreateProspectLocator.ConfirmDelete(driver).click();
		ScreenShots.screenshots(driver, "Prospect");
		Thread.sleep(4000);
		CreateProspectLocator.ConfirmDelete(driver).click();
		ScreenShots.screenshots(driver, "Prospect");
		log.info("Prospect Deleted Sucessfully");

		ViewKilled();
		// --------Delete Prospect By menu List END-----------//
		return driver;
	}

	public static void ViewKilled() throws Exception {

		Thread.sleep(8000);
		CreateProspectLocator.MenuClick(driver).click();
		CreateProspectLocator.ViewKill(driver).click();
		Thread.sleep(4000);
		CreateProspectLocator.DeleteKill(driver, 3).click();
		CreateProspectLocator.ConfirmDelete(driver).click();
		ScreenShots.screenshots(driver, "Prospect");
		Thread.sleep(8000);
		CreateProspectLocator.ConfirmDelete(driver).click();
		ScreenShots.screenshots(driver, "Prospect");
	}

	// =======================================================================================================================//

	public static WebDriver payment(WebDriver driver) throws Exception {
		// --------------Add Payment----------------//
		Robot rb = new Robot();
		Thread.sleep(7000);
		ScreenShots.screenshots(driver, "Prospect");
		CreateProspectLocator.ActionButtonClick(driver).click();
		Thread.sleep(1000);
		CreateProspectLocator.ActionListClick(driver, 5).click();
		ScreenShots.screenshots(driver, "Prospect");
		Thread.sleep(1000);
		CreateProspectLocator.OpenCalenderClick(driver).click();
		Thread.sleep(3000);
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
		/*
		 * CreateProspectLocator.SelectDate(driver).click(); Thread.sleep(1000);
		 */
		log.info("Date Selected Sucessfully");
		CreateProspectLocator.AddPayment(driver).click();
		Thread.sleep(1000);
		ScreenShots.screenshots(driver, "Prospect");
		CreateProspectLocator.TextBoxName(driver, "paymentMode_input").click();
		Thread.sleep(1000);
		Common.selectFromList();
		Thread.sleep(1000);
		CreateProspectLocator.ElementID(driver, "Reference").sendKeys(
				"" + Common.randomNumber());
		Thread.sleep(1000);
		CreateProspectLocator.ElementID(driver, "input_amount").sendKeys("10");
		Thread.sleep(1000);
		CreateProspectLocator.ElementID(driver, "btnAddPayment").click();
		log.info("Payment Added Sucessfully");
		// --------------Add Payment End----------------//
		return driver;
	}

	// =======================================================================================================================//

	public static WebDriver AddCompany(WebDriver driver) throws Exception {
		
		Thread.sleep(3000);
		Common.loader();
		CreateProspectLocator.ClickSeller(driver).click();
		Thread.sleep(1000);
		CreateProspectLocator.TextBoxName(driver, "editSeller_input").sendKeys(
				"" + Common.randomNumber());
		Thread.sleep(1000);
		CreateProspectLocator.AddNewCompanyClick(driver).click();
		Thread.sleep(4000);
		ScreenShots.screenshots(driver, "Prospect");
		CreateProspectLocator.ElementID(driver, "cmpnyName").sendKeys(
				"Test Companan " + Common.randomNumber());
		/*
		 * CreateProspectLocator.ElementID(driver,
		 * "cmpny_FirstName").sendKeys("Test First Name");
		 * CreateProspectLocator.ElementID(driver,
		 * "cmpny_LastName").sendKeys("Test Last Name");
		 * CreateProspectLocator.ElementID(driver,
		 * "cmpny_Email").sendKeys("Test"+Common.randomNumber()+"@yopmail.com");
		 */
		CreateProspectLocator.ElementID(driver, "Phone").sendKeys(
				"0" + Common.randomNumber() + Common.randomNumber() + "5");
		CreateProspectLocator.ElementID(driver, "MailAddress1").sendKeys(
				"Test Address " + Common.randomNumber());
		CreateProspectLocator.ElementID(driver, "MailAddress2").sendKeys(
				"Test Address " + Common.randomNumber());
		CreateProspectLocator.TextBoxName(driver, "state_input").click();
		Common.selectFromList();
		CreateProspectLocator.ElementID(driver, "MailCity").sendKeys(
				"Test City " + Common.randomNumber());
		CreateProspectLocator.ElementID(driver, "MailZip").sendKeys(
				"" + Common.randomNumber());
		ScreenShots.screenshots(driver, "Prospect");
		CreateProspectLocator.AddClick(driver).click();
		Thread.sleep(1000);
		log.info("New Company Added Sucessfully");
		ScreenShots.screenshots(driver, "Prospect");
		return driver;
	}

	// =======================================================================================================================//

	public static WebDriver EditTract(WebDriver driver) throws Exception {
		Thread.sleep(15000);
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,800)", "");
		//AddTractByMaP();
		Thread.sleep(25000);
	//	CreateProspectLocator.OpenTract(driver).click();
		try {
			for (int j = 0; j <= 3; j++) {
				try {
					Thread.sleep(1000);
					CreateProspectLocator.OpenCounty(driver, j).click();
					result = 1;

				} catch (org.openqa.selenium.NoSuchElementException e) {
					result = 0;
				}
				
				for (int i = 1; i <= 3; i++) {

					if (result == 1) {
						try {
							Thread.sleep(1000);
							ScreenShots.screenshots(driver, "Prospect");
							CreateProspectLocator.TractInputField(driver, j, i,
									"$acrc").clear();
							CreateProspectLocator.TractInputField(driver, j, i,
									"$acrc").sendKeys(
									"" + Common.randomNumber());
							Thread.sleep(1500);
							CreateProspectLocator.TractInputField(driver, j, i,
									"NetMinInt").clear();
							CreateProspectLocator.TractInputField(driver, j, i,
									"NetMinInt").sendKeys(
									"" + Common.randomDecimalNumber());
							Thread.sleep(1500);
							CreateProspectLocator.TractInputField(driver, j, i,
									"NetRoyInt").clear();
							CreateProspectLocator.TractInputField(driver, j, i,
									"NetRoyInt").sendKeys(
									"" + Common.randomDecimalNumber());
							Thread.sleep(1500);
							CreateProspectLocator.TractInputField(driver, j, i,
									"NPRIInt").clear();
							CreateProspectLocator.TractInputField(driver, j, i,
									"NPRIInt").sendKeys(
									"" + Common.randomDecimalNumber());
							Thread.sleep(1500);
							CreateProspectLocator.TractInputField(driver, j, i,
									"ORRIInt").clear();
							CreateProspectLocator.TractInputField(driver, j, i,
									"ORRIInt").sendKeys(
									"" + Common.randomDecimalNumber());
							CreateProspectLocator.Pagehearder(driver).click();
							Thread.sleep(1500);
							log.info("Tract "+i+" updated sucessfully");
						} catch (org.openqa.selenium.NoSuchElementException e) {
							log.info("All tract updated");
						}
						// int j = 1;
						/*
						 * while (j <= 5) {
						 * 
						 * System.out.println(i); if (j == 1 || j == 2 || j == 4
						 * || j == 7 || j == 9) {
						 * CreateProspectLocator.TractInputField(driver, i, j)
						 * .clear();
						 * CreateProspectLocator.TractInputField(driver, i, j)
						 * .sendKeys("" + Common.randomNumber());
						 * Thread.sleep(2500); } else {
						 * CreateProspectLocator.TractInputField(driver, i, j)
						 * .clear();
						 * CreateProspectLocator.TractInputField(driver, i, j)
						 * .sendKeys("" + Common.randomDecimalNumber());
						 * Thread.sleep(2500); }
						 * 
						 * 
						 * }
						 */
					}
					ScreenShots.screenshots(driver, "Prospect");

				}
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
			log.info("All tract updated");
		}
		log.info("Tract Result updated Sucessfully");
		// ==================Delete Tract==================//
	/*	Thread.sleep(5000);
		CreateProspectLocator.EditTractClick(driver, 1, 2).click();
		Thread.sleep(2000);
		CreateProspectLocator.ConfirmDelete(driver).click();
		Thread.sleep(9000);
		ScreenShots.screenshots(driver, "Prospect");
		CreateProspectLocator.ConfirmDelete(driver).click();
		ScreenShots.screenshots(driver, "Prospect");
		log.info("Tract Deleted Sucessfully");
		Thread.sleep(5000);*/
		// ==================Delete Tract END==================//
		return driver;

		// ===========Add Comment==================//
		/*
		 * Thread.sleep(6000); Robot rb= new Robot();
		 * CreateProspectLocator.CommentText(driver).click();
		 * Thread.sleep(1000); for(int i=1;i<=11;i++) {
		 * rb.keyPress(KeyEvent.VK_TAB); rb.keyRelease(KeyEvent.VK_TAB); }
		 * rb.keyPress(KeyEvent.VK_T); rb.keyPress(KeyEvent.VK_E);
		 * rb.keyPress(KeyEvent.VK_S); rb.keyPress(KeyEvent.VK_T);
		 * 
		 * Thread.sleep(500); CreateProspectLocator.CommentPost(driver).click();
		 */
	}

	// =======================================================================================================================//

	public static WebDriver AddTractByMaP(WebDriver driver) throws Exception {
		Actions action = new Actions(driver);
		WebElement map = CreateProspectLocator.Map(driver);
		// Zoom In map
		Thread.sleep(4000);
		for (int i = 0; i <= 1; i++)
			action.moveToElement(map, 397, 395).doubleClick().perform();
		// End-Zoom In
		Thread.sleep(4000);
		action.moveToElement(map, 924, 360).click().perform();
		ScreenShots.screenshots(driver, "Prospect");
		log.info("Location found");
		// ----------Right Click for selected area--------------//
		Thread.sleep(3000);
		action.moveToElement(map, 924, 360).contextClick().perform();
		// ----------Right Click for selected area end--------------//
		Thread.sleep(3000);
		CreateProspectLocator.EditTractAddClick(driver).click();
		Thread.sleep(3000);
		return driver;
	}

	// =======================================================================================================================//

	public static WebDriver updateProspect(WebDriver driver) throws Exception {
		Thread.sleep(8000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-900)", "");
		Thread.sleep(1000);
		CreateProspectLocator.ActionButtonClick(driver).click();
		Thread.sleep(1000);
		// ----------Mouse Hover to Edit option-----//
		Actions action = new Actions(driver);
		WebElement map = CreateProspectLocator.Map(driver);
		WebElement we = CreateProspectLocator.ActionListClick(driver, 1);
		action.moveToElement(we).build().perform();
		// ----------Mouse Hover to Edit option END-----//
		Thread.sleep(2000);
		CreateProspectLocator.ActionEditClick(driver).click();
		ScreenShots.screenshots(driver, "Prospect");
		// -----Add Section form map-----//
		Thread.sleep(2000);
		CreateProspectLocator.Header(driver, 1).click();
		Thread.sleep(6000);
		// Zoom In
		for (int i = 0; i <= 1; i++)
			action.moveToElement(map, 521, 318).doubleClick().perform();
		// End-Zoom In
		Thread.sleep(3000);
		action.moveToElement(map, 711, 318).click().perform();
		Thread.sleep(3000);
		ScreenShots.screenshots(driver, "Prospect");
		// -----Add Section form map END-----//
		// ------------Tract --------------//
		Thread.sleep(2000);
		CreateProspectLocator.Header(driver, 2).click();
		log.info("Tract info popup loaded sucessfully");
		List<WebElement> head_table = driver.findElements(By.tagName("thead"));
		int thCount = head_table.size();
		// System.out.println("Total Tract County: "+(thCount-2));
		log.info("Total Tract County: " + (thCount - 2));
		ScreenShots.screenshots(driver, "Prospect");
		for (int i = 0; i < thCount - 2; i++) {
			String TotalRecord = CreateProspectLocator.HeadCount(driver, i)
					.getText();
			String Count = Common.Trim(TotalRecord);
			int num = Integer.parseInt(Count);
			// System.out.println("ROW: "+num);
			log.info("Total Row Found: " + num);
			// ---------Select Subsection Pop up-----------------//
			for (int r = 0; r <= num - 1; r++) {
				Thread.sleep(2000);
				CreateProspectLocator.QtrCallClick(driver, i, r + 1).click();
				Thread.sleep(2000);
				CreateProspectLocator.subsectionSelect(driver, r + 3).click();
				Thread.sleep(2000);
				CreateProspectLocator.subsectionOKButton(driver).click();
			}
			ScreenShots.screenshots(driver, "Prospect");
			log.info("Tract Subsection Updated");
			// ---------Select Subsection Pop up End-----------------//
		}
		log.info("Tract Updated Sucessessfully");
		// ------------Tract End--------------//

		// ------------Tract Header--------------//
		log.info("Switch to Tract header sucessfully");
		Thread.sleep(1000);
		CreateProspectLocator.Header(driver, 3).click();
		ScreenShots.screenshots(driver, "Prospect");
		CreateProspectLocator.ElementID(driver, "fullname").clear();
		CreateProspectLocator.ElementID(driver, "fullname").sendKeys(
				"Test Updated " + Common.randomNumber());
		CreateProspectLocator.TextBoxName(driver, "Source_input").click();
		Common.selectFirstFromList();
		Thread.sleep(1000);
		CreateProspectLocator.TextBoxName(driver, "play_input").click();
		Common.selectFirstFromList();
		CreateProspectLocator.TextBoxName(driver, "seller_input").click();
		Common.selectFirstFromList();
		CreateProspectLocator.TextBoxName(driver, "buyer_input").click();
		Common.selectFirstFromList();
		CreateProspectLocator.TextBoxName(driver, "Landman_input").click();
		Common.selectFirstFromList();
		CreateProspectLocator.ElementID(driver, "EstPurchasePrice").clear();
		CreateProspectLocator.ElementID(driver, "EstPurchasePrice").sendKeys(
				"" + Common.randomNumber());
		CreateProspectLocator.ElementID(driver, "decimalinterest").clear();
		CreateProspectLocator.ElementID(driver, "decimalinterest").sendKeys(
				"" + Common.randomDecimalNumber());
		ScreenShots.screenshots(driver, "Prospect");
		log.info("Tract header filled sucessfully");
		// ------------Tract Header End--------------//

		CreateProspectLocator.ElementID(driver, "btnSaveProspect").click();

		log.info("Prospect Updated sucessfully");
		return driver;

	}
	
	public static WebDriver ProspectPopUpDepthTract(WebDriver driver) throws Exception {

		// -----------ProspectButton------------//
		Thread.sleep(3000);
		CreateProspectLocator.CreateProspectButton(driver).click();

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
			String TotalRecord = CreateProspectLocator.HeadCount(driver, i)
					.getText();
			String Count = Common.Trim(TotalRecord);
			int num = Integer.parseInt(Count);
			System.out.println("ROW: " + num);
			log.info("Total Row Found: " + num);

			
			int intTractCount=Common.randomNumber1to3();
				for(int P=1;P<=intTractCount;P++)
				{
					CreateProspectLocator.AddIntTract(driver).click();
				}
				
				CreateProspectLocator.SwitchIntTab(driver, intTractCount);
				// ---------Select Subsection Pop up-----------------//
				for (int r = 0; r <= num - 1; r++) {
					Thread.sleep(2000);
					CreateProspectLocator.QtrCallClick(driver, i , r+1).click();
					Thread.sleep(2000);
					CreateProspectLocator.subsectionSelect(driver,
							(Common.randomNumber2to10() - 1)).click();
					Thread.sleep(2000);
				
				// -------------Depth Tract---------------//
				log.info("Depth Tract Start");
				Thread.sleep(1000);
				CreateProspectLocator.ElementID(driver, "depth-details-tab").click();
				int numberofTract = Common.randomNumber2to10();
				if (numberofTract <= 4) {
					CreateProspectLocator.ElementID(driver, "NoOfTracts").sendKeys(
							"" + numberofTract);
					CreateProspectLocator.AddDepthTract(driver).click();
					Thread.sleep(1000);
					for (int k = 1; k <= numberofTract; k++) {
						CreateProspectLocator.DepthDescription(driver, k).sendKeys(
								"Description " + Common.randomNumber());
						Thread.sleep(500);
					}
				} else {
					numberofTract = 3;
					CreateProspectLocator.ElementID(driver, "NoOfTracts").sendKeys(
							"" + numberofTract);
					CreateProspectLocator.AddDepthTract(driver).click();
					Thread.sleep(1000);
					for (int k = 1; k <= numberofTract; k++) {
						CreateProspectLocator.DepthDescription(driver, k).sendKeys(
								"Description " + Common.randomNumber());
						Thread.sleep(500);
					}
				}
				Thread.sleep(1000);
				CreateProspectLocator.DepthDescriptionOkClick(driver).click();
				log.info("Depth Tract End");
				// -------------Depth Tract End---------------//
				
			/*	WorkFlowLocator.ProspectNetRoyAcer(driver, r).sendKeys(
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

		// CreateProspectLocator.ElementID(driver,
		// "decimalinterest").sendKeys(""+Common.randomDecimalNumber());
		CreateProspectLocator.ElementID(driver, "LegalDescription").sendKeys(
				"Test Description" + Common.randomDecimalNumber());

		ScreenShots.screenshots(driver, "Work Flow");
		log.info("Tract header filled sucessfully");
		// ------------Tract Header End--------------//

		CreateProspectLocator.ElementID(driver, "btnSaveProspect").click();

		log.info("Tract Created Sucessessfully");
		// ------------Tract End--------------//
		return driver;
	}
	
	
}
