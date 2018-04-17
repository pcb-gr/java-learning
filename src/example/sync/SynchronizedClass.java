package example.sync;

public class SynchronizedClass {
	private int a = 0;

	public synchronized void log1(String msg1, String msg2) {

		for (int i = 1; i <= 5; i++) {
			a++;
			System.out.println(msg1 + "-" + msg2 + " > A: " + a);

			try {
				Thread.sleep(100);
			} catch (Exception e) {
			}
		}
	}

	public void log2(String msg1, String msg2) {
		System.out.println("Begin " + msg1 + "-" + msg2);
		synchronized (this) {
			for (int i = 1; i <= 5; i++) {
				a++;
				System.out.println(msg1 + "-" + msg2 + " > A: " + a);

				try {
					Thread.sleep(100);
				} catch (Exception e) {
				}
			}
		}
		System.out.println("End " + msg1 + "-" + msg2);
	}
}
