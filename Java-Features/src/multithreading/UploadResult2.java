package multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class UploadResult2 implements Callable<Boolean>{
	
	String taskName;
	UploadResult2(String name){ taskName = name;}
	
	@Override
	public Boolean call() {
		System.out.println(Thread.currentThread().getName() + " (Start) " + taskName);
		
		// Code for uploading result: Dummy implementation
        Boolean retValue = null;
        try {
            Thread.sleep(2000);
            // code to Upload result
            // Set retValue to true
            retValue = Boolean.TRUE;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            // Set retValue to false
             retValue = Boolean.FALSE;
        }
        System.out.println(Thread.currentThread().getName() + " (End) " + taskName);
        return retValue;
	}
	

	public static void main(String[] args) {
		
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		UploadResult2 uploadCallable = new UploadResult2("Batch 1");
		
		Future<Boolean> future = executorService.submit(uploadCallable);
		
		try {
			System.out.println(future.get());
		}catch(Exception e) {
			e.getMessage();
		}
	}
}
/*
call() is the single method available in the Callable interface that represents the task needs to get completed by the thread
The call() method uses generics to define its return type.

As Runnable interface uses the run() method similarly Callable interface has call() method.

A Future object is a value that a callable thread will return in the future.  Future object's get() method will give the result value if it is ready, otherwise, it blocks the calling thread.

It also has methods to check whether the calculation is complete, wait until it is finished, etc.

 */