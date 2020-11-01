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
