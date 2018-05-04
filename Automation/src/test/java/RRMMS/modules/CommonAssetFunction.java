package RRMMS.modules;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import RRMMS.Test.CreateProspect;
import RRMMS.locators.CreateProspectLocator;
import RRMMS.locators.PostCloseLocator;
import RRMMS.utility.Common;
import RRMMS.utility.ScreenShots;

public class CommonAssetFunction {
	static WebDriver driver;
	static Logger log = Logger.getLogger(CreateProspect.class.getClass());
	static int result, row, num;
	
	
	public static WebDriver searchAsset(WebDriver driver) throws Exception {
		Thread.sleep(2000);
		Robot rb = new Robot();
		log.info("Search Assect by Smart Search");
		ScreenShots.screenshots(driver, "Post Close");
		CreateProspectLocator.ElementID(driver, "smartsearchbox").click();

		Thread.sleep(2000);
		for (int i = 1; i <= 3; i++) {
			rb.keyPress(KeyEvent.VK_DOWN);
			rb.keyRelease(KeyEvent.VK_DOWN);
		}
		Thread.sleep(2000);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);

		Common.selectFromList();
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		ScreenShots.screenshots(driver, "Post Close");
		Thread.sleep(15000);

		log.info("Asset opened sucessfully");
		/*
		 * String url=driver.getCurrentUrl(); String
		 * SelectedCounty=Common.Trim(url);
		 * selectedCounty=Integer.parseInt(SelectedCounty);
		 */
		Common.loader();
		CreateProspectLocator.ActionButtonClick(driver).click();
		Thread.sleep(2000);
		ScreenShots.screenshots(driver, "Post Close");
		CreateProspectLocator.ActionListClick(driver, 4).click();
		Thread.sleep(2000);

		PostCloseLocator.ElementID(driver, "specialnstruction").sendKeys(
				"Test Special Instruction" + Common.randomNumber());
		ScreenShots.screenshots(driver, "Post Close");
		Thread.sleep(1000);
		PostCloseLocator.NextButton(driver).click();

		Thread.sleep(2000);
		int County = CountyCount(driver);
		try{
		for (int i = 1; i <= County; i++) {
			PostCloseLocator.ElementID(driver, "txtPageNo").sendKeys(
					"" + Common.randomNumber2to10());
			// PostCloseLocator.ElementID(driver,
			// "txtAmount").sendKeys(""+Common.randomNumber());
		}
		}catch(org.openqa.selenium.NoSuchElementException e)
		{
			log.info("County details not dsiplayed");
		}
		ScreenShots.screenshots(driver, "Post Close");
		Thread.sleep(2000);
		PostCloseLocator.GenerateCheckButton(driver).click();
		Thread.sleep(2000);
		/* PostCloseLocator.GenerateCheckCloseButton(driver).click(); */
		log.info("Check generated sucessfully");
		return driver;

	}
	public static WebDriver AssetFlow(WebDriver driver) throws InterruptedException, AWTException {
		log.info("Asset work flow start");
		Thread.sleep(5000);
		Common.loader();
		Robot rb = new Robot();
		int County = CountyCount(driver);
		log.info("Count found" + County);
		PostCloseLocator.NotificationIconClick(driver).click();
		// --------------Unrecorded Deed-----------------//
		Common.loader();
		log.info("Unrecorded Deed start");
		for (int i = 1; i <= 4; i++) {
			Thread.sleep(500);
			PostCloseLocator.UnRecordDeedCheck(driver, i).click();
		}
		log.info("Unrecorded Deed Checked");
		PostCloseLocator.NextButtonClick(driver).click();
		Thread.sleep(1000);
		for (int i = 1; i <= County; i++) {
			Thread.sleep(500);
			PostCloseLocator.ElementID(driver, "CheckNumber0" + (i + 9)).sendKeys(
					"" + Common.randomNumber());
		}
		PostCloseLocator.GenerateNotificationClick(driver).click();
		Thread.sleep(5000);
		// Thread.sleep(2000);
		// Common.selectFromList();
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		log.info("unrecorded Deed End");
		// --------------Unrecorded Deed End-----------------//

		// ----------------Deed Recording---------------//
		log.info("Deed Recording start");
		Thread.sleep(2000);
		for (int i = 1; i <= County; i++) {
			Thread.sleep(500);
			PostCloseLocator.RecordedDateClick(driver, i + 1).click();
			Thread.sleep(5000);
			PostCloseLocator.RecordedDateCalenderClick(driver, i + 1).click();
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
		}
		log.info("Date selected for all County");
		log.info("Deed Recording start");
		// ----------------Deed Recording End---------------//

		// --------------Recorded Deed-----------------//
		log.info("Record Deed Start");
		Common.loader();
		PostCloseLocator.NotificationIconClick(driver).click();
		Thread.sleep(5000);
		for (int i = 2; i <= 2; i++) {
			Thread.sleep(500);
			PostCloseLocator.RecordDeedCheck(driver, i).click();

		}
		log.info("Record Deed Checked");
		Thread.sleep(500);
		Common.loader();
		PostCloseLocator.NotificationRecordedDeedClick(driver).click();
		log.info("Record Deed End");
		// --------------Recorded Deed End-----------------//
		
		//--------------Received Date Enter----------------//
		Common.loader();
		PostCloseLocator.NotificationIconClick(driver).click();
		int Row = RowCount(driver);
		for (int i = 1; i <= Row; i++) {
			Common.loader();
			PostCloseLocator.RecordingDate(driver, i).click();
			Common.loader();
			PostCloseLocator.RecordingDateCalander(driver, i).click();
			Thread.sleep(1000);
			try {
				CreateProspectLocator.SelectDate(driver).click();
			} catch (org.openqa.selenium.NoSuchElementException exception) {
				Thread.sleep(1000);
				rb.keyPress(KeyEvent.VK_ENTER);
				rb.keyRelease(KeyEvent.VK_ENTER);
			}

			// CreateProspectLocator.SelectDate(driver).click();
			Thread.sleep(1000);
		}
		
		//--------------Received Date Enter----------------//
		PostCloseLocator.CloseNotifiactionScreen(driver).click();
		
		return driver;

	}
	public static int CountyCount(WebDriver driver) {
		List<WebElement> Table_Row = driver
				.findElements(By
						.xpath("html/body/div[1]/div/div[3]/div/ui-view/main/div/div[1]/div/div/div[2]/div/div/div/div/div[3]/div/div/div/div/div/div[1]/table/tbody/tr"));
		int County = Table_Row.size();
		System.out.println("Total County: " + (County - 1));
		return County - 1;
	}
	public static int RowCount(WebDriver driver) {
		List<WebElement> Table_Row = driver
				.findElements(By
						.xpath("//div[@id='notifyHistoryGridView']/div[2]/table/tbody/tr"));
		int Row = Table_Row.size();
		System.out.println("Total Row: " + (Row+1));
		return Row+1;
	}

}
