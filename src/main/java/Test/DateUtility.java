package Test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DateUtility {
	
	public void selectDateByJS(WebElement element, String date,WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].setAttribute('value','"+date+"');", element);
	}

	
	public void selectDateUsingRowsAndColumns()
	{
		
	}
	
	
	
	
	
}
