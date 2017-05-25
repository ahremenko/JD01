package by.htp.ahremenko;

public class TasksWithNumbers {

	public static void main(String[] args) {
		
		int x;
		int i;
		KeyboardInput kbd = new KeyboardInput();
				
		x = kbd.enterInt( true, "Enter amount of numbers" );
		//NumbersActions.getFibonacciNumbers(x);
		
		NumbersActions.printNodNok(x);
		
		int n1, n2;
		
		n1 = kbd.enterInt(true, "Enter number #1");
		n2 = kbd.enterInt(true, "Enter number #2");
		System.out.println("NOK (" + n1 + "," + n2 + ") = " + NumbersActions.getNOK(n1, n2));
		//i = kbd.enterInt( true, "Enter int" );
		
		//a = TaskNumbers.getMinSimpleDivisor(x);
		//System.out.println(" getMinSimpleDivisor (x) = " + a);
		
		//System.out.println("For " + x + "," + i + " max Divisor is: " + TaskNumbers.getMaxDivisor(x,i));
		//System.out.println("For " + x + "," + i + " min Multiple is: " + x*i/(TaskNumbers.getMaxDivisor(x,i)));
		
		//i = (int)Math.sqrt(x);
		//System.out.println("SQRT(" + x + ") = " + i);
		
				
		//System.out.println("You entered x = " + x);
		//s = kbd.enterString( "Enter string:" );
		//System.out.println("You entered s = " + s);*/

		
		////////////////////////////////////////////////////////////
		// how to call exception in next code?? 
		/*
		System.out.print("Enter char: ");
		try {
			x = System.in.read();
			char c = (char)x;
			System.out.println("Symbol '" + c + "' has code: " + x);
		} catch (java.io.IOException e){
			System.err.println("Input error: " + e);
		}*/
		////////////////////////////////////////////////////////////		
		
	
	}

}
