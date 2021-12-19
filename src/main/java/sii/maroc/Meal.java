package sii.maroc;

import java.util.ArrayList;
import java.util.List;

public class Meal {
	List<Dish> listOfDishes=new ArrayList<Dish>();
	List<Integer> listOfNumbers;

	public Meal(List<Dish> listOfDishes, List<Integer> listOfNumbers) {
		super();
		this.listOfDishes=new ArrayList<Dish>();
		this.listOfDishes.addAll(listOfDishes);
		this.listOfNumbers =  listOfNumbers;
	}

	public int servedDishes() {
		int sum=0;
		for(int i: listOfNumbers) {
			sum+=i;
		}
		
		return sum;
	}

	public int cookingDuration() {
		int duration=0;
		for(int i=0; i<listOfDishes.size(); i++) {
			for(int j=1; j<=listOfNumbers.get(i); j++) {
				if(j==1) {
					duration+=listOfDishes.get(i).cookingDuration();
				}else {
					duration+=listOfDishes.get(i).cookingDuration()/2;
				}
				
			}
			
		}
		
		return duration;
	}

}
