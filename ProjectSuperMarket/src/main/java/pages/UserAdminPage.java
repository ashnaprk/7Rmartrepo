package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class UserAdminPage {
	WebDriver driver;
	PageUtility utility=new PageUtility(); //page utility
	
	public UserAdminPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement newbutton;
	
	@FindBy(xpath="//input[@id='username']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath="//select[@id='user_type']")
	WebElement usertype;
	
	@FindBy(xpath="//button[@name='Create']")
	WebElement save;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") //assertion (webelement)
	WebElement alertmsg;
	
	
	public UserAdminPage newButton() //15 all methods are changed to return useradmin because after each method is executed it stays in the useradmin page
	{
		newbutton.click();
		return this;
	}
	public UserAdminPage adminInfo(String username1,String password1)
	
	{   username.sendKeys(username1);
	    password.sendKeys(password1);
	   
		//usernamefield.sendKeys("MSdhonii");
		//passwordfield.sendKeys("chennai");
		
		utility.selectByIndex(usertype, 2);
		return this;
		//Select select=new Select(dropdownfield);
		//select.selectByIndex(2);
	}
	
	public UserAdminPage saveButton()
	{
		save.click();
		return this;
	}
	public boolean isAlertMessageDisplayed() //for assertion
	{
		return alertmsg.isDisplayed();
	}

}
