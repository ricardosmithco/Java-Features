package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UploadResult implements Runnable{
	
	String taskName;
	
	UploadResult(String name){
		taskName = name;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " (Start) " + taskName);
		// some random code for uploading result: Dummy implementation
		
		try {
			Thread.sleep(4000);
		}catch(Exception e) {
			e.getMessage();
		}
		System.out.println(Thread.currentThread().getName() + " (End) " + taskName);
	}

	public static void main(String[] args) {
		ExecutorService exServicePool = Executors.newFixedThreadPool(2);    // Creating a thread Pool of size 2
	    int noOfUploadTasks = 3;    // Assuming we have 3 UploadResult task which needs to be processed
	    for (int i = 1; i <= noOfUploadTasks; i++) {
	        UploadResult uploadRunnable = new UploadResult("UploadResult:" + i);
	        exServicePool.execute(uploadRunnable);
	    }		
		
		exServicePool.shutdown();
		while( ! exServicePool.isTerminated()) {}
		System.out.println("Finished all threads");

	}

}

// The threads in the thread pool are assigned each of the UploadResult tasks. 
// Look at the program's output. Notice how thread 1 is reused to execute the 3rd UploadResult task.
