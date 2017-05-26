package by.htp.ahremenko.fire;

import by.htp.ahremenko.KeyboardInput;
import by.htp.ahremenko.set.ALinkedList;


public class TaskWithALinkedList {

	public static void main(String[] args) {

		KeyboardInput kbd = new KeyboardInput();
		String commandLine = "";
		String response = "";
		ALinkedList<Integer> aLinkedList = new ALinkedList();
		ALinkedList<String> aLinkedListString = new ALinkedList();
		
		aLinkedList.addLast(10);
		aLinkedList.addLast(20);
		aLinkedList.addLast(30);
		aLinkedList.addLast(40);
		
		aLinkedListString.addLast("First");
		aLinkedListString.addLast("Second");
		aLinkedListString.addLast("Third");
		
		do {
        	commandLine = kbd.enterString("Your command >> ");
        	try {
            	if (commandLine.toUpperCase().equals("EXIT")) break;
            	if (commandLine.toUpperCase().contains("ADDLAST")) {
            		try {     
	            		response = commandLine.substring("ADDLAST".length()+1);
	            		try {
	            			Integer y = Integer.parseInt(response);
	            			if  (aLinkedList.addLast(y) != null) 
	            				response = "[" + response + "] added as LAST succefully.";
	            		} catch (NumberFormatException e) {
	            			response = response.replaceAll("'", "");
	            			if  (aLinkedListString.addLast(response) != null) 
	            				response = "[" + response + "] added as LAST succefully.";
	            		}
            		} catch (StringIndexOutOfBoundsException e) {
            			response = "Type [KEY] params for adding.";
            		}
            	}

            	else if (commandLine.toUpperCase().contains("ADDFIRST")) {
            		try {            		 
	            		response = commandLine.substring("ADDFIRST".length()+1);
	            		try {
	            			Integer y = Integer.parseInt(response);
	            			if  (aLinkedList.addFirst(y) != null) 
	            				response = "[" + response + "] added as FIRST succefully.";
	            		} catch (NumberFormatException e) {
	            			response = response.replaceAll("'", "");
	            			if  (aLinkedListString.addFirst(response) != null) 
	            				response = "[" + response + "] added as FIRST succefully.";
	            		}
            		} catch (StringIndexOutOfBoundsException e) {
            			response = "Type [KEY] params for adding.";
            		}
            	}

            	else if (commandLine.toUpperCase().contains("ADDAFTER")) {
            		try {            		 
	            		response = commandLine.substring("ADDAFTER".length()+1);
	            		if (response.contains(" ")) {
	            			String afterEnt = response.substring( 0, response.indexOf(" "));
	            			response = response.substring( response.indexOf(" ")+1);
		            		try {
		            			Integer newKey = Integer.parseInt(response);
		            			Integer afterKey = Integer.parseInt(afterEnt);
		            			if  (aLinkedList.addAfter(afterKey,newKey) != null) 
		            				response = "[" + response + "] added succefully.";
		            		} catch (NumberFormatException e) {
		            			response = response.replaceAll("'", "");
		            			if  (aLinkedListString.addAfter(afterEnt, response) != null) 
		            				response = "[" + response + "] added succefully.";
		            		}
	            		}	
            		} catch (StringIndexOutOfBoundsException e) {
            			response = "Type [KEY] params for adding.";
            		}
            	}
            	
            	else if (commandLine.toUpperCase().contains("DEL")) {
            		try {            		 
	            		response = commandLine.substring("DEL".length()+1);
	            		try {
	            			Integer y = Integer.parseInt(response);
	            			if  (aLinkedList.delete(y) ) 
	            				response = "[" + response + "] was deleted succefully.";
	            			else
	            				response = "[" + response + "] not found or something went wrong.. :(";
	            		} catch (NumberFormatException e) {
	            			response = response.replaceAll("'", "");
	            			if  (aLinkedListString.delete(response) ) 
	            				response = "[" + response + "] was deleted succefully.";
	            			else
	            				response = "[" + response + "] not found or something went wrong.. :(";
	            		}
            		} catch (StringIndexOutOfBoundsException e) {
            			response = "Type [KEY] params for adding.";
            		}
            	}
            	
            	else if (commandLine.toUpperCase().contains("GET")) {
            		try {
            			response = commandLine.substring("GET".length()+1);
	            		try {
	            			Integer y = Integer.parseInt(response);
	            			response = aLinkedList.getAsString(aLinkedList.getFirst(), y);
	            		} catch (NumberFormatException e) {
	            			response = response.replaceAll("'", "");
	            			response = aLinkedListString.getAsString(aLinkedListString.getFirst(), response);
	            		}
            		} catch (StringIndexOutOfBoundsException e) {
            			response = "Check and type correct params for adding.";
            		}
            	}
            	else if (commandLine.toUpperCase().contains("SHOW")) {
            		try {            		 
            			response = commandLine.substring("SHOW".length()+1);
            			if  (response.toUpperCase().equals("I")) response = "Current list <Integer>: " + aLinkedList.toString();
            			else if ( response.toUpperCase().equals("S")) response = "Current list <String>: " + aLinkedListString.toString();
            			else response = "Use 'I' or 'S' only.";
            		} catch (StringIndexOutOfBoundsException e) {
            			response = "Check and type correct params for adding.";
            		}
            	}
            	else if (commandLine.toUpperCase().contains("SIZE")) {
            		try {            		 
            			response = commandLine.substring("SIZE".length()+1);
            			if  (response.toUpperCase().equals("I")) response = "Size <Integer>: " + aLinkedList.getSize();
            			else if ( response.toUpperCase().equals("S")) response = "Size <String>: " + aLinkedListString.getSize();
            			else response = "Use 'I' or 'S' only.";
            		} catch (StringIndexOutOfBoundsException e) {
            			response = "Check and type correct params for adding.";
            		}
            	}
            	else if (commandLine.toUpperCase().contains("?")) {
            		response = "Allowed commands:\nADDLAST [key]\nADDFIRST [key]\nADDAFTER [existKey] [newKey]\nDEL [key]\nGET [key]\nSHOW [I|S]\nSIZE[I|S]\nEXIT";
            	}
            	else
            		response = "Unknown command. Use '?'.";
        	} catch (Exception e) {
        		response = e.getMessage();
        	}
        	if (!response.equals("")) System.out.println("\n" + response);
        	response = "";
        } while (!commandLine.toUpperCase().equals("EXIT"));  
        System.out.println("\nHave a nice day :)");	

	}

}
