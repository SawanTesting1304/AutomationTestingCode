package RRMMS.Test;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import RRMMS.TestData.RRMMS_Urls;
import RRMMS.locators.ClientDataLocator;
import RRMMS.modules.CommonClientData;
import RRMMS.modules.CommonProspectFunctions;
import RRMMS.start.Start;
import RRMMS.utility.Common;
import RRMMS.utility.ScreenShots;

public class ClientDataProspect {
	public static WebDriver driver;
	Login l1 = new Login();
	String Location;
	static Logger log = Logger.getLogger(CreateProspect.class.getClass());
	static int result;
	public static Workbook book;
	public static WritableWorkbook wbook;
	public static Sheet sheet;
	public static WritableSheet wsheet;
	public static int num_rows;

	/* @Test(priority = 1) */
	public void Start() throws Exception {
		this.driver = Start.getDriverInstance();
		this.driver = Start.InitilizeBrowser7();
		ScreenShots.screenshots(driver, "Prospect");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}
	
	@Test(priority = 1)
	public void ProspectSmartSearch() throws Exception {
		// ------------Prospect Create by using smart search --------------//
		
		this.driver = Start.getDriverInstance();
		
		CommonClientData.GetClientData(driver);
				
		CommonClientData.searchProspectLocation(driver);
		
		CommonClientData.ProspectPopUp(driver);
		Common.loader();
		CommonClientData.searchProspectLocation(driver);
		
		CommonClientData.LeasePopUp(driver);
		
		CommonClientData.searchProspectLocation(driver);
		CommonClientData.ProductionUnit(driver);
		
		//driver.close();
		

	}
	
	
}
