package RRMMS.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PostCloseLocator {
	public static WebElement ElementID(WebDriver driver, String FieldName)
	{
		WebElement ElementID= driver.findElement(By.id(""+FieldName+""));
		return ElementID;
	}
	public static WebElement NextButton(WebDriver driver)
	{
		WebElement NextButton= driver.findElement(By.xpath("//div[@id='chkRequestsectionA']/div[2]/div/a"));
		
		return NextButton;
	}
	public static WebElement GenerateCheckButton(WebDriver driver)
	{
		WebElement GenerateCheckButton= driver.findElement(By.xpath("//div[@id='chkRequestsectionB']/div[3]/div/a"));
		return GenerateCheckButton;
	}
	public static WebElement GenerateCheckCloseButton(WebDriver driver)
	{
		WebElement GenerateCheckCloseButton= driver.findElement(By.xpath("//div[@id='generate-chk-request']/div/div/div[1]/button"));
		return GenerateCheckCloseButton;
	}
	public static WebElement NotificationIconClick(WebDriver driver)
	{
		WebElement NotificationIconClick= driver.findElement(By.xpath("//div[@id='fixed-stat']/h1/div[2]/div[2]/a/img"));
		return NotificationIconClick;
	}
	public static WebElement UnRecordDeedCheck(WebDriver driver, int i)
	{
		WebElement UnRecordDeedCheck= driver.findElement(By.xpath("//div[@id='sectionA2']/form/div[1]/div["+i+"]/div/label"));
		return UnRecordDeedCheck;
	}
	
	public static WebElement NextButtonClick(WebDriver driver)
	{
		WebElement NextButtonClick= driver.findElement(By.xpath("//div[@id='sectionA2']/div[1]/div/button[1]"));
		return NextButtonClick;
	}
	public static WebElement GenerateNotificationClick(WebDriver driver)
	{
		WebElement GenerateNotificationClick= driver.findElement(By.xpath("//div[@id='sectionB2']/div[3]/button"));
		return GenerateNotificationClick;
	}
	public static WebElement CountyCount(WebDriver driver)
	{
		WebElement CountyCount= driver.findElement(By.xpath("html/body/div[1]/div/div[3]/div/ui-view/main/div/div[1]/div/div/div[2]/div/div/div/div/div[3]/div/div/div/div/div/div[1]/table/tbody/tr"));
		return CountyCount;
	}
	public static WebElement RecordedDateClick(WebDriver driver, int i)
	{
		WebElement RecordedDateClick= driver.findElement(By.xpath("html/body/div[1]/div/div[3]/div/ui-view/main/div/div[1]/div/div/div[2]/div/div/div/div/div[3]/div/div/div/div/div/div[1]/table/tbody/tr["+i+"]/td[5]/span[1]"));
		return RecordedDateClick;
	}
	
	public static WebElement RecordedDateCalenderClick(WebDriver driver, int i)
	{
		WebElement RecordedDateCalenderClick= driver.findElement(By.xpath("html/body/div[1]/div/div[3]/div/ui-view/main/div/div[1]/div/div/div[2]/div/div/div/div/div[3]/div/div/div/div/div/div[1]/table/tbody/tr["+i+"]/td[5]/span[2]/span/span/span"));
		return RecordedDateCalenderClick;
	}
	
	public static WebElement RecordDeedCheck(WebDriver driver, int i)
	{
		WebElement RecordDeedCheck= driver.findElement(By.xpath("//div[@id='sectionA2']/form/div[2]/div["+i+"]/div/label"));
		return RecordDeedCheck;
	}
	public static WebElement NotificationRecordedDeedClick(WebDriver driver)
	{
		WebElement NotificationRecordedDeedClick= driver.findElement(By.xpath("//div[@id='sectionA2']/div[1]/div/button[2]"));
		return NotificationRecordedDeedClick;
	}
	
	public static WebElement RecordingDate(WebDriver driver, int i)
	{
		WebElement RecordingDate= driver.findElement(By.xpath(".//*[@id='notifyHistoryGridView']/div[2]/table/tbody/tr["+i+"]/td[5]/span/span/input"));
		return RecordingDate;
	}
	
	public static WebElement RecordingDateCalander(WebDriver driver, int i)
	{
		WebElement RecordingDate= driver.findElement(By.xpath("html/body/div[1]/div/div[3]/div/ui-view/div[5]/div/div/div[2]/div/div[1]/div[2]/div/div[2]/table/tbody/tr["+i+"]/td[5]/span/span/span/span"));
		return RecordingDate;
	}
	
	
	
	
}
