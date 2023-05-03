package testcase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Resources.Baseclass;

public class Hypertension extends Baseclass {
	
	public static ArrayList recipeid = new ArrayList();
	public static ArrayList recipeNameList = new ArrayList();
	public static ArrayList ingredientList = new ArrayList();
	public static ArrayList prepTimeList = new ArrayList();
	public static ArrayList cookTimeList = new ArrayList();
	public static ArrayList prepMethodList = new ArrayList();
	//public static ArrayList NutrientList = new ArrayList();
	//public static ArrayList TargettedmorbidconditionsList= new ArrayList();
	//public static ArrayList urllist=new ArrayList();
	
	@Test(priority=5)

public void Hyper() throws IOException{
	

	       Excel_RW wb = new Excel_RW("C:\\Users\\shanj\\eclipse-workspace\\RecipeScraping\\Excel_Hypertension_1.xlsx");
	        
	       	
      		wb.setCellData("Recipe Data", 0, 0,"RecipeId");
  			wb.setCellData("Recipe Data", 0, 1,"Recipe Name");
  			wb.setCellData("Recipe Data", 0, 2,"Ingredients");
  			wb.setCellData("Recipe Data", 0, 3,"Preparation Time");
  			wb.setCellData("Recipe Data", 0, 4,"Cooking Time");
  			//wb.setCellData("Recipe Data", 0, 7,"Preparation method");
  			//wb.setCellData("Recipe Data", 0, 8,"Nutrient values");
  			//wb.setCellData("Recipe Data", 0, 9,"Targetted morbid conditions (Diabeties/Hypertension/Hypothyroidism)");
  			//wb.setCellData("Recipe Data", 0, 10,"Recipe URL");
		
		driver.findElement(By.id("ctl00_txtsearch")).sendKeys("Hypertension Recipes");
		driver.findElement(By.id("ctl00_imgsearch")).click();
		
		
		
		
		List <WebElement> ReceipeList= driver.findElements(By.xpath("//div[@class='rcc_recipecard']"));
		   System.out.println("outer loop" +ReceipeList.size());
	       
	       
	       for (int j = 1; j <=ReceipeList.size()  ; j++)
	        { 
	        	WebElement r_id =driver.findElement(By.xpath("(//div[@class='rcc_recipecard'])[" + j +"]//span")); 
	        	String s = r_id.getText();
	        	String formattedrecipeid =  s.substring(8, s.length()-9);
	        	recipeid.add(formattedrecipeid.trim());
	 	    	
	       	    WebElement recipeName = driver.findElement(By.xpath("//div[@class='rcc_recipecard']["+j+"]//span[@class='rcc_recipename']/a"));
	        	System.out.println("Name of Recipe : "+recipeName.getText());
	        	recipeNameList.add(recipeName.getText());
	            
	 
	        	driver.findElement(By.xpath("//div[@class='rcc_recipecard']["+j+"]//span[@class='rcc_recipename']/a")).click();
	        	
	        	WebElement Ingrediants = driver.findElement(By.xpath("//div[@id='rcpinglist']"));
	        	ingredientList.add(Ingrediants.getText());
	        	System.out.println("Ingrediants are : "+Ingrediants.getText());
	        	
	        	WebElement PrepTime = driver.findElement(By.xpath("//*[@id='ctl00_cntrightpanel_pnlRecipeScale']/section/p[2]/time[1]"));
	        	prepTimeList.add(PrepTime.getText());      	
	        	System.out.println("Preperation Time is : "+ PrepTime.getText());
	        	
	        	WebElement CookTime = driver.findElement(By.xpath("//*[@id='ctl00_cntrightpanel_pnlRecipeScale']/section/p[2]/time[2]"));
	        	cookTimeList.add(CookTime.getText());
	        	System.out.println("Cooking Time is : "+CookTime.getText());
	        	

		        /*	WebElement PrepMethod = driver.findElement(By.xpath("//*[@id=recipe_small_steps]/span/ol[1]"));
		        	prepMethodList.add(PrepMethod.getText());
		        	System.out.println("Preperation Time is : "+PrepMethod.getText());*/
	        	
	        	wb.setCellData("Recipe Data", j, 0, recipeid.get(j-1).toString());
   				wb.setCellData("Recipe Data", j, 1, recipeNameList.get(j-1).toString());
   				wb.setCellData("Recipe Data", j, 2, ingredientList.get(j-1).toString());
   				wb.setCellData("Recipe Data", j, 3, prepTimeList.get(j-1).toString());
   				wb.setCellData("Recipe Data", j, 4, cookTimeList.get(j-1).toString());
		        	
		        	driver.navigate().back();
	        }
	       

   			
   			
   		/*	for(int rownum = 1; rownum <= ReceipeList.size(); rownum++)
   			{
   				
   				wb.setCellData("Recipe Data", rownum, 0, recipeid.get(rownum-1).toString());
   				wb.setCellData("Recipe Data", rownum, 1, recipeNameList.get(rownum-1).toString());
   				wb.setCellData("Recipe Data", rownum, 2, ingredientList.get(rownum-1).toString());
   				wb.setCellData("Recipe Data", rownum, 3, prepTimeList.get(rownum-1).toString());
   				wb.setCellData("Recipe Data", rownum, 4, cookTimeList.get(rownum-1).toString());
   				//wb.setCellData("Recipe Data", rownum, 5, prepMethodList.get(rownum-1).toString());
   				//wb.setCellData("Recipe Data", rownum, 8, NutrientList.get(rownum).toString());
   				//wb.setCellData("Recipe Data", rownum, 9, TargettedmorbidconditionsList.get(rownum).toString());
   				//wb.setCellData("Recipe Data", rownum, 10, urllist.get(rownum).toString()); 
   				
   			}*/
   			
   			int rowcount = wb.getRowCount("Recipe Data") -1;
   			
   			System.out.println("Total Recipe taken in excel :" + rowcount );
   			
           }
                    
	}             
	        	
//only 17 recipe run






