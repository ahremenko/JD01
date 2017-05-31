package by.htp.ahremenko.threads;

import by.htp.ahremenko.set.ALinkedList;
import by.htp.ahremenko.set.ALinkedList.Node;

public class Warehouse {
	/// jenkov.com - java memory model
	private volatile ALinkedList<String> allowedFruits;
	private volatile int stored;
	
	
	public int getStored() {
		return stored;
	}

	public Warehouse() {
		allowedFruits = new ALinkedList();
		this.stored = 0;
	}
	
	public synchronized void putFruit (String newFruit) {
		allowedFruits.addLast(newFruit);
		this.stored = allowedFruits.getSize(); 
	}
	
	public synchronized String getFruit () {
		String ret = "";
		if (allowedFruits.getSize() > 0) ret = allowedFruits.getFirstAndDelete();
		this.stored = allowedFruits.getSize();
		return ret;
	}
	
	@Override
	public String toString() {
		return allowedFruits.toString();
	}
	
}
