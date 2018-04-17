package example.sync;

public class JavaThreadSynchronizedMain {
	public static void main(String[] args) {
		final SynchronizedClass obj1 = new SynchronizedClass();
		final SynchronizedClass obj2 = new SynchronizedClass();

		Thread t1 = new Thread() {
			public void run() {
				//obj1.log1("Thread 1", "Log 1");
				 obj1.log2("Thread 1", "Log 2");
				//SynchronizedStaticClass.log1("Thread 1", "Log 1");
			}
		};

		Thread t2 = new Thread() {
			public void run() {
				//obj2.log1("Thread 2", "Log 1");
				 obj1.log2("Thread 2", "Log 2");
				//SynchronizedStaticClass.log1("Thread 2", "Log 1");
			}
		};

		Thread t3 = new Thread() {
			public void run() {
				//obj1.log1("Thread 3", "Log 1");
				 obj1.log2("Thread 3", "Log 2");
				//SynchronizedStaticClass.log1("Thread 3", "Log 1");
			}
		};

		t1.start();
		t2.start();
		t3.start();
	}
}
