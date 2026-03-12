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
	
  @Test(description = "Verify manage page and upload files")
  public void verifyManagerInfo() throws IOException, AWTException 
  {   
	  LoginPage login=new LoginPage(driver);
	  String username=ExcelUtilities.getStringData(1, 0, "Loginpagetest");
	  String password=ExcelUtilities.getStringData(1, 1, "Loginpagetest");
	  login.enterUserNameAndPassWordfield(username, password);
	  homepage=login.loginButton();
	  managepage=homepage.manageInfo();
	  
	 
	  managepage.newCateogory().
	  enterCateogory(ExcelUtilities.getStringData(1, 0, "Managetest"))
	  .discounts()
	  .choosefiles()
	  .scrollDownAction()
	  .scrolldownActionToTopMenuButton()
	  .topMenu()
	  .saveInfo();
	  boolean alertIsDispalyed=managepage.isAlertMsgDisplayed();
	  Assert.assertTrue(alertIsDispalyed,Constant.ALERTMESSAGEMANAGEPAGEFILEUPLOAD);
	  
  }
}
