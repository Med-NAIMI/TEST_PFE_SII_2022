package sii.maroc;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Restaurant {
	private String mozarellaBallsInStock ;
	private String tomatoesInStock ;
	private String oliveOil ;
	private String pepper ;
	private String seaSalt ;
	private String water ;
	private String flourInStock ;

	public Restaurant(String mozarellaBallsInStock, String tomatoesInStock, String oliveOil, String pepper) {
		this.mozarellaBallsInStock=mozarellaBallsInStock;
		this.tomatoesInStock=tomatoesInStock;
		this.oliveOil=oliveOil;
		this.pepper=pepper;
	}

	public Restaurant(String flourInStock, String tomatoesInStock, String seaSalt, String mozarellaBallsInStock, 
			String oliveOil, String water) {
		this.flourInStock=flourInStock;
		this.tomatoesInStock=tomatoesInStock;
		this.seaSalt=seaSalt;
		this.mozarellaBallsInStock=mozarellaBallsInStock;
		this.oliveOil=oliveOil;
		this.water=water;
	}

	public Ticket order(String string) {
		//
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
		Matcher mTomatoMozzarella = pTomatoMozzarella.matcher(string); 
		
		Pattern pPizza = Pattern.compile("Pizza");  
		Matcher mPizza = pPizza.matcher(string); 
		
		Dish dish=null;
		boolean b0=mTomatoMozzarella.find();
		boolean b1=mPizza.find();
		
		if(b0) {
			dish=new TomatoMozarella();
		}else if(b1){
			dish=new Pizza();
		}
		
		
		List<Dish> listOfDishes=new ArrayList<Dish>();
		listOfDishes.add(dish);
		
		List<Integer> listOfNumbers=new ArrayList<Integer>();
		listOfNumbers.add(numberOfDishes);
		
		Ticket ticket= new Ticket(listOfDishes, listOfNumbers);
		
		return ticket;
	}

	
	public Meal retrieve(Ticket ticket) {
		Meal meal=new Meal(ticket.listOfDishes, ticket.listOfNumbers);		
		return meal;
	}
}
