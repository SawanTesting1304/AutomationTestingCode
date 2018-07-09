package RRMMS.Test;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import RRMMS.modules.CommonAssetFunction;
import RRMMS.modules.CommonProspectFunctions;
import RRMMS.start.Start;
import RRMMS.utility.Common;
import RRMMS.utility.ScreenShots;

public class DocumentGeneration {
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
	public void GenerateDocumentProspect() throws Exception {
		
		this.driver = Start.logIN();
		log.info("Logged In sucessfully");
		ScreenShots.screenshots(driver, "Prospect");
		Common.loader();
		CommonProspectFunctions.ViewProspect(driver);
		CommonProspectFunctions.GenerateOfferPackage(driver);

		
		//driver.close();

	}
	
	@Test(priority = 2)
	public void GenerateDocumentAsset() throws Exception {
		Common.loader();
		CommonAssetFunction.SearchAssetByMenu(driver);
		CommonAssetFunction.GenerateCheckRequest(driver);
		CommonAssetFunction.GenerateNotification(driver);
		Thread.sleep(8000);
		//driver.close();

	}
}
