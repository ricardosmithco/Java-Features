package multithreading;

public class ThreadExample1 {

	public static void main(String[] args) {
		MyThreadClass t1 = new MyThreadClass();
		MyThreadClass t2 = new MyThreadClass();
		MyThreadClass t3 = new MyThreadClass();
		MyThreadClass t4 = new MyThreadClass();
		MyThreadClass t5 = new MyThreadClass();
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}
}

class MyThreadClass extends Thread{
	@Override
	public void run() {
		System.out.println("thread running man");
	}
}
