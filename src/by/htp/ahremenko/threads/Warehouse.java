package by.htp.ahremenko.threads;

import by.htp.ahremenko.set.ALinkedList;
import by.htp.ahremenko.set.ALinkedList.Node;

public class Warehouse {
	/// jenkov.com - java memory model
	private ALinkedList<String> allowedFruits;
	
	public Warehouse() {
		allowedFruits = new ALinkedList();
	}
	
	public void putFruit (String newFruit) {
		allowedFruits.addLast(newFruit);
	}
	
	public String getFruit () {
		Node<String> fruit = null;
		if (allowedFruits.getSize() > 0) {
			fruit = allowedFruits.getFirst();
			allowedFruits.delete(fruit);
		}
	}
	
}
