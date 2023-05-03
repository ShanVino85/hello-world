package testcase;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Resources.Baseclass;

public class StartPro extends Baseclass {
	
	
     @Test(priority=2)
	//public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
 public void start() {
		//initializebrowser();
		List<WebElement>searchpageresult;
		List<String> alllinkText= new ArrayList();
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\shanj\\Downloads\\chromedriver_win32\\chromedriver.exe");
		//System.setProperty(".http.factory", "jdk-http-client");
		//WebDriverManger.Chrome.setup();
		//WebDriver driver=new ChromeDriver();
		
		//driver.get("https://www.tarladalal.com/");
		//driver.manage().window().maximize();
		driver.findElement(By.id("ctl00_txtsearch")).sendKeys("vegetarian Recipes");
		driver.findElement(By.id("ctl00_imgsearch")).click();
		
		
		for(int i=1;i<=5;i++) {
			
			if(i>1)
			driver.findElement(By.xpath("//*[@id='cardholder']/div[3]/a["+i+"]")).click();
			//Thread.sleep(2000);
			
		
		searchpageresult= driver.findElements(By.xpath("//div[@class='rcc_recipecard']/div[3]"));
		//searchpageresult= driver.findElements(By.xpath("//div[@class='rcc_rcpcore']/span/a"));
		
		alllinkText.add("PAGE" + i );
		alllinkText.add("============================================");
		for(WebElement link : searchpageresult) {
			
			alllinkText.add("-------------------------------------------");
			
			alllinkText.add(link.getText());
		}
		}
	for(String eachlinktext : alllinkText ) {
		System.out.println(eachlinktext);
	}
	
	
			
	}
		
		
	}


