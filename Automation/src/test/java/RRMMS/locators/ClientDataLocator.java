package RRMMS.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClientDataLocator {
	public static WebElement RegNoClick(WebDriver driver, int i)
	{
		WebElement TextBox= driver.findElement(By.xpath("html/body/table/tbody/tr["+i+"]/td[2]/a"));
		return TextBox;
	}
	public static WebElement State(WebDriver driver)
	{
		WebElement State= driver.findElement(By.xpath("html/body/table[2]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td[1]/input"));
		return State;
	}
	
	public static WebElement County(WebDriver driver)
	{
		WebElement County= driver.findElement(By.xpath("html/body/table[2]/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td[2]/input"));
		return County;
	}
	
	public static WebElement Blk(WebDriver driver)
	{
		WebElement Blk= driver.findElement(By.xpath("html/body/table[2]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td[7]/input"));
		return Blk;
	}
	
	public static WebElement Tshp(WebDriver driver)
	{
		WebElement Tshp= driver.findElement(By.xpath("html/body/table[2]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td[3]/input"));
		return Tshp;
	}
	
	public static WebElement Sect(WebDriver driver)
	{
		WebElement Sect= driver.findElement(By.xpath("html/body/table[2]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td[5]/input"));
		return Sect;
	}
	public static WebElement Legal_Description(WebDriver driver)
	{
		WebElement Legal_Description= driver.findElement(By.xpath("html/body/table[2]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td[8]/input"));
		return Legal_Description;
	}
	public static WebElement DecimalInt(WebDriver driver)
	{
		WebElement DecimalInt= driver.findElement(By.xpath("html/body/table[2]/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[2]/td[5]/input"));
		return DecimalInt;
	}
	public static WebElement Gross(WebDriver driver)
	{
		WebElement Gross= driver.findElement(By.xpath("html/body/table[2]/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[2]/td[3]/input"));
		return Gross;
	}
	public static WebElement SellerDetails(WebDriver driver)
	{
		WebElement SellerDetails= driver.findElement(By.xpath("html/body/table[2]/tbody/tr/td/table/tbody/tr[2]/td/a/span"));
		return SellerDetails;
	}
	public static WebElement Entity(WebDriver driver)
	{
		WebElement Entity= driver.findElement(By.xpath("//div[@id='GreenBox']/form/table/tbody/tr[5]/td[1]/table/tbody/tr[2]/td[1]/input"));
		return Entity;
	}
	public static WebElement FirstName(WebDriver driver)
	{
		WebElement FirstName= driver.findElement(By.xpath("//div[@id='GreenBox']/form/table/tbody/tr[5]/td[1]/table/tbody/tr[2]/td[3]/input"));
		return FirstName;
	}
	public static WebElement LastName(WebDriver driver)
	{
		WebElement LastName= driver.findElement(By.xpath("//div[@id='GreenBox']/form/table/tbody/tr[5]/td[1]/table/tbody/tr[2]/td[4]/input"));
		return LastName;
	}
	public static WebElement Price(WebDriver driver)
	{
		WebElement Price= driver.findElement(By.xpath("//div[@id='GreenBox']/form/table/tbody/tr[6]/td[2]/table/tbody/tr[2]/td[1]/input"));
		return Price;
	}
	public static WebElement LegalDescription(WebDriver driver)
	{
		WebElement LegalDescription= driver.findElement(By.id("DocumentLegalDescription"));
		return LegalDescription;
	}
	public static WebElement Play(WebDriver driver)
	{
		WebElement Play= driver.findElement(By.id("Play"));
		return Play;
	}
	public static WebElement LeaseQtrCall(WebDriver driver)
	{
		WebElement LeaseQtrCall= driver.findElement(By.xpath("html/body/table[2]/tbody/tr/td/table/tbody/tr[5]/td/form/table/tbody/tr[1]/td/table/tbody/tr[2]/td[5]/input"));
		return LeaseQtrCall;
	}
	public static WebElement LeaseNotes(WebDriver driver)
	{
		WebElement LeaseNotes= driver.findElement(By.id("LeaseNotes"));
		return LeaseNotes;
	}
	public static WebElement Term(WebDriver driver)
	{
		WebElement Term= driver.findElement(By.xpath("html/body/table[2]/tbody/tr/td/table/tbody/tr[5]/td/form/table/tbody/tr[1]/td/table/tbody/tr[2]/td[8]/input"));
		return Term;
	}
	
	public static WebElement SelectProductionUnitWell(WebDriver driver, String wellname)
	{
		WebElement SelectProductionUnitWell= driver.findElement(By.xpath(".//div/div[2]//span/label[@for='"+wellname+"']/preceding::div[1]"));
		System.out.println("Test"+SelectProductionUnitWell);
		return SelectProductionUnitWell;
	}
	public static WebElement Wellname1(WebDriver driver, String wellname)
	{
		WebElement Wellname1= driver.findElement(By.xpath(".//*[@id='Production']/table/tbody/tr/td[1]/form/table/tbody/tr/td[1]/table/tbody/tr/td[1]/a[contains(text(),'"+wellname+"')]"));
		return Wellname1;
	}
	public static WebElement Wellname2(WebDriver driver)
	{
		WebElement Wellname2= driver.findElement(By.xpath(".//*[@id='Production']/table/tbody/tr/td[1]/form/table/tbody/tr/td[1]/table/tbody/tr/td[2]/div"));
		return Wellname2;
	}
	
	

}
