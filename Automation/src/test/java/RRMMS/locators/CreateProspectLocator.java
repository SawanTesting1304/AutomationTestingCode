package RRMMS.locators;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import RRMMS.utility.Common;

public class CreateProspectLocator {
	
	public static WebElement radiobuttonSelect(WebDriver driver, String FieldName)
	{
		WebElement radiobuttonSelect= driver.findElement(By.xpath("//label[contains(text(),'"+FieldName+"')]"));
		return radiobuttonSelect;
	}
	public static WebElement ElementID(WebDriver driver, String FieldName)
	{
		WebElement TextBox= driver.findElement(By.id(""+FieldName+""));
		return TextBox;
	}
	public static WebElement ProspectName(WebDriver driver)
	{
		WebElement ProspectName= driver.findElement(By.xpath("//div[@id='fixed-stat']/h1/span"));
		return ProspectName;
	}
	
	
	public static WebElement List(WebDriver driver, String FieldName)
	{
		WebElement List= driver.findElement(By.id("//li[@id='lientity']/a[contains(text(),'"+FieldName+"')]"));
		return List;
	}
	public static WebElement CreateProspectButton(WebDriver driver)
	{
		WebElement Button= driver.findElement(By.xpath("//div[@id='createDiv']/button[contains(text(),'Create Prospect')]"));
		return Button;
	}
	public static WebElement ProspectNetRoyAcer(WebDriver driver, int i)
	{
		WebElement ProspectNetRoyAcer= driver.findElement(By.id("NetRoyaltyAcre"+i));
		return ProspectNetRoyAcer;
	}
	public static WebElement ProspectNetRoyInt(WebDriver driver, int f)
	{
		WebElement ProspectNetRoyInt= driver.findElement(By.id("NetRoyInterest0"+f));
		return ProspectNetRoyInt;
	}
	
	
	
	public static WebElement polygon(WebDriver driver)
	{
		WebElement polygon= driver.findElement(By.xpath("//div[@id='map']/div[2]/div[2]/div/button[1]"));
		return polygon;
	}
	public static WebElement Header(WebDriver driver, int i)
	{
		WebElement polygon= driver.findElement(By.xpath("//div[@id='divCreateProspect']/div[2]/ul/li["+i+"]/a/span/img"));
		return polygon;
	}
	public static WebElement TextBoxName(WebDriver driver, String TextName)
	{
		WebElement TextBoxName= driver.findElement(By.name(TextName));
		return TextBoxName;
	}
	public static WebElement HeadCount(WebDriver driver, int i)
	{
		WebElement HeadCount= driver.findElement(By.xpath("//div[@id='accordion"+i+"']/div/a/h4/span[3]"));
		return HeadCount;
	}
	public static WebElement QtrCallClick(WebDriver driver,int i, int r)
	{
		WebElement QtrCallClick= driver.findElement(By.xpath("//div[@id='accordion"+i+"']//tbody["+r+"]/tr[1]/td[@id='qtrcall']//a/img"));
		return QtrCallClick;
	}
	public static WebElement Map(WebDriver driver)
	{
		WebElement Map=driver.findElement(By.xpath("//div[@id='map']/div[2]/canvas"));
		return Map;
	}
	public static WebElement RedFlagRejectResaonSubmit(WebDriver driver)
	{
		WebElement RedFlagRejectResaonSubmit=driver.findElement(By.xpath("//form[@id='frmRejectReason']/div[2]/div/button"));
		return RedFlagRejectResaonSubmit;
	}
	
	public static WebElement subsectionSelect(WebDriver driver, int i)
	{
		WebElement subsectionSelect=driver.findElement(By.xpath("//div[@id='desc']/div[1]/div[1]/div["+i+"]/button"));
		return subsectionSelect;
	}
	public static WebElement subsectionOKButton(WebDriver driver)
	{
		WebElement subsectionOKButton=driver.findElement(By.xpath("//div[@id='track-builder']/div/div/div[2]/div[2]/button[1]"));
		return subsectionOKButton;
	}
	public static WebElement SaveProspectButton(WebDriver driver)
	{
		WebElement SaveProspectButton=driver.findElement(By.xpath("//div[@id='prospectTrack']/div[1]/div[1]/button"));
		return SaveProspectButton;
	}
	public static WebElement NotificationIconClick(WebDriver driver)
	{
		WebElement NotificationIconClick=driver.findElement(By.xpath("//li[@id='header_inbox_bar']/a"));
		return NotificationIconClick;
	}
	public static WebElement NotificationListClick(WebDriver driver)
	{
		WebElement NotificationListClick=driver.findElement(By.xpath("//ul[@id='drop']/li[2]/a/span[2]"));
		return NotificationListClick;
	}
	public static WebElement Notification2ListClick(WebDriver driver)
	{
		WebElement Notification2ListClick=driver.findElement(By.xpath("//ul[@id='drop']/li[3]/a/span[2]"));
		return Notification2ListClick;
	}
	/*public static WebElement ViewProspectButtonClick(WebDriver driver)
	{
		WebElement ViewProspectButtonClick=driver.findElement(By.xpath("//ul[@id='menu']/li[1]/a/img"));
		return ViewProspectButtonClick;
	}*/
	public static WebElement ClickFirstProspect(WebDriver driver)
	{
		WebElement ClickFirstProspect=driver.findElement(By.xpath("//div[@id='divViewProspect']/div/div/div/div[1]/div"));
		return ClickFirstProspect;
	}
	public static WebElement KillButtonClick(WebDriver driver)
	{
		WebElement KillButtonClick=driver.findElement(By.xpath("//div[@id='divViewProspect']/div/div/div/div[1]/div/div/div/a[2]"));
		return KillButtonClick;
	}
	public static WebElement ConfirmDelete(WebDriver driver)
	{
		WebElement ConfirmDelete=driver.findElement(By.xpath("html/body/div[2]/div[2]/button[2]"));
		return ConfirmDelete;
	}
	public static WebElement ActionButtonClick(WebDriver driver)
	{
		WebElement ActionButtonClick=driver.findElement(By.xpath("//div[@id='fixed-stat']/h1/div[2]/div[1]/a"));
		return ActionButtonClick;
	}
	public static WebElement ActionListClick(WebDriver driver, int i)
	{
		WebElement ActionListClick=driver.findElement(By.xpath("//div[@id='fixed-stat']/h1/div[2]/div[1]/ul/li["+i+"]/a"));
		return ActionListClick;
	}
	public static WebElement OpenCalenderClick(WebDriver driver)
	{
		WebElement OpenCalenderClick=driver.findElement(By.xpath("//div[@id='add-payment']/div/div/div[2]/div/div[4]/span[1]/span/span/span"));
		return OpenCalenderClick;
	}
	public static WebElement SelectDate(WebDriver driver) throws AWTException, InterruptedException
	{
		WebElement SelectDate=driver.findElement(By.xpath("//a[@title='"+Common.date()+"']"));
		return SelectDate;
	}
	public static WebElement AddPayment(WebDriver driver)
	{
		WebElement SelectDate=driver.findElement(By.xpath("//div[@id='payList']/div[2]/div[1]/button"));
		
		return SelectDate;
	}
	public static WebElement ClickSeller(WebDriver driver)
	{
		WebElement ClickSeller=driver.findElement(By.xpath("//div[@id='collapse1']/div[2]/div/div/div/div/div/div[3]/div[2]/span[1]"));
		return ClickSeller;
	}
	public static WebElement AddNewCompanyClick(WebDriver driver)
	{
		WebElement AddNewCompanyClick=driver.findElement(By.xpath("//div[@id='editSeller-list']/div[3]/div/button"));
		return AddNewCompanyClick;
	}
	public static WebElement AddClick(WebDriver driver)
	{
		WebElement AddClick=driver.findElement(By.xpath("//form[@id='frmCompany']/div[8]/div/button"));
		return AddClick;
	}
	public static WebElement EditTractClick(WebDriver driver, int i, int j)
	{
		WebElement EditTractClick=driver.findElement(By.xpath("//div[@id='collapsett']/div/div/div/div/form/table/tbody["+i+"]/tr[1]/td[10]/div/i["+j+"]"));
		return EditTractClick;
	}
	public static WebElement OpenTract(WebDriver driver)
	{
		WebElement OpenTract=driver.findElement(By.xpath("//div[@id='accordion00a1N']/div/a/h4"));
		return OpenTract;
	}
	public static WebElement OpenCounty(WebDriver driver, int i)
	{
		WebElement OpenTract=driver.findElement(By.xpath("//div[@id='accordion"+i+"']/div/a/h4"));
		return OpenTract;
	}
	
	public static WebElement TractInputField(WebDriver driver, int i, int j, String id)
	{
		WebElement TractInputField=driver.findElement(By.xpath("//div[@id='collapseNewND"+i+"']//tbody["+j+"]//input[@id='"+id+"']"));
		return TractInputField;
	}
	
	public static WebElement EditTractAddClick(WebDriver driver)
	{
		WebElement EditTractAddClick=driver.findElement(By.xpath("//div[@id='createDiv']/button"));
		return EditTractAddClick;
	}
	public static WebElement Pagehearder(WebDriver driver)
	{
		WebElement Pagehearder=driver.findElement(By.xpath("//div[@id='main']/div/div[1]/header"));
		return Pagehearder;
	}
	
	//div[@id='main']/div/div[1]/header/a[1]/img
	/*.//*[@id='collapsett']/div/div/div/div/form/table/tbody[1]/tr[1]/td[10]/div/i[1]
	.//*[@id='collapsett']/div/div/div/div/form/table/tbody[2]/tr[1]/td[10]/div/i[1]
	.//*[@id='collapsett']/div/div/div/div/form/table/tbody[3]/tr[1]/td[10]/div/i[1]
*/	
	public static WebElement ActionEditClick(WebDriver driver)
	{
		WebElement ActionEditClick=driver.findElement(By.xpath("//div[@id='fixed-stat']/h1/div[2]/div[1]/ul/li[1]/ul/li[1]/a"));
		return ActionEditClick;
	}
	public static WebElement CommentText(WebDriver driver)
	{
		WebElement CommentText=driver.findElement(By.xpath("//form[@id='frmCommentBox']/div[1]/table/tbody/tr[1]/td"));
		return CommentText;
	}
	public static WebElement CommentPost(WebDriver driver)
	{
		WebElement CommentPost=driver.findElement(By.xpath("//form[@id='frmCommentBox']/div[2]/div/button"));
		return CommentPost;
	}
	public static WebElement ViewKill(WebDriver driver)
	{
		WebElement ViewKill=driver.findElement(By.xpath("//div[@id='divViewProspect']/div/div/div/h1/span/a"));
		return ViewKill;
	}
	
	public static WebElement DeleteKill(WebDriver driver, int i)
	{
		WebElement DeleteKill=driver.findElement(By.xpath("//div[@id='killedProspectGridView']/div[2]/table/tbody/tr["+i+"]/td[10]/a[2]/i"));
		return DeleteKill;
	}
	//html/body/div[1]/div/div[3]/div/ui-view/main/div/div/div/div/div[6]/div/div/div/div/div/div/div/div/form/table/tbody[1]/tr[2]/td/table/tbody/tr[2]/td[2]/div/input
	//html/body/div[1]/div/div[3]/div/ui-view/main/div/div/div/div/div[6]/div/div/div/div/div/div/div/div/form/table/tbody[2]/tr[2]/td/table/tbody/tr[2]/td[2]/div/input
	
	public static WebElement DepthCheckBoxClick(WebDriver driver)
	{
		WebElement DepthCheckBoxClick=driver.findElement(By.xpath("//div[@id='desc']/div[1]/div[2]/div/div[4]/label"));
		return DepthCheckBoxClick;
	}
	public static WebElement AddDepthTract(WebDriver driver)
	{
		WebElement AddDepthTract=driver.findElement(By.xpath("//div[@id='depth-details']/div[1]/div[2]/button"));
		return AddDepthTract;
	}
	
	public static WebElement DepthDescription(WebDriver driver, int i)
	{
		WebElement DepthDescription=driver.findElement(By.xpath("html/body/div[1]/div/div[3]/div/ui-view/div[1]/div[2]/div/div/div/div[2]/div[1]/div/div/div/div/div[3]/div[2]/div/div/form/div["+i+"]/div/textarea"));
		return DepthDescription;
	}
	public static WebElement DepthDescriptionOkClick(WebDriver driver)
	{
		WebElement DepthDescriptionOkClick=driver.findElement(By.xpath("//div[@id='track-builder']/div/div/div[2]/div[2]/button[1]"));
		return DepthDescriptionOkClick;
	}
	public static WebElement ProsepctName(WebDriver driver)
	{
		WebElement DepthDescriptionOkClick=driver.findElement(By.xpath("//input[@id='prospectName']"));
		return DepthDescriptionOkClick;
	}
	public static WebElement MenuClick(WebDriver driver)
	{
		WebElement MenuClick=driver.findElement(By.xpath("//ul[@id='menu']/li[1]/a/img"));
		return MenuClick;
	}
	
	
	
}
