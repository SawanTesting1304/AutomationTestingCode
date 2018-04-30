package RRMMS.Test;

//import java.awt.AWTException;
//import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import jxl.Sheet;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;




//import com.project1.GenericLib.ScreenShots;
import RRMMS.locators.CreateProspectLocator;
import RRMMS.locators.LoginLocator;
import RRMMS.locators.WorkFlowLocator;
import RRMMS.modules.CommonProspectFunctions;
import RRMMS.start.Start;
import RRMMS.utility.*;
import RRMMS.Test.Login;
import RRMMS.TestData.ExcelData;

public class CreateProspect extends RRMMS.utility.TestBase {
	public static WebDriver driver;
	Login l1 = new Login();
	String Location;
	static Logger log = Logger.getLogger(CreateProspect.class.getClass());
	static int result;

	/* @Test(priority = 1) */
	public void Start() throws Exception {
		this.driver = Start.getDriverInstance();
		this.driver = Start.InitilizeBrowser7();
		ScreenShots.screenshots(driver, "Prospect");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	// @Test(priority = 2)
	// @Test(priority = 1)
	public void test() throws Exception {
		this.driver = Start.logIN();
		log.info("Logged In sucessfully");
		Common.waitUntilLoads(driver);
		Thread.sleep(30000);
	/*	// --------Search Prospect------------------//
		CreateProspectLocator.ElementID(driver, "chkSideMenuBar").click();
		Thread.sleep(1000);
		CreateProspectLocator.ViewProspectButtonClick(driver).click();
		Thread.sleep(1000);
		CreateProspectLocator.ClickFirstProspect(driver).click();
		log.info("Prospect Viewed By Menu List");
		// --------Search Prospect End------------------//
*/		Thread.sleep(10000);
		CreateProspectLocator.NotificationIconClick(driver).click();
		ScreenShots.screenshots(driver, "Prospect");
		Thread.sleep(12000);
		CreateProspectLocator.NotificationListClick(driver).click();
		ScreenShots.screenshots(driver, "Prospect");
		log.info("Prospect Viewed By Notification");
		Thread.sleep(1000);
		//EditTract();
	}
	

	// SmartSearch
	@Test(priority = 1)
	public void ProspectSmartSearch() throws Exception {
		// ------------Prospect Create by using smart search --------------//

		this.driver = Start.logIN();
		log.info("Logged In sucessfully");
		ScreenShots.screenshots(driver, "Prospect");
		
		CommonProspectFunctions.searchProspectLocation(driver);
		
		CommonProspectFunctions.ProspectPopUp(driver);

		// ------------Prospect Created by using smart search
		// successfully--------------//

		// ------------Other Functionality of
		// Prospect---------------------------//
		Thread.sleep(1000);
		//CommonProspectFunctions.ViewProspect(driver);

		Thread.sleep(1000);
		//CommonProspectFunctions.payment(driver);

		Thread.sleep(1000);
		//CommonProspectFunctions.AddCompany(driver);

		

		Thread.sleep(1000);
		//CommonProspectFunctions.ProspectDelete(driver);

		// ------------Other Functionality of
		// Prospect---------------------------//
		Thread.sleep(8000);
		driver.close();

	}

	// Draw Polygon
	// @Test(priority = 1)
	public void ProspectDrawPolygon() throws Exception {
		// ------------Prospect Create By Draw Polygon method --------------//
		this.driver = Start.logIN();
		ScreenShots.screenshots(driver, "Prospect");
		log.info("Logged In sucessfully");
		Actions action = new Actions(driver);
		Thread.sleep(9000);
		WebElement map = CreateProspectLocator.Map(driver);
		// Zoom In map
		Thread.sleep(5000);
		for (int i = 0; i < 5; i++) {
			action.moveToElement(map, 464, 464).doubleClick().perform();
			Thread.sleep(2000);
		}
		log.info("Map Zoom In sucessfully");
		// End-Zoom In
		Thread.sleep(7000);
		// -----------Select Polygon option------------
		CreateProspectLocator.polygon(driver).click();
		Thread.sleep(3000);
		log.info("Draw polygon selected");
		// Draw Polygon
		action.moveToElement(map, 326, 319).click().perform();
		action.moveToElement(map, 474, 325).click().perform();
		action.moveToElement(map, 531, 561).click().perform();
		action.moveToElement(map, 531, 561).doubleClick().perform();
		log.info("Polygon Drawn sucessfully");
		ScreenShots.screenshots(driver, "Prospect");
		// ---------Draw Polygon End----------------//

		// ----------Right Click for selected area--------------//
		Thread.sleep(3000);
		ScreenShots.screenshots(driver, "Prospect");
		action.moveToElement(map, 531, 561).contextClick().perform();
		// ----------Right Click for selected area end--------------//

		/*ProspectPopUp();*/

		// ------------Prospect Created successfully--------------//
	}
	
}
