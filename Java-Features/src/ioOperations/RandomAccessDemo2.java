package ioOperations;

import java.io.RandomAccessFile;
import java.io.File;
import java.io.IOException;

public class RandomAccessDemo2 {

	static File file = new File("C:\\GitRepos\\Java-Features\\DemoDirectory");

	static File inputFile1 = new File("C:\\GitRepos\\Java-Features\\DemoDirectory\\Input1.txt");
	static File inputFile2 = new File("C:\\GitRepos\\Java-Features\\DemoDirectory\\Input2.txt");
	static File outputFile = new File("C:\\GitRepos\\Java-Features\\DemoDirectory\\Output.txt");

	public static void main(String[] args) {
		try {
			createBothInputFiles();
			RandomAccessFile[] randomFiles = writeToBothInputFiles();
			combineFiles(randomFiles);
			
		}catch(IOException io) {
			io.printStackTrace();
		}
	}
	
	public static void createBothInputFiles() throws IOException{
		System.out.println("has the directory been created?: " + file.mkdir());
		System.out.println("created Input file 1? : " + inputFile1.createNewFile());
		System.out.println("created Input file 2? : " + inputFile2.createNewFile());
		System.out.println("created Output file?: " + outputFile.createNewFile());
	}
	
	public static RandomAccessFile[] writeToBothInputFiles() throws IOException{
		RandomAccessFile randomFile1 = new RandomAccessFile("C:\\GitRepos\\Java-Features\\DemoDirectory\\Input1.txt", "rw");
		RandomAccessFile randomFile2 = new RandomAccessFile("C:\\GitRepos\\Java-Features\\DemoDirectory\\Input2.txt", "rw");
		randomFile1.writeUTF("Lila Ike has great album called The ExPerience");
		randomFile2.writeUTF("Mortimer has a gret album called: Fight the Fight");
		randomFile1.seek(0);
		randomFile2.seek(0);
		return new RandomAccessFile[] {randomFile1, randomFile2};
	}
	
	// reads from separate files and writes input into single file.
	public static void combineFiles(RandomAccessFile[] files) throws IOException {
		RandomAccessFile output = new RandomAccessFile("C:\\GitRepos\\Java-Features\\DemoDirectory\\Output.txt", "rw");
		for(RandomAccessFile file: files) {
			output.writeUTF(file.readLine());
			output.writeUTF("\n");
		}
	}

}
