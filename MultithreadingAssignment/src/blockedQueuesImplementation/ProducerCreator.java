package blockedQueuesImplementation;

public class ProducerCreator implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<App.numProducers;++i) {
			Thread t = new Thread(new Producer());
			t.setName("P"+i);
			t.start();
		}
		
	}
}
