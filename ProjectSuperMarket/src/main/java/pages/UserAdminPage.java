package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class UserAdminPage {
	WebDriver driver;
	PageUtility utility = new PageUtility();

	public UserAdminPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newbutton;

	@FindBy(xpath = "//input[@id='username']")
	WebElement username;

	@FindBy(xpath = "//input[@id='password']")
	WebElement password;

	@FindBy(xpath = "//select[@id='user_type']")
	WebElement usertype;

	@FindBy(xpath = "//button[@name='Create']")
	WebElement save;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertmsg;

	public UserAdminPage newButton() {
		newbutton.click();
		return this;
	}

	public UserAdminPage adminInfo(String username1, String password1)

	{
		username.sendKeys(username1);
		password.sendKeys(password1);

		utility.selectByIndex(usertype, 2);
		return this;

	}

	public UserAdminPage saveButton() {
		save.click();
		return this;
	}

	public boolean isAlertMessageDisplayed() {
		return alertmsg.isDisplayed();
	}

}
