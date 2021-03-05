package com.FreeCRM.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.FreeCRM.Base.TestBase;

public class HomePage extends TestBase 
{
@FindBy(id="contextual-help-link")
WebElement Helpxpath; 

@FindBy(xpath= "//a[@class='current']")
WebElement updatelink;

@FindBy(xpath = "//div[.='Media']")
WebElement MediaTab;

@FindBy(xpath = "//span[.='New']")
WebElement NewLink;

@FindBy(xpath = "//div[.='Users']")
WebElement UserLink;

@FindBy(xpath = "//a[@href='user-new.php']" )
WebElement AddNewUser;

//initialising my object repo

     public HomePage()
     {
    	 PageFactory.initElements(driver, this);
    	 
     }

//methods to perform action on my object repo
     public String HomePageTitle()
     {
    	 String homepagetitle = driver.getTitle();
    	 return homepagetitle;
     }
     
     public boolean HelpButton()
     {
    	 boolean b = Helpxpath.isDisplayed();
    	 return b;
     }
     
     public UpdatesPage UpdateLink()
     {
    	 updatelink.click();
    	 return new UpdatesPage();
     }
     
     public MediaPage MediaTab()
     {
    	 MediaTab.click();
    	 return new MediaPage();
     }
     
     public NewPage NewLink()
     {
    	 NewLink.click();
    	 return new NewPage();
     }
     
     public UserPage AddNewUser()
     {
    	 Actions action = new Actions(driver);
    	 action.moveToElement(UserLink).build().perform();
    	 AddNewUser.click();
    	 return new UserPage();
    	
     }
     
}
