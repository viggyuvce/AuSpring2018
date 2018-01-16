package ProducerConsumer;

import java.util.ArrayList;

public class Inventory {	
	public static ArrayList<String> buffer = new ArrayList<String>();
	public static int max_capacity = 10;
	
	public static void main(String[] args) {
		int i = 1;
			while(true) {
			Producer producer = new Producer();
			Thread producerThread = new Thread(producer);
			producerThread.setName("P"+i);
			
			Consumer consumer = new Consumer();
			Thread consumerThread = new Thread(consumer);
			consumerThread.setName("C"+i);
			
			producerThread.start();
			consumerThread.start();
			i++;
			}
		
	}

}
