package by.htp.ahremenko.threads;

import by.htp.ahremenko.set.ALinkedList;
import by.htp.ahremenko.set.ALinkedList.Node;
import by.htp.ahremenko.utl.FileRW;

public class Warehouse {
	/// jenkov.com - java memory model
	{
		stored = 0;
	}
	
	private volatile ALinkedList<String> allowedFruits;
	private volatile int stored;
	private final int WH_MAX_SIZE = 5;
	private FileRW logFile;
	
	public int getStored() {
		return stored;
	}

	public Warehouse( FileRW lf ) { 
		allowedFruits = new ALinkedList<String>();
		this.stored = 0;
		logFile = lf;
	}
	
	public synchronized void putFruit (String newFruit, String info) {
		while (this.stored >= this.WH_MAX_SIZE) {
			try {
				wait();
				logFile.writeLog("You were riched MAX_SIZE. Please, wait... [" + info + "]");
				System.out.println("You were riched MAX_SIZE. Please, wait... [" + info + "]");
			} catch (InterruptedException e) {e.printStackTrace();}            		
		}
		allowedFruits.addLast(newFruit);
		this.stored = allowedFruits.getSize();
		notify();
	}
	
	public synchronized String getFruit (String info) {
		String ret = "";
		while (ret.equals("")) {
			if (allowedFruits.getSize() > 0) ret = allowedFruits.getFirstAndDelete();
			if (!ret.equals("")) break; 
			try {
				wait();
				logFile.writeLog("There are no fruits in Warehouse! [" + info + "]");
				System.out.println( "There are no fruits in Warehouse! [" + info + "]");
			} catch (InterruptedException e) {}
		}	
		this.stored = allowedFruits.getSize();
		notify();
		return ret;
	}

	public synchronized String getSpecFruit (String wantedFruit, String info) {
		String ret = "";
		while (ret.equals("")) {
			if (allowedFruits.getSize() > 0) ret = allowedFruits.getAsString( allowedFruits.getFirst(), wantedFruit);
			if (!ret.contains(wantedFruit)) {
				ret = "";
				try {
					logFile.writeLog("Fruit " + wantedFruit + " not found in Warehouse! [" + info + "]");
					System.out.println("Fruit " + wantedFruit + " not found in Warehouse! [" + info + "]");
					wait();
				} catch (InterruptedException e) {}
			} else {
				break;
			}
		};
		allowedFruits.delete(wantedFruit);
		this.stored = allowedFruits.getSize();
		notify();
		ret = wantedFruit;
		return ret;
	}
	
	@Override
	public String toString() {
		return allowedFruits.toString();
	}
	
}
