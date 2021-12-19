package sii.maroc;

public class Pizza extends Dish {
	private int mozarellaBalls=1 ;
	private int tomatoes=4 ;
	private int flourInStock=300;// g unit
	private int water=100;//cl unit
	
	
	@Override
	public int cookingDuration() {
		
		return 20;
	}

}
