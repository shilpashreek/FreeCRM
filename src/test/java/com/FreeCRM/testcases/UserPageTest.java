package com.FreeCRM.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.FreeCRM.Base.TestBase;
import com.FreeCRM.Pages.HomePage;
import com.FreeCRM.Pages.LoginPage;
import com.FreeCRM.Pages.UserPage;

public class UserPageTest extends TestBase
{
	static HomePage homepage;  //home
	LoginPage login;
	UserPage userpage;
   public UserPageTest()
   {
	   super();
   }
   
  @BeforeMethod
  public void Setup()
  {
	 initialization();
	login = new LoginPage();
	 login.login(prop.getProperty("username"), prop.getProperty("password"));
  }
  
  @Test(enabled=false)
  public void ValidateNewUserCreation()
  {
	  userpage= new UserPage();
	  userpage.CreateNewUser("jerry", "a@gmail.com", "tom", "test", "www.ggogle.com", "PasswordStrong", "Author");
  }
  
  @AfterMethod
  public void tearDown()
  {
	  driver.quit();
  }
}
