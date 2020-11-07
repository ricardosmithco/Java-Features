package java8;

/*
* File: Homework1
* Author: Ricardo Smith
* Date: November 2, 2020
* Purpose: This program accepts several user inputs and calculates 
* 1.) A person's average quiz scores, 2.) A person's age and 3.) the temperature in fahrenheit. 
* 
*/

// Import statements
import java.util.Scanner;
import java.text.DecimalFormat;

public class Homework1 { // class begins
	
	// define static variables used throughout application.
	static int studentId;
	static double quiz1;
	static double quiz2;
	static double quiz3;
	static int age;
	static double temperature;
	
	// define decimal formatter for rounding calculations
	static DecimalFormat decimalFormatter = new DecimalFormat("0.00");
	// define scanner object for taking input.
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) { //main method
		
		// prompt user for input: Student ID
		System.out.println("Please enter your Student ID number");
		
		// sanitize and initialize student Id
		studentId = validateStudentId(scanner);
		
		// prompt user for quiz scores. Sanitize and initialize quiz scores
		System.out.println("Please enter your Quiz 1 percentage score");
		quiz1 = validateQuiz(scanner);
		System.out.println("Please enter your Quiz 2 percentage score");
		quiz2 = validateQuiz(scanner);
		System.out.println("Please enter your Quiz 3 percentage score");
		quiz3 = validateQuiz(scanner);
		
		// prompt user for age in months. Sanitize and initialize age
		System.out.println("Please enter your age in months");
		age = validateAge(scanner);
		
		// prompt user for temperature in Celsius. Initialize temperature
		System.out.println("Please enter the temperature in Celsius");
		temperature = scanner.nextDouble();
		
		System.out.println("Processing ...");
		
		// echo the quiz values to the user.
		System.out.println("Quiz 1 Score: " + quiz1);
		System.out.println("Quiz 2 Score: " + quiz2);
		System.out.println("Quiz 3 Score: " + quiz3);
		
		// calculate the average quiz scores and print to screen
		System.out.println(calculateQuizAverage(quiz1, quiz2, quiz3));
		
		// calculate and print age in years
		System.out.println("Age in years: " + (age/12));
		
		// echo degrees in Celsius. 
		System.out.println("Temperature in Celsius: " + temperature + "\u00B0");
		
		// calculate and print Fahrenheit degree conversion
		System.out.println("Temperature in Fahrenheit: " + fahrenheitConversion(temperature) + "\u00B0");
		
		// close scanner class
		scanner.close();
	} // end main method
	
	private static int validateStudentId(Scanner scanner) { // method validating student id
		int id;
		try {
			id = scanner.nextInt();
			if(id < 0) throw new Exception();
			
		}catch(Exception e) {
			System.out.println("Invalid Student Id, please enter correct value");
			return validateStudentId(scanner);
		}
		return id;
	} // end student validation method
	
	private static double validateQuiz(Scanner scanner) { // method to validate quiz scores
		double quiz;
		try {
			quiz = scanner.nextDouble();
			if(quiz < 0 || quiz > 100.0) throw new Exception();
		}catch(Exception e) {
			System.out.println("Invalid quiz score, please enter correct value");
			return validateQuiz(scanner);
		}
		return quiz;
	} // end quiz validation method
	
	private static int validateAge(Scanner scanner) { // method to validate age
		int age;
		try {
			age = scanner.nextInt();
			if(age < 0 || age > 1440) throw new Exception();
			
		}catch(Exception e) {
			System.out.println("Invalid age, please enter value between 0 - 1440");
			return validateAge(scanner);
		}
		return age;
	} // end age validation method
	
	private static String calculateQuizAverage(double quiz1, double quiz2, double quiz3) { //method to calculate quiz average
		double average = (quiz1 + quiz2 + quiz3) / 3;
		return decimalFormatter.format(average);
	} // end quiz average method
	
	private static String fahrenheitConversion(double degreeCelsius) { // method to calculate Fahrenheit degrees
		double degreesFarenheit = (degreeCelsius * 1.8) + 32;
		return decimalFormatter.format(degreesFarenheit);
	} // end Fahrenheit calculation method
	
} // end of class.
