package testscript;

import java.awt.AWTException;
//import java.awt.Robot;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManagePage;
import utilities.ExcelUtilities;

public class ManageTest extends Base {
	HomePage homepage;
	ManagePage managepage;

	@Test(description = "Verify that a new category can be added to the Manage Page")
	public void verifyToAddNewCateogoryInManagePage() throws IOException, AWTException {
		LoginPage login = new LoginPage(driver);
		String username = ExcelUtilities.getStringData(1, 0, "Loginpagetest");
		String password = ExcelUtilities.getStringData(1, 1, "Loginpagetest");
		login.enterUserNameAndPassWordfieldInLoginPage(username, password);
		homepage = login.ClickOnloginButtonInLoginPage();
		managepage = homepage.ClickOnmanageInfoButtonInManagePage();

		managepage.ClickOnNewCateogoryInManagePage()
				  .enterCateogoryNameInManagePage(ExcelUtilities.getStringData(1, 0, "Managetest"))
				  .enterDiscountsInManagePage().UploadfilesInManagePage().scrollDownActionInManagePage()
				  .scrolldownActionToTopMenuButtonInManagePage().ClickOntopMenuRadioButtonInManagePage()
				  .ClickOnsaveInfoInManagePage();
		boolean alertIsDispalyed = managepage.isAlertMsgDisplayedInManagePage();
		Assert.assertTrue(alertIsDispalyed, Constant.ALERTMESSAGEMANAGEPAGEFILEUPLOAD);

	}
}
