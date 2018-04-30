package RRMMS.Test;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import jxl.Sheet;
import jxl.read.biff.BiffException;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import RRMMS.TestData.ExcelData;
import RRMMS.locators.CreateProspectLocator;
import RRMMS.locators.LoginLocator;
import RRMMS.locators.WorkFlowLocator;
import RRMMS.modules.CommonProspectWorkFlow;
import RRMMS.start.Start;
import RRMMS.utility.Common;
import RRMMS.utility.Log;
import RRMMS.utility.ScreenShots;

public class PendingDueDiligence_Flow extends RRMMS.utility.TestBase{
	static WebDriver driver;
	Login l1 = new Login();
	String Location;
	static Logger log = Logger.getLogger(CreateProspect.class.getClass());
	static int result;

	public void Start() throws Exception {
		this.driver = Start.getDriverInstance();
		this.driver = Start.InitilizeBrowser7();
		ScreenShots.screenshots(driver, "Prospect");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void PendingDueDelay() throws Exception {
		this.driver = Start.getDriverInstance();
	
		CommonProspectWorkFlow.LoginLandAndTitleUser(driver);
		
		CommonProspectWorkFlow.RedFlag(driver);
		CommonProspectWorkFlow.ClearToPay(driver);
		Thread.sleep(3000);
		String winHandleBefore = driver.getWindowHandle();
		CommonProspectWorkFlow.ManagenmentClearToPayApproval(driver);
		driver.switchTo().window(winHandleBefore);
		try{
		driver.switchTo().window(winHandleBefore);
		}catch(org.openqa.selenium.NoSuchWindowException e)
		{
			log.info("Script executed sucessfully");
		}

	}

}
