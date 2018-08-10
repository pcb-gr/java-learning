package example.parttern.creational.singleton;

/*
	Thể hiện Singleton Class được tạo lúc class được tải , 
	đây là cách dễ dàng nhất để tạo 1 singleton class nhưng nó có nhược điểm là thể hiện được tạo kể cả khi nó không được dùng đến, 
	và không thể bắt được ngoại lệ lúc tạo thể hiện.
*/

public class EagerInitializedSingleton {

	private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();

	// private constructor to avoid client applications to use constructor
	private EagerInitializedSingleton() {
	}

	public static EagerInitializedSingleton getInstance() {
		return instance;
	}

}
