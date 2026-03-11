package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class LoginPage 

{
	WebDriver driver;
	WaitUtility wait=new WaitUtility();
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	@FindBy(xpath="//input[@placeholder='Username']")
	WebElement username;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement login;
	
	@FindBy(xpath="//p[text()='Dashboard']")
	WebElement dashboard;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement alert;
	
	public LoginPage enterUserNameAndPassWordfield(String usernamevalue,String passwordvalue) 
	{
		username.sendKeys(usernamevalue);
		password.sendKeys(passwordvalue);
		return this; 
	}
	public HomePage loginButton() 
	{
	
		wait.elementToBeClicked(driver, login);
		login.click();
		return new HomePage(driver); 
	}
	public boolean isHomePagedisplayed()
	{
		return dashboard.isDisplayed();
	}
	public boolean isAlertDisplayed()
	{
		return alert.isDisplayed();
	}
	
}

