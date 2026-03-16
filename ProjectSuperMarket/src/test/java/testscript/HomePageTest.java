package testscript;

import java.awt.AWTException;
//import java.awt.Robot;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtilities;

public class HomePageTest extends Base {
	HomePage homepage;

	@Test(description = "Verify that the user can logout successfully after logging in")
	public void verifylogout() throws AWTException, IOException

	{
		LoginPage login = new LoginPage(driver);
		String username = ExcelUtilities.getStringData(1, 0, "HomeTest");
		String password = ExcelUtilities.getStringData(1, 1, "HomeTest");
		login.enterUserNameAndPassWordfield(username, password);
		
		homepage = login.loginButton();
		homepage.adminButton().logoutButton();
		String expected = "Login | 7rmart supermarket";
		String actual = driver.getTitle();
		Assert.assertEquals(actual, expected, "Logout failes");
	}
}
