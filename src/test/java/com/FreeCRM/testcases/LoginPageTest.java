/**
 * 
 */
package com.FreeCRM.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.FreeCRM.Base.TestBase;
import com.FreeCRM.Pages.HomePage;
import com.FreeCRM.Pages.LoginPage;

/**
 * @author Manjushree
 *
 */
public class LoginPageTest extends TestBase 
{
	TestBase testbase;
	public static LoginPage loginpage;
	HomePage homepage;
	public LoginPageTest()
	{
		super(); //calling super class constructor, so that my props will be initialised
	}
@BeforeMethod
public void SetUp()
{
	testbase=new TestBase();
	initialization();
	loginpage = new LoginPage();
}

@Test(priority=0)
public void LoginPageTitleTest()
{
	String title = loginpage.ValidateHomePageTitle();
	System.out.println(title);
	Assert.assertEquals(title, "Log In ‹ Wordpress Demo Site at Demo.Center — WordPress");
}

@Test(priority=1)
public void LogoTest()
{
	boolean flag = loginpage.ValidateLogo();
	Assert.assertTrue(flag);
}

@Test(priority=3)
public void LoginTest()
{
	homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
}


@AfterMethod
public void tearDown()
{
	driver.quit();
}
}
