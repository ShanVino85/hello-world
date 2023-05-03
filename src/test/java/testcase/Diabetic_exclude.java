package testcase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import Resources.Baseclass;
import io.github.bonigarcia.wdm.WebDriverManager;



public class Diabetic_exclude extends Baseclass {
	
	
	
    	
	//static WebDriver driver;
	
		public static ArrayList recipeid = new ArrayList();
		public static ArrayList recipeNameList = new ArrayList();
		public static ArrayList ingredientList = new ArrayList();
		public static ArrayList prepTimeList = new ArrayList();
		public static ArrayList cookTimeList = new ArrayList();
		//public static ArrayList prepMethodList = new ArrayList();
		//public static ArrayList NutrientList = new ArrayList();
		//public static ArrayList TargettedmorbidconditionsList= new ArrayList();
		//public static ArrayList urllist=new ArrayList();
		public static ArrayList exe_ind = new ArrayList();
	    //public String exelude_ind;
		
		
		@Test(priority=4)
	    	public void scrapediabetic() throws IOException {
			

				//wb.setCellData("Recipe Data", 0, 5,"Exclude indicator");
				//wb.setCellData("Recipe Data", 0, 7,"Preparation method");
				//wb.setCellData("Recipe Data", 0, 8,"Nutrient values");
				//wb.setCellData("Recipe Data", 0, 9,"Targetted morbid conditions (Diabeties/Hypertension/Hypothyroidism)");
			//	wb.setCellData("Recipe Data", 0, 10,"Recipe URL");
				
			
					driver.findElement(By.id("ctl00_txtsearch")).sendKeys("Diabetic");
		     		driver.findElement(By.id("ctl00_imgsearch")).click();
			
	       
	       List<WebElement> ReceipeList = driver.findElements(By.xpath("//div[@class='rcc_recipecard']"));
	       System.out.println("outer loop" +ReceipeList.size());
	       
	              
	        for (int j = 1; j <= 15; j++)
	        { 
	        //	exelude_ind = "N";
	        	WebElement r_id =driver.findElement(By.xpath("(//div[@class='rcc_recipecard'])[" + j +"]//span")); 
	        	String s = r_id.getText();
	        	String formattedrecipeid =  s.substring(8, s.length()-9);
	        	recipeid.add(formattedrecipeid.trim());
	 	    	
	       	    WebElement recipeName = driver.findElement(By.xpath("//div[@class='rcc_recipecard']["+j+"]//span[@class='rcc_recipename']/a"));
	        	System.out.println("Name of Recipe : ("+j +") :"+recipeName.getText());
	        	recipeNameList.add(recipeName.getText());
	            
	 
	        	driver.findElement(By.xpath("//div[@class='rcc_recipecard']["+j+"]//span[@class='rcc_recipename']/a")).click();
	        	//Thread.sleep(1000);
	        	
	        	try {
	        	
	        	WebElement Ingrediants = driver.findElement(By.xpath("//div[@id='rcpinglist']"));
	        //	ingredientList.add(Ingrediants.getText());
	        //	System.out.println("Ingrediants are : "+Ingrediants.getText());
	        	
	        	
	        	//Thread.sleep(1000);
	        	
	        	String exe_ingr = "sugar";
	        	//String exe_ingr1= "White rice";
	        	        	
	        	        	
	        	if( Ingrediants.getText().contains(exe_ingr) )    // || (Ingrediants.getText().contains(exe_ingr1)))
	        	{
	        		exe_ind.add("Y");
	        	
	        	}
	        	else
	        	{
	        		exe_ind.add("N");
		        	
	 	        }
	        	
	        	ingredientList.add(Ingrediants.getText()); 
	        	
	        	System.out.println("Ingrediants are : "+Ingrediants.getText()  );
	        	}
	        	catch (Exception e){
	        		
	        		System.out.println("exclude");	
	        	}
	        	       	
	        	
	        	WebElement PrepTime = driver.findElement(By.xpath("//p//time[1]"));
	        	//prepTimeList.add(PrepTime.getText());      	
	        	System.out.println("Preperation Time is : "+ PrepTime.getText());
	        	
	        	WebElement CookTime = driver.findElement(By.xpath("//p//time[2]"));
	        	//cookTimeList.add(CookTime.getText());
	        	System.out.println("Cooking Time is : "+CookTime.getText());
	        	
	    	     	driver.navigate().back();
	    	     	System.out.println("going next :" + (j+1));
	        }
				
	        System.out.println("EXCEL WRITING");
	         int r =1;
	        
	        Excel_RW wb = new Excel_RW("C:\\Users\\shanj\\eclipse-workspace\\RecipeScraping\\Excel_Diabetic231.xlsx");
			//Excel_RW wb = new Excel_RW("C:\\Users\\shanj\\eclipse-workspace\\RecipeScraping\\Excel_Diabetic_exc3.xlsx");
	        System.out.println("HEADER WRITING");
	        
			//	Excel_RW wb = new Excel_RW(excel_name);

	            wb.setCellData("RecipeData", 0, 0,"RecipeId");
				wb.setCellData("RecipeData", 0, 1,"Recipe Name");
				wb.setCellData("RecipeData", 0, 2,"Ingredients");
				wb.setCellData("RecipeData", 0, 3,"Preparation Time");
				wb.setCellData("RecipeData", 0, 4,"Cooking Time");
	        
						       
				 System.out.println("HEADER WRITING done");
				 
			        
				 for (int j = 0; j < 10; j++)
	        {  
	        
	         if( exe_ind.get(j).toString().contains("Y"))
           	   {
	        	 System.out.println(recipeid.get(0).toString() +"   " + recipeid.get(j).toString());        		
        		wb.setCellData("RecipeData", r, 0, recipeid.get(j).toString());
				wb.setCellData("RecipeData", r, 1, recipeNameList.get(j).toString());
				wb.setCellData("RecipeData", r, 2, ingredientList.get(j).toString());
				wb.setCellData("RecipeData", r, 3, prepTimeList.get(j).toString());
				wb.setCellData("RecipeData", r, 4, cookTimeList.get(j).toString());
        	   r++;
        	   }
	         System.out.println("Liner cnt " + r);
		        
	        }    
    			
    			int rowcount = wb.getRowCount("Recipe Data") -1;
    			
    			System.out.println("Total Recipe taken in excel :" + rowcount );
	        
	        
		}  		    			
	           	                     
		}
		


