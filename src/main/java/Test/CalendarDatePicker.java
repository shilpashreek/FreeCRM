package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CalendarDatePicker {

	
public static WebDriver driver;
	
	@BeforeTest
	public void setup() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C://Users//Manjushree//Downloads//chromedriver_win32 (3)//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}
	
	
	@Test(enabled=false)
	public void CalendarGadgetUsingJavascrpit()
	{
		String date="16-08-2020";
		/*
		 * driver.findElement(By.cssSelector(".menu_Flights")).click();
		 * driver.findElement(By.
		 * xpath("//div[@class='fsw_inputBox dates inactiveWidget ']")).click();
		 */
		
		////td[@class=' ui-datepicker-days-cell-over  ui-datepicker-current-day ui-datepicker-today']/following-sibling::td/../following-sibling::tr[2]/td[2]
		WebElement DateFiled = driver.findElement(By.id("ctl00_mainContent_txt_Fromdate"));
		DateUtility dateUtility = new DateUtility();
		dateUtility.selectDateByJS(DateFiled, date, driver);
	}
	
	@Test
	public void selectDateWithXPATH() throws Exception
	{
		WebElement DepartureDate=driver.findElement(By.xpath("(//button[@class='ui-datepicker-trigger'])[1]"));
		DepartureDate.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td[@class=' ui-datepicker-days-cell-over  ui-datepicker-current-day ui-datepicker-today']")).click();
		Thread.sleep(2000);
		////table[@class='ui-datepicker-calendar']/tbody/tr/following-sibling::tr[4]/td[@class=' ui-datepicker-days-cell-over  ui-datepicker-current-day ui-datepicker-today']
		WebElement returnDate=driver.findElement(By.xpath("(//button[@class='ui-datepicker-trigger'])[2]"));
		returnDate.click();
		
		
		
	}
	
	
	
		@AfterTest
		public void quit() {
		   // driver.quit();
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
