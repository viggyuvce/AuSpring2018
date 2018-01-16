package ProducerConsumer;

public class Producer implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized(Inventory.buffer) {
			while(Inventory.buffer.size() == Inventory.max_capacity) {
				try {
					Inventory.buffer.wait();
				} catch (InterruptedException e) {
				// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			Inventory.buffer.add(Thread.currentThread().getName());
			System.out.println(Thread.currentThread().getName() + "produced");;
			System.out.println("****Current status of Inventory****");
			for(String s:Inventory.buffer) {
				System.out.print(s+" ");
			}
			System.out.println("");
			Inventory.buffer.notify();
			/*try {
			//	Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}
		
	}
}
