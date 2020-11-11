package lambdaExpressions;

public class DemoThreadMine {
	/* public static void main(String pars[]) {
	        Thread threadInstance = new Thread(new Runnable() {
	            //run --- implementation
	            public void run() {
	                System.out.println(" Its me from thread");
	            }
	        });
	        threadInstance.start();
	    } */
	
	// turning the above ^ into a lambda statement 
	
	public static void main(String[] args) {
		Runnable myRun = () -> System.out.println("Its me from thread");
		Thread threadInstance= new Thread(myRun);
		threadInstance.run();
	}

}
