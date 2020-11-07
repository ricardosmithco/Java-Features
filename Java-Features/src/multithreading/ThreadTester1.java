package multithreading;

public class ThreadTester1 {

	public static void main(String[] args) {
		Thread1 t1 = new Thread1();
		Thread2 t2 = new Thread2();
		
		t1.setPriority(Thread.MIN_PRIORITY);
		t2.setPriority(Thread.MAX_PRIORITY);
		t1.start();
		t2.start();
	}

}

class Thread1 extends Thread{
	@Override
	public void run() {
		System.out.println("Inside thread 1");
		for(int i = 0; i<3; i++) {
			System.out.println("inside thread1: "+i);
		}
		System.out.println("Thread1 finished");
	}
}

class Thread2 extends Thread{
	@Override
	public void run() {
		System.out.println("Inside thread 2");
		for(int i = 0; i<3; i++) {
			System.out.println("inside thread2: "+i);
		}
		System.out.println("Thread2 finished");
	}
}

// This method shows how the setPriority() works !
