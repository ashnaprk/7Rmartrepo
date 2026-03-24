package testscript;

import java.io.IOException;

import org.testng.Assert;

//import java.awt.AWTException;
//import java.awt.Robot;

import org.testng.annotations.Test;

import constants.Constant;
import pages.UserAdminPage;
import utilities.ExcelUtilities;
import utilities.FakerUtility;
import pages.HomePage;
import pages.LoginPage;

public class UserAdminTest extends Base {
	HomePage homepage;
	UserAdminPage adminpage;
	FakerUtility faker = new FakerUtility();

	@Test(description = "Verify the functionality of adding a new user to UserAdmin Page", retryAnalyzer = retry.Retry.class)
	public void verifyAdminInfo() throws IOException {
		LoginPage login = new LoginPage(driver);
		String username = ExcelUtilities.getStringData(1, 0, "Adminpagetest");
		String password = ExcelUtilities.getStringData(1, 1, "Adminpagetest");

		login.enterUserNameAndPassWordfieldInLoginPage(username, password);
		homepage = login.ClickOnloginButtonInLoginPage();
		adminpage = homepage.ClickOnmoreInfoButtonInUserAdminPage();
		String adminname = faker.getFakeFirstName();
		String adminpassword = faker.getPassword();
		adminpage.clickOnnewButtonInUserAdminPage().enterAdminInfoDetailsInAdminPage(adminname, adminpassword).clickOnsaveButtonInAdminPage();

		boolean alertdisplayed = adminpage.isAlertMessageDisplayed();
		Assert.assertTrue(alertdisplayed, Constant.ALERTMESSAGEUSERADDEDSUCCESSFULLY);

	}

	@Test(description = "Verify that the user can search for a username in the Admin page")
	public void searchUsernameinAdminPage() throws IOException {
		LoginPage login = new LoginPage(driver);
		String username = ExcelUtilities.getStringData(1, 0, "Adminpagetest");
		String password = ExcelUtilities.getStringData(1, 1, "Adminpagetest");
		login.enterUserNameAndPassWordfieldInLoginPage(username, password);
		homepage = login.ClickOnloginButtonInLoginPage();
		adminpage = homepage.ClickOnmoreInfoButtonInUserAdminPage();
		adminpage.clickOnSearchButton1InAdminPage().enterUsernameToBeSearchedInAdminPage(ExcelUtilities.getStringData(1, 4, "Adminpagetest"))
				 .selectUserTypeToBeSearchedInAdminPage().clickOnSearchButton2InAdminPage();

		boolean result = adminpage.isSearchedUsernamePresentInAdminPage(ExcelUtilities.getStringData(1, 4, "Adminpagetest"));
		Assert.assertTrue(result, Constant.ALERTMESSAGEFORSEARCH);

	}

}
