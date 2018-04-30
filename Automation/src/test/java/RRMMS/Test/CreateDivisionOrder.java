package RRMMS.Test;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import jxl.Sheet;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import RRMMS.TestData.ExcelData;
import RRMMS.locators.CreateProspectLocator;
import RRMMS.locators.DivisionOrderLocators;
import RRMMS.locators.WorkFlowLocator;
import RRMMS.modules.CommonDivisionOrder;
import RRMMS.start.Start;
import RRMMS.utility.Common;
import RRMMS.utility.ScreenShots;

public class CreateDivisionOrder extends RRMMS.utility.TestBase{
	public static WebDriver driver;
	Login l1 = new Login();
	String Location;
	static Logger log = Logger.getLogger(CreateProspect.class.getClass());
	static int result, row, n=1;

	/* @Test(priority = 1) */
	public void Start() throws Exception {
		this.driver = Start.getDriverInstance();
		this.driver = Start.InitilizeBrowser7();
		ScreenShots.screenshots(driver, "Division Order");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}
	
	@Test(priority = 1)
	public void CreateDivisionOrder() throws Exception {
		//-----Create DO ---------//

		this.driver = Start.logIN();
		log.info("Logged In sucessfully");
		ScreenShots.screenshots(driver, "Division Order");
		CommonDivisionOrder.CreateDO(driver);
	
	}
}
