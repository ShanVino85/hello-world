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

	public class  DiaPage  extends Baseclass {
		
		
		
		//static WebDriver driver;
		
		public static ArrayList recipeid = new ArrayList();
		public static ArrayList recipeNameList = new ArrayList();
		public static ArrayList ingredientList = new ArrayList();
		public static ArrayList prepTimeList = new ArrayList();
		public static ArrayList cookTimeList = new ArrayList();
		//public static ArrayList prepMethodList = new ArrayList();
		public static ArrayList NutrientList = new ArrayList();
		//public static ArrayList TargettedmorbidconditionsList= new ArrayList();
		public static ArrayList urllist=new ArrayList();
		
		
		@Test(priority=4)
	    	public void scrapediabetic() throws IOException {
			
					driver.findElement(By.id("ctl00_txtsearch")).sendKeys("Diabetic");
		     		driver.findElement(By.id("ctl00_imgsearch")).click();

	Excel_RW wb = new Excel_RW("C:\\Users\\shanj\\eclipse-workspace\\RecipeScraping\\Excel_Diabeticespage2.xlsx");	     		
	       
	for(int i=1;i<=2;i++) {

	        String sheet_name = "Recipe_page"+i;

	       			wb.setCellData(sheet_name, 0, 0,"RecipeId");
	    			wb.setCellData(sheet_name, 0, 1,"Recipe Name");
	    			wb.setCellData(sheet_name, 0, 2,"Ingredients");
	    			wb.setCellData(sheet_name, 0, 3,"Preparation Time");
	    			wb.setCellData(sheet_name, 0, 4,"Cooking Time");
		    			
		    			if(i>1)
		    			driver.findElement(By.xpath("//*[@id='cardholder']/div[3]/a["+i+"]")).click();
			
	       
	       List<WebElement> ReceipeList = driver.findElements(By.xpath("//div[@class='rcc_recipecard']"));
	       System.out.println("outer loop" +ReceipeList.size());
	       
	        for (int j = 1; j <= 10; j++)
	        { 
	        	WebElement r_id =driver.findElement(By.xpath("(//div[@class='rcc_recipecard'])[" + j +"]//span")); 
	        	String s = r_id.getText();
	        	String formattedrecipeid =  s.substring(8, s.length()-9);
	        	recipeid.add(formattedrecipeid.trim());
	                wb.setCellData(sheet_name, j, 0, formattedrecipeid.trim());
	 	    	
	       	    WebElement recipeName = driver.findElement(By.xpath("//div[@class='rcc_recipecard']["+j+"]//span[@class='rcc_recipename']/a"));
	        	System.out.println("Name of Recipe : "+recipeName.getText());
	                wb.setCellData(sheet_name, j, 1, recipeName.getText());
	        	recipeNameList.add(recipeName.getText());

			
	            
	 
	        	driver.findElement(By.xpath("//div[@class='rcc_recipecard']["+j+"]//span[@class='rcc_recipename']/a")).click();
	        	//Thread.sleep(1000);
	        	
	        	WebElement Ingrediants = driver.findElement(By.xpath("//div[@id='rcpinglist']"));
	        	ingredientList.add(Ingrediants.getText());
	                wb.setCellData(sheet_name, j, 2, Ingrediants.getText());
	        	System.out.println("Ingrediants are : "+Ingrediants.getText());
	        	
	        	WebElement PrepTime = driver.findElement(By.xpath("//p//time[1]"));
	        	prepTimeList.add(PrepTime.getText());    
	 		 wb.setCellData(sheet_name, j, 3, PrepTime.getText());  	
	        	System.out.println("Preperation Time is : "+ PrepTime.getText());
	        	
	        	WebElement CookTime = driver.findElement(By.xpath("//p//time[2]"));
	        	cookTimeList.add(CookTime.getText());
	 		 wb.setCellData(sheet_name, j, 4, CookTime.getText());
	        	System.out.println("Cooking Time is : "+CookTime.getText());
	        	
	        /*	WebElement PrepMethod = driver.findElement(By.xpath("//div[@id='recipe_small_steps']"));
	        	prepMethodList.add(PrepMethod.getText());
	        	System.out.println("Preperation Time is : "+PrepMethod.getText());
	        	
	        	WebElement Nutrients = driver.findElement(By.xpath("//table[@id='rcpnutrients']")); //Problem in when running 8 th recipe.untill prepemethod looks fine
	        	NutrientList.add(Nutrients.getText());
	        System.out.println("Nutrient Values are : "+Nutrients.getText());
	        	
	        	WebElement Recipeurl = driver.findElement(By.xpath("//div[@id='recipe_small_steps']"));
	        	urllist.add(driver.getCurrentUrl());
	        	System.out.println("Preperation Time is : "+driver.getCurrentUrl());*/
	               	
	        	
	        	driver.navigate().back();
	        
	        }
	    		
	       // String excel_name= prop.getProperty("excel_path");
	       // Excel_RW wb = new Excel_RW("C:\\Users\\shanj\\eclipse-workspace\\RecipeScraping\\Excel_Diabetices_1.xlsx");
	        
	        
	        
	        
	        
	       /* System.out.println("Worksheet Name :" + sheet_name );
	        
	        	//	Excel_RW wb = new Excel_RW(excel_name);
	        		
	    			//wb.setCellData(sheet_name, 0, 7,"Preparation method");
	    			//wb.setCellData(sheet_name, 0, 8,"Nutrient values");
	    			//wb.setCellData(sheet_name, 0, 9,"Targetted morbid conditions (Diabeties/Hypertension/Hypothyroidism)");
	    			//wb.setCellData(sheet_name, 0, 10,"Recipe URL");
	    			
	    			
	    			for(int rownum = 1; rownum <= 10; rownum++)
	    			{
	    				
	    				
	    				wb.setCellData(sheet_name, rownum, 1, recipeNameList.get(rownum-1).toString());
	    				wb.setCellData(sheet_name, rownum, 2, ingredientList.get(rownum-1).toString());
	    				wb.setCellData(sheet_name, rownum, 3, prepTimeList.get(rownum-1).toString());
	    				wb.setCellData(sheet_name, rownum, 4, cookTimeList.get(rownum-1).toString());
	    				//wb.setCellData(sheet_name, rownum, 5, prepMethodList.get(rownum).toString());
	    				//wb.setCellData(sheet_name, rownum, 8, NutrientList.get(rownum).toString());
	    				//wb.setCellData(sheet_name, rownum, 9, TargettedmorbidconditionsList.get(rownum).toString());
	    				//wb.setCellData(sheet_name, rownum, 10, urllist.get(rownum).toString()); 
	    				
	    			}
	    			
	    			int rowcount = wb.getRowCount(sheet_name) -1;
	    			
	    			System.out.println("Total Recipe taken in excel :" + rowcount );*/
	    			
	            }
	
		}
	                                





}
