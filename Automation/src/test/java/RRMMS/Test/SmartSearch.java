package RRMMS.Test;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import RRMMS.locators.CreateProspectLocator;
import RRMMS.start.Start;
import RRMMS.utility.Common;
import RRMMS.utility.ScreenShots;

public class SmartSearch extends RRMMS.utility.TestBase{
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
	public void test() throws Exception {
		this.driver = Start.logIN();
		log.info("Logged In sucessfully");
		// ---------------View Prospect by Smart Search---------------------//
		Common.loader();
		Robot rb = new Robot();
		Common.loader();
		//Robot rb = new Robot();
		CreateProspectLocator.ElementID(driver, "smartsearchbox").click();
		CreateProspectLocator.ElementID(driver, "smartsearchbox").clear();
		Thread.sleep(2000);
		for (int i = 1; i <= 9; i++) {
			if(i!=3 && i!=6 && i!=2)
			{
				int k=1;
				do
				{
					rb.keyPress(KeyEvent.VK_DOWN);
					rb.keyRelease(KeyEvent.VK_DOWN);
					Thread.sleep(400);
					k++;
				}while( k<i);
				Thread.sleep(500);
				rb.keyPress(KeyEvent.VK_ENTER);
				rb.keyRelease(KeyEvent.VK_ENTER);
				Common.loader();
				int num=Common.randomNumber2to10();
				for (int j=1;j<=num;j++)
				{
					rb.keyPress(KeyEvent.VK_DOWN);
					rb.keyRelease(KeyEvent.VK_DOWN);
					/*System.out.println("j: "+j);*/
				}
				Thread.sleep(2000);
				rb.keyPress(KeyEvent.VK_ENTER);
				rb.keyRelease(KeyEvent.VK_ENTER);
				Common.loader();
				log.info("Element Search By Smart Search");
				Common.loader();
				CreateProspectLocator.ElementID(driver, "smartsearchbox").click();
				CreateProspectLocator.ElementID(driver, "smartsearchbox").clear();
				/*System.out.println("i: "+i);*/
			}
		}
		Common.loader();
		//CreateProspectLocator.ElementID(driver, "smartsearchbox").sendKeys(""+LeaseName);
		
	
		
		// END---------------------/
	}
}
