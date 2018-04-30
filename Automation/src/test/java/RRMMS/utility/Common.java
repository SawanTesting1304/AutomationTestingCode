package RRMMS.utility;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import jxl.Sheet;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.codeborne.selenide.WebDriverRunner;



























import RRMMS.Test.CreateProspect;
import RRMMS.TestData.ExcelData;
import RRMMS.locators.CreateProspectLocator;
import RRMMS.locators.LeaseLocator;
import RRMMS.locators.PostCloseLocator;
import RRMMS.locators.WorkFlowLocator;
import RRMMS.start.Start;

/**
 * @author smartData
 * <h1>Common Functions</h1>
 * <p>Purpose: This class is for common function</p>
 * It is used to handle all the common functionalities which can be used in other classes
 *
 */
public class Common extends Start {
	static int result;
	static Logger log = Logger.getLogger(CreateProspect.class.getClass());
    public static final long DEFAULT_WAIT = 90000;

    /**
     * <h1>Search Trading partner <h1/>
     * <p>Purpose:This method is used for browser initialization</p>
     *
     */
   /* public static void Init() {
        InitilizeBrowser();
    }*/

    /**
     * <h1>Login User <h1/>
     * <p>Purpose:This method is used for login to application</p>
     *
     * @param UserName,Password
     * @throws Exception
     */

    
    public static boolean IsElementExists(By by) {
        try {
            sleep(2000);
            return $(by).exists();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * <h1>Switch to lightning view <h1/>
     * <p>Purpose:This method is used for switch to lightning view </p>
     *@throws Exception
     */
  

    /**
     * <h1>Click on Element <h1/>
     * <p>Purpose:This method is used to perform click functionality using By locator  </p>
     *
     * @param Element,detail
     * @throws Exception
     */

    public static void ClickElement(By Element, String detail) throws Exception {
        try {
            Log.info("Clicking on:" + detail);
            $(Element)
                    .waitUntil(appear, DEFAULT_WAIT )
                    .click();
            } catch (Exception e) {
            Log.error("Error on:" + detail);
            Log.error("There is exception: " + e.getMessage());
            throw e;

        }
    }



    /**
     * <h1>Click on Element <h1/>
     * <p>Purpose:This method is used to perform click functionality </p>
     *
     * @param Element,detail
     * @throws Exception
     */


    public static void ClickElement(WebElement Element, String detail ) {
        try {
            Log.info("Clicking on:" + detail);
            $(Element)
                    .waitUntil(appear, DEFAULT_WAIT)
                    .click();
//			WaitTool.waitForElementToBeClickable(driver, Element, timeOutInSeconds);
//			Element.click();
        } catch (Exception e) {
            Log.error("There is an exception: " + e.toString());
        }
    }

    /**
     * <h1>Find All Elements<h1/>
     * <p>Purpose:This method is used to get all web elements </p>
     *
     * @param Element,timeOutInSeconds
     * @throws Exception
     */


  


    public static WebElement FindAnElementByExactText(String text) {
        return $(byText(text)).waitUntil(appear, DEFAULT_WAIT).getWrappedElement();
    }

    public static WebElement FindAnElementByTextContains(String text) {
        return $(withText(text)).waitUntil(appear, DEFAULT_WAIT).getWrappedElement();
    }


    public static void HighlightElement(By by) {
        WebElement elm = WebDriverRunner.getWebDriver().findElement(by);
        // draw a border around the found element
        if (driver instanceof JavascriptExecutor) {
            ((JavascriptExecutor) WebDriverRunner.getWebDriver()).executeScript("arguments[0].style.backgroundColor='#80ff80'", elm);
        }
    }

    public static void HighlightElement(WebElement elm) {
        // draw a border around the found element
        if (driver instanceof JavascriptExecutor) {
            ((JavascriptExecutor) WebDriverRunner.getWebDriver()).executeScript("arguments[0].style.backgroundColor='#80ff80'", elm);
        }
    }

    public static WebElement FindAnElement(By Element) throws Exception {
        WebElement TempElement = null;
        try {
            TempElement = $(Element)
                    .waitUntil(appear, DEFAULT_WAIT).getWrappedElement();
        } catch (Exception e) {
            Log.error("There is an exception: " + e.toString());
            throw e;
        }
        return TempElement;
    }

    /**
     * <h1>Switch To Frame<h1/>
     * <p>Purpose:This method is used for switch control to another frame</p>
     *
     * @throws Exception
     */

   /* public static void SwitchToFrame() throws Exception {
        try {
            List<WebElement> NewRequestFrame = Common.FindAllElements(GlobalRepo.frame, 20);
            int size = NewRequestFrame.size();
            driver.switchTo().frame(size - 1);
            Log.info("Switching to frame: " + size);
            Thread.sleep(2000);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            Log.error("Problem in Switching to frame ");
            Log.error(e.getMessage());
            throw e;
        }

    }*/

    /**
     * <h1>Switch To Frame<h1/>
     * <p>Purpose:This method is used for switch control to another frame</p>
     *
     * @throws Exception
     */

    public static void SwitchToFrame(WebElement frames, int interval) throws Exception {
        try {
            driver.switchTo().frame(frames);
            Thread.sleep(interval);
        } catch (InterruptedException e) {
            Log.error("Problem in Switching to frame ");
            Log.error(e.getMessage());
            throw e;
        }

    }

    /**
     * <h1>Clear and Send Key<h1/>
     * <p>Purpose:This method is used for clear present element and send new value into text field</p>
     *
     * @param Element,KeysToSend,Detail
     * @throws Exception
     */
    public static void ClearAndSendKey(By Element, String KeysToSend[],String Detail ) throws Exception {
        try {
            Log.info(Detail);
            WebElement element = $(Element)
                    .waitUntil(appear, DEFAULT_WAIT)
                    .waitUntil(enabled, DEFAULT_WAIT);
            element.clear();
            element.sendKeys(KeysToSend);

        } catch (Exception e) {
            Log.error("There is an exception in setting a text value: " + e.toString());
            throw e;
        }
    }


    /**
     * <h1>Switch Control<h1/>
     * <p>Purpose:This method is used for switch control from one windows to another windows</p>
     *
     */
    public static void switchWindow() {
        // Store the current window handle
        String winHandleBefore = driver.getWindowHandle();

        // Perform the click operation that opens new window

        // Switch to new window opened
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

        // Perform the actions on new window

        // Close the new window, if that window no more required
        driver.close();

        // Switch back to original browser (first window)
        driver.switchTo().window(winHandleBefore);

        // Continue with original browser (first window)
    }

    public static void ClearAndSendKeys(By Element, String KeysToSend, String Detail) throws Exception {
        try {
            Log.info("Input "+Detail);
            $(Element)
                    .waitUntil(appear, DEFAULT_WAIT)
                    .waitUntil(enabled, DEFAULT_WAIT)
                    .setValue(KeysToSend);
        } catch (Exception e) {
            Log.error("Error in setting a text value: " + e.toString());
            throw e;
        }
    }

    public static void sendKeys(By Element, Keys enter,String Detail ) throws Exception {
        try {
            Log.info(Detail);
            WebElement element = $(Element)
                    .waitUntil(appear, DEFAULT_WAIT)
                    .waitUntil(enabled, DEFAULT_WAIT);
            element.sendKeys(enter);

        } catch (Exception e) {
            Log.error("Error in send Keys" + Element.toString());
            Log.error(e.getMessage());
            throw e;

        }
    }


    /**
     * <h1>Search Anything<h1/>
     * <p>Purpose:This method is used for search request and wait for request to come and then it will click on Request
     * link by passing request name and link Requests,Workflows etc) to click as parameter( as</p>
     *
     * @param moduleName,KeywordToSearch
     * @throws Exception
     */
  

    
    /**
     * <h1>Wait for result present <h1/>
     * <p>Purpose:This method is used for request to present, it will wait for request to come at certain time frame,
     * if request will not arrive at certain time frame </p>
     *
     * @param globalSearchRequestTab
     * @throws Exception
     */

 

    public static void clickPartialLinkText(String LinkToClick ) throws Exception {
        ClickElement((By.partialLinkText(LinkToClick)),"Click Link "+LinkToClick);
         }

    //TBD
    public static void ClickLink(String LinkToClick) {
         $(byLinkText(LinkToClick)).waitUntil(appear,DEFAULT_WAIT).click();
          }

    public static void SwitchTab(int Interval) {
         sleep(Interval);
		  Actions TabToShiftTo = new Actions(driver);
          TabToShiftTo.keyDown(Keys.COMMAND).keyDown(Keys.SHIFT).sendKeys(Keys.TAB).build().perform();
    }

   

    //TBD
    public static void javascriptExecutor(WebElement Element, int Interval) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", Element);
        try {
            Thread.sleep(Interval);
        } catch (Exception e) {
            Log.error("There is an exception: " + e.toString());
        }
    }

    //TBD
    public static void SwitchToDefaultContent(int Interval) {
        try {
            System.out.println("Switching default");
            driver.switchTo().defaultContent();
            Thread.sleep(Interval);
        } catch (Exception e) {
            Log.error("There is an exception: " + e.toString());
        }
    }

    public static void RefreshPage(int Interval) {
        try {
            Thread.sleep(6000);
            driver.navigate().refresh();
            Thread.sleep(Interval);
        } catch (Exception e) {
            Log.error("There is an exception: " + e.toString());
        }
    }

    /**
     * <h1>selectDueDate<h1/>
     * <p>Purpose:This method is used for select due date while send or save TP compliance requirement </p>
     *
     * @param Interval
     * @throws InterruptedException
     */
    public static void selectDueDate(int Interval) throws InterruptedException {
        Actions action = new Actions(driver);
        WebElement we1 = driver.findElement(By.id("dueDate"));
        action.moveToElement(we1).moveToElement(driver.findElement(By.xpath("//span[contains(.,'30')]"))).click().build().perform();
        Thread.sleep(Interval);
    }
    /**
     * <h1>selectDueDate<h1/>
     * <p>Purpose:This method is used for select due date  while send or save TP compliance requirement </p>
     *
     * @param Interval
     * @throws InterruptedException
     */
    public static void selectDueDate1(By ElementFirst, By ElementSecond, int Interval) throws InterruptedException {
        Actions action = new Actions(driver);
        WebElement we1 = driver.findElement(ElementFirst);
        action.moveToElement(we1).moveToElement(driver.findElement(ElementSecond)).click().build().perform();
        Thread.sleep(Interval);
    }

    // Double click on element
   

    /**
     * <h1>Close Browser <h1/>
     * <p>Purpose:This method is used for close open browser after test executions</p>
     *
     * @throws Exception
     */
    public static void closeBrowser() {
//		driver.quit();
        try{
        if(driver!=null){
            driver.close();
            driver=null;

        }

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    // Verify test present in page
    public static void verifyTextPresentorNot(String AutoRequeestName) {
        driver.getPageSource().contains(AutoRequeestName);
    }

    /*public static void mouseHover(By ElementToHover, By ElementToClick, int timeOutInSeconds) {
        try {
            WaitTool.waitForElementPresentAndDisplay(driver, ElementToHover, timeOutInSeconds);
            WebElement elemenToHover = driver.findElement(ElementToHover);
            Actions action = new Actions(driver);
            action.moveToElement(elemenToHover).build().perform();
            WaitTool.waitForElementPresentAndDisplay(driver, ElementToClick, timeOutInSeconds);
            driver.findElement(ElementToClick).click();
        } catch (Exception e) {
            Log.error("There is an exception: " + e.toString());
        }
    }*/

    /**
     * <h1> Search and Publish form<h1/>
     * <p>Purpose:This method is used for search and publish the form </p>
     *
     * @param FormName
     * @throws Exception
     */
   

    //Assertions
    public static void assertElementContainsText(By by, String text){
        $(by).waitUntil(appear,DEFAULT_WAIT).shouldHave(text(text));
    }

    public static void assertText(By Element, String ExpectedText) {
        String actual=$(Element).waitUntil(appear,DEFAULT_WAIT).getText();
        Assert.assertEquals(actual.toUpperCase(),ExpectedText.toUpperCase());
     }
    public static void assertExactTextPresent(String text) {
        WebElement element = $(byText(text)).waitUntil(appear, DEFAULT_WAIT).shouldBe(exist).getWrappedElement();
        HighlightElement(element);
    }

    public static void assertAnyTextPresent(String text) {
        WebElement element = $(withText(text)).waitUntil(appear, DEFAULT_WAIT).shouldBe(exist).getWrappedElement();
        HighlightElement(element);
    }

    public static void assertElementPresentAndDisplayed(By by){
        $(by).waitUntil(appear,DEFAULT_WAIT).shouldBe(visible);
    }

    public static boolean assertValue(By Element, String ExpectedValue) {
        return $(Element).waitUntil(appear,DEFAULT_WAIT)
                .shouldHave(value(ExpectedValue))
                .exists();
    }


    public static void alert(int Interval) throws InterruptedException {
        Alert alert = driver.switchTo().alert();
        sleep(3000);
        alert.accept();
    }

    public static void switchToActiveElementString(String Element, int Interval) {
        driver.switchTo().activeElement().sendKeys(Element);
         }

    public static void switchToActiveElementKeys(Keys tab) {
        driver.switchTo().activeElement().sendKeys(tab);
    }

    public static void SwitchToWindowHandle(String Element) {
        driver.switchTo().window(Element);
    }

    public static String WindowHandle() {
        return driver.getWindowHandle();
    }

    public static Set<String> WindowHandles() {
        driver.getWindowHandles();
        return null;
    }

    public static Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    public static void Action(WebElement Element) {
        Actions act = new Actions(driver);
        act.moveToElement(Element);
    }

    public static void switchFrame(By Element, int Interval) {
            driver.switchTo().frame(driver.findElement(Element));
            sleep(Interval);

    }

    public static void deleteCookies(int Interval) {
            driver.manage().deleteAllCookies();
            sleep(Interval);
    }

 

    /**
     * <h1> Get Text<h1/>
     * <p>Purpose: If null is returned then the comparison fails and execution of fails </p>
     *
     * @param Element,timeOutInSeconds
     * @throws Exception
     */

    public static String getElementText(By Element, int timeOutInSeconds) {
         return $(Element).waitUntil(appear,DEFAULT_WAIT).getText();

    }


    /**
     * <h1>ClickElementByLastIndex<h1/>
     * <p>Purpose: To click the last index from all the elements found </p>
     *
     * @param Element,timeOutInSeconds
     * @throws Exception
     */

  
    /**
     * <h1>Count<h1/>
     * <p>Purpose: To get count of total number of elements found </p>
     *
     * @param Element,Interval
     * @throws Exception
     */

    public static int getCount(By Element, int Interval) throws InterruptedException {
        Thread.sleep(Interval);
        List<WebElement> myElements = driver.findElements(Element);
        int size = myElements.size();
        return size;
    }



    /**
     * <h1>Select Duedate<h1/>
     * <p>Purpose: This method is used for select due date </p>
     *
     * @param element,Interval
     * @throws Exception
     */
   


    /**
     * <h1>ProjectDirectory<h1/>
     * <p>Purpose: This method is used for get project directory to get the file to upload document in document library </p>
     *
     * @throws Exception
     */

    public static String getProjectDirectory() {
        return System.getProperty("user.dir");
    }


    /**
     * <h1>Get Data From Property File<h1/>
     * <p>Purpose: This method is used to get form name from property file  </p>
     *@param key
     * @throws Exception
     */


    public static String GetUserData(String key) {
        Properties prop = new Properties();
        InputStream input = null;
        String projectDir = System.getProperty("user.dir") + "/src/test/resources/";
        try {
            input = new FileInputStream(projectDir + "users.properties");
            // load a properties file
            prop.load(input);
            // get the property value and print it out

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {

            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return prop.getProperty(key);
    }

    public static String CaptureScreenForReport(String ImagesPath) {
        TakesScreenshot oScn = (TakesScreenshot) driver;
        File oScnShot = oScn.getScreenshotAs(OutputType.FILE);
        File oDest = new File(ImagesPath + ".jpg");
        try {
            FileUtils.copyFile(oScnShot, oDest);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        //Create relative path

        return oDest.getName();
    }

    public static String GetTimeStamp() {
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HHmmss").format(new Date());
        return timeStamp;
    }

    public static void executeStep(boolean result, String step) throws Exception {
        if (result) {
            Log.info("Execution of: " + step + "-PASS");
        } else {
            throw new Exception("Execution of: " + step + "-FAILED");
        }

    }

    public static void verifyStep(boolean result, String step) throws Exception {
        if (result) {
            Log.info("Verification of: " + step + "-PASS");
        } else {
            throw new Exception("Verification of: " + step + "-FAILED");
        }

    }

    //New Added 25Aug
   /* public static void url() {
        driver.get(Urls.baseUrl);
    }*/

    /**
     * <h1>Wait for result present <h1/>
     * <p>Purpose:This method is used for request to present, it will wait for request to come at certain time frame,
     * if request will not arrive at certain time frame </p>
     *
     * @param globalSearchRequestTab
     * @throws Exception
     */

  

    /**
     * <h1>Handle Request Popup<h1/>
     * <p>Purpose:This method is used for handing request popup when TP and Product is already sent</p>
     *
     * @throws Exception
     */

    

    /**
     * <h1> Save Form Name <h1/>
     * <p>Purpose:This method is used save the form name </p>
     *
     * @param formName
     * @throws Exception
     */

   

    /**
     * <h1> Save Form  <h1/>
     * <p>Purpose:This method is used to save form into file </p>
     *
     * @throws Exception
     */



  /*  public static String getForm() {
        Properties prop = new Properties();
        String filePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "Form.properties";
        try (FileInputStream fis = new FileInputStream(filePath)) {
            prop.load(fis);
            return prop.getProperty("Form");
        } catch (Exception ex) {
            ex.printStackTrace();
            return "NA";
        }
    }//End save form

*/
    /**
     * <h1> Switch to Active Frame <h1/>
     * <p>Purpose:This method is used for switch control to active frame </p>
     *
     */

    public static void switchToActiveFrame(){
        Log.info("Switching to active frame");
        WebElement element =$(".active.oneContent").$("iframe").waitUntil(appear,DEFAULT_WAIT);
        WebDriverRunner.getWebDriver().switchTo().frame(element);
        Log.info("Switched to active frame successfull");
    }


    /**
     * <h1> Verify Request And Workflow Status <h1/>
     * <p>Purpose:This method is used to verify request and workflow statues using Request status workflow
     * status and request name as a parameter </p>
     *
     * @param RequestStatus,WorkflowStatus,requestName
     * @throws Exception
     *//*
    public static void verifyRequestAndWorkflowStatus(String RequestStatus,String WorkflowStatus,String requestName) throws Exception {
        Request ObjReq = new Request();
        TestBase.logTestStep(String.format("Verify |Request status = %s|Workflow status = %s for request name = %s",RequestStatus,WorkflowStatus,requestName));

        ObjReq.searchRequest("Requests", requestName);
        Common.RefreshPage();
        Common.assertText(RequestRepo.txtRequestStatus,RequestStatus);

        Common.ClickElement(By.xpath("(//span[contains(text(),'Related')])[position()=1]"), "Request");
        String workflowStatus = String.format("(//span[contains(.,'%s')])[position()=1]",WorkflowStatus);
        Common.assertText(RequestRepo.workflowStatus,WorkflowStatus);

    }
*/

    /**
     * <h1> Click on AppLauncher Item <h1/>
     * <p>Purpose:This method is used to click on item present on app launcher using item name(Ex Requests)as parameter </p>
     *
     * @param Item
     * @throws Exception
     */
    public static void ClickAppLauncherItem(String Item) throws Exception {
        String xpath=String.format("//li[contains(@class,'oneAppLauncherItem')]//a[@title='%s']",Item);
        ClickElement(By.xpath(xpath),"App Launcher Item: "+Item);
    }

    /**
     * <h1> Get Current URL<h1/>
     * <p>Purpose:This method is used for get current url </p>
     *
     */
    public  static String GetCurrentUrl(){
    if(driver!=null){
            return driver.getCurrentUrl();
    }
    else
    return "";

    }
    public static void selectFromList() throws AWTException, InterruptedException
	{
		Robot rb= new Robot();
		Thread.sleep(500);
		int num=Common.randomNumber2to10();
		for(int i=1;i<=num;i++)
		{
			rb.keyPress(KeyEvent.VK_DOWN);
			rb.keyRelease(KeyEvent.VK_DOWN);
		}
	}
    
    public static int selectAssetList() throws AWTException, InterruptedException
	{
		Robot rb= new Robot();
		Thread.sleep(500);
		int num=Common.randomNumber2to10();
		for(int i=1;i<=num;i++)
		{
			rb.keyPress(KeyEvent.VK_DOWN);
			rb.keyRelease(KeyEvent.VK_DOWN);
		}
		return num;
	}
    public static void selectFromPUList() throws AWTException, InterruptedException
   	{
   		Robot rb= new Robot();
   		Thread.sleep(500);
   		int num=Common.randomNumber1to5();
   		for(int i=1;i<=num;i++)
   		{
   			rb.keyPress(KeyEvent.VK_DOWN);
   			rb.keyRelease(KeyEvent.VK_DOWN);
   		}
   		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		
   	}
    public static void selectFirstFromList() throws AWTException, InterruptedException
	{
		Robot rb= new Robot();
		Thread.sleep(500);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
	}
	public static int randomNumber() throws AWTException
	{
		int randNum = (int) (Math.random() * 9999);
		return randNum;
	}
	public static float randomDecimalNumber() throws AWTException
	{
		float randNum = (float) (Math.random() * 99);
		return randNum;
	}
	public static int randomNumber2to10() throws AWTException
	{
		int randNum = (int) (Math.random() * 9 + 2);
		return randNum;
	}
	public static int randomNumber1to3() throws AWTException
	{
		int randNum = (int) (Math.random() * 2 + 1);
		return randNum;
	}
	public static int randomNumberX() throws AWTException
	{
		int randNum = (int) (Math.random() * 500 + 390);
		return randNum;
	}
	public static int randomNumberY() throws AWTException
	{
		int randNum = (int) (Math.random() * 300 + 150);
		return randNum;
	}
	public static int randomNumber1to5() throws AWTException
	{
		int randNum = (int) (Math.random() * 4 + 1);
		return randNum;
	}
	public static String Trim(String a)
	{
		String[] parts = a.split("results");
		String part1 = parts[0]; 
		
		part1 = part1.replaceAll("[^-?0-9]+", ""); 
		Arrays.asList(part1.trim().split(""));
		part1 = part1.replaceAll("  ", "").trim();
		part1 = part1.replaceAll("-", ""); 
		//System.out.println(part1);
		return part1;
	}
	public static void Scroll(int i)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,"+i+")", "");
	}
	public static String date() throws AWTException, InterruptedException {
		// TODO Auto-generated method stub
		//Thread.sleep(1000);
		Calendar cal = Calendar.getInstance();
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.MEDIUM);
        cal.add(Calendar.DATE,0);
        String Time=  df.format(cal.getTime());
	    String[] sp = Time.split(" ");
		String op=sp[0]+" "+ sp[1]+" "+ sp[2]+" "+ sp[3];
	    System.out.println(op);
		return op;
		
	}
	
	public static WebDriver waitUntilLoads(WebDriver driver) throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver,180);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader1")));
		return driver;
		
	}
	
	public static void waitUntilElmtFound(WebDriver driver, WebElement element){
		WebDriverWait wait = new WebDriverWait(driver,120);
		element = wait.until(ExpectedConditions.visibilityOf(element)); 
		element = wait.until(ExpectedConditions.elementToBeClickable(element)); 
		//element = wait.until(ExpectedConditions.visibilityOfAllElements(elements)(element)); 
		
	}
	public static void NewTab() throws AWTException
	{
		Robot rb=new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_T);
		rb.keyRelease(KeyEvent.VK_T);
		rb.keyRelease(KeyEvent.VK_CONTROL);
	}
	public static void implicitWait()
	{
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	}
	public static void checkPageIsReady(WebDriver driver) {
		  
		  JavascriptExecutor js = (JavascriptExecutor)driver;
		  
		  
		  //Initially bellow given if condition will check ready state of page.
		  if (js.executeScript("return document.readyState").toString().equals("complete")){ 
		   System.out.println("Page Is loaded.");
		   return; 
		  } 
		  
		  //This loop will rotate for 25 times to check If page Is ready after every 1 second.
		  //You can replace your value with 25 If you wants to Increase or decrease wait time.
		  for (int i=0; i<40; i++){ 
		   try {
		    Thread.sleep(1000);
		    }catch (InterruptedException e) {} 
		   //To check page ready state.
		   if (js.executeScript("return document.readyState").toString().equals("complete")){ 
		    break; 
		   }   
		  }
		 }
    public static void loader() throws InterruptedException
	{
		Thread.sleep(5000);
		try{
		WebElement load=driver.findElement(By.className("loader1"));
			if(load.isDisplayed());
			System.out.println("Loading...");
			Common.waitUntilLoads(driver);
		}catch(org.openqa.selenium.NoSuchElementException e)
		{
			Common.waitUntilLoads(driver);
		}catch(org.openqa.selenium.StaleElementReferenceException e)
		{
			
		}
		
	}
    public static WebDriver logout(WebDriver driver) throws InterruptedException {
		Common.loader();
		String UserName = WorkFlowLocator.UserLoginName(driver).getText();
		Thread.sleep(2000);
		Common.loader();
		WorkFlowLocator.UserLoginName(driver).click();
		//System.out.println(UserName + " log Out Sucessfully");
		Thread.sleep(500);
		WorkFlowLocator.Logout(driver).click();
		log.info(UserName + " log Out Sucessfully");
		return driver;
	}
    
   
    
  
}

