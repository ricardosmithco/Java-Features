package multithreading;

public class RandomClass {
	public static void main(String[] args) {
		ThreadTester threadTester = new ThreadTester();
		threadTester.start();
	}
}

class ThreadTester extends Thread{
	@Override
	public void run() {
		System.out.println("thread running...");
	}
}

/*
 * In Java, thread creation can happen in two ways.
 * The first way extends the Thread Class of java.lang package
 * Follow the upcoming steps to create threads using Thread class:
 * 
 * 1.) Write a class that extends the Thread class.
 * 2.) Override/redefine the run() of the Thread class to define the operations that need to be performed by the thread.
 * 3.) Create instances of the subclass of Thread and start invoking start() method.
 * 
 * For the other method, see the other class : RandomClass2.
 */


