package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtilities;

public class LoginPageTest extends Base {
	HomePage homepage;

	@Test(description="Verify LoginPage with valid and invalid credentials",dataProvider = "credentialvalues", groups = "smoke")
	public void verifyData(String username, String password) {
		LoginPage login = new LoginPage(driver);
		login.enterUserNameAndPassWordfieldInLoginPage(username, password);
		homepage = login.ClickOnloginButtonInLoginPage();
		boolean homepagedispalyed = login.isHomePagedisplayed();
		Assert.assertTrue(homepagedispalyed, Constant.ERRORMESSAGEFORLOGIN);

	}

	@DataProvider(name = "credentialvalues")
	public Object testdata() {
		Object data[][] = { { "admin", "admin" }, { "admin", "tyeydgg" }, { "ashna", "admin" }, { "rohit", "ggsgs" } };
		return data;
	}

	@Test(description = "verify valid username and valid password",groups = "smoke")
	public void verifyvalidUsernameAndValidPassword() throws IOException {
		LoginPage login = new LoginPage(driver);
		String username = ExcelUtilities.getStringData(1, 0, "LoginpageTest");
		String password = ExcelUtilities.getStringData(1, 1, "LoginpageTest");
		login.enterUserNameAndPassWordfieldInLoginPage(username, password);
		homepage = login.ClickOnloginButtonInLoginPage();

	}

	@Test(description = "verify invalid username and valid password")
	@Parameters({ "usernamefields", "passwordfields" })
	public void verifyInvalidUsernameAndValidPassword(String username, String password) {
		LoginPage login = new LoginPage(driver);
		login.enterUserNameAndPassWordfieldInLoginPage(username, password);
		homepage = login.ClickOnloginButtonInLoginPage();

	}

	@Test(description = "verify valid username and invalid password")
	@Parameters({ "usernamefield", "passwordfield" })
	public void verifyValidUsernameAndInvalidPassword(String username, String password) {
		LoginPage login = new LoginPage(driver);
		login.enterUserNameAndPassWordfieldInLoginPage(username, password);
		homepage = login.ClickOnloginButtonInLoginPage();
	}

}
