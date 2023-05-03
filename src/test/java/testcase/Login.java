package testcase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import Resources.Baseclass;

public class Login extends Baseclass {
	protected WebDriver driver;
	
	@Test		
	public void logs() throws Exception
	{
		
		driver=initializebrowser();
		driver.get(prop.getProperty("url"));
	    Thread.sleep(2000);
		
		}
	
	
	@AfterSuite
       public void teardown() throws Exception
      {
    	
    	  driver.quit();
      }

}
