package multithreading;

public class MyThread extends Thread{
	@Override
	public void run() {
		 System.out.println("Inside run");
	}
	public static void main(String[] args) throws InterruptedException {
		MyThread t = new MyThread();
		t.start();
		System.out.println("is this thread alive?: " + t.isAlive());
		t.join();				// main method waits for thread t to complete
		System.out.println("is this thread alive after running join() ? : " + t.isAlive());
		Thread.sleep(3000);		// main method sleeps for 3 seconds
		System.out.println("Main thread ends");
	}
}
