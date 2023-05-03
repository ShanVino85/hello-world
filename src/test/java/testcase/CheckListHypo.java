package testcase;

import java.util.ArrayList;

public class CheckListHypo {
	
public static ArrayList<String> eliminatedList = new ArrayList<String>();
	
	static boolean checkIngrediant(String i_Ingredient) {

		String p_Ingredient = i_Ingredient.toLowerCase();
		System.out.println("igredeintes coming" + p_Ingredient);
		//eliminatedList.add("garlic");
		eliminatedList.add("tofu");
		eliminatedList.add("cauliflower");      
		eliminatedList.add("cabbage");
		eliminatedList.add("broccoli");
		eliminatedList.add("kale");
		eliminatedList.add("spinach");
		eliminatedList.add("strawberries");
		eliminatedList.add("peanuts");
		eliminatedList.add("peaches");
		eliminatedList.add("frozen food");
		eliminatedList.add("fried food");
		eliminatedList.add("sugar");
		eliminatedList.add("gluten");
		eliminatedList.add("fries");
	    eliminatedList.add("cakes");
		eliminatedList.add("candies");
		eliminatedList.add("white bread");
		eliminatedList.add("coffee");
		eliminatedList.add("alcohol");
		eliminatedList.add("soy milk");
		eliminatedList.add("edamame");
		eliminatedList.add("sweet potatoes");
		eliminatedList.add("pine nuts");
		

		boolean isIngrediant = true;
		for (String v : eliminatedList) {
			if (p_Ingredient.contains(v)) // p_Ingredient
			{
				System.out.println("Eliminated::" + p_Ingredient + "because of " + v + "recepid" + "");
				isIngrediant = false;
				break;
			}
		}

		return isIngrediant;

	}
	
	

}





















