package sii.maroc;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ticket {
	 List<Dish> listOfDishes;
	 List<Integer> listOfNumbers;
	 

	public Ticket(List<Dish> listOfDishes, List<Integer> listOfNumbers ) {
		super();
		this.listOfDishes = listOfDishes;
		this.listOfNumbers=listOfNumbers;
	}


	public Ticket and(String string) {
		int numberOfDishes=0;
		
				//find numberOfDishes
				Pattern p = Pattern.compile("[0-9]");  
				Matcher m = p.matcher(string.substring(1,2));  
				
				if(m.matches()) {
					numberOfDishes= Integer.parseInt(string.substring(0,2));
				}else 
					numberOfDishes= Integer.parseInt(string.substring(0,1));
				
				//find type Of Dishe
				Pattern pTomatoMozzarella = Pattern.compile("Tomato Mozzarella Salad");  
				Matcher mTomatoMozzarella1 = pTomatoMozzarella.matcher(string); 
				
				Pattern pPizza = Pattern.compile("Pizza");  
				Matcher mPizza = pPizza.matcher(string); 
				
				Dish dish=null;
				boolean b0=mTomatoMozzarella1.find();
				boolean b1=mPizza.find();
				if(b0) {
					dish=new TomatoMozarella();
					
				}else if(b1){
					dish=new Pizza();
				}
				
				this.listOfDishes.add(dish);
				this.listOfNumbers.add(numberOfDishes);
				
				
		return this;
	}

}
