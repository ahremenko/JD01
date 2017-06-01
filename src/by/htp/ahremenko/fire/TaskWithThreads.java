package by.htp.ahremenko.fire;

import by.htp.ahremenko.threads.Account;
import by.htp.ahremenko.threads.CargoTruck;
import by.htp.ahremenko.threads.OperatorDeposit;
import by.htp.ahremenko.threads.OperatorWithdraw;
import by.htp.ahremenko.threads.Warehouse;

public class TaskWithThreads {

	public static void main(String[] args) throws InterruptedException {
		/*
		Warehouse wh = new Warehouse();
		String[] Fruits = {"Orange", "Banana", "Strawberry", "Grapes", "Pomegranate", "Watermelon"};
		
		//wh.putFruit(Fruits[1]);
		//wh.putFruit(Fruits[3]);
		
		System.out.println("On warehouse: " + wh.toString() + " size: " + wh.getStored());
		
		CargoTruck car1 = new CargoTruck();
		CargoTruck car2 = new CargoTruck();
		car1.setCarNumber("AA-1");
		car1.setCarWH(wh);
		car2.setCarNumber("BB-2");
		car2.setCarWH(wh);
		
		System.out.println("Start working.");
		
		car1.start();
		car2.start();
		*/
		
		Account acc = new Account();
		System.out.println(acc.toString());
		OperatorDeposit op1 = new OperatorDeposit(acc);
		OperatorWithdraw op2 = new OperatorWithdraw(acc);
		Thread t1 = new Thread(op1);
		Thread t2 = new Thread(op2);
		t1.start();
		t2.start();
		t1.join(0);
		t2.join(0);
		System.out.println(" done.");
		System.out.println(acc.toString());
		
		
	}
}
