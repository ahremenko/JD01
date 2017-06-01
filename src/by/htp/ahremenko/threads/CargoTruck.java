package by.htp.ahremenko.threads;

import java.util.Random;

public class CargoTruck extends Thread {
	
	private enum CargoType { PRODUCER, CONSUMER }
	private String carNumber;
	private Warehouse carWH;
	private String wantedFruit;
	private CargoType truckType;
	public static final String[] Fruits = {"Orange", "Banana", "Strawberry", "Grapes", "Pomegranate", "Watermelon", "Pineapple", "Mango"};
	
	{
		carNumber = "";
		wantedFruit = "";
		truckType = null;
	}
	
	public CargoTruck (Warehouse carWH, String carNumber) {
		this.carWH = carWH;
		this.carNumber = carNumber;
	}
	
	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public String getWantedFruit() {
		return wantedFruit;
	}

	public void setWantedFruit(String fruit) {
		this.wantedFruit = fruit;
	}
	
	public Warehouse getCarWH() {
		return carWH;
	}

	public void setCarWH(Warehouse carWH) {
		this.carWH = carWH;
	}

	public void setCargoType( String tp ) {
		try {
			this.truckType = CargoType.valueOf(tp);
		} catch (IllegalArgumentException e) {
			this.truckType = null;
		}
	}

	@Override
	public void run()	
	{	
		final Random random = new Random();
		
		int randomFruit; 
		int randomAction; 
		String Fruit = ""; 
		
		for(int i = 1; i <= 10; i++) {
			randomFruit = random.nextInt(Fruits.length-1);
            randomAction = random.nextInt(500);
            Fruit = (getWantedFruit().equals("") ? Fruits[randomFruit] : getWantedFruit() );
            //System.out.print("Stage " + i + ": - Truck #" + this.carNumber + " " + ( randomAction%2==0 ? "GET " + ( getWantedFruit().equals("") ? "any fruit" : getWantedFruit() )  : "PUT " + Fruits[randomFruit]  )  );
            if (this.truckType == CargoType.CONSUMER)  
            	getFruitFromWarehouse(i, getWantedFruit());
            else if (this.truckType == CargoType.PRODUCER)
            	putFruitInWarehouse(i, Fruit );
            else if (this.truckType == null)  
	            if ( (randomAction%2) == 0 )  
	            	getFruitFromWarehouse(i, getWantedFruit());
	            else 
	            	putFruitInWarehouse(i, Fruit );
            
            // little pause
			try {
				Thread.sleep(randomAction);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }		
	}
	
	public void getFruitFromWarehouse( int i, String wantedFruit) {
		//CarTruck wants to get a fruit - m.b. special, m.b. not
		String Fruit = "";
    	if (!wantedFruit.equals("")) 
    		Fruit = carWH.getSpecFruit(wantedFruit, "Stage #" + i + " Truck  #" + this.carNumber);
    	else
    		Fruit = carWH.getFruit("Stage #" + i + " Truck  #" + this.carNumber);
 	    System.out.println("Stage " + i + " result: Truck  #" + this.carNumber + " gets: " + Fruit + ". Warehouse size: " + carWH.getStored() + ", in warehouse: " + carWH.toString());
	}

	public void putFruitInWarehouse( int i, String Fruit) {
    	carWH.putFruit(Fruit, "Stage #" + i + " Truck  #" + this.carNumber );
    	System.out.println("Stage " + i + " result: Truck  #" + this.carNumber + " puts on warehouse: " + Fruit + ". Warehouse size: " + carWH.getStored() + ", in warehouse: " + carWH.toString());            	
	}
	

}
