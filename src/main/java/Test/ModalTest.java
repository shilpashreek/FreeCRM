package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ModalTest {

	@FindBy(xpath="//div[@class='modal-footer']/p") WebElement modal;
	public ModalTest()
	{
		PageFactory.initElements(driver, this);
	}
	public static WebDriver driver;

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C://Users//Manjushree//Downloads//chromedriver_win32 (3)//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/entry_ad");
		driver.manage().window().maximize();
		ModalTest modalTest = new ModalTest();

	}

	@Test(expectedExceptions= {StaleElementReferenceException.class}) 
	public void modalDisplayed()throws Exception {

		WebElement modal = driver.findElement(By.xpath("//div[@class='modal-footer']/p"));
		Thread.sleep(3000);
		boolean dis = modal.isDisplayed();
		Assert.assertTrue(dis, "modal is not displayed");
		modal.click();
		/*
		 * //driver.navigate().refresh();
		 * 
		 * WebDriverWait wait = new WebDriverWait(driver,20);
		 * wait.until(ExpectedConditions.visibilityOf(clickHere));
		 * 
		 * clickHere.click(); //driver.navigate().refresh(); boolean
		 * notdis=close.isDisplayed(); Assert.assertFalse(notdis, "modal is displayed");
		 */
		Thread.sleep(3000);
		driver.findElement(By.id("restart-ad")).click();
		Thread.sleep(3000);
		boolean modal_status=modal.isDisplayed();
		Assert.assertFalse(modal_status,"modal is displayed");
		
	}

	@AfterTest
	public void quit() {
		// driver.quit();
	}

}
