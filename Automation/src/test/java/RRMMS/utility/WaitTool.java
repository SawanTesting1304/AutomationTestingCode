package RRMMS.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

/**
 * @author smartData
 * <h1>WaitTool</h1>
 * <p>Purpose: This class is used for manage waits</p>
 * It is used to handle implecity and explecity wait
 *
 */

public class WaitTool {

	public static void wait(WebDriver driver, int t)
	{
		driver.manage().timeouts().implicitlyWait(t, TimeUnit.SECONDS);
	}
}
