package Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumCoding {
	public static WebDriver driver;
	
	@FindBy(xpath="(//ul[@data-role='listview']/li[@class='srp clearfix   ']/descendant::a[contains(.,'£')])[4]")
	WebElement prop_4;
	
	@FindBy(xpath="(//ul[@data-role='listview']/li[@class='srp clearfix   ']/descendant::a[contains(.,'£')])[5]")
	WebElement prop_5;
	
	public SeleniumCoding()
	{
		PageFactory.initElements(driver, this);
	}
	
	@BeforeTest
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C://Users//Manjushree//Downloads//chromedriver_win32 (3)//chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.zoopla.co.uk/");
		driver.manage().window().maximize();
		driver.manage().getCookieNamed(" Your cookie preferences ");
		//driver.manage().deleteAllCookies();
		
	}
	
	@Test(priority=1)
	public void Login() throws Exception
	{
		String search_url="https://www.zoopla.co.uk/for-sale/property/london/?q=London&results_sort=newest_listings&search_source=home";
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@id='cookie-consent-form']/div/descendant::button[@class='ui-button-primary ui-cookie-accept-all-medium-large']")));
		driver.findElement(By.xpath("//form[@id='cookie-consent-form']/div/descendant::button[@class='ui-button-primary ui-cookie-accept-all-medium-large']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("search-input-location")).sendKeys("London");
		driver.findElement(By.id("search-submit")).click();
		Assert.assertEquals(driver.getCurrentUrl(), search_url);
		
	}
	
	@Test(priority=2)
	public void getPriceList() throws Exception
	{
		List<String> priceTag = new ArrayList<String>();
		List<WebElement> price_lists = driver.findElements(By.xpath("//*[contains(@id,'listing_')]/div/div[2]/a"));
		System.out.println("total properties listed are" +price_lists.size());
		for(WebElement price:price_lists)
		{
			
			priceTag.add(price.getText());
			
		}
		System.out.println("before sorting the prices"+priceTag);
		System.out.println("After sorting");
		Collections.sort(priceTag);
		System.out.println("after sorting list" +priceTag);
		Collections.reverse(priceTag);
		System.out.println("after sorting in reverse order" +priceTag);
		
	}
	
	@Test(priority=3,enabled=true)
	public void selectFifthprice()
	{
		WebElement order = driver.findElement(By.xpath("//select[@name='results_sort']"));
		Select s = new Select(order);
		List<WebElement> price_dropdown = s.getOptions();
		ArrayList<String> ar = new ArrayList<String>();
		for(int i=1; i<price_dropdown.size();i++)
		{
			ar.add(price_dropdown.get(i).getText());
			System.out.println(price_dropdown.get(i).getText());
		}
		System.out.println("sorted filter list ");
		Collections.sort(ar);
		Collections.reverse(ar);
	
	}
	
	@Test(priority=4,enabled=true)
	public void select_Fifth_property() throws Exception
	{
		String success_search="https://www.zoopla.co.uk/for-sale/details/";
		List<WebElement> props = driver.findElements(By.xpath("//ul[@data-role='listview']/li/descendant::a[contains(.,'£')]"));
		
		System.out.println("properties list size  " +props.size() );
		for(int i=1;i<=props.size();i++)
		{
			if(i==5)
			{
				//if(props.get(i).getText().contains("0")) {
				
				WebElement prop_4 = driver.findElement(By.xpath("(//ul[@data-role='listview']/li[@class='srp clearfix   ']/descendant::a[contains(.,'£')])[4]"));
				WebElement prop_5 = driver.findElement(By.xpath("(//ul[@data-role='listview']/li[@class='srp clearfix   ']/descendant::a[contains(.,'£')])[5]"));
				Thread.sleep(4000);
				JavascriptExecutor js = ((JavascriptExecutor)driver);
				js.executeScript("arguments[0].scrollIntoView(true);", prop_4);
				
				WebDriverWait wait = new WebDriverWait(driver,30);
				wait.until(ExpectedConditions.visibilityOf(prop_5));
				Actions act = new Actions(driver);
				Thread.sleep(3000);
				act.moveToElement(prop_5).click().build().perform();
				//prop_5.click();
				break;
			//}
			}
		}
		
		//Assert.assertEquals(driver.getCurrentUrl(), success_search);
		Assert.assertTrue(driver.getCurrentUrl().contains(success_search), "Not clicked on property");
	
	}
	
	String agent_name=null;
	
	@Test(priority=5,enabled=true)
	public void getAgentDetails()
	{
		WebElement logo=driver.findElement(By.xpath("//div[@class='dp-sidebar-wrapper__contact']/div/descendant::img"));
		boolean logo_displayed=logo.isDisplayed();
		Assert.assertTrue(logo_displayed);
		String text_on_logo = logo.getAttribute("alt");
		System.out.println("Agent logo contains " +text_on_logo);
		agent_name=driver.findElement(By.xpath("(//div[@class='ui-agent__text']/h4)[1]")).getText();
		System.out.println("Agent name--" +agent_name);
		String agent_ph_no = driver.findElement(By.xpath("(//p[@class='ui-agent__tel ui-agent__text']/a)[1]")).getText();
		System.out.println("Agent cell num " +agent_ph_no);
		boolean Agent_name=driver.findElement(By.xpath("(//div[@class='ui-agent__text']/h4)[1]")).isDisplayed();
		Assert.assertTrue(Agent_name,"Agent name is not displayed");
		
	}
	
	@Test(priority=6,enabled=true)
	public void validateAgentName() throws Exception
	{
		driver.findElement(By.xpath("(//div[@class='ui-agent__text']/h4)[1]")).click();
		Thread.sleep(3000);
		String Agent_name_detailsPage=driver.findElement(By.xpath("(//h1[@class='bottom-half']/b)[1]")).getText();
		Assert.assertEquals(Agent_name_detailsPage, agent_name);
		
	}
	
	@AfterTest
	public void quit()
	{
	   driver.quit();
	}

}
