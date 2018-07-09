package RRMMS.Test;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import RRMMS.modules.CommonLeaseFunction;
import RRMMS.start.Start;
import RRMMS.utility.Common;
import RRMMS.utility.ScreenShots;

public class CloneLease {
	
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

	@Test(priority =1)
	public void Creaetlease() throws Exception {

		this.driver = Start.logIN();
		log.info("Logged In sucessfully");
		ScreenShots.screenshots(driver, "Lease");
		CommonLeaseFunction.SearchLocation(driver);
		CommonLeaseFunction.LeasePopUp(driver);
		Thread.sleep(2000);
		Common.loader();
		//CommonLeaseFunction.EditLeaseTract(driver);
		//CommonLeaseFunction.searchLease(driver);

	}
	@Test(priority =2)
	public void leaseClone() throws Exception {

		CommonLeaseFunction.CloneLease(driver);
		/*CommonLeaseFunction.LeasePopUp(driver);*/
		Thread.sleep(2000);
		Common.loader();
		//CommonLeaseFunction.EditLeaseTract(driver);
	
	}

}
