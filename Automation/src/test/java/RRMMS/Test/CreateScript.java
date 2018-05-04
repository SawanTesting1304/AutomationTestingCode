package RRMMS.Test;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import RRMMS.modules.CommonAOIFunction;
import RRMMS.modules.CommonLeaseFunction;
import RRMMS.modules.CommonProductionUnit;
import RRMMS.modules.CommonProspectFunctions;
import RRMMS.start.Start;
import RRMMS.utility.Common;
import RRMMS.utility.ScreenShots;

public class CreateScript {
	
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
	
	@Test(priority = 2)
	public void ProspectSmartSearch() throws Exception {
		// ------------Prospect Create by using smart search --------------//

		CommonProspectFunctions.searchProspectLocation(driver);
		
		CommonProspectFunctions.ProspectPopUp(driver);
		Thread.sleep(1000);
		//CommonProspectFunctions.ViewProspect(driver);

	}
	
	@Test(priority = 3)
	public void Createlease() throws Exception {

		CommonLeaseFunction.SearchLocation(driver);
		CommonLeaseFunction.LeasePopUp(driver);
		Thread.sleep(2000);
		Common.loader();

	}
	@Test(priority = 4)
	public void ProductionUnitPopup() throws Exception {
		CommonProductionUnit.location(driver);
		CommonProductionUnit.ProductionUnit(driver);

	}
	

}
