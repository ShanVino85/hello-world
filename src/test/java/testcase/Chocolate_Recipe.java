package testcase;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Resources.Baseclass;

public class Chocolate_Recipe extends Baseclass {
	

    @Test(priority=3)
	
public void choco() {
		
		driver.findElement(By.id("ctl00_txtsearch")).sendKeys("Diabetic Recipes");
		driver.findElement(By.id("ctl00_imgsearch")).click();
		
		
	//	int foodsize=driver.findElements(By.xpath("//div[@class='rcc_rcpcore']/span/a")).size();
		//System.out.println(foodsize);
		
          for(int i=1;i<=5;i++) {
			
			if(i>1)
			driver.findElement(By.xpath("//*[@id='cardholder']/div[3]/a["+i+"]")).click();
		
		for(int j=1;j<=5;j++) {
		 String RecipeID=driver.findElement(By.id( "//*[@id='maincontent']/div[1]/div[2]/div["+j+"]/div[2]/span")).getText();
         System.out.println(RecipeID);

	    String RecipeName=driver.findElement(By.id( "//*[@id='maincontent']/div[1]/div[2]/div["+j+"]/div[3]/span/a")).getText();
	    System.out.println(RecipeName);
	    
	    driver.findElement(By.id( "//*[@id='maincontent']/div[1]/div[2]/div["+j+"]/div[3]/span/a")).click();
	    
	   String preparationtime= driver.findElement(By.xpath("//*[@id='ctl00_cntrightpanel_pnlRecipeScale']/section/p[2]/time[1]")).getText();
	    System.out.println(preparationtime);
	    
	    String cookingtime= driver.findElement(By.xpath("//*[@id='ctl00_cntrightpanel_pnlRecipeScale']/section/p[2]/time[2]")).getText();
	    System.out.println(cookingtime);
	    
	 
	    String ingrdients= driver.findElement(By.xpath("//*[@id='recipe_ingredients']/section")).getText();
	    System.out.println(ingrdients);
	  
	    
	    String Perparation= driver.findElement(By.xpath("//*[@id='recipe_small_steps']")).getText();
	    System.out.println(Perparation);
	    
	  
	    
	    String Nurtionvalue= driver.findElement(By.xpath("//*[@id='accompaniments']")).getText();
	    System.out.println( Nurtionvalue);
	    String strUrl = driver.getCurrentUrl();
		System.out.println("Recipe URL :"+ strUrl);
		driver.navigate().back();
		} }
}}
