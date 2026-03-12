package testscript;

import java.io.IOException;

import org.testng.Assert;

//import java.awt.AWTException;
//import java.awt.Robot;

import org.testng.annotations.Test;

import constants.Constant;
import pages.UserAdminPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtilities;
import utilities.FakerUtility;

public class UserAdminTest extends Base {
	HomePage homepage;                     
	UserAdminPage adminpage;
	FakerUtility faker=new FakerUtility();
	
  @Test(description = "verify newuser to adminpage",retryAnalyzer = retry.Retry.class)
  public void verifyAdminInfo() throws IOException 
  {
	  LoginPage login=new LoginPage(driver);
	  String username=ExcelUtilities.getStringData(1, 0, "Adminpagetest");
	  String password=ExcelUtilities.getStringData(1, 1, "Adminpagetest");
	  
	  login.enterUserNameAndPassWordfield(username, password);
	  homepage=login.loginButton();                           
	  adminpage=homepage.moreInfoButton();                    
	  String adminname=faker.getFakeFirstName();
	  String adminpassword=faker.getPassword();
	  adminpage.newButton().adminInfo(adminname, adminpassword).saveButton();  
	 
	  
	  boolean alertdisplayed=adminpage.isAlertMessageDisplayed(); 
	  Assert.assertTrue(alertdisplayed,Constant.ALERTMESSAGEUSERADDEDSUCCESSFULLY);
	  
			  
	  
	  
  }
}
