package com.FreeCRM.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.FreeCRM.Util.util;

public class TestBase 
{
 public static WebDriver driver;
public static Properties prop;
public static FileInputStream fis;


//read properties from config file
           public TestBase()
           {
        	   prop=new Properties();
        	   try 
        	   {
        		  // File src = new File("./FreeCRM/config.properties");
        		  // fis=new FileInputStream(src);
        		   
        		   fis=new FileInputStream(System.getProperty("user.dir") + File.separator +"src"+File.separator+"main"+File.separator+"java"+File.separator+"com"+File.separator+"FreeCRM"+File.separator+ "Configuration"+File.separator + "config.properties");
				//fis=new FileInputStream("C:\\Users\\Manjushree\\eclipse-workspace\\FreeCRM\\    src\\main\\java\\com\\FreeCRM\\Configuration\\config.properties");
				prop.load(fis);
			   } 
        	   catch (FileNotFoundException e) 
        	   {
				e.printStackTrace();
			   }
        	   catch (IOException e) 
        	   {
				e.printStackTrace();
			   }
	            
	       }
           
           
 public static void initialization()
 {
	//get my browser details
    	 String browsername = prop.getProperty("browser");
	 System.out.println(browsername);
	 if(browsername.equals("chrome"))
	 {
		 System.setProperty("webdriver.chrome.driver", "C:/Users/Manjushree/eclipse-workspace/FreeCRM/Drivers/chromedriver.exe");
		 driver=new ChromeDriver();
	 }
	 else if(browsername.equals("FireFox"))
	 {
		 System.setProperty("webdriver.gecko.driver", "C:/Users/Manjushree/Downloads/chromedriver_win32/geckodriver.exe");
		 driver=new FirefoxDriver();
	 }
	 else
	 {
		 System.out.println("no browser value found");
	 }
     
	 driver.manage().window().maximize();
	 
	 //if the application takes too long time to load then we have to change the time value here
	 //to avaoid changing values in code , will just declare the value in one util class
	 
	 driver.manage().timeouts().pageLoadTimeout(util.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	 driver.manage().timeouts().implicitlyWait(util.IMPLICIT_WAIT, TimeUnit.SECONDS);
	 driver.get(prop.getProperty("url"));
	 
 }
 
}
