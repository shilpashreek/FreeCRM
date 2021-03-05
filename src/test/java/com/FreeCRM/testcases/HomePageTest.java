package com.FreeCRM.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.FreeCRM.Base.TestBase;
import com.FreeCRM.Pages.HomePage;
import com.FreeCRM.Pages.LoginPage;
import com.FreeCRM.Pages.MediaPage;
import com.FreeCRM.Pages.UserPage;

public class HomePageTest extends TestBase 
{
	static LoginPage login;
	static HomePage Homepage;
	static MediaPage mediapage;
	static UserPage userpage;
	
    public HomePageTest()
    {
    	super();
    }
    
 @BeforeMethod
 public void Setup()
 {
	initialization();
	login=new LoginPage();
	Homepage=login.login(prop.getProperty("username"), prop.getProperty("password"));
	
 }
 
 @Test(priority=0)
 public void VerifyHomePageTitle()
 {
	 String hometitle = Homepage.HomePageTitle();
	 System.out.println(hometitle);
	 Assert.assertEquals(hometitle, "Dashboard ‹ Wordpress Demo Site at Demo.Center — WordPress" , "Homepage title found is not matching with expected title");
	
 }
 
 @Test(priority=1)
 public void VerifyHelpTextisDisplayed()
 {
	 boolean b = Homepage.HelpButton();
	 Assert.assertTrue(true, "Help Button is displayed in homepage");
 }
 
 @Test(priority=2)
 public void VerifyMediaidDisplayed()
 {
	 mediapage=Homepage.MediaTab();
	 String M_tabtitle = driver.getTitle();
	 System.out.println(M_tabtitle);
	 Assert.assertEquals(M_tabtitle, "Media Library ‹ Wordpress Demo Site at Demo.Center — WordPress", "Title is not matching");
	
 }
 
 @Test(priority=3)
 public void ClickOnUserCreation()
 {
	 userpage=Homepage.AddNewUser();
 }
 
 @AfterMethod
 public void tearDpwn()
 {
	 driver.quit();
 }
}
