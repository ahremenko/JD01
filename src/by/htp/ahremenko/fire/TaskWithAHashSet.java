package by.htp.ahremenko.fire;

import by.htp.ahremenko.KeyboardInput;
import by.htp.ahremenko.entity.Book;
import by.htp.ahremenko.set.AHashSet;

public class TaskWithAHashSet {

	public static void main(String[] args) {
		KeyboardInput kbd = new KeyboardInput();
		String commandLine = "";
		String response = "";
		AHashSet<Book> setOfBooks = new AHashSet<Book>();
		
		do {
        	commandLine = kbd.enterString("Type command here >> ");
        	try {
            	if (commandLine.toUpperCase().equals("EXIT")) break;
            	if (commandLine.toUpperCase().contains("ADD")) {
            		try {            		 
	            		response = commandLine.substring(commandLine.indexOf(' ')+1);
	            		Book newBook;

		            		String t = response.substring(0, response.indexOf(' '));
		            		response = response.substring(response.indexOf(' ')+1);
		            		String n = response.substring(0, response.indexOf(' '));
		            		response = response.substring(response.indexOf(' ')+1);
		            		Integer y = Integer.parseInt(response);
			            		if (!t.equals("") && !n.equals("") && y>0 ) {
			            			newBook = new Book (t,n,y);
			            			response = setOfBooks.add(newBook);
			            		} else {
			            			throw new StringIndexOutOfBoundsException();
			            		}
            		} catch (StringIndexOutOfBoundsException|NumberFormatException e) {
            			response = "Check and type correct params for adding.";
            		}
            	}
            	if (commandLine.toUpperCase().contains("SHOW")) {
            		response = "Current list: " + setOfBooks.toString();
            	}
            	if (commandLine.toUpperCase().contains("SIZE")) {
            		response = "Size: " + setOfBooks.getSize() + ", FullSize: " + setOfBooks.getFullSize();
            	}
            	if (commandLine.toUpperCase().contains("?")) {
            		response = "Allowed commands:\nADD [Title] [Author] [Year]\nSHOW\nSIZE\nEXIT";
            	}
        	} catch (Exception e) {
        		response = e.getMessage();
        	}
        	if (!response.equals("")) System.out.println("\n" + response);
        	response = "";
        } while (!commandLine.toUpperCase().equals("EXIT"));  
        System.out.println("\nHave a nice day :)");		

	}

}
