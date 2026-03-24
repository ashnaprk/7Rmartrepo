package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage
{
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
			
	}
	@FindBy(xpath="//a[@class='nav-link' and @data-toggle='dropdown']")
	WebElement admin;

	
	@FindBy(xpath="(//a[@class='dropdown-item'])[2]")
	WebElement logout;
	
	@FindBy(xpath="(//a[@class='small-box-footer'])[1]")
	WebElement moreinfoadmin; 
	
	@FindBy(xpath="//a[contains(@href,'list-category')]")
	WebElement managemoreinfo;
	
	@FindBy(xpath="(//i[@class='fas fa-arrow-circle-right'])[7]")
	WebElement moreNewsinfo;
	
	public HomePage ClickOnadminButtonInHomePage() 
	{
		
		admin.click();
		return this;
		
	}
	public HomePage ClickOnlogoutButtonInHomePage()  
	{                            

		logout.click();
		return this;
	
	}
	public UserAdminPage ClickOnmoreInfoButtonInUserAdminPage()   
	{
		moreinfoadmin.click();
		return new UserAdminPage(driver); 
	
	}
	public ManagePage ClickOnmanageInfoButtonInManagePage()
	{
		managemoreinfo.click();
		return new ManagePage(driver);
	}
	public NewsPage ClickOnmoreNewsInfoButtonInNewsPage()
	{
		moreNewsinfo.click();
		return new NewsPage(driver);
	}
	
	
}
	
	


