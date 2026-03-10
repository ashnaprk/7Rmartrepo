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
	
	public LoginPage enterUserNameAndPassWordfield(String usernamevalue,String passwordvalue) //2)still in home page so instead void login
	{
		username.sendKeys(usernamevalue);
		password.sendKeys(passwordvalue);
		return this; //1)whole entering username & password still in Login page so instead of void LoginPage and return to login page itself
	}
	public HomePage loginButton() //4)homepage is given instead of void because it goes to homepage after loginclick
	{
	
		wait.elementToBeClicked(driver, login);
		login.click();
		return new HomePage(driver); //3)after clicking goes to homepage so return-new homepage driver
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

