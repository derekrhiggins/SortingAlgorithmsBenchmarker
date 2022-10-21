
public class ArrayGenerator { // Generate the random arrays


	private int[][] array;

	
	public ArrayGenerator(int numberOfTests) { // Generate for number of tests required
		this.array = new int[numberOfTests][];
	}
	

	public int[] getTestArray(int numberOfTest) { // This clones the random array to keep it unsorted
		return array[numberOfTest].clone(); //
	}

	
	public void generateArrays(int n) { // Generate array for input sizes

		for(int i = 0; i < array.length; i++) {
			array[i] = generateRandomArray(n);
		}
		
	}


	private int[] generateRandomArray(int n) { // Method to generate random arrays
		
		int[] array = new int[n];
		
		for(int i = 0; i < n; i++) {
			array[i] = (int) (Math.random() * 100);
		}

		return array;

	}
}
