package RRMMS.Test;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import RRMMS.modules.CommonProductionUnit;
import RRMMS.modules.CommonProspectFunctions;
import RRMMS.start.Start;
import RRMMS.utility.Common;
import RRMMS.utility.ScreenShots;

public class EditProductionUnit {

	
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
	public void ProductionUnitEdit() throws Exception {
		
		this.driver = Start.logIN();
		log.info("Logged In sucessfully");
		ScreenShots.screenshots(driver, "Prospect");
		Common.loader();
		CommonProductionUnit.EditProductionUnit(driver);

	}
	
	@Test(priority = 2)
	public void ProductionUnitMathDownload() throws Exception {
		CommonProductionUnit.PU_MathDownload(driver);

	}
	
}
