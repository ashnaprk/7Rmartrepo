package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;



public class UserAdminPage {
	WebDriver driver;
	PageUtility utility = new PageUtility();
	WaitUtility wait = new WaitUtility();

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

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement search;

	@FindBy(xpath = "//input[@id='un']")
	WebElement usernameToSearch;

	@FindBy(xpath = "//select[@id='ut']")
	WebElement userTypeToSearch;

	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchTheUsername;

	public UserAdminPage clickOnnewButtonInUserAdminPage() {
		newbutton.click();
		return this;
	}

	public UserAdminPage enterAdminInfoDetailsInAdminPage(String username1, String password1)

	{
		username.sendKeys(username1);
		password.sendKeys(password1);

		utility.selectByIndex(usertype, 2);
		return this;

	}

	public UserAdminPage clickOnsaveButtonInAdminPage() {
		save.click();
		return this;
	}

	public boolean isAlertMessageDisplayed() {
		return alertmsg.isDisplayed();
	}

	public UserAdminPage clickOnSearchButton1InAdminPage() {
		search.click();
		return this;
	}

	public UserAdminPage enterUsernameToBeSearchedInAdminPage(String SearchName) {
		usernameToSearch.sendKeys(SearchName);
		return this;
	}

	public UserAdminPage selectUserTypeToBeSearchedInAdminPage() {
		utility.selectByIndex(userTypeToSearch, 2);
		return this;
	}

	public UserAdminPage clickOnSearchButton2InAdminPage() {
		searchTheUsername.click();
		return this;
	}

	public boolean isSearchedUsernamePresentInAdminPage(String expectedName) {
		wait.waitForElementToBeVisible(driver, By.xpath("//table/tbody/tr"));
		List<WebElement> usernames = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
		if (usernames.size() == 0) {   //If no rows found
			System.out.println("No user found");
			return false;
		}
		for (WebElement element : usernames) {
			String actual = element.getText().trim();
			System.out.println("Checking: " + actual);
			if (actual.equalsIgnoreCase(expectedName)) {
				return true;

			}
		}
		return false;

	}

}
