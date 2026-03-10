package testscript;

import java.awt.AWTException;
//import java.awt.Robot;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;

public class HomePageTest extends Base{
	HomePage homepage; //9 homepage globally declared with reference variable
  
	@Test
  public void verifylogout() throws AWTException 
  
  {
	  LoginPage login= new LoginPage(driver);
	  login.enterUserNameAndPassWordfield("admin", "admin");
	  homepage=login.loginButton(); //10)login button is called returned with homepage
	  homepage.adminButton().logoutButton();//11)admin button & logout button of home page is called returned with homepage
	                                        // page chaining
	 
	  /*login.loginButton();
	  Robot robot=new Robot();
	  robot.delay(2000);
	  HomePage home=new HomePage(driver);
	  home.adminButton();
	  home.logoutButton(); */
	  
	  //after logout then should be back in login page checking
	  String expected="Login | 7rmart supermarket"; //test:pass
	  String actual=driver.getTitle();
	  Assert.assertEquals(actual, expected,"Logout failes");
	  
	 // String expected2="Login | 7rmart supermarket1"; test :fails
	 // String actual2=driver.getTitle();
	 // Assert.assertEquals(actual2, expected2,"Logout fails");
	  
	    
	  
  }
}
