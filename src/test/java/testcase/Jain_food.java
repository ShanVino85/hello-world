package testcase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Resources.Baseclass;

public class Jain_food extends Baseclass {
	
	public static ArrayList recipeid = new ArrayList();
	public static ArrayList recipeNameList = new ArrayList();
	
	
	@Test(priority=7)
	public void scrapediabetic() throws IOException {
		
	
		
		driver.findElement(By.id("ctl00_txtsearch")).sendKeys("Jain Recipes");
 		driver.findElement(By.id("ctl00_imgsearch")).click();
 		
 		Excel_RW wb = new Excel_RW("C:\\Users\\shanj\\eclipse-workspace\\RecipeScraping\\Excel_JainFood.xlsx");	     		
	       
 		for(int i=1;i<=4;i++) {

 		        String sheet_name = "Recipe_page"+i;

 		       			wb.setCellData(sheet_name, 0, 0,"RecipeId");
 		    			wb.setCellData(sheet_name, 0, 1,"Recipe Name");
		
		 	if(i>1)
    			driver.findElement(By.xpath("//*[@id='cardholder']/div[4]/a["+ i +"]")).click();
	
   
   List<WebElement> ReceipeList = driver.findElements(By.xpath("//div[@class='rcc_recipecard']"));
   System.out.println("outer loop" +ReceipeList.size());
   
					    for (int j = 1; j <= 10; j++)
					    { 
					    	WebElement r_id =driver.findElement(By.xpath("(//div[@class='rcc_recipecard'])["+ j +"]//span")); 
					    	String s = r_id.getText();
					    	String formattedrecipeid =  s.substring(8, s.length()-9);
					    	recipeid.add(formattedrecipeid.trim());
					    	System.out.println("RecipeID : " +formattedrecipeid.trim());
					    	 wb.setCellData(sheet_name, j, 0, formattedrecipeid.trim());
					    	
						    	
					   	    WebElement recipeName = driver.findElement(By.xpath("//div[@class='rcc_recipecard']["+ j +"]//span[@class='rcc_recipename']/a"));
					    	System.out.println("Name of Recipe : "+recipeName.getText());
					    	//recipeNameList.add(recipeName.getText());
					    	 wb.setCellData(sheet_name, j, 1, recipeName.getText());
					    }
        
				}
	
		}
	
}
