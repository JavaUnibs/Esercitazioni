package jExample_Threads;

import java.util.concurrent.*;

public class Main {	
	
	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();

		Future<Integer> fa = executor.submit(new MyThread(31));
		Future<Integer> fb = executor.submit(new MyThread(23));
		Future<Integer> fc = executor.submit(new MyThread(13));

		try {
			
			System.out.printf("\nA: %d", fa.get());
			System.out.printf("\nB: %d", fb.get());
			System.out.printf("\nC: %d", fc.get());
			
		} catch (InterruptedException e) {
			e.printStackTrace();
			return;
		} catch (ExecutionException e) {
			e.printStackTrace();
		} finally {
			executor.shutdown();
		}
		
		System.out.print("Done!");
	}

}

class MyThread implements Callable<Integer> {
	private static int nThreads = 0;
	int id;
	int delay;
	
	MyThread(int delay){
		this.id = nThreads++;
		this.delay = delay;
	}
	
	public Integer call() throws Exception {
		int step = 5000/delay;
		for(int i=0; i<step; i++) {
			System.out.format("\n%d, line: %2d", this.id, i);

			try {
				Thread.currentThread().sleep(delay);
			} catch (InterruptedException e) {
				return null;
			}
		}
		return step;
	}
}