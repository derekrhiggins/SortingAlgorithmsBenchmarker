
import java.util.Arrays;

public class Algorithms {

	/*
	 * BUBBLE SORT
	 * Reference: https://www.geeksforgeeks.org/bubble-sort/
	 * 
	 */
	
	public void bubble(int[] sortThis) { 

		int elementsSorted = 1; // Use one to start and last index of array

		boolean swaps = false;

		do {
			
			swaps = false; // Reset swaps flag

			for(int i = 0; i < sortThis.length - elementsSorted; i++) { //Iterate over array for comparisons
				
				if(sortThis[i] > sortThis[i+1]) { // Compare in pairs
					
					int temp = sortThis[i];
					sortThis[i] = sortThis[i+1];
					sortThis[i+1] = temp;
					
					swaps = true; // Set flag that swap occurred
				}
			}
			
			elementsSorted++; // Increase last element sorted
			
		}while(swaps); // Finish when sorted
	}


	
	/*
	 * MERGE SORT 
	 * Reference: https://www.geeksforgeeks.org/merge-sort/
	 * 
	 */

	private void merge(int[] toSort, int left, int mid, int right) { 	// Method to sort sub-arrays and merge them
		
		int splitA = mid - left + 1; // Get the length of the two sub-arrays to sort/merge
		int splitB = right - mid;
		
		int firstPart[] = new int [splitA]; // Temporary arrays to store the sub-arrays
		int secondPart[] = new int [splitB];
		
		for(int i = 0; i < splitA; i++) { // Populate the temporary arrays
			
			firstPart[i] = toSort[left + i]; // Based on index of left portion start incrementing with i
		
		}
		
		for(int j = 0; j < splitB; j++) {
		
			secondPart[j] = toSort[mid + j + 1];  // Based on index of midpoint where split + 1 incrementing with j
		
		}
		

		int i = 0, j = 0;

		int k = left; 		// Variable to locate the start of the index of the array to sort and then traverse 

		while(i < splitA && j < splitB) { 		//Do-While there both sub-arrays

			if(firstPart[i] <= secondPart[j]) { 			//Compare, assign and move index on array to sort
				toSort[k] = firstPart[i];
				i++; // Increment i
			} else {
				toSort[k] = secondPart[j];
				j++; // Increment j
			}
			k++; // Increment k
		}
		
		while (i < splitA) { //Check for any element left in the sub-arrays and assign it to the array
			toSort[k] = firstPart[i];
			i++; // Increment i
			k++; // Increment k
		}
		while (j < splitB) {
			toSort[k] = secondPart[j];
			j++; // Increment j
			k++; // Increment k
		}

		//Done, recursion in "sort()" will continue and sort/merge the next sub-array until all done
	}


	//Method to recursively divide the array until we reach sub-arrays of 1 element (base case)
	//Merge is always a sub-array of at least two elements
	public void sort(int toSort[], int partA, int partB) {

		if(partA < partB) { // Act on smaller portion
	
			int midPoint = (partA + partB)/2; //Get the index in the middle
		
			sort(toSort, partA, midPoint); 	//Recursively get half of both sub-arrays and sort
			sort(toSort, midPoint + 1, partB);
			
			merge(toSort, partA, midPoint, partB); // Now merge

		}
	}

	
	
	/*
	 * RADIX SORT
	 * Reference: https://www.geeksforgeeks.org/radix-sort/
	 * 
	 */
	
	//Method to sort the array by Least Significant Digit
	//Parameters: Input Array, Array Length
	
	public void radix(int[] toSort, int n) {
		
		
		int max = getMax(toSort, n); //Find max value of the array using method

		for(int exponent = 1; max/exponent > 0; exponent *= 10) { // Loop over array examining the significant digit beginning with the rightmost, i.e. remainder of m/exp
			countSort(toSort, n, exponent); 	//Send to counting sort method with the radix to examine
		}
	}


	private int getMax(int[] toSort, int n) { 	//Find the maximum value of the array

		int max = toSort[0]; //Set the first element as the max

		for(int i = 1; i < n; i++) { 	//Compare and swap if larger get the max
			if (toSort[i] > max) {
				max = toSort[i];
			}
		}
		
		return max;
	}
	

	private void countSort(int[] toSort, int n, int exp) { // Method implementing Counting Sort Algorithm

		int[] output = new int[n]; // Array for storing result

		int i;

		int[] count = new int[10]; 	//Array for storing counts of each value (0-9 as decimal)
		Arrays.fill(count, 0); // Set counts/instances to zero for all digits
		
		for (i = 0; i < n; i++) { 		//Loop over array 'counting' the number of instances of each digit
			count[(toSort[i]/exp)%10]++;		
		}
		
		for(i = 1; i < 10; i++) { // Loop over setting the index of where each value in sorted array should rank
			count[i] += count[i - 1];
		}
		
		for(i = n - 1; i >= 0; i--) { // Loop from right (for stability of result) and assign to output array the value of toSort, i.e. the amount of times the value appears
			output[count[(toSort[i]/exp)%10] -1] = toSort[i];
			count[(toSort[i]/exp)%10]--;
		}

		for(i = 0; i < n; i++) { // Change output array toSort with the sorted result
			toSort[i] = output[i];
		}
	}


	
	
	/*
	 * SELECTION SORT
	 * Reference: https://www.geeksforgeeks.org/selection-sort/
	 * 
	 */

	public void selection(int[] sortThis) {
		//Variables for the Loops
		int leftSection = 0;
		int rightSection = 0;
		int sorted = 0;
		
		for(leftSection = 0; leftSection < sortThis.length -1; leftSection++) { //Loop over the array

			sorted = leftSection; // Set the sorted portion

			for(rightSection = leftSection + 1; rightSection < sortThis.length; rightSection++) { // Loop over array from next element (left+1)

				if(sortThis[rightSection] < sortThis[sorted]) { // Compare each element with the minimum
					sorted = rightSection;
				}
			}

			int temp = sortThis[leftSection]; // Swap minimum value with the left position
			sortThis[leftSection] = sortThis[sorted];
			sortThis[sorted] = temp;
		}
	}

	
	/*
	 * INSERTION SORT 
	 * Reference: https://www.geeksforgeeks.org/insertion-sort/ 
	 * 
	 */

	public void insertion(int[] toSort) {
	
		for(int i = 1; i < toSort.length; i++) { //Loop over the array starting at the second element
	
			int key = toSort[i]; 		//Select the element to compare
			int j = i-1; 			//Select index where to start to compare (to the left)

			while(j >= 0 && toSort[j] > key) { // While loop moves along elements and compares to key

				toSort[j+1] = toSort[j];
				j = j-1;  //Move the index of comparison one position to the left

			}

			toSort[j+1] = key; // Insert key value

		}

	}

}