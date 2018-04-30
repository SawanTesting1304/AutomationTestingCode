package RRMMS.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WorkFlowLocator {
	public static WebElement AttachmentCheckBox(WebDriver driver, int i)
	{
		WebElement AttachmentCheckBox= driver.findElement(By.xpath("//form[@id='frmGenerateOffer']/div[1]/div["+i+"]/div/label"));
		return AttachmentCheckBox;
	}
	public static WebElement ElementID(WebDriver driver, String FieldName)
	{
		WebElement ElementID= driver.findElement(By.id(""+FieldName+""));
		return ElementID;
	}
	public static WebElement WorkFlowDate(WebDriver driver, int i)
	{
		WebElement WorkFlowDate= driver.findElement(By.xpath("//form[@id='frmGenerateOfferManual']/div/div/div[2]/div["+i+"]/div/div/span[1]/span/span/span"));
		
		return WorkFlowDate;
	}
	public static WebElement GenerateButton(WebDriver driver)
	{
		WebElement GenerateButton= driver.findElement(By.xpath("//form[@id='frmGenerateOffer']/div[2]/div[2]/button"));
		return GenerateButton;
	}
	public static WebElement offerPackageNextButton(WebDriver driver)
	{
		WebElement offerPackageNextButton= driver.findElement(By.xpath("//div[@id='genOfferSectionA1']/div[2]/div/a"));
		return offerPackageNextButton;
	}
	
	public static WebElement ProspectNetRoyAcer(WebDriver driver, int i)
	{
		WebElement ProspectNetRoyAcer= driver.findElement(By.id("NetRoyaltyAcre"+i));
		return ProspectNetRoyAcer;
	}
	public static WebElement ProspectDecInt(WebDriver driver, int f)
	{
		WebElement ProspectDecInt= driver.findElement(By.xpath("//tbody["+f+"]//td[8]//input"));
		return ProspectDecInt;
	}
	
	public static WebElement UserLoginName(WebDriver driver)
	{
		WebElement UserLoginName= driver.findElement(By.xpath("//div[@id='main']/div/div[1]/header/nav[1]/ul/li[2]/a/span[2]"));
															//div[@id='main']/div/div[1]/header/nav[1]/ul/li[2]/a/span[2]
		return UserLoginName;
	}
	
	public static WebElement Logout(WebDriver driver)
	{
		WebElement Logout= driver.findElement(By.xpath(".//*[@id='main']/div/div[1]/header/nav[1]/ul/li[2]/ul/li[5]/a"));
		return Logout;
	}
	public static WebElement uploadBrowse(WebDriver driver)
	{
		WebElement uploadBrowse= driver.findElement(By.xpath("html/body/div[1]/div/div[3]/div/ui-view/main/div/div/div/div/div[7]/div[1]/div/ul/li[3]/div/div/a/div/span/button"));
		return uploadBrowse;
	}
	
	public static WebElement DiligenceDateClick(WebDriver driver)
	{
		WebElement DiligenceDateClick= driver.findElement(By.xpath("//div[@id='collapse1']/div[3]/div/div/div/div/div/div[4]/div[1]/following-sibling::div/span[1]"));
		return DiligenceDateClick;
	}
	public static WebElement DiligenceDateCalanderClick(WebDriver driver)
	{
		WebElement DiligenceDateCalanderClick= driver.findElement(By.xpath("//div[@id='collapse1']/div[3]/div/div/div/div/div/div[4]/div[2]/span[2]/span/span/span"));
		return DiligenceDateCalanderClick;
	}
	
	public static WebElement ClickOutsideOfInputBox(WebDriver driver)
	{
		WebElement ClickOutsideOfInputBox= driver.findElement(By.xpath("//div[@id='main']/div/div[1]/header/div[1]"));
		return ClickOutsideOfInputBox;
	}
	
	public static WebElement DiligenceSubmit(WebDriver driver)
	{
		WebElement DiligenceSubmit= driver.findElement(By.xpath("//div[@id='divDueDeligenceDueDate']/div/div/div[2]/form/div[2]/div/button"));
		return DiligenceSubmit;
	}
	public static WebElement PriceApprovalSubmit(WebDriver driver)
	{
		WebElement PriceApprovalSubmit= driver.findElement(By.xpath("//form[@id='frmPriceApproval']/div[2]/div[2]/button"));
		return PriceApprovalSubmit;
	}
	public static WebElement PriceApprovalButton(WebDriver driver)
	{
		WebElement PriceApprovalSubmit= driver.findElement(By.xpath("//div[@id='fixed-stat']/h1/div[2]/div[3]/div"));
		return PriceApprovalSubmit;
	}
	public static WebElement PriceApproveReject(WebDriver driver, int i)
	{
		WebElement PriceApprovalSubmit= driver.findElement(By.xpath("//div[@id='fixed-stat']/h1/div[2]/div[3]/div/ul/li["+i+"]/a"));
		return PriceApprovalSubmit;
	}
	
	public static WebElement ClearToPayclick(WebDriver driver)
	{
		WebElement ClearToPayclick= driver.findElement(By.xpath("//div[@id='fixed-stat']/h1/div[2]/div[2]/a[2]"));
		return ClearToPayclick;
	}
	public static WebElement RejectReason(WebDriver driver)
	{
		WebElement RejectReason= driver.findElement(By.xpath("//form[@id='frmRejectReason']/div[2]/div/button"));
		return RejectReason;
	}
	
	public static WebElement UploadOwnershipReport(WebDriver driver)
	{
		WebElement UploadOwnershipReport= driver.findElement(By.xpath("//div[@id='Mineral']/div/a/div/span/button"));
		return UploadOwnershipReport;
	}
	public static WebElement Message(WebDriver driver)
	{
		WebElement Message= driver.findElement(By.xpath(".//*[@id='toast-container']/div/div"));
		return Message;
	}
	
	public static WebElement Date(WebDriver driver)
	{
		WebElement Message= driver.findElement(By.xpath("//div[@id='divDueDeligenceDueDate']/div/div/div[2]/form/div[1]/div/span/span/input"));
		return Message;
	}
	
	public static WebElement FinalPriceApprovalButton(WebDriver driver)
	{
		WebElement FinalPriceApprovalButton= driver.findElement(By.xpath("//div[@id='fixed-stat']/h1/div[2]/div[4]/div/a"));
		//div[@id='fixed-stat']/h1/div[2]/div[4]/div/a
		//div[@id='main']/div/div[3]/div/ui-view/main/div/div/div/div
		///h1/div[2]/div[4]/div/a/i
		//div[@id='fixed-stat']
		return FinalPriceApprovalButton;
	}
	public static WebElement FinalPriceApproveReject(WebDriver driver, int i)
	{
		WebElement FinalPriceApproveReject= driver.findElement(By.xpath("//div[@id='fixed-stat']/h1/div[2]/div[4]/div/ul/li["+i+"]/a"));
		return FinalPriceApproveReject;
	}

	
}
