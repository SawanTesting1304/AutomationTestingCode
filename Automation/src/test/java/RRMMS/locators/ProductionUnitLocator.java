package RRMMS.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductionUnitLocator {
	public static WebElement CreateProductionUnitButtonClick(WebDriver driver)
	{
		WebElement Button= driver.findElement(By.xpath("//div[@id='createDiv']/button[contains(text(),'Create Production Unit')]"));
		return Button;
	}

	public static WebElement SelectProductionUnitWell(WebDriver driver)
	{
		WebElement SelectProductionUnitWell= driver.findElement(By.xpath(".//*[@id='mCSB_2_container']/div[1]/div[2]/div/span"));
		return SelectProductionUnitWell;
	}
	public static WebElement AllSectionCheck(WebDriver driver)
	{
		WebElement AllSectionCheck= driver.findElement(By.xpath("//div/div/div[2]/div[2]/div/div[1]/div[1]/div/a"));
		return AllSectionCheck;
	}
	public static WebElement HeadCount(WebDriver driver, int i)
	{
		WebElement HeadCount= driver.findElement(By.xpath("//div[@id='accordion"+i+"']/div/a/h4/span[2]"));
		return HeadCount;
	}
	public static WebElement QtrCallClick(WebDriver driver,int i, int r)
	{
		WebElement QtrCallClick= driver.findElement(By.xpath("//div[@id='accordion"+i+"']//tbody["+r+"]/tr[1]/td[@id='qtrcall']//a/img"));
		return QtrCallClick;
	}
	public static WebElement subsectionSelect(WebDriver driver, int i)
	{
		WebElement subsectionSelect=driver.findElement(By.xpath("//div[@id='desc']/div[1]/div[1]//div["+i+"]/button"));
		return subsectionSelect;
	}
	public static WebElement subsectionOKButton(WebDriver driver)
	{
		WebElement subsectionOKButton=driver.findElement(By.xpath("//div[@id='track-builder']/div/div/div[2]/div[2]/button[1]"));
		return subsectionOKButton;
	}
	public static WebElement NextButtonClick(WebDriver driver)
	{
		WebElement NextButtonClick= driver.findElement(By.xpath("//div[2]/div[2]/div/div[1]/div[3]/a[2]"));
		return NextButtonClick;
	}
	
	public static WebElement PuHeader(WebDriver driver)
	{
		WebElement PuHeader= driver.findElement(By.xpath("//div[@id='divCreateProductionUnit']/div[2]/ul/li[3]/a/span/img"));
		return PuHeader;
	}
	
	public static WebElement PuRelationShip(WebDriver driver)
	{
		WebElement PuRelationShip= driver.findElement(By.xpath("//div[@id='fieldlist']/div/div[4]/div/div/span[1]/span/input"));
		return PuRelationShip;
	}
	public static WebElement Putype(WebDriver driver)
	{
		WebElement Putype= driver.findElement(By.xpath("//form//div[2]/div[3]//div[1]/div/div/span[1]/span/span[1]"));
		return Putype;
	}
	public static WebElement PuSave(WebDriver driver)
	{
		WebElement PuSave= driver.findElement(By.xpath("//form[@id='frmProductionUnit']/div/div[1]/div[1]/button"));
		return PuSave;
	}
	public static WebElement PuName(WebDriver driver)
	{
		WebElement PuName= driver.findElement(By.xpath("//div[@id='fixed-stat']/h1/span"));
		return PuName;
	}
	
	public static WebElement ActionListClick(WebDriver driver, int i)
	{
		WebElement ActionListClick=driver.findElement(By.xpath("//div[@id='fixed-stat']/h1/div[2]/div[1]/ul/li["+i+"]/a"));
		return ActionListClick;
	}
	public static WebElement EditPUOptinoClick(WebDriver driver)
	{
		WebElement CloneOptinoClick=driver.findElement(By.xpath("//div[@id='fixed-stat']/h1/div[2]/div/ul/li[1]/ul/li/a"));
		return CloneOptinoClick;
	}
	
}
