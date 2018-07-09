package RRMMS.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AssetLocator {
	public static WebElement MenuAssetClick(WebDriver driver)
	{
		WebElement MenuAssetClick=driver.findElement(By.xpath("//ul[@id='menu']/li[2]/a/img"));
		return MenuAssetClick;
	}
	public static WebElement OpenAsset(WebDriver driver)
	{
		WebElement OpenAsset=driver.findElement(By.xpath("//div[@id='divViewAsset']/div/div/div/div[1]"));
		return OpenAsset;
	}
	public static WebElement ActionButtonClick(WebDriver driver)
	{
		WebElement ActionButtonClick=driver.findElement(By.xpath("//div[@id='fixed-stat']/h1/div[2]/div/a"));
		return ActionButtonClick;
	}
	public static WebElement ActionListClick(WebDriver driver, int i)
	{
		WebElement ActionListClick=driver.findElement(By.xpath("//div[@id='fixed-stat']/h1/div[2]/div[1]/ul/li["+i+"]/a"));
		return ActionListClick;
	}
	public static WebElement UncheckedCloneOption(WebDriver driver, int i)
	{
		WebElement UncheckedCloneOption=driver.findElement(By.xpath("//form[@id='frmCloneOptions']/div[1]/div["+i+"]/div/label"));
		return UncheckedCloneOption;
	}
	public static WebElement ClickCloneButton(WebDriver driver)
	{
		WebElement ClickCloneButton=driver.findElement(By.xpath("//form[@id='frmCloneOptions']/div[2]/div[2]/button"));
		return ClickCloneButton;
	}
	public static WebElement CloneOptinoClick(WebDriver driver)
	{
		WebElement CloneOptinoClick=driver.findElement(By.xpath("//div[@id='fixed-stat']/h1/div[2]/div/ul/li[6]/ul/li/a"));
		return CloneOptinoClick;
	}
	public static WebElement SaveLease(WebDriver driver)
	{
		WebElement SaveLease= driver.findElement(By.xpath("html/body/div[1]/div/div[3]/div/ui-view/main/div/div/div/div/div[7]/div/div/div/div/div/div/div[3]/div[1]/div/div[3]/div[3]/div/div[1]/div[1]/button"));
		return SaveLease;
	}
	
}
