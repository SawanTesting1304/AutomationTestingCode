package RRMMS.modules;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import jxl.Sheet;

import org.apache.log4j.Logger;
import org.joda.time.Seconds;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import RRMMS.Test.CreateProspect;
import RRMMS.TestData.ExcelData;
import RRMMS.locators.AssociationLocator;
import RRMMS.utility.Common;

public class CommonDragAndDropAssociation {
	static WebDriver driver;
	static Logger log = Logger.getLogger(CreateProspect.class.getClass());
	static int result, row, num, mCount=1;
	static String ProspectName;
	
	
	public static WebDriver DragAndDropAssociation(WebDriver driver) throws Exception 
	{
		Robot rb=new Robot();
		Common.loader();
		Common.loader();
		AssociationLocator.MenuAssociationClick(driver).click();
		Common.loader();
		String winHandleBefore = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		Common.loader();
		AssociationLocator.AssetSearchBox(driver).sendKeys("10567 Test prospect 15");
		Thread.sleep(1000);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Common.loader();
		System.out.println("Asset serach sucessfully");
		//Filter ON/OFF
		Common.loader();
		AssociationLocator.Filtertoggel(driver).click();
		Common.loader();
		AssociationLocator.ExpandTract(driver).click();
		WebElement DragLocation=AssociationLocator.DragLocation(driver, 1);
		WebElement DropLocation=AssociationLocator.DropLocation(driver, 1);
		System.out.println("Got Drag and drop location");
		
		/*Actions act=new Actions(driver);
		act.dragAndDrop(DragLocation, DropLocation).build().perform();*/
		
		 /*Actions builder = new Actions(driver);

		   Action dragAndDrop = builder.clickAndHold(DragLocation)
		       .moveToElement(DropLocation)
		       .release(DropLocation)
		       .build();

		   dragAndDrop.perform();*/
		
		/* Actions builder = new Actions(driver);

		   builder.keyDown(Keys.CONTROL)
		       .click(DragLocation)
		       .click(DropLocation)
		       .keyUp(Keys.CONTROL);

		Then get the action:

		   Action selectMultiple = builder.build();
		And execute it:

		   selectMultiple.perform();*/
		
		
		
        Actions builder = new Actions(driver);
        builder.clickAndHold(DragLocation);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(2000);
        builder.dragAndDropBy(DragLocation,455, 211);
        Thread.sleep(2000);
       
        builder.release(DropLocation);
        Thread.sleep(2000);
       
        builder.build().perform();
        
		Common.loader();
		return driver;
	}
}
