
public class Producer implements Runnable {

	WareHouse wareHouse;
	
	 public Producer(WareHouse wareHouse) {
		this.wareHouse=wareHouse;
	}
	@Override
	public void run() {
		while(true)
		{
			int num = (int)(Math.random()*100);
			wareHouse.addItem(num);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
