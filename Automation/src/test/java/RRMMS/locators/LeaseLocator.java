package RRMMS.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LeaseLocator {
	public static WebElement CreateLeaseButton(WebDriver driver)
	{
		WebElement Button= driver.findElement(By.xpath("//div[@id='createDiv']/button[3]"));
		return Button;
	}
	public static WebElement QtrCallClick(WebDriver driver, int i, int r)
	{
		WebElement QtrCallClick= driver.findElement(By.xpath("//div[@id='collapseThree_"+i+"']/div/div/div/div/table/tbody/tr["+r+"]/td[2]/div/a/img"));
		return QtrCallClick;
	}
	public static WebElement Header(WebDriver driver, int i)
	{
		WebElement Header= driver.findElement(By.xpath("//div[@id='divCreateLease']/div[2]/ul/li["+i+"]/a/span/img"));
		return Header;
	}
	public static WebElement SaveLease(WebDriver driver)
	{
		WebElement SaveLease= driver.findElement(By.xpath("html/body/div[1]/div/div[3]/div/ui-view//div[2]/div[1]/div/div[3]/div[3]/div/div[1]/div[1]/button[contains(text(),'Save')]"));
		return SaveLease;
	}
	public static WebElement ElementID(WebDriver driver, String FieldName)
	{
		WebElement TextBox= driver.findElement(By.id(""+FieldName+""));
		return TextBox;
	}
	public static WebElement ElementIDint(WebDriver driver, String FieldName, int i)
	{
		WebElement ElementIDint= driver.findElement(By.id(""+FieldName+i+""));
		return ElementIDint;
	}
	public static WebElement TextBoxName(WebDriver driver, String TextName)
	{
		WebElement TextBoxName= driver.findElement(By.name(TextName));
		return TextBoxName;
	}
	public static WebElement LeaseQuad(WebDriver driver, int j , int i)
	{
		//WebElement TextBoxName= driver.findElement(By.xpath("//div[@id='collapseNew"+j+"']//tr["+i+"]/td[3]/div/a/img"));
		WebElement TextBoxName= driver.findElement(By.xpath("//div[2]/div[2]/div[2]/div/div/div/div/div/div/div["+j+"]//form/table/tbody["+i+"]/tr/td[4]/div/a/img"));
		
		return TextBoxName;
	}
	public static WebElement ClearQuad(WebDriver driver)
	{
		WebElement ClearQuad= driver.findElement(By.xpath("//div[@id='desc']/div[3]/div/div[3]/button"));
		return ClearQuad;
	}
	public static WebElement OpenTract(WebDriver driver)
	{
		WebElement OpenTract=driver.findElement(By.xpath("//div[@id='accordion00a1']/div/h4/a"));
		return OpenTract;
	}
	public static WebElement LesaeName(WebDriver driver)
	{
		WebElement LesaeName=driver.findElement(By.xpath("//div[@id='fixed-stat']/h1"));
		return LesaeName;
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
	public static WebElement CloneOptinoClick(WebDriver driver)
	{
		WebElement CloneOptinoClick=driver.findElement(By.xpath("//div[@id='fixed-stat']/h1/div[2]/div/ul/li[2]/ul/li/a"));
		return CloneOptinoClick;
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
	
	

}
