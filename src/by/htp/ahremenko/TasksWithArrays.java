package by.htp.ahremenko;

public class TasksWithArrays {

	public static void main(String[] args) {
		int rows, columns;
		/*int[] testArray = new int[10];
		ArrayActions.fillArrayWithRandom(testArray);
		ArrayActions.printArray(testArray, "------------- current array --------------------");
		ArrayActions.sortArray(testArray);
		ArrayActions.printArray(testArray, "------------- array after sorting --------------------");
		*/
		
		KeyboardInput kbd = new KeyboardInput();
		rows = kbd.enterInt( true, "Enter amount of rows" );
		columns = kbd.enterInt( true, "Enter amount of columns" );
		
		int[][] testArray2 = new int[rows][columns]; 
		for (int i=0; i<testArray2.length; i++) {
			//testArray2[i] = new int[columns];  // for variable scale
			ArrayActions.fillArrayWithRandom(testArray2[i]);
			ArrayActions.printArray(testArray2[i], "------------- row #" + i + " array --------------------");
			ArrayActions.sortArrayV2(testArray2[i]);
			ArrayActions.printArray(testArray2[i], "------------- row #" + i + " sorted --------------------");
    	}
		
		
	}

}
