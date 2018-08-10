package example.parttern.creational.singleton;

/*
	Method getInstance() được đánh dấu là synchronized  tức là chỉ có duy nhất 1 thread được g�?i đến nó trong 1 th�?i điểm.
*/

public class ThreadSafeSingleton {
	
	private static ThreadSafeSingleton instance;

	private ThreadSafeSingleton() {
	}

	public static synchronized ThreadSafeSingleton getInstance() {
		if (instance == null) {
			instance = new ThreadSafeSingleton();
		}
		return instance;
	}
	
}
