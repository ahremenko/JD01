package by.htp.ahremenko;

import java.util.Random;

public class TasksWithRational {

	
	public static void main(String[] args) {
		int i,n1,d1;
		KeyboardInput kbd = new KeyboardInput();
		int n = kbd.enterInt( true, "How many members will be in Array of Rational? " );
		Random rnd = new Random();
		
		/*Rational r1 = new Rational (0, 1);
		System.out.print("r1: ");
		r1.printRational();
		Rational r2 = new Rational (2, 12);
		System.out.print(", r2: ");
		r2.printRational();
		Rational r3;
		r3 = r2.addRational(r1);
		System.out.print(", r1 + r2 = ");
		r3.printRational();*/
		System.out.print("Array of Rationals : ");
		
		Rational[] ArrayOfRational = new Rational [n];
		for (i=0;i<n;i++){
			d1 = 0;
			while (d1==0) {
			  d1 = rnd.nextInt(10);
			}
			n1 = 0;
			while (n1==0 || n1>=d1) {
			  n1 = rnd.nextInt(10);
			}
			ArrayOfRational[i] = new Rational(n1, d1);
			System.out.print( ArrayOfRational[i].getRationalAsString() + "; ");
		}
		System.out.println("");
		Rational ttlR = new Rational (0,1);
		for (i=0;i<n;i++) {
			ttlR = ttlR.addRational(ArrayOfRational[i]);
		}
		System.out.println("Total sum of array: " + ttlR.getRationalAsString());
		
	}	
}
