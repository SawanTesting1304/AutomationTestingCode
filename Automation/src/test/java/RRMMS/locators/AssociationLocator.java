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
		WebElement ProspectCheck= driver.findElement(By.xpath("//div[1]/table/tbody/tr["+i+"]/td[1]/div/label"));
		return ProspectCheck;
	}
	public static WebElement AssetCheck(WebDriver driver, int i)
	{
		WebElement ProspectCheck= driver.findElement(By.xpath(" //div[1]/table/tbody/tr["+i+"]/td[1]/div/label"));
															  
		return ProspectCheck;
	}
	
	
	public static WebElement AssetTabClick(WebDriver driver)
	{
		WebElement AssetTabClick= driver.findElement(By.xpath("//div[@id='sectionA11']/div[1]/a"));
		return AssetTabClick;
	}
	public static WebElement ProspectTabClick(WebDriver driver)
	{
		WebElement ProspectTabClick= driver.findElement(By.xpath("//div[@id='sectionB11']/div[1]/a"));
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
		WebElement LeaseGrossRoyaltySave= driver.findElement(By.xpath("//div[@id='leaseRoyaltyPopupProspect']//div[2]//div[2]/div/button[1]"));
		return LeaseGrossRoyaltySave;
	}
	public static WebElement SplitIntrest(WebDriver driver)
	{
		WebElement SplitIntrest= driver.findElement(By.xpath("//tbody[1]/tr[1]/td[15]/div/ul/li[1]/a"));
		return SplitIntrest;
	}
	
	public static WebElement TractDecimalIntrest(WebDriver driver)
	{
		WebElement TractDecimalIntrest= driver.findElement(By.xpath("//div[@id='leaseRoyaltyPopupProspect']//div[2]/div[1]/span[1]/span"));
		return TractDecimalIntrest;
	}
	public static WebElement DecimalIntrest(WebDriver driver, int i)
	{
		WebElement DecimalIntrest= driver.findElement(By.id("leaseNMI"+i));
		return DecimalIntrest;
	}
	//--------------------------------------------------------------------------------------------------------------------------------//
	//Drag and Drop Association Locators
	//--------------------------------------------------------------------------------------------------------------------------------//
	public static WebElement MenuAssociationClick(WebDriver driver)
	{
		WebElement AssociationClick=driver.findElement(By.xpath("//ul[@id='menu']/li[4]/a/i"));
		return AssociationClick;
	}
	
	public static WebElement AssetSearchBox(WebDriver driver)
	{
		WebElement AssetSearchBox=driver.findElement(By.xpath("//ul[@id='tabs']/li[3]/div/div/div[2]/span[1]/span/input"));
		return AssetSearchBox;
	}
	
	public static WebElement DragLocation(WebDriver driver, int i)
	{
		WebElement DragLocation=driver.findElement(By.xpath("//div[@id='mCSB_4_container']//tr["+i+"]/td[5]"));
		return DragLocation;
	}
	public static WebElement DropLocation(WebDriver driver, int i)
	{
		WebElement DropLocation=driver.findElement(By.xpath("//div[@id='accordionN0']//tbody["+i+"]/tr[1]//td[9]//span"));
		return DropLocation;
	}
	public static WebElement Filtertoggel(WebDriver driver)
	{
		WebElement Filtertoggel=driver.findElement(By.xpath("//div[@id='accordion00a1']//div[1]//div[1]//div/label[@for='myonoffswitch5']"));
		return Filtertoggel;
	}
	public static WebElement ExpandTract(WebDriver driver)
	{
		WebElement ExpandTract=driver.findElement(By.xpath("//tr[@id='35206']/td[1]/a"));
		return ExpandTract;
	}
	
	
	
}
