
public class Consumer implements Runnable {

	WareHouse wareHouse;
	
	 public Consumer(WareHouse wareHouse) {
		this.wareHouse=wareHouse;
	}
	@Override
	public void run() {
		while(true)
		{
			wareHouse.removeItem();
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
