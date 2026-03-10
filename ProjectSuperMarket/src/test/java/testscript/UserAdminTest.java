package testscript;

import java.io.IOException;

import org.testng.Assert;

//import java.awt.AWTException;
//import java.awt.Robot;

import org.testng.annotations.Test;

import pages.UserAdminPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtilities;
import utilities.FakerUtility;

public class UserAdminTest extends Base {
	HomePage homepage;                     //16)both globally declared
	UserAdminPage adminpage;
	FakerUtility faker=new FakerUtility();
	
  @Test(description = "VERIFY NEWUSER TO ADMINPAGE",retryAnalyzer = retry.Retry.class)
  public void verifyAdminInfo() throws IOException //throws AWTException 
  {
	  LoginPage login=new LoginPage(driver);
	  String username=ExcelUtilities.getStringData(1, 0, "Adminpagetest");
	  String password=ExcelUtilities.getStringData(1, 1, "Adminpagetest");
	  
	  //login.enterUserNameAndPassWordfield("admin", "admin");
	  login.enterUserNameAndPassWordfield(username, password);
	  homepage=login.loginButton();                           //16) here login button clicked then to login page
	  adminpage=homepage.moreInfoButton();                    //17)here homepage moreinfo click the to adminpage
	  String adminname=faker.getFakeFirstName();
	  String adminpassword=faker.getPassword();
	  adminpage.newButton().adminInfo(adminname, adminpassword).saveButton();  //18)here adminpage methods all are called and username manually given
	 /* //Robot robot=new Robot();
	  //robot.delay(2000);
  
     UserAdminPage newadmininfo=new UserAdminPage(driver);
	  String username1=ExcelUtilities.getStringData(1, 2, "Adminpagetest");
	  String password1=ExcelUtilities.getStringData(1, 3, "Adminpagetest");
	  
	  newadmininfo.moreInfo();
	  newadmininfo.newButton();
	  newadmininfo.adminInfo(username1,password1);
	 // Robot robot2=new Robot();
	 // robot2.delay(2000);
	  newadmininfo.saveButton(); */
	  
	  boolean alertdisplayed=adminpage.isAlertMessageDisplayed(); //assertion
	  //Assert.assertTrue(alertdisplayed, "User added succesfully Alert pops up");
	  Assert.assertTrue(alertdisplayed, "ALERTMESSAGEUSERADDEDSUCCESSFULLY");
			  
	  
	  
  }
}
