package RRMMS.Test;

import java.awt.AWTException;
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
import org.testng.annotations.Test;

import RRMMS.TestData.ExcelData;
import RRMMS.locators.AssociationLocator;
import RRMMS.locators.CreateProspectLocator;
import RRMMS.locators.LeaseLocator;
import RRMMS.locators.ProductionUnitLocator;
import RRMMS.locators.WorkFlowLocator;
import RRMMS.modules.CommonProductionUnit;
import RRMMS.modules.CommonProspectFunctions;
import RRMMS.start.Start;
import RRMMS.utility.Common;
import RRMMS.utility.ScreenShots;

public class ProductionUnit extends RRMMS.utility.TestBase{

	public static WebDriver driver;
	Login l1 = new Login();
	String Location;
	static Logger log = Logger.getLogger(CreateProspect.class.getClass());
	static int result, row, n=1;

	/* @Test(priority = 1) */
	public void Start() throws Exception {
		this.driver = Start.getDriverInstance();
		this.driver = Start.InitilizeBrowser7();
		ScreenShots.screenshots(driver, "Prospect");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}
	
	@Test(priority = 1)
	public void ProductionUnitPopup() throws Exception {
		// ------------Prospect Create by using smart search --------------//

		this.driver = Start.logIN();
		log.info("Logged In sucessfully");
		ScreenShots.screenshots(driver, "Prospect");
		CommonProductionUnit.location(driver);
		CommonProspectFunctions.ProspectPopUp(driver);
		CommonProductionUnit.createLease(driver);
		//CommonProductionUnit.Association(driver);
		CommonProductionUnit.ProductionUnit(driver);
		
		//driver.close();

	}
	
	
}
