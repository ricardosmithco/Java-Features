package ioOperations;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class JohnTotal {
	
	static int englishTotal = 0;
	static int mathsTotal = 0;
	static int scienceTotal = 0;

	public static void main(String[] args) throws IOException{
		BufferedReader inFileTerm1 = null;
		BufferedReader inFileTerm2 = null;
		BufferedWriter outFileTotal = null;
		
		
		try {
			inFileTerm1 = new BufferedReader(new FileReader("JohnTerm1.txt"));
			inFileTerm2 = new BufferedReader(new FileReader("JohnTerm2.txt"));
			
			BufferedReader[] files = {inFileTerm1, inFileTerm2};
			
			for(BufferedReader inFile: files) {
				while(inFile.ready()) {
					String line = inFile.readLine();
					String[] strArray = line.split(":");
					tallyMarks(strArray[0].trim(), strArray[1].trim());
				}
				if(inFile != null)inFile.close();
			}
			
			outFileTotal = new BufferedWriter(new FileWriter("JohnTermTotal.txt"));
			outFileTotal.write("English: " + englishTotal + "\n" );
			outFileTotal.write("Maths: " + mathsTotal + "\n" );
			outFileTotal.write("Science: " + scienceTotal + "\n");
			
			if(outFileTotal != null) outFileTotal.close();
			
		}catch(IOException io) {
			io.getMessage();
		}
	}
	
	public static void tallyMarks(String subject, String mark) {
		if(subject.equalsIgnoreCase("english")) englishTotal+= Integer.parseInt(mark);
		if(subject.equalsIgnoreCase("maths")) mathsTotal+= Integer.parseInt(mark);
		if(subject.equalsIgnoreCase("science")) scienceTotal+= Integer.parseInt(mark);
	}

}

/*
 * When data is read and written, a byte or character at a time, it is a very expensive operation due to frequent disk access
 * This can be optimized by buffering a group of bytes or characters together and then making use of them.
 * Buffering helps to store an entire block of values into a buffer, and then make the data available for use.
 * There are four buffered stream classes:
 * BufferedInputStream and BufferedOutputStream help in creating buffered byte streams
 * BufferedReader and BufferedWriter are used to create buffered character stream
 */
