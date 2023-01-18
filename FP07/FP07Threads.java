package programming;

public class FP07Threads {

	public static void main(String[] args) {

		// creating thread using Runnable
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					// get the id of threads
					System.out.println(Thread.currentThread().getId() + ":" + i);

				}

			}

		};

		// creating thread using lamda
		Runnable runnable2 = () -> {
			for (int i = 0; i < 10000; i++) {
				System.out.println(Thread.currentThread().getId() + ":" + i);

			}
		};

		//removing the loop and using functional programming
		Runnable runnable3 = () -> 
								IntStream.range(0, 10000)
								.forEach( i -> System.out.println(Thread.currentThread().getId() + ":" + i))


		Thread thread = new Thread(runnable);
		thread.start();

		Thread thread1 = new Thread(runnable2);
		thread1.start();

		Thread thread2 = new Thread(runnable2);
		thread2.start();

		 // all these threads are executed in parallel

	}

}
