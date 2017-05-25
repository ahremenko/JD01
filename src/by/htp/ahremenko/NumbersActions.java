package by.htp.ahremenko;

public class NumbersActions {

	public static void getFibonacciNumbers( int n) {
		// returns n fibonacci numbers
		int a = 0;
		int b = 1;
		int c;
		int i;
		
		System.out.println("Please, remember the fibonacci numbers:");
		for(i=0;i<n;i++) {
			if (i == 0) { c = a; }
			else if (i == 1) {c = b;}
			else { c = a + b; a = b; b = c;}
			System.out.println("#" + (i+1) + ": " + c);
		}
		
	}
	
	public static void printNodNok (int n) {
		// prints NOD and NOK for n entered numbers
		int x,i,j;
		int[] a = new int[n];
		KeyboardInput k = new KeyboardInput();
		int nod = 1;
		int nok = 1;
		
		for(i=0;i<n;i++){
			x = k.enterInt( true, "Enter number #" + (i+1) );
			a[i] = x;
			
			if (i==0) {
				nod = a[i];
				nok = a[i];
			} else {
				nod = getMaxDivisor(nod, a[i]);
				j = getMaxDivisor(nok, a[i]);
				nok = nok * a[i] / j;
			}
		}
		
		System.out.println("NOD: " + nod + ", NOK:" + nok );
		
		/*for(i=0;i<n;i++){
			//System.out.println("#" + (i+1) + ": " + a[i]);
			x = getMinSimpleDivisor(a[i]);
			divisor = 1; // if all next numbers divides by x
			for(j=i;j<n;j++){
				remain = a[j] % x; 
				if ( remain != 0) { divisor = 0; }
			}
			if (divisor == 1) { nod = nod * x;}
		}*/		
		
	}
	
	public static int getNOK (int x1, int x2) {
		return ( x1 * x2 / getMaxDivisor(x1, x2) );
	}
	
	public static int getMaxDivisor( int x1, int x2) {
		int maxDivisor = 1;
		int n1 = x1;
		int n2 = x2;
		int simpleDivisor;
		int remain;
		
		do {
			simpleDivisor = getMinSimpleDivisor(n1);
			if ( simpleDivisor == 1) {simpleDivisor = n1;}
			n1 = n1 / simpleDivisor;
			if ( simpleDivisor > 1 ) {
				remain = n2 % simpleDivisor;
				if ( remain == 0 ) {
					maxDivisor = maxDivisor * simpleDivisor;
					n2 = n2 / simpleDivisor;
				}	
			} 
		} while (n1>1 && n2>1);
		return maxDivisor;
	}
	
	/*public static int getMinSimpleDivisor( int x ) {
		int[] simpleNumber = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
		int i = 0,j,k;
		int minSimple = 1;
		k = simpleNumber[0];  // if min simple divisor exists - it must be less then SQRT(x)
		while ( minSimple==1 && i < simpleNumber.length && k <= (int)Math.sqrt(x)) {
			k = simpleNumber[i];
			j = x % k;
			if (j==0) {minSimple = k;}
			i++;			
		}
		return minSimple;
	}*/
	
	public static int getMinSimpleDivisor( int x ) {
		int i=2;
		int rem;
		int minSimple = 1;
		
		while ( i<=(int)Math.sqrt(x) && minSimple==1) {
			if ( isNumberSimple(i) == 1) {  // if number is simple - try to divide on it
				rem = x % i;
				if (rem==0) {minSimple = i;}  
				i++;			
			}
		}
		return minSimple;
	}
	
	public static int isNumberSimple( int x) {
		int minDivisor = 1;
		int rem;
		int i=2;
		while ( minDivisor==1 && i < x ) {
			rem = x % i;
			if (rem==0) {minDivisor = i;} // if remains = 0 - then exists divisor != 1 and != x  - then x is not Simple
			i++;			
		}
		if (minDivisor>1) {
			return 0;
		} else {
			return 1;
		}
	}
}
