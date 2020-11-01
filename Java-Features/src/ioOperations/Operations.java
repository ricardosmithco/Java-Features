package ioOperations;

import java.io.FileOutputStream;
import java.io.FileInputStream;

public class Operations {

	public static void main(String[] args) {
		//writeCandidateNames();
		readCandidateNames();
	}
	
	public static void writeCandidateNames() {
		try {
			FileOutputStream outfile = new FileOutputStream("CandidateNames.txt");
			String data = "Lila Ike, Protoje, Chronixx, Koffee, Jesse Royal";
			byte[] byteArray = data.getBytes();
			outfile.write(byteArray);
			outfile.close();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void readCandidateNames() {
		try {
			FileInputStream infile = new FileInputStream("CandidateNames.txt");
			int i = infile.read();
			
			while (i != -1) {
				System.out.print((char)i);
				i = infile.read();
			}
			
			infile.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	

}
