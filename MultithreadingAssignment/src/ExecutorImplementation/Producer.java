package ExecutorImplementation;

import blockedQueuesImplementation.App;

public class Producer implements Runnable {

	private static int i;
	@Override
	public void run() {
		i++;
		// TODO Auto-generated method stub
		Thread.currentThread().setName("P"+i);
		synchronized(App.queue) {
			try {
				App.queue.put(Thread.currentThread().getName());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				System.out.println(Thread.currentThread().getName()+" produced");
				System.out.print("Current status of queue is :");
				
				for(String s:App.queue) {
					System.out.print(s+" ");
				}
				System.out.println("");
			
		}
		
	}

}
