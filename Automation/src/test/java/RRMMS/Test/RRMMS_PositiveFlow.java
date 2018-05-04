package RRMMS.Test;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import RRMMS.TestData.RRMMS_Urls;
import RRMMS.modules.CommonAssetFunction;
import RRMMS.modules.CommonAssociation;
import RRMMS.modules.CommonCreatePU;
import RRMMS.modules.CommonDivisionOrder;
import RRMMS.modules.CommonProductionUnit;
import RRMMS.modules.CommonProspectWorkFlow;
import RRMMS.start.Start;
import RRMMS.utility.Common;
import RRMMS.utility.ScreenShots;

public class RRMMS_PositiveFlow {
	static WebDriver driver;
	Login l1 = new Login();
	String Location;
	static Logger log = Logger.getLogger(CreateProspect.class.getClass());
	static int result, row, num;

	public void Start() throws Exception {
		this.driver = Start.getDriverInstance();
		this.driver = Start.InitilizeBrowser7();
		ScreenShots.screenshots(driver, "Prospect");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void AfterBuildPostiveFlow() throws Exception {
		this.driver = Start.logIN();
		log.info("Logged In sucessfully");
		ScreenShots.screenshots(driver, "Work Flow");
		CommonAssociation.SearchLocation(driver);
		
		//Create Prospect 
		CommonAssociation.ProspectPopUp(driver);
		Common.loader();
		
		//Create Lease and Lease Association
		CommonAssociation.createLease(driver);
		Common.loader();
		Thread.sleep(3000);
		CommonAssociation.Association(driver);
		CommonAssociation.createLease(driver);
		Thread.sleep(3000);
		CommonAssociation.Association(driver);
		Common.loader();
		
		//Open Prospect
		
		CommonAssociation.LeaseRoyality(driver);
		
		String winHandleBefore = driver.getWindowHandle();
		//Prospect Work Flow
		CommonProspectWorkFlow.GenerateOfferPackage(driver);
	
		CommonProspectWorkFlow.uploadDoc(driver);

		Common.logout(driver);
		
		CommonProspectWorkFlow.LoginLandAndTitleUser(driver);
		
		CommonProspectWorkFlow.ClearToPay(driver);
		Thread.sleep(3000);
		driver.getWindowHandle();
		Thread.sleep(1000);
		CommonProspectWorkFlow.ManagenmentClearToPayApproval(driver);
		driver.switchTo().window(winHandleBefore);
		try {
			driver.switchTo().window(winHandleBefore);
		} catch (org.openqa.selenium.NoSuchWindowException e) {
			log.info("Script executed sucessfully");
		}
		log.info("Prospect converted to asset sucessfully.");
		
		
		
		//Search Asset and login
		driver.navigate().to(RRMMS_Urls.baseUrl);
		Common.logIN();
		Common.loader();
		driver.findElement(By.xpath("//ul[@id='menu']/li[2]/a/img")).click();
		Common.loader();
		driver.findElement(By.xpath("//div[@id='divViewAsset']/div/div/div/div[1]/a/div/div[2]/div")).click();
		Common.loader();
		//Asset work Flow
		CommonAssetFunction.AssetFlow(driver);
		
		//Create Production Unit
		driver.navigate().to(RRMMS_Urls.baseUrl);
		CommonAssociation.SearchLocation(driver);
		CommonCreatePU.ProductionUnit(driver);
		
		//Create DO
		CommonCreatePU.CreateDO(driver);
		
		//DO Workflow
		//CommonDivisionOrder.DoWorkFlow(driver);

		
	}
}
