package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskRunner {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		int tasks = 5;
		for(int i = 1; i<=tasks; i++) {
			Task task = new Task(i);
			executorService.execute(task);
		}
		
		executorService.shutdown();
		while( ! executorService.isTerminated()) {}
		System.out.println("all tasks complete");

	}
}

class Task implements Runnable{
	private int counter;
	
	Task(int counter){
		this.counter = counter;
	}
	
	public int getCounter() {return counter;}
	
	public void setCounter(int counter) { this.counter = counter;}
	
	public int incrementCounter() {
		return counter++;
	}
	
	@Override
	public void run() {
		incrementCounter();
		System.out.println("Counter value: " + counter);
	}
}
