package pages;

import org.openqa.selenium.JavascriptExecutor;


//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constant;
import utilities.FileUploadUtilities;
//import utilities.PageUtility;
import utilities.WaitUtility;
//import utilities.PageUtility;

public class ManagePage {
	
	WebDriver driver;
	FileUploadUtilities fileupload=new FileUploadUtilities();
	WaitUtility wait=new WaitUtility();
	 
	 

	public ManagePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement newcateogory;
	@FindBy(xpath="//input[@class='form-control']")
	WebElement entercateogory;
	@FindBy(xpath="//li[@id='134-selectable']")
	WebElement discount;
	@FindBy(xpath="//input[@type='file']")
	WebElement choosefile;
	@FindBy(xpath="(//input[@value='no'])[1]")
	WebElement topmenuradiobutton;
	@FindBy(xpath="//button[@class='btn btn-danger']")
	WebElement savebutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement alertmessage;
	
	
	
	public ManagePage newCateogory()
	{
	
		newcateogory.click();
		return this;
	}
	public ManagePage enterCateogory(String entercategoryname)
	{
		entercateogory.sendKeys(entercategoryname);
		return this;
	}
	public ManagePage discounts()
	{   
		
		discount.click();
		return this;
	}
	public ManagePage choosefiles()
	{    
		fileupload.sendKeysForFileUpload(choosefile, Constant.TESTDATAIMAGE);
		
		return this;
	}
	
	public ManagePage topMenu()
	
	{   
		
		//wait.elementToBeClicked(driver, topmenuradiobutton);
		wait.visibilityOfElement(driver, topmenuradiobutton);
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click();", topmenuradiobutton);
	    return this;
		//topmenuradiobutton.click();
	
	}
	
	public ManagePage saveInfo()
	
	{ 
	
		wait.visibilityOfElement(driver, savebutton);
		savebutton.click();
		return this;
	}
	public ManagePage scrollDownAction()
	{ 
		JavascriptExecutor javascript=(JavascriptExecutor) driver;
		javascript.executeScript("window.scrollBy(0,500)"," " );
		return this;
		
	}
	public ManagePage scrolldownActionToTopMenuButton()
	
	{  
	     
		JavascriptExecutor javascript=(JavascriptExecutor) driver;
		javascript.executeScript("arguments[0].scrollIntoView(true)",topmenuradiobutton);
		return this;
	}
	public boolean isAlertMsgDisplayed()
	{
		return alertmessage.isDisplayed();
		
	}
	
	

}
