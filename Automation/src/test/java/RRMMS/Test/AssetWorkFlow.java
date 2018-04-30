package RRMMS.Test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import RRMMS.locators.CreateProspectLocator;
import RRMMS.locators.PostCloseLocator;
import RRMMS.modules.CommonAssetFunction;
import RRMMS.start.Start;
import RRMMS.utility.Common;
import RRMMS.utility.ScreenShots;

public class AssetWorkFlow extends RRMMS.utility.TestBase{
	static WebDriver driver;
	Login l1 = new Login();
	String Location;
	static Logger log = Logger.getLogger(AssetWorkFlow.class.getClass());
	static int result, num, selectedCounty;

	public void Start() throws Exception {
		this.driver = Start.getDriverInstance();
		this.driver = Start.InitilizeBrowser7();
		ScreenShots.screenshots(driver, "Prospect");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void workFlowAsset() throws Exception {
		this.driver = Start.logIN();
		log.info("Logged In sucessfully");
		ScreenShots.screenshots(driver, "Post Close");
		log.info("Executing Post Close start");
		
		Actions action = new Actions(driver);
		Thread.sleep(4000);
		Common.loader();
		WebElement map = driver.findElement(By
				.xpath("//div[@id='map']/div[2]/canvas"));
		Thread.sleep(2000);
		Common.loader();
		CommonAssetFunction.searchAsset(driver);
		Common.loader();
		CommonAssetFunction.AssetFlow(driver);

	}

	
	

	

}
