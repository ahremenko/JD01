package by.htp.ahremenko.fire;

import by.htp.ahremenko.threads.CargoTruck;
import by.htp.ahremenko.threads.Warehouse;

public class TaskWithThreads {

	public static void main(String[] args) {
		
		Warehouse wh = new Warehouse();
		String[] Fruits = {"Orange", "Banana", "Strawberry", "Grapes", "Pomegranate", "Watermelon"};
		
		wh.putFruit(Fruits[1]);
		wh.putFruit(Fruits[3]);
		
		System.out.println("On warehouse: " + wh.toString());
		
		CargoTruck car1 = new CargoTruck();
		CargoTruck car2 = new CargoTruck();
		car1.setCarNumber("AA-1");
		car1.setCarWH(wh);
		car2.setCarNumber("BB-2");
		car2.setCarWH(wh);
		
		System.out.println("Start working.");
		
		car1.start();
		car2.start();
		
		

	}

}
