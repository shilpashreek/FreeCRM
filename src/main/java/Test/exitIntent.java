package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class exitIntent {
	public static WebDriver driver;
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C://Users//Manjushree//Downloads//chromedriver_win32 (3)//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/exit_intent");
		//driver.manage().window().maximize();

	}
	
	@Test
	public void validateModal() throws Exception
	{
		WebElement header = driver.findElement(By.cssSelector("h3"));
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		//act.moveToElement(header, 291, 0).build().perform();
		act.moveToElement(header).moveByOffset(161,29).build().perform();
		//boolean modal_header=driver.findElement(By.xpath("//div[@class='modal-title']")).isDisplayed();
		//Assert.assertTrue(modal_header);
	}
	
	
	@AfterTest
	public void quit() {
	    //driver.quit();
	}


}
