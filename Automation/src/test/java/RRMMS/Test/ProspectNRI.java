package RRMMS.Test;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import RRMMS.locators.CreateProspectLocator;
import RRMMS.modules.CommonProspectFunctions;
import RRMMS.start.Start;
import RRMMS.utility.Common;
import RRMMS.utility.ScreenShots;

public class ProspectNRI {
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

	
	@Test(priority = 1)
	public void ProspectNRI() throws Exception {
		// ------------Prospect Create by using smart search --------------//

		this.driver = Start.logIN();
		log.info("Logged In sucessfully");
		ScreenShots.screenshots(driver, "Prospect");
		
		CommonProspectFunctions.searchProspectLocation(driver);
		
		CommonProspectFunctions.ProspectPopUpNRI(driver);
		
		
		Thread.sleep(8000);
		//driver.close();

	}
	
	@Test(priority = 2)
	public void FixedFloatingNPRI() throws Exception {
		Common.loader();
				
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,860)", "");
		
		CommonProspectFunctions.FixedFloating(driver);	
		
		
	}
	
	
}
