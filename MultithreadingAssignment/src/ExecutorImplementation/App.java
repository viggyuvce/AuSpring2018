package ExecutorImplementation;


import java.util.concurrent.*;
public class App {
	
	//3 working threads to handle producer threads
	private static int nProducersExec=3;
	//10 working threads to handle consumer threads
	private static int nConsumersExec = 10;
	//maximum number of producers in the bar
	private static int nProducers = 10;
	//maximum number of consumers in the bar
	private static int nConsumers = 100;
    static BlockingQueue<String> queue = new ArrayBlockingQueue<String>(10);
	
	public static void main(String[] args) {
		ExecutorService pExecutor = Executors.newFixedThreadPool(nProducersExec);
		ExecutorService cExecutor = Executors.newFixedThreadPool(nConsumersExec);
		
		for(int i=1;i<=nProducers;++i) {
			pExecutor.submit(new Producer());
		}
		for(int i=1;i<=nConsumers;++i) {
			cExecutor.submit(new Consumer());
		}
		
		
	}
}
