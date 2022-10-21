import java.text.*;


public class Benchmarker { // This class runs the benchmarking process

	private String[] sortingAlgosArray;
	private int[] sizeArray;

	public Benchmarker(String[] sortingAlgos, int[] inputSizeArray) { // Constructor
		this.sortingAlgosArray = sortingAlgos;
		this.sizeArray = inputSizeArray;
	}


	public void runBenchmarkTest(int numberOfRuns) { // Method for running the test
		

		TestObject test = new TestObject(numberOfRuns); // Create new test object
		
		int cols = sizeArray.length;
		int rows = sortingAlgosArray.length;
		
		double[][] results = new double[rows][cols]; // 2D Array to store data

		
		for(int j = 0; j < cols; j++) { // Generate random arrays

			test.generateArrays(sizeArray[j]);

			
			System.out.println("Testing for " + sizeArray[j] + " inputs.");
			
			
			
			for(int i = 0; i < rows; i++) { // Loop over generated arrays for each algorithm
			

				String sortingAlgoSelected = sortingAlgosArray[i];
				test.setSortingAlgoSelected(sortingAlgoSelected);
				
				results[i][j] = test.calcAverageTime(); // Run the benchmark
			}
		}
		
		output(results); // Output the results
	}


	private void output(double[][] results) { // Output calculated results
		

		String[] sizes = new String[sizeArray.length + 1]; // Array for formatting
	

		int z = 0; // Fill size array with values used

		sizes[0] = "Size";

		for(int i = 1; i < sizes.length; i++) {
			sizes[i] = Integer.toString(sizeArray[z]);
			z++;
		}


		DecimalFormat formatted = new DecimalFormat("#.000");

		Output output = new Output(); // Output to file

		System.out.println("\nSorting Algorithms Benchmarker");

		for(int i = 0; i < sizes.length; i++) { // Output all data
			
			System.out.printf("%-11s", sizes[i]);
			output.print(sizes[i]);
		}
		
		System.out.printf("%n");
		output.print("\n");
		
		for(int i = 0; i < results.length; i++) { 		// Output all data stored in the results array

			
			System.out.printf("%-11s", sortingAlgosArray[i]);

			output.print(sortingAlgosArray[i]);

			for(int j = 0; j < results[0].length; j++) {

				System.out.printf("%-11.3f", results[i][j]);
				output.print(formatted.format(results[i][j]));
			}
			
			System.out.printf("%n");
			output.print("\n");
		}
		
		output.write(); // Saves to file
		
	}
}
