package ioOperations;

import java.io.RandomAccessFile;
import java.io.IOException;

public class RandomAccessDemo {

	public static void main(String[] args) throws IOException{
		RandomAccessFile randomFile = new RandomAccessFile("C:\\GitRepos\\Java-Features\\Demo.txt", "rw");
		System.out.println("Current position in empty file: " + randomFile.getFilePointer());
		randomFile.writeUTF("This is a first entry");
		System.out.println("position after writing: " + randomFile.getFilePointer());
		randomFile.seek(0);
		System.out.println(randomFile.readUTF());
		randomFile.close();
	}

}
