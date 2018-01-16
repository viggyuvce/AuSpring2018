package blockedQueuesImplementation;

public class ConsumerCreator implements Runnable {
	@Override
	public void run() {
		for(int i=0;i<App.numConsumers;++i) {
			Thread t = new Thread(new Consumer());
			t.setName("C"+i);
			t.start();
		}
	}	
	
}
