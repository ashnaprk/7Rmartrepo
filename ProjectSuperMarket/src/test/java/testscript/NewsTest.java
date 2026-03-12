package testscript;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.NewsPage;
import utilities.ExcelUtilities;


public class NewsTest extends Base {
	HomePage homepage;
	NewsPage newspage;


	@Test
	public void addNews() throws IOException {
		LoginPage login = new LoginPage(driver);
		String username = ExcelUtilities.getStringData(1, 0, "LoginpageTest");
		String password = ExcelUtilities.getStringData(1, 1, "LoginpageTest");
		login.enterUserNameAndPassWordfield(username, password);
		homepage = login.loginButton();

		newspage = homepage.moreNewsInfoButton();

		newspage.newButton().enterNewsField(ExcelUtilities.getStringData(1, 0, "NewsTest")).saveButton();

	}
}
