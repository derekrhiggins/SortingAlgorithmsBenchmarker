import java.io.*;
import java.util.*;

public class Output {

	private List<String> results; // Instance variable


	public Output(){ // Consructor
		this.results = new ArrayList<String>();
	}


	public void print(String pieceOfData) { // Store results in instance ArrayList
		results.add(pieceOfData);

		if(pieceOfData != "\n") results.add(","); 		// Formatting for CSV file. Don't do on "new line"
		
	}


	public void write() { // Write to CSV file
		try {
			File benchMarkingResults = new File("./Results.csv");

				BufferedWriter bw = new BufferedWriter(new FileWriter(benchMarkingResults));

				for(String i : results) {
					bw.write(i);
				}

				bw.flush();
				bw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
