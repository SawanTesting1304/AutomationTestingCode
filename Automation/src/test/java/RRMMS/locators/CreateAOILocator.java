package RRMMS.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateAOILocator {
	
	public static WebElement ElementID(WebDriver driver, String FieldName)
	{
		WebElement TextBox= driver.findElement(By.id(""+FieldName+""));
		return TextBox;
	}
	public static WebElement TextBoxName(WebDriver driver, String TextName)
	{
		WebElement TextBoxName= driver.findElement(By.name(TextName));
		return TextBoxName;
	}
	public static WebElement polygon(WebDriver driver)
	{
		WebElement polygon= driver.findElement(By.xpath("//div[@id='map']/div[3]/div[2]/div[1]/button[1]"));
		return polygon;
	}
	public static WebElement Header(WebDriver driver, int i)
	{
		WebElement polygon= driver.findElement(By.xpath("//div[@id='divCreateAOI']/div[2]/ul/li["+i+"]/a/span/img"));
		return polygon;
	}
	public static WebElement CreateAOIButton(WebDriver driver)
	{
		WebElement Button= driver.findElement(By.xpath("//div[@id='createDiv']/button"));
		return Button;
	}
	public static WebElement Map(WebDriver driver)
	{
		WebElement Map=driver.findElement(By.xpath("//div[@id='map']/div[2]/canvas"));
		return Map;
	}
	public static WebElement AOITypeClick(WebDriver driver)
	{
		WebElement AOITypeClick=driver.findElement(By.xpath("//form/div/div[2]/div/div/div/div/div[2]/div[1]/div/span/span/span[2]/span"));
		return AOITypeClick;
	}
	
	
}
