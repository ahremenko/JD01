package by.htp.ahremenko.set;

import java.util.Arrays;

import by.htp.ahremenko.entity.Book;

public class AHashSet<T extends Book> {
	
	private final Integer INCREASED_SIZE = 2;
	private Integer size;  // amount of not empty elements
	private Integer fullSize;  // amount of length of array (empty + not empty elements)
	private Book[] elements;

	
	public AHashSet() {
		elements = new Book[INCREASED_SIZE];  
		size = 0;
		fullSize = this.INCREASED_SIZE;
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		for (int i=0; i<this.size; i++) {
		     result = prime * result * elements[i].hashCode();
		}     
		return result; 
	}
	
	public Integer getSize() {
		return size;
	}

	public Integer getFullSize() {
		return fullSize;
	}

	public String add (Book newElement) {
		
		String msg = "";
		boolean isContains = false;
		// searching duplicate
		for (int i=0; i<this.size; i++) {
	    	if ( elements[i].equals(newElement)) {
		    	isContains = true;
		    }
		}
		
		if (!isContains) {
			if (this.size == this.fullSize) {
					//creating new size as old size + defIncrease 
					this.fullSize = this.size + INCREASED_SIZE;
					// copy old array to temp array
					Book[] tempArray = Arrays.copyOf(elements, this.fullSize); 
					elements = tempArray;
					//new step and new array with increased size
			} 
			elements[this.size] = newElement;
			this.size++;
			msg = "Element successfully added.";
		} else {
			msg = "Element already exists!";
		}
		return msg;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<this.size; i++) {
			sb.append(elements[i].toString());
		}
		return sb.toString();
	}
	
	
}
