package multithreading;

public class DataContainer {
	private int intData;
	
	public DataContainer() {}
	public DataContainer(int value) { intData = value;}
	
	public int getData() { return intData;}
	public void setData(int value){ intData = value;}

	public static void main(String[] args) throws InterruptedException {
		DataContainer dataContainer = new DataContainer(5);
		Producer producerThread = new Producer(dataContainer);
		Consumer consumerThread = new Consumer(dataContainer);
		
		producerThread.setPriority(5);
		consumerThread.setPriority(10);
		
		producerThread.start();
		consumerThread.start();
		
		
	}
}

class Producer extends Thread{
	
	DataContainer container;
	@Override
	public void run() {
		for(int i = 0; i<3; i++) {
			int data = container.getData();
			container.setData(++data);
			System.out.println("Producer data now: " + container.getData() );
		}
	}
	
	Producer(DataContainer container) {
		this.container = container;
	}
}

class Consumer extends Thread{
	
	DataContainer container;
	Consumer(DataContainer container){
		this.container = container;
	}
	@Override
	public void run() {
		
		for(int i = 0; i<3; i++) {
			int data = container.getData();
			container.setData(--data);
			System.out.println("Consumer data now: " + container.getData());
		}
	}
	
	
}
