package RRMMS.Test;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.rmi.dgc.Lease;
import java.util.List;
import java.util.concurrent.TimeUnit;

import jxl.Sheet;

import org.apache.log4j.Logger;
import org.apache.log4j.helpers.Loader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import RRMMS.TestData.ExcelData;
import RRMMS.locators.CreateProspectLocator;
import RRMMS.locators.LeaseLocator;
import RRMMS.locators.WorkFlowLocator;
import RRMMS.modules.CommonLeaseFunction;
import RRMMS.start.Start;
import RRMMS.utility.Common;
import RRMMS.utility.ScreenShots;

public class CreateLease extends RRMMS.utility.TestBase {
	static WebDriver driver;
	Login l1 = new Login();
	String Location;
	static Logger log = Logger.getLogger(CreateProspect.class.getClass());
	static int result, num;

	public void Start() throws Exception {
		this.driver = Start.getDriverInstance();
		this.driver = Start.InitilizeBrowser7();
		ScreenShots.screenshots(driver, "Prospect");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void lease() throws Exception {

		this.driver = Start.logIN();
		log.info("Logged In sucessfully");
		ScreenShots.screenshots(driver, "Lease");
		CommonLeaseFunction.SearchLocation(driver);
		CommonLeaseFunction.LeasePopUp(driver);
		Thread.sleep(2000);
		Common.loader();
		//CommonLeaseFunction.EditLeaseTract(driver);
		CommonLeaseFunction.searchLease(driver);

	}

	

}
