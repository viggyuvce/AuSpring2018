package ProducerConsumer;

public class Consumer implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized(Inventory.buffer) {
			while(Inventory.buffer.size() ==0) {
				try {
					Inventory.buffer.wait();
				} catch (InterruptedException e) {
				// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			Inventory.buffer.remove(0);
			System.out.println(Thread.currentThread().getName()+"Consumed");
			System.out.println("****Current status of Inventory****");
			for(String s:Inventory.buffer) {
				System.out.print(s+" ");
			}
			System.out.println("");
			Inventory.buffer.notify();
			/*try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}
		
	}

}
