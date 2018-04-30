package RRMMS.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AssociationLocator {
	public static WebElement ElementID(WebDriver driver, String FieldName)
	{
		WebElement TextBox= driver.findElement(By.id(""+FieldName+""));
		return TextBox;
	}
	public static WebElement ElementName(WebDriver driver, String TextName)
	{
		WebElement ElementName= driver.findElement(By.name(TextName));
		return ElementName;
	}
	public static WebElement AssociationOpenLink(WebDriver driver)
	{
		WebElement AssociationOpenLink= driver.findElement(By.xpath("//div[@id='accordion00a1']/div/h4/div/a[2]"));
		return AssociationOpenLink;
	}
	public static WebElement ProspectCheck(WebDriver driver, int i)
	{
		WebElement ProspectCheck= driver.findElement(By.xpath("html/body/div[1]/div/div[3]/div/ui-view/div[2]/div/div/div[2]/div/div/div/div[1]/div[2]/div/div/div/div/div/div[1]/table/tbody/tr["+i+"]/td[1]/div/label"));
		return ProspectCheck;
	}
	public static WebElement AssetCheck(WebDriver driver, int i)
	{
		WebElement ProspectCheck= driver.findElement(By.xpath(" html/body/div[1]/div/div[3]/div/ui-view/div[2]/div/div/div[2]/div/div/div/div[2]/div[2]/div/div/div/table/tbody/tr["+i+"]/td[1]/div/label"));
															  
		return ProspectCheck;
	}
	
	
	public static WebElement AssetTabClick(WebDriver driver)
	{
		WebElement AssetTabClick= driver.findElement(By.xpath("//div[@id='sectionA1']/div[1]/a"));
		return AssetTabClick;
	}
	public static WebElement ProspectTabClick(WebDriver driver)
	{
		WebElement ProspectTabClick= driver.findElement(By.xpath("//div[@id='sectionB1']/div[1]/a"));
		return ProspectTabClick;
	}
	public static WebElement SaveButton(WebDriver driver)
	{
		WebElement SaveButton= driver.findElement(By.xpath("//div[@id='association']/div/div/div[2]/div/div/div/div[3]/div/button[1]"));
		return SaveButton;
	}
	public static WebElement LeaseRoyaltyClick(WebDriver driver)
	{
		WebElement LeaseRoyalty= driver.findElement(By.xpath("//tbody[1]/tr[1]/td[15]/div/input"));
		return LeaseRoyalty;
	}
	public static WebElement LeaseGrossRoyalty(WebDriver driver)
	{
		WebElement LeaseGrossRoyalty= driver.findElement(By.xpath("//tbody[1]/tr[1]/td[15]/div/ul/li[2]/a"));
		return LeaseGrossRoyalty;
	}
	public static WebElement LeaseGrossRoyaltySave(WebDriver driver)
	{
		WebElement LeaseGrossRoyaltySave= driver.findElement(By.xpath("//div[@id='leaseRoyaltyPopup']//div[2]/div/button[1]"));
		return LeaseGrossRoyaltySave;
	}
	public static WebElement SplitIntrest(WebDriver driver)
	{
		WebElement SplitIntrest= driver.findElement(By.xpath("//tbody[1]/tr[1]/td[15]/div/ul/li[1]/a"));
		return SplitIntrest;
	}
	
	public static WebElement TractDecimalIntrest(WebDriver driver)
	{
		WebElement TractDecimalIntrest= driver.findElement(By.xpath("//div[@id='leaseRoyaltyPopup']//div[1]/span[1]/span"));
		return TractDecimalIntrest;
	}
	public static WebElement DecimalIntrest(WebDriver driver, int i)
	{
		WebElement DecimalIntrest= driver.findElement(By.id("leaseNMI"+i));
		return DecimalIntrest;
	}
	
	
	
	
	
	
	
}
