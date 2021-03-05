package com.FreeCRM.Util;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.FreeCRM.Base.TestBase;

public class util extends TestBase
{
public static long PAGE_LOAD_TIMEOUT =60;
public static long IMPLICIT_WAIT = 60;

public void EXPLICIT_WAIT()
{
	WebDriverWait wait = new WebDriverWait(driver,30);
	
}

public void GetUrl(String url)
{
	driver.get(url);
}

}
