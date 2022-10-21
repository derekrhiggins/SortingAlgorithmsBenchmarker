/*
 * Derek Higgins
 * g00398357@gmit.ie
 * 
 * Computational Thinking with Algorithms
 * Project - Sorting Algorithms Benchmarker
 * */


public class Runner {
	

	public static void main(String[] args) {

		
		String[] testAlgos = new String[] {"Bubble", "Merge", "Radix", "Selection", "Insertion"}; // Algorithms are called from the following array

		int numTests = 10; // Number of runs for each algo on random data

		int[] arrayInputSizes = new int[] {100, 250, 500, 750, 1000, 1250, 2500, 3750, 5000, 6250, 7500, 8750, 10000}; // Array input sizes

		Benchmarker benchmarker = new Benchmarker(testAlgos, arrayInputSizes);

		benchmarker.runBenchmarkTest(numTests);
	}

}