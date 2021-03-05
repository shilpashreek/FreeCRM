package Test;

import java.io.IOException;
import java.net.HttpURLConnection;
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

public class BrokenLinks {
	
	public static WebDriver driver;
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C://Users//Manjushree//Downloads//chromedriver_win32 (3)//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.toolsqa.com/automation-practise-switch-windows/");
		driver.manage().window().maximize();

	}
	
	@Test
	public void validateBrokenLinks() throws Exception, IOException
	{
		
		List<WebElement> links_images=driver.findElements(By.tagName("a"));
		links_images.addAll(driver.findElements(By.tagName("img")));
		int totalLinksAndImages=links_images.size();
		System.out.println("Total links and images in the page--" +totalLinksAndImages); //6
		
		List<WebElement> ActiveLinks=new ArrayList<WebElement>();
		
		for(int i=0;i<totalLinksAndImages;i++)
		{
			System.out.println(links_images.get(i).getAttribute("href"));
			if(links_images.get(i).getAttribute("href")!=null && (! links_images.get(i).getAttribute("href").contains("javascript")) && (! links_images.get(i).getAttribute("href").contains("mailto")) && (! links_images.get(i).getAttribute("href").contains("about:blank")) && links_images.get(i).getAttribute("href").contains("http"))
			{
				ActiveLinks.add(links_images.get(i));
			}
		}
		System.out.println("active links--"+ActiveLinks.size());  //2 --2 are active ,4 are broken
		
		//check links/imgs with httpconnection api
		for(int j=0;j<ActiveLinks.size();j++)
		{
			
		HttpURLConnection connection = (HttpURLConnection)new URL(ActiveLinks.get(j).getAttribute("href")).openConnection();
		connection.connect();
		int resCode = connection.getResponseCode();
		String Responsemsg=connection.getResponseMessage();  //if link is proper it will return ok
		connection.disconnect();
		System.out.println(ActiveLinks.get(j).getAttribute("href") +"---" +Responsemsg +" " +resCode);
		//200-ok
		//404-not found
		//500- internal error
		//400- bad request
		}
		
	}
	
	
	@AfterTest
	public void quit() {
	    driver.quit();
	}

}
