package by.htp.ahremenko.fire;

import by.htp.ahremenko.threads.Account;
import by.htp.ahremenko.threads.CargoTruck;
import by.htp.ahremenko.threads.OperatorDeposit;
import by.htp.ahremenko.threads.OperatorWithdraw;
import by.htp.ahremenko.threads.Warehouse;
import by.htp.ahremenko.utl.FileRW;

public class TaskWithThreads {

	public static void main(String[] args) throws InterruptedException {
		FileRW logFile = new FileRW( "c:\\Temp\\log.csv" );
		Warehouse wh = new Warehouse( logFile );
		//String[] Fruits = {"Orange", "Banana", "Strawberry", "Grapes", "Pomegranate", "Watermelon", "Pineapple", "Mango"};
		
		
		logFile.clearLog();
		
		wh.putFruit(CargoTruck.Fruits[1], "");
		wh.putFruit(CargoTruck.Fruits[3], "");
		
		//wh.getSpecFruit(Fruits[3]+"2", "");
		
		System.out.println("Warehouse {" + wh.getStored() + "} : " + wh.toString() );
		logFile.writeLog("Warehouse {" + wh.getStored() + "} : " + wh.toString());
		
		CargoTruck car1 = new CargoTruck(wh, "AnyAction", logFile);
		
		CargoTruck car2 = new CargoTruck(wh, "Consumer-Ban", logFile);
		car2.setWantedFruit(CargoTruck.Fruits[1]);
		car2.setCargoType("CONSUMER");
		
		CargoTruck car3 = new CargoTruck(wh, "Producer-Ban", logFile);
		car3.setWantedFruit(CargoTruck.Fruits[1]);
		car3.setCargoType("PRODUCER");
		
		System.out.println("Start working...");
		logFile.writeLog("Start working...");
		
		car1.start();
		car2.start();
		car3.start();
		
		/*
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
		*/
		
	}
}
