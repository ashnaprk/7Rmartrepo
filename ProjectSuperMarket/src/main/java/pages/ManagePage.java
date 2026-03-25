package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constant;
import utilities.FileUploadUtilities;
import utilities.PageUtility;

import utilities.WaitUtility;

public class ManagePage {

	WebDriver driver;
	FileUploadUtilities fileupload = new FileUploadUtilities();
	WaitUtility wait = new WaitUtility();
	PageUtility page = new PageUtility();

	public ManagePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newcateogory;
	@FindBy(xpath = "//input[@class='form-control']")
	WebElement entercateogory;
	@FindBy(xpath = "//li[@id='134-selectable']")
	WebElement discount;
	@FindBy(xpath = "//input[@type='file']")
	WebElement choosefile;
	@FindBy(xpath = "(//input[@value='no'])[1]")
	WebElement topmenuradiobutton;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement savebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")

	WebElement alertmessage;

	public ManagePage ClickOnNewCateogoryInManagePage() {

		newcateogory.click();
		return this;
	}

	public ManagePage enterCateogoryNameInManagePage(String entercategoryname) {
		entercateogory.sendKeys(entercategoryname);
		return this;
	}

	public ManagePage enterDiscountsInManagePage() {

		discount.click();
		return this;
	}

	public ManagePage UploadfilesInManagePage() {

		fileupload.sendKeysForFileUpload(choosefile, Constant.TESTDATAIMAGE);
		return this;
	}

	public ManagePage ClickOntopMenuRadioButtonInManagePage()

	{
		page.scrollToElement(driver, topmenuradiobutton);
		wait.elementToBeClicked(driver, topmenuradiobutton);
		page.clickUsingJs(driver, topmenuradiobutton);
		return this;

	}

	public ManagePage ClickOnsaveInfoInManagePage()

	{
		page.scrollToElement(driver, savebutton);
		wait.elementToBeClicked(driver, savebutton);
		page.clickUsingJs(driver, savebutton);
		return this;

	}

	public ManagePage scrollDownActionInManagePage() {
		page.scrollByPixel(driver, 0, 500);
		return this;

	}

	public ManagePage scrolldownActionToTopMenuButtonInManagePage()

	{
		page.scrollToElement(driver, topmenuradiobutton);

		return this;
	}

	public boolean isAlertMsgDisplayedInManagePage() {
		wait.visibilityOfElement(driver, alertmessage);
		return alertmessage.isDisplayed();

	}

}
