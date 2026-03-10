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
	WebElement moreinfoadmin;  //12)taken from useradminpage first click is this
	
	@FindBy(xpath="//a[contains(@href,'list-category')]")
	WebElement managemoreinfo;
	
	@FindBy(xpath="(//i[@class='fas fa-arrow-circle-right'])[7]")
	WebElement moreNewsinfo;
	
	public HomePage adminButton() //7)admin click after still in homepage
	{
		
		admin.click();
		return this;
		
	}
	public HomePage logoutButton() //8)after logout its gone to login page but can't write it because test case is completed here therefore 
	{                              //   homepage is returned because to get a completion

		logout.click();
		return this;
	
	}
	public UserAdminPage moreInfoButton()   //13)taken from useradminpage 
	{
		moreinfoadmin.click();
		return new UserAdminPage(driver); //14) return to useradmin page here useradmin page starts
	
	}
	public ManagePage manageInfo()
	{
		managemoreinfo.click();
		return new ManagePage(driver);
	}
	public NewsPage moreNewsInfoButton()
	{
		moreNewsinfo.click();
		return new NewsPage(driver);
	}
	
}
	
	


