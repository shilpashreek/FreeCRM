package com.FreeCRM.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.FreeCRM.Base.TestBase;

public class MediaPage extends TestBase 
{
	
@FindBy(xpath = "//h1[.='Media Library']")
WebElement MediaLibraryLabel;



  public MediaPage()
  {
	  //initialising by object repository
	  PageFactory.initElements(driver, this);
	  
  }
  
  //Methods
  
  public boolean GetMediaLibraryLabel()
  {
	  boolean b = MediaLibraryLabel.isDisplayed();
	  return b;
  }
  
 public void ClickOnDropDownValue()
 {
	WebDriverWait wait = new WebDriverWait(driver,30);
	WebElement AllMediaItemsFilter = driver.findElement(By.xpath("//select[@name='attachment-filter']//option"));
	wait.until(ExpectedConditions.visibilityOf(AllMediaItemsFilter));
	 Select s = new Select(AllMediaItemsFilter);
	 List<WebElement> filteroptions = s.getOptions();
	 s.selectByVisibleText("Mine");
	 //iterate
	 for(WebElement MediaItems:filteroptions)
	 {
		 System.out.println(MediaItems);
	 }
 }
}
