package multithreading;

public class ThreadExample2 {

	public static void main(String[] args) {
		AClass aClass = new AClass();
		Thread t1 = new Thread(aClass);
		Thread t2 = new Thread(aClass);
		Thread t3 = new Thread(aClass);
		Thread t4 = new Thread(aClass);
		Thread t5 = new Thread(aClass);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}
}

class AClass implements Runnable{
	@Override
	public void run() {
		System.out.println("random thread is running");
	}
}
