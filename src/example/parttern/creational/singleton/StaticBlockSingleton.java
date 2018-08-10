package example.parttern.creational.singleton;

/*
	Khởi tạo bằng static block,
	nó giống hệt cách 1 tuy nhiên có thể sử lý được ngoại lệ khi khởi tạo thể hiện đầu tiên.

*/

public class StaticBlockSingleton {
	private static StaticBlockSingleton instance;

	private StaticBlockSingleton() {
	}

	// static block initialization for exception handling
	static {
		try {
			instance = new StaticBlockSingleton();
		} catch (Exception e) {
			throw new RuntimeException("Exception occured in creating singleton instance");
		}
	}

	public static StaticBlockSingleton getInstance() {
		return instance;
	}
}
