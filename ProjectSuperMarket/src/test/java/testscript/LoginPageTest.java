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

public class LoginPageTest extends Base{
	HomePage homepage; //5)homepage globally declared
	//DATA PROVIDER----
  @Test(dataProvider ="credentialvalues",groups = "smoke")
  public void verifyData(String username,String password)
  {
	  LoginPage login=new LoginPage(driver);
	  login.enterUserNameAndPassWordfield(username, password);
	  homepage=login.loginButton();
	  boolean homepagedispalyed=login.isHomePagedisplayed(); //assertion1
	  //Assert.assertTrue(homepagedispalyed,"LOGIN FAILED - HOMEPAGE NOT DISPLAYED");
	  Assert.assertTrue(homepagedispalyed,Constant.ERRORMESSAGEFORLOGIN); 
	  
	 // boolean alertdisplayed=page1.isAlertDisplayed(); //assertion2
	 // Assert.assertTrue(alertdisplayed,"INVALID ALERT MESSAGE IS  POPING UP");
	    
	  
  }
  
  @DataProvider(name="credentialvalues")
  public Object testdata()
  {
	  Object data[][]= {{"admin","admin"},{"admin","tyeydgg"},{"ashna","admin"},{"rohit","ggsgs"}};
	  return data;
  } 
  
  //DATA PROVIDER COMPLETED HERE____
	@Test(groups="smoke")
  public void verifyvalidUsernameAndValidPassword() throws IOException
  {
	  LoginPage login=new LoginPage(driver);
	  String username = ExcelUtilities.getStringData(1, 0,"LoginpageTest");
	  String password = ExcelUtilities.getStringData(1, 1, "LoginpageTest");
	  login.enterUserNameAndPassWordfield(username, password);
	  homepage=login.loginButton();//6)homepage reference variable=loginbutton ie after clicking login its going to homepage
	  
	// boolean homepagedispalyed=page2.isHomePagedisplayed(); //assertion3
	// Assert.assertTrue(homepagedispalyed,"LOGIN FAILED - HOMEPAGE NOT DISPLAYED");
	 
	  
	  //boolean alertdisplayed=page2.isAlertDisplayed(); //assertion4
	 // Assert.assertTrue(alertdisplayed,"ALERT MESSAGE IS not POPING UP");
	  
	  
	  
	  
  }
	@Test
	@Parameters({"usernamefields","passwordfields"}) //parameter can run only using xml
	public void verifyInvalidUsernameAndValidPassword(String username,String password)
	{
		LoginPage login=new LoginPage(driver);
		login.enterUserNameAndPassWordfield(username , password); 
		homepage=login.loginButton();
		
	}
	
	@Test
	@Parameters({"usernamefield","passwordfield"})
	public void verifyValidUsernameAndInvalidPassword(String username,String password)
	{
		LoginPage login=new LoginPage(driver);
		login.enterUserNameAndPassWordfield(username, password);
		homepage=login.loginButton();
	}
	
	
}

