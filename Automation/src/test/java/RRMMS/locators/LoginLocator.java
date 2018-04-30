package RRMMS.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginLocator {
	/* public static By userName=By.id("Username");
	 public static By password=By.id("Password");*/
	 
	 public static WebElement txtFld_rrmms(WebDriver driver, String FieldName)
	{
		WebElement username= driver.findElement(By.id(""+FieldName+""));
		return username;
	}
	/*public static WebElement password(WebDriver driver)
	{
		WebElement password= driver.findElement(By.id("Password"));
		return password;
	}*/
	public static WebElement Loginbutton(WebDriver driver)
	{
		WebElement Loginbutton= driver.findElement(By.name("Login"));
		return Loginbutton;
	}
	 
	//input[@id='Password']
}
