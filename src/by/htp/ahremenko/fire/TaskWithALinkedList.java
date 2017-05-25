package by.htp.ahremenko.fire;

import by.htp.ahremenko.KeyboardInput;
import by.htp.ahremenko.set.ALinkedList;


public class TaskWithALinkedList {

	public static void main(String[] args) {

		KeyboardInput kbd = new KeyboardInput();
		String commandLine = "";
		String response = "";
		ALinkedList<Integer> aLinkedList = new ALinkedList();
		
		
		do {
        	commandLine = kbd.enterString("Type command here >> ");
        	try {
            	if (commandLine.toUpperCase().equals("EXIT")) break;
            	if (commandLine.toUpperCase().contains("ADDLAST")) {
            		try {            		 
	            		response = commandLine.substring(commandLine.indexOf(' ')+1);
	            		Integer y = Integer.parseInt(response);
	            			if  (aLinkedList.addLast(y) != null) {
	            				response = "[" + response + "] added succefully.";
	            			};
            		} catch (StringIndexOutOfBoundsException|NumberFormatException e) {
            			response = "Check and type correct params for adding.";
            		}
            	}
            	
            	/*if (commandLine.toUpperCase().contains("GET")) {
            		try {            		 
	            		response = commandLine.substring(commandLine.indexOf(' ')+1);
	            		Integer y = Integer.parseInt(response);
          				response = aSet.getAsString(aSet.root, y);
            		} catch (StringIndexOutOfBoundsException|NumberFormatException e) {
            			response = "Check and type correct params for adding.";
            		}
            	}*/
            	if (commandLine.toUpperCase().contains("SHOW")) {
            		response = "Current list: " + aLinkedList.toString();
            	}
            	if (commandLine.toUpperCase().contains("SIZE")) {
            		response = "Size: " + aLinkedList.getSize();
            	}
            	if (commandLine.toUpperCase().contains("?")) {
            		response = "Allowed commands:\nADDLAST [key]\nSHOW\nSIZE\nEXIT";
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
