package RRMMS.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DivisionOrderLocators {

	public static WebElement ElementID(WebDriver driver, String FieldName)
	{
		WebElement ElementID= driver.findElement(By.id(""+FieldName+""));
		return ElementID;
	}
	public static WebElement DivisionOrderMenuClick(WebDriver driver)
	{
		WebElement DivisionOrderMenuClick= driver.findElement(By.xpath("//ul[@id='menu']/li[3]/a/img"));
		return DivisionOrderMenuClick;
	}
	public static WebElement MenuAddDo(WebDriver driver)
	{
		WebElement DivisionOrderMenuClick= driver.findElement(By.xpath("//li[@id='drpdwn']/ul/li[2]/a"));
		return DivisionOrderMenuClick;
	}
	public static WebElement MenuViewDo(WebDriver driver)
	{
		WebElement DivisionOrderMenuClick= driver.findElement(By.xpath("//li[@id='drpdwn']/ul/li[1]/a"));
		return DivisionOrderMenuClick;
	}
	
	public static WebElement CheckBox(WebDriver driver,int i)
	{
		WebElement CheckBox= driver.findElement(By.xpath("//div[@id='porTable000"+i+"']/table/tbody/tr[1]/th[1]/label"));
		return CheckBox;
	}
	
	public static WebElement AddDO(WebDriver driver)
	{
		WebElement AddDO= driver.findElement(By.xpath("//div[@id='main']//div[3]//ui-view/main//div[1]/h1/div/a"));
		return AddDO;
	}
	public static WebElement IssureInput(WebDriver driver)
	{
		WebElement IssureInput= driver.findElement(By.xpath("//input[@name='Issuer_input']"));
		return IssureInput;
	}
	
	public static WebElement Source(WebDriver driver)
	{
		WebElement Source= driver.findElement(By.xpath("//div//span[contains(text(),'Source')]"));
		return Source;
	}
	public static WebElement Type(WebDriver driver)
	{
		WebElement Type= driver.findElement(By.xpath("//div[@id='main']//div[2]/div/div[2]/span"));
		return Type;
	}
	public static WebElement AppylButtonClick(WebDriver driver)
	{
		WebElement AppylButtonClick= driver.findElement(By.xpath("//div[@id='main']//div[3]/div/ui-view//div[1]//h4/span/button"));
		return AppylButtonClick;
	}
	public static WebElement DOAttachmentBrowse(WebDriver driver)
	{
		WebElement DOAttachmentBrowse= driver.findElement(By.xpath("//div[@id='DivisionOrder']//button"));
		return DOAttachmentBrowse;
	}
	public static WebElement state_input(WebDriver driver)
	{
		WebElement state_input= driver.findElement(By.xpath("//input[@name='state_input'][@placeholder='--State--']"));
		return state_input;
	}
	
	
	public static WebElement County_input(WebDriver driver)
	{
		WebElement County_input= driver.findElement(By.xpath("//input[@name='County_input']"));
		return County_input;
	}
	public static WebElement Block_input(WebDriver driver)
	{
		WebElement Block_input= driver.findElement(By.xpath("//input[@name='Block_input']"));
		return Block_input;
	}
	public static WebElement Section_input(WebDriver driver)
	{
		WebElement Section_input= driver.findElement(By.xpath("//input[@name='Section_input']"));
		return Section_input;
	}
	public static WebElement Asset_input(WebDriver driver)
	{
		WebElement Asset_input= driver.findElement(By.xpath("//input[@name='Asset_input']"));
		return Asset_input;
	}
	public static WebElement Lease_input(WebDriver driver)
	{
		WebElement Lease_input= driver.findElement(By.xpath("//input[@name='Lease_input']"));
		return Lease_input;
	}
	public static WebElement SearchNoResult(WebDriver driver)
	{
		WebElement SearchNoResult= driver.findElement(By.xpath("//div[@id='main']//form/div/p"));
		return SearchNoResult;
	}
	public static WebElement OpenFirstDOFromList(WebDriver driver)
	{
		WebElement OpenFirstDOFromList= driver.findElement(By.xpath("//div[@id='viewDivisionOrderGridView']//tr[1]/td[1]/a"));
		return OpenFirstDOFromList;
	}
	public static WebElement ActionButtonClick(WebDriver driver)
	{
		WebElement ActionButtonClick= driver.findElement(By.xpath("//div[@id='divMainOverLay']/h1/div[3]/div/a"));
		return ActionButtonClick;
	}
	
	public static WebElement MarkAsVerifiedClick(WebDriver driver)
	{
		WebElement MarkAsVerifiedClick= driver.findElement(By.xpath("//div[@id='divMainOverLay']/h1/div[3]/div/ul/li[2]/a"));
		return MarkAsVerifiedClick;
	}
	
	public static WebElement ApproveDOClick(WebDriver driver)
	{
		WebElement ApproveDOClick= driver.findElement(By.xpath("//div[@id='divMainOverLay']/h1/div[3]/div/ul/li[4]/a"));
		return ApproveDOClick;
	}
	public static WebElement DeniedDOClick(WebDriver driver)
	{
		WebElement DeniedDOClick= driver.findElement(By.xpath("//div[@id='divMainOverLay']/h1/div[3]/div/ul/li[3]/a"));
		return DeniedDOClick;
	}
	public static WebElement InPayClick(WebDriver driver)
	{
		WebElement InPayClick= driver.findElement(By.xpath("//div[@id='divMainOverLay']/h1/div[3]/div/ul/li[5]/div/div/div/label"));
		return InPayClick;
	}
	
	
	
	
	//input[@name='Block_input']
	
	//input[@name='Asset_input']
	
}
