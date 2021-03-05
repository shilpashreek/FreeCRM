package com.FreeCRM.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.FreeCRM.Base.TestBase;

public class UserPage extends TestBase
{
@FindBy(name="user_login")
WebElement Usernamefield;

@FindBy(name="email")
WebElement Email;

@FindBy(name="first_name")
WebElement FirstName;

@FindBy(name="last_name")
WebElement LastName;

@FindBy(name="url")
WebElement Website;

@FindBy(xpath="//button[contains(.,'Show password')]")
WebElement ShowPassword;

@FindBy(name = "pass1-text")
WebElement password;

@FindBy(name="role")
WebElement Role;

    public UserPage()
    {
    	PageFactory.initElements(driver, this);
    }
    
    
//Create new user
    public void CreateNewUser(String UserName,String Email_id,String First_name,String Last_name,String Web_Url,String PassWord,String role)
    {
    	Usernamefield.sendKeys(UserName);
    	Email.sendKeys(Email_id);
    	FirstName.sendKeys(First_name);
    	LastName.sendKeys(Last_name);
    	Website.sendKeys(Web_Url);
    	ShowPassword.click();
    	password.sendKeys(PassWord);
    	
    	Select s =new Select(Role);
    	s.selectByVisibleText(role);
    	
      
    }
    

}
