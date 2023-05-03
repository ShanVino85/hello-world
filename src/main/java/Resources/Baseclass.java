package Resources;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Baseclass{
	public static WebDriver driver;
	public static Properties prop;
			
	public Baseclass() 
	{
		
		//Read my Property;
		
		try {
			prop=new Properties();
			FileInputStream ip= new FileInputStream("C:\\Users\\shanj\\eclipse-workspace\\RecipeScraping\\src\\main\\java\\Resources\\congfig.properties");
			prop.load(ip);
			
			
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e) 
		{
			e.printStackTrace();
		
		}
		}
	
	
	public WebDriver initializebrowser() 
	{
	String browserName= prop.getProperty("browser");
	if( browserName.equals("chrome")) {
		WebDriverManager.chromedriver().setup();
	     driver=new ChromeDriver();
		 
	}
	else if( browserName.equals("firefox")) {
		 WebDriverManager.firefoxdriver().setup();
         driver =new FirefoxDriver();
		
	}
	else if( browserName.equals("Edge browser")) {
		WebDriverManager.edgedriver().setup();
		  driver =new  EdgeDriver();
		
	}
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	

	return driver;
		
	}}

