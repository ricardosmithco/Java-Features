package multithreading;

public class Tester {
	
	public static void main(String[] args) throws InterruptedException {
		Event homecoming = new Event("Homecoming", 1);
		RegisterThread t1 = new RegisterThread(homecoming);
		t1.start();
		RegisterThread t2 = new RegisterThread(homecoming);
		t2.start();
		CancelRegistration t3 = new CancelRegistration(homecoming);
		t3.start();
	}

}

class Event{
	String eventName;
	int numOfSeats;
	
	public Event(String name, int seats) {
		eventName = name;
		numOfSeats = seats;
	}
	
	public synchronized void registerForEvent(int ticket) { // gives wrong result unless we add the synchronized keyword to the method to 
											   					// control multiple threads from accessing it at the same time!
		try {
			if(this.numOfSeats == 0) {      // if no seats available,
				System.out.println("loading...");
				this.wait(5000);			// releases the lock on object and waits for 5 seconds
				if(this.numOfSeats == 0) {  // check if any seat got released by a cancellation. 
					throw new Exception("No more seats available for this event");
				}
			} 
			else {
				System.out.println("Booking successful");
				this.numOfSeats--;
				System.out.println("Available seats remaining: " + this.numOfSeats);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	} // end registerForEvent()
	
	public synchronized void cancelSeats() {
		try {
			this.numOfSeats++;
			System.out.println("Cancellation successful");
			System.out.println("Available seats: " + this.numOfSeats);
			this.notify();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}


class RegisterThread extends Thread{
	Event event;
	
	RegisterThread(Event event){
		this.event = event;
	}
	
	@Override
	public void run() {
		event.registerForEvent(1);
	}
}

class CancelRegistration extends Thread{
	Event event;
	
	CancelRegistration(Event event){
		this.event = event;
	}
	
	@Override
	public void run() {
		event.cancelSeats();
	}
}

/*
 * In a multithreaded environment, two or more threads may access a shared resource.
 * Synchronization is used to ensure that only one thread can access the shared resource at a time.
 * Every object has a built-in mutually exclusive lock called monitor. Only one thread can acquire the monitor on an object at a time.
 * On synchronization, a thread obtains the lock to an object, and other threads wait until the lock is released.
 */
