package RRMMS.Test;

import java.awt.Robot;
import java.util.concurrent.TimeUnit;

import jxl.Sheet;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import RRMMS.TestData.ExcelData;
import RRMMS.locators.CreateProspectLocator;
import RRMMS.locators.DivisionOrderLocators;
import RRMMS.locators.LoginLocator;
import RRMMS.locators.WorkFlowLocator;
import RRMMS.modules.CommonDivisionOrder;
import RRMMS.start.Start;
import RRMMS.utility.Common;
import RRMMS.utility.ScreenShots;

public class DivisionOrderWorkFlow extends RRMMS.utility.TestBase{
	
	public static WebDriver driver;
	Login l1 = new Login();
	String Location;
	static Logger log = Logger.getLogger(CreateProspect.class.getClass());
	static int result, row, n=1;
	
	
	public void Start() throws Exception {
		this.driver = Start.getDriverInstance();
		this.driver = Start.InitilizeBrowser7();
		ScreenShots.screenshots(driver, "Division Order");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}
	
	@Test(priority = 1)
	public void CreateDivisionOrder() throws Exception {
		this.driver = Start.logIN();
		log.info("Logged In sucessfully");
		Robot rb = new Robot();
		
		ScreenShots.screenshots(driver, "Division Order");
		Common.loader();
		Thread.sleep(3000);
		CommonDivisionOrder.DoWorkFlow(driver);
	}
	
}
