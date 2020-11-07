package multithreading;

public class RandomClass2 {
	public static void main(String[] args) {
		ThreadTester2 threadTester = new ThreadTester2();
		Thread thread = new Thread(threadTester);
		thread.start();
	}
}

class ThreadTester2 implements Runnable{

	@Override
	public void run() {	
		System.out.println("thread is running !");
	}
}

/*
 *  The other way of creating threads is to implement the java.lang.Runnable interface.
 *  It contains a single abstract method, run() that needs to be redefined in order to define the tasks of the thread
 *  Follow these steps in order to come up with a thread using the Runnable interface:
 *  
 *  1.) Write a class that implements the Runnable interface of the java.lang package.
 *  2.) Implement the run() method to define the operations to be performed by the thread.
 *  3.) Create instances of Thread class by passing the instance of the class that implements the Runnable interface. 
 *  Then, invoke the start() method on the instance that got created.
 *  
 *  NOTE: In the previous case, the start() method was invoked on the instance of the class that extended the Thread class.
 *  But, here the Thread instance accepts the instance of the class that implements Runnable and finally,
 *  the start() method needs to be invoked on the resulting instance.
 *  
 */ 
