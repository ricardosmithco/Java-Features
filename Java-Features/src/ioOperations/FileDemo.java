package ioOperations;

import java.io.File;

public class FileDemo {

	public static void main(String[] args) {
		File file = new File("C:\\GitRepos\\Java-Features\\Demo.txt");
		
		try {
			boolean isCreated = file.createNewFile();
			System.out.println("File Created: " + isCreated);
			System.out.println("Name of the file: " + file.getName());
			System.out.println("Path of the file: " + file.getPath());
			System.out.println("is Directory?: " + file.isDirectory());
			System.out.println("list: " + file.list());
			System.out.println("what is  toPath() method about?: " + file.toPath());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
