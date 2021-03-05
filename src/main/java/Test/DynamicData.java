package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DynamicData {
	
public static WebDriver driver;
	
	
	@BeforeTest
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C://Users//Manjushree//Downloads//chromedriver_win32 (3)//chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");
		
	}
	
	@Test
	public void extractData()
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='start']/button")));
		driver.findElement(By.xpath("//div[@id='start']/button")).click();
		//WebElement load_icon = driver.findElement(By.xpath("//div[.='Loading... ']"));
		
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[.='Loading... ']"))));
		String dynamicText=driver.findElement(By.xpath("//div[@id='finish']/h4")).getText();
		System.out.println(dynamicText);
	
	}
	
	@AfterTest
	public void quit()
	{
	   driver.quit();
	}

}
