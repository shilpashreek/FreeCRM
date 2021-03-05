package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Scroll 

{
public static WebDriver driver;
	
	
	@BeforeTest
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C://Users//Manjushree//Downloads//chromedriver_win32 (3)//chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/infinite_scroll");
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void scrolling() throws Exception
	{
		
		Actions a = new Actions(driver);
		
		for(int i=1; i<=4; i++) {
			
			/*
			 * ((JavascriptExecutor)
			 * driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
			 * Thread.sleep(2000);
			 */
			a.sendKeys(Keys.PAGE_DOWN).build().perform();
			Thread.sleep(2000);
		
		}
		
		  WebElement par = driver.findElement(By.xpath("(//div[@id='content']/div/descendant::div[@class='jscroll-added'])[5]"));
		  String paragraph = par.getText();
		  System.out.println(paragraph);
		
	}
	
	@AfterTest
	public void quit()
	{
	  driver.quit();
	}
}
