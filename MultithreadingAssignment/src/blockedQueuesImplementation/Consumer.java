package blockedQueuesImplementation;

public class Consumer implements Runnable{

	@Override
	public void run() {
			synchronized(App.queue) {
			try {
				App.queue.take();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			System.out.println(Thread.currentThread().getName()+" consumed");
			System.out.print("Current status of queue is: ");
		
			for(String s:App.queue) {
				System.out.print(s+" ");
			}
			System.out.println("");
		
	}
	}

}
