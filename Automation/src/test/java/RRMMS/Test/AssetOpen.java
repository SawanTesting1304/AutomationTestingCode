package RRMMS.Test;

import java.util.concurrent.TimeUnit;

import jxl.Sheet;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import RRMMS.TestData.ExcelData;
import RRMMS.locators.LoginLocator;
import RRMMS.modules.CommonAssetFunction;
import RRMMS.start.Start;
import RRMMS.utility.Common;
import RRMMS.utility.ScreenShots;

public class AssetOpen {
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
	public void AllAssetOpen() throws Exception {
		this.driver = Start.logIN();
		/*Common.loader();
		LoginLocator.txtFld_rrmms(driver, "Username").sendKeys("hlavergne");
		LoginLocator.txtFld_rrmms(driver, "Password").sendKeys("Uat@2017");
		LoginLocator.Loginbutton(driver).click();*/
		System.out.println("Login pass");
		log.info("Logged In sucessfully");
		ScreenShots.screenshots(driver, "Post Close");
		//log.info("Executing Post Close start");
		String url="https://mmstest.piedrallc.com/detailasset/";
		Sheet sheet = ExcelData.GetData("AssetId");
		for(int i=54;i<=208;i++)
		{
			Common.loader();
			System.out.println((i+1)+": Asset Open: "+url+sheet.getCell(0,i).getContents());
			driver.navigate().to(url+sheet.getCell(0,i).getContents());
			Common.loader();
			Common.loader();
			
		}
		

	}

}
