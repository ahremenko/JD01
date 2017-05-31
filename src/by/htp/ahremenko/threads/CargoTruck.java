package by.htp.ahremenko.threads;

import java.util.Random;

public class CargoTruck extends Thread {
	
	private String carNumber;
	private Warehouse carWH;
	
	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	
	public Warehouse getCarWH() {
		return carWH;
	}

	public void setCarWH(Warehouse carWH) {
		this.carWH = carWH;
	}

	@Override
	public void run()	
	{	
		final Random random = new Random();
		String[] Fruits = {"Orange", "Banana", "Strawberry", "Grapes", "Pomegranate", "Watermelon"};
		int randomFruit; 
		int randomAction; 
		String Fruit = ""; 
		
		Fruit = carWH.getFruit();
		
		for(int i = 0; i < 10; i++) {
            randomFruit = random.nextInt(Fruits.length-1);
            randomAction = random.nextInt(1000);
            //System.out.println("Stage " + i + " Fruit: " + randomFruit + " action: " + ( randomAction%2==0 ? "GET " : "PUT " ) );
            if ( (randomAction%2) == 0) { 
            	
            	//while (Fruit.equals("")) { 
            		Fruit = carWH.getFruit();
            		if (Fruit.equals("")) {
            			System.out.println("Stage " + i + ": - Truck #" + this.carNumber + " - nothing to gets. Waiting for....");
            		} else {
            			System.out.println("Stage " + i + ": - Truck #" + this.carNumber + " gets: " + Fruit + ". Warehouse size: " + carWH.getStored());
            		}
            	//}	
            } else {
            	Fruit = Fruits[randomFruit];
            	carWH.putFruit(Fruit);
            	System.out.println("Stage " + i + ": - Truck #" + carNumber + " puts on warehouse: " + Fruit + ". Warehouse size: " + carWH.getStored());            	
            };
			try {
				Thread.sleep(randomAction);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }		
	}
	
	 

}
