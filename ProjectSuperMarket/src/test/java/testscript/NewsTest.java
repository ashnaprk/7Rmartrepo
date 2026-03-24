package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.NewsPage;
import utilities.ExcelUtilities;


public class NewsTest extends Base {
	HomePage homepage;
	NewsPage newspage;


	@Test(description = "Verify adding news messages in the News page")
	public void addNews() throws IOException {
		LoginPage login = new LoginPage(driver);
		String username = ExcelUtilities.getStringData(1, 0, "LoginpageTest");
		String password = ExcelUtilities.getStringData(1, 1, "LoginpageTest");
		login.enterUserNameAndPassWordfieldInLoginPage(username, password);
		homepage = login.ClickOnloginButtonInLoginPage();

		newspage = homepage.ClickOnmoreNewsInfoButtonInNewsPage();

		newspage.clickNewButtonInNewsPage().enterNewsFieldInNewsPage(ExcelUtilities.getStringData(1, 0, "NewsTest")).clickSavebuttonInNewsPage();
        
	}
	@Test(description = "Verify that the user can search for a news in the News page")
	public void searchNews() throws IOException
	{
		LoginPage login = new LoginPage(driver);
		String username = ExcelUtilities.getStringData(1, 0, "LoginpageTest");
		String password = ExcelUtilities.getStringData(1, 1, "LoginpageTest");
		login.enterUserNameAndPassWordfieldInLoginPage(username, password);
		homepage = login.ClickOnloginButtonInLoginPage();
		newspage = homepage.ClickOnmoreNewsInfoButtonInNewsPage();
		newspage.clickOnSearchButton1InNewsPage().enterTheNewsThatToBeSearched(ExcelUtilities.getStringData(1, 1, "NewsTest")).clickOnsearchButton2InNewsPage();
		boolean result=newspage.isSearchedNewsIsPresentInNewsPage(ExcelUtilities.getStringData(1, 1, "NewsTest"));
		Assert.assertTrue(result, Constant.ALERTMESSAGEFORNEWSSEARCH);
		
	}
}
