package ExecutorImplementation;

import java.util.Random;

import blockedQueuesImplementation.App;

public class Consumer implements Runnable {

	private int age;
	static private int i=0;
	public Consumer() {
		Random rand = new Random();
		this.age = rand.nextInt(50)+1;
	}
	@Override
	public void run() {
		i++;
		Thread.currentThread().setName("Consumer"+i);
		synchronized(App.queue) {
			String product = "";
			try {
				
				if(this.age >= 21) {
					product = App.queue.take();
					System.out.print(Thread.currentThread().getName()+" age is "+age+" Time to party!!!!!");
					System.out.println(Thread.currentThread().getName()+" consumed alcohol of "+product);
				}
				else {
					if(product.length()==0)
					System.out.println(Thread.currentThread().getName()+" can't consume the alcohol! Age is still "+age+ " ....");
				}
					
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			System.out.print("Current status of queue is: ");
		
			for(String s:App.queue) {
				System.out.print(s+" ");
			}
			System.out.println("");
		
	}
		
	}

}
