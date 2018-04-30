package RRMMS.Test;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import RRMMS.locators.CreateAOILocator;
import RRMMS.locators.CreateProspectLocator;
import RRMMS.modules.CommonAOIFunction;
import RRMMS.start.Start;
import RRMMS.utility.Common;
import RRMMS.utility.ScreenShots;

public class CreateAOI extends RRMMS.utility.TestBase {
	static WebDriver driver;
	Login l1 = new Login();
	String Location;
	static Logger log = Logger.getLogger(CreateProspect.class.getClass());
	static int result, i;

	public void Start() throws Exception {
		this.driver = Start.getDriverInstance();
		this.driver = Start.InitilizeBrowser7();
		ScreenShots.screenshots(driver, "CreateProspect");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test(priority = 1)
	public void createAOIDrawPolygon() throws Exception {
		// ------------Prospect Create By Draw Polygon method --------------//
		this.driver = Start.logIN();
		ScreenShots.screenshots(driver, "AOI");
		log.info("Logged In sucessfully");
		CommonAOIFunction.location(driver);
		CommonAOIFunction.AIOpopup(driver);
	}

}
