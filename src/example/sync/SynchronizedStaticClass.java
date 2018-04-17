package example.sync;

public class SynchronizedStaticClass {
	private static int a = 0;

	public static synchronized void log1(String msg1, String msg2) {

		for (int i = 1; i <= 5; i++) {
			a++;
			System.out.println(msg1 + "-" + msg2 + " > A: " + a);

			try {
				Thread.sleep(100);
			} catch (Exception e) {
			}
		}
	}

}
