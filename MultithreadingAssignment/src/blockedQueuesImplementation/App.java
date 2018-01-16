package blockedQueuesImplementation;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class App {
	static int numProducers = 10;
	static int numConsumers = 10;
	public static BlockingQueue<String> queue = new ArrayBlockingQueue<String>(10);
	public static void main(String[] args) {
		Thread PC = new Thread(new ProducerCreator());
		Thread CC = new Thread(new ConsumerCreator());
		PC.start();
		CC.start();
	}
}
