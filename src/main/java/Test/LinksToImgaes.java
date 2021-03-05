package Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LinksToImgaes {
	
public static WebDriver driver;
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C://Users//Manjushree//Downloads//chromedriver_win32 (3)//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/broken_images");
		driver.manage().window().maximize();

	}
	
	@Test
	public void Images() throws MalformedURLException, IOException
	{
		
		List<WebElement> Image_list = driver.findElements(By.tagName("img"));
		Image_list.addAll(driver.findElements(By.tagName("a")));
		int imageSize=Image_list.size();
		System.out.println("Total number of images--" +imageSize);
		
		  ArrayList<WebElement> ele = new ArrayList<WebElement>(); 
		  for(int i=0; i<imageSize; i++) 
		  { 
			  System.out.println(Image_list.get(i).getAttribute("href"));
			  if(Image_list.get(i).getAttribute("href")!=null)
			  {
				  ele.add(Image_list.get(i));
			 
		      }
			 
		  }
		  System.out.println("size of active links" +" " +ele.size());
		  
		  
		  for(int k=0;k<ele.size();k++)
		  {
			 HttpURLConnection con = (HttpURLConnection)new URL(ele.get(k).getAttribute("href")).openConnection();
			 con.connect();
			 String res_msg=con.getResponseMessage();
			 int resCode=con.getResponseCode();
			 System.out.println("status of" +" "+ele.get(k).getAttribute("href") +" "+ "is" +" "+res_msg +" " +resCode);
			 if(resCode>=400)
			 {
				 System.out.println(ele.get(k).getAttribute("href") +"is a broken link");
			 }else
			 {
				 System.out.println(ele.get(k).getAttribute("href") +"is a valid link");
			 }
		  }
	
	}
	
	
	@AfterTest
	public void quit() {
	    driver.quit();
	}

}
