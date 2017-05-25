package by.htp.ahremenko;

public class TasksWithStrings {

	public static void main(String[] args) {
		String s1 = "";
		Double dd;
		KeyboardInput kbd = new KeyboardInput();

		dd = kbd.enterDouble( "Enter Double" );			
		System.out.println("You entered: " + dd );
		
		s1 = kbd.enterString("Please, enter string like double");
		
		System.out.println("You entered: " + s1);
		try {
			dd = Double.parseDouble(s1);
			System.out.println("Converted double: " + dd);
		} catch (java.lang.NumberFormatException e) {
			System.err.println("Can't convert to double! " + e);
		}

		/*s1 = kbd.enterString("Please, enter string like int");
		System.out.println("You entered: " + s1);
		try {
		   i = Integer.parseInt(s1);
		   System.out.println("Converted int: " + i);
		} catch (java.lang.NumberFormatException e) {   
			   System.err.println("Can't convert to int! " + e);
		}*/
		
		//String s1 = "string1";
		//String s2 = "string1";
		
		
	}

}
