package com.FreeCRM.testcases;



import org.testng.TestNG;

public class TestNGRunner {
	
	static TestNG testNG;
	public static void main(String[] args)
	{
		//java -jar FreeCRM.jar - to run through command prompt
		
		testNG=new TestNG();
		//if u have created extent report then use
		 //ExtentReportListener e = new ExtentReportListener();
		 
		testNG.setTestClasses(new Class[] {getUsername.class,HomePageTest.class,
				LoginPageTest.class,MediaPageTest.class,UserPageTest.class});
		//testNG.addListener(e);
		testNG.run();
	}

}
