package RRMMS.Test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import jxl.Sheet;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import RRMMS.TestData.ExcelData;
import RRMMS.locators.AssociationLocator;
import RRMMS.locators.CreateProspectLocator;
import RRMMS.locators.LeaseLocator;
import RRMMS.locators.WorkFlowLocator;
import RRMMS.modules.CommonAssociation;
import RRMMS.modules.CommonDragAndDropAssociation;
import RRMMS.start.Start;
import RRMMS.utility.Common;
import RRMMS.utility.ScreenShots;

public class Association extends RRMMS.utility.TestBase {
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
	public void AssociationMain() throws Exception {
		this.driver = Start.logIN();
		log.info("Logged In sucessfully");
		ScreenShots.screenshots(driver, "Work Flow");
		/*CommonAssociation.SearchLocation(driver);
		CommonAssociation.ProspectPopUp(driver);
		Common.loader();
		CommonAssociation.createLease(driver);
		Common.loader();
		Thread.sleep(3000);
		CommonAssociation.Association(driver);
		CommonAssociation.createLease(driver);
		Thread.sleep(3000);
		CommonAssociation.Association(driver);
		Common.loader();
		CommonAssociation.LeaseRoyality(driver);*/
		
		CommonDragAndDropAssociation.DragAndDropAssociation(driver);
	}

}
