
public class TestObject { // Object to call the sorting algorithm
	

	private int numberOfTests; // Number of tests to run

	private Algorithms sortingAlgo; // Algorithm to sort with

	private ArrayGenerator arrGenerator; // ArrayGenerator object

	private String sortingAlgSelected; // Selected Algorithm


	public TestObject(int numberOfTests) { //Constructor
		sortingAlgo = new Algorithms();
		arrGenerator = new ArrayGenerator(numberOfTests);
		this.numberOfTests = numberOfTests;
	}


	public void generateArrays(int size) { 	//Method to generate random arrays
		arrGenerator.generateArrays(size);
	}


	public double calcAverageTime() { // Method for calculating run times

		double averageTime;

		double[] runningTimes = getRunningTimes();

		double sumTimes = 0; // Sum up runningTimes

		for(int i = 0; i < runningTimes.length; i++) {

			sumTimes += runningTimes[i];
		}
		
		averageTime = sumTimes / runningTimes.length;
		
		return averageTime;
	}


	public void setSortingAlgoSelected(String sortingAlgSelected) { // Method to set Sorting Algorithm
		this.sortingAlgSelected = sortingAlgSelected;
	}



	private double[] getRunningTimes() { // Method to get RunningTimes

		double[] runTimes = new double[numberOfTests];

		for(int i = 0; i < runTimes.length; i++) { //Loop the number of test times called for

			int[] runTest = arrGenerator.getTestArray(i); // Use getTest method to set test to Run

			long startTime = System.nanoTime(); // Start Time

			callAlg(runTest); // Run the sorting algorithm
			

			long finishTime = System.nanoTime(); // Finish Time

			long runTimeNanoSeconds = finishTime-startTime; // Calculate runtime
			double runTimeMilliSeconds = runTimeNanoSeconds/1000000.0;

			runTimes[i] = runTimeMilliSeconds;
		}

		return runTimes; // Return the runTime for this algorithm
	}


	private void callAlg(int[] toSort) { // Method to call the algorithms to be run with any necessary parameters

		switch (sortingAlgSelected) {
		case "Bubble":
			sortingAlgo.bubble(toSort);
			break;
		case "Selection":
			sortingAlgo.selection(toSort);
			break;
		case "Insertion":
			sortingAlgo.insertion(toSort);
			break;
		case "Merge":
			sortingAlgo.sort(toSort, 0, toSort.length - 1);
			break;
		case "Radix":
			sortingAlgo.radix(toSort, toSort.length);
			break;
			
		}
	}
}
