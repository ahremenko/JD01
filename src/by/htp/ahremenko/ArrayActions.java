package by.htp.ahremenko;

import java.util.Random;

public class ArrayActions {
	
	public static void fillArrayWithRandom( int[] ar) {
		Random rnd = new Random();
		for( int i=0; i<ar.length; i++) {
			ar[i] = rnd.nextInt(1000);
		}
	}
	
	public static void printArray( int[] ar, String msgText) {
		System.out.println(msgText);
		//for( int i=0; i<ar.length; i++) {
		//	System.out.print(ar[i] + "; ");
		//}
		for (int x : ar) {
			System.out.print(x + "; ");
		}
		System.out.println();		
	}
	
	public static void sortArray( int[] ar) {
		int minValueIndex = 0;
		for( int i=0; i<ar.length; i++) {
			minValueIndex = i;
			for( int j=i+1; j<ar.length; j++) {
				if (ar[j]<ar[minValueIndex]){
					minValueIndex = j;
				}
			}
			int temp = ar[i];
			ar[i] = ar[minValueIndex];
			ar[minValueIndex] = temp;
		}
	}
	
	public static void sortArrayV2 (int [] ar ) {
		int temp;
		for(int i=0; i<ar.length; i++) {
			for(int j=0; j<ar.length-1-i; j++) {
				if (ar[j] > ar[j+1]) {
					temp = ar[j];
					ar[j] = ar[j+1];
					ar[j+1] = temp;
				}
			}
		}
	}

}
