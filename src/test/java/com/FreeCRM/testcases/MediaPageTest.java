package com.FreeCRM.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.FreeCRM.Base.TestBase;
import com.FreeCRM.Pages.HomePage;
import com.FreeCRM.Pages.LoginPage;
import com.FreeCRM.Pages.MediaPage;

public class MediaPageTest extends TestBase
{
	static LoginPage login;
	static HomePage home;
	static MediaPage mediapage;
	
 public MediaPageTest()
 {
	 super();
 }
 
 @BeforeMethod
 public void setup()
 {
	initialization();
	
	login=new LoginPage();
	home=login.login(prop.getProperty("username"), prop.getProperty("password"));
	mediapage=home.MediaTab();
	
 }
 
 @Test(priority=0)
 public void VerifyMediaTabPageisdisplayed()
 {
	 boolean b = mediapage.GetMediaLibraryLabel(); 
	 Assert.assertTrue(true);
 }
 
 @Test(priority=1,enabled=false)
 public void VerifyMediaItemsDropDownValues()
 {
	 mediapage.ClickOnDropDownValue();
 }
 
 @AfterMethod
 public void tearDown()
 {
	 driver.quit();
 }
}
