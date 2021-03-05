/**
 * 
 */
package com.FreeCRM.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.FreeCRM.Base.TestBase;

/**
 * @author Manjushree
 *
 */
public class LoginPage extends TestBase 
{
//page factory or object repository
	
	@FindBy(name= "log")
	WebElement username;
	
	@FindBy(name= "pwd")
	WebElement password;
	
	@FindBy(name= "wp-submit")
	WebElement LoginButton;
	
	@FindBy(name= "rememberme")
	WebElement rememberCheckbox;

	@FindBy(xpath= "//a[.='Lost your password?']")
	WebElement LostPasswordLink;
	
	@FindBy(xpath= "//a[.='Powered by WordPress']")
	WebElement logo;
	
	//initialize the object/page repository
	public LoginPage()
	{
		PageFactory.initElements(driver, this);  //initialize objects of the current class i.e., LoginPage Objects
		
	}
	
//actions or methods
//1. get title
public String ValidateHomePageTitle()
{
	String pagetitle = driver.getTitle();
	return pagetitle;
}

//2. Verify WordPress Logo
public boolean ValidateLogo()
{
	boolean b = logo.isDisplayed();
	return b;
}

public HomePage login(String un, String pwd)
{	
	username.sendKeys(un);
	password.sendKeys(pwd);
	LoginButton.click();
	
	return new HomePage();     //this method is returning homepage class object
	
	
}
	
	
}
