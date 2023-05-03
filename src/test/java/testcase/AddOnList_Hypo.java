package testcase;
import java.util.ArrayList;

public class AddOnList_Hypo {

		
	public static ArrayList<String> addonlist = new ArrayList<String>();
		
		static boolean checkIngrediant(String i_Ingredient) {

			String p_Ingredient = i_Ingredient.toLowerCase();
			System.out.println("igredeintes coming" + p_Ingredient);
			//addonlist.add("garlic");
			addonlist.add("milk");
			addonlist.add("dairy");      
			addonlist.add("eggs");
			addonlist.add("nuts");
			addonlist.add("pumpkin seeds");
			addonlist.add("iodized salt");
			addonlist.add("brazil nuts");
			addonlist.add("blue berries");
			addonlist.add("low-fat yogurt");
			addonlist.add("brown rice");
			addonlist.add("quinoa");
			addonlist.add("mushroom");
			addonlist.add("egg");
			addonlist.add("egg");
			addonlist.add("egg");
			addonlist.add("egg");
			addonlist.add("egg");
		

			boolean isIngrediant = false;
			for (String v : addonlist) {
				if (p_Ingredient.contains(v)) // p_Ingredient
				{
					System.out.println("Eliminated::" + p_Ingredient + "because of " + v + "recepid" + "");
					isIngrediant = true;
					break;
				}
			}

			return isIngrediant;

		}
		
	
	
		
		
		
		
		
		
		
		
		
		
	
		






















}
