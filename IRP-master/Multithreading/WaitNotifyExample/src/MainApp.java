
public class MainApp {

	public static void main(String[] args) {
		WareHouse wareHouse = new WareHouse();
		
		Producer producer = new Producer(wareHouse);
		
		Consumer consumer = new Consumer(wareHouse);
		
		Thread producerThread = new Thread(producer);
		producerThread.start();
		
		Thread consumerThread = new Thread(consumer);
		consumerThread.start();

	}

}
