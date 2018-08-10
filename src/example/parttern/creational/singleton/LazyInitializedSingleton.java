//1. Tạo một đối tượng của chính lớp đó có thuộc tính private static.
//2. Tạo một private constructor để lớp này không thể khởi tạo bởi các đối tượng ở ngoài bản thân class đó.
//3. Tạo một method tên là getInstance() (Ohhhhh, Ok, bất cứ tên gì chúng ta muốn) và trả v�? đối tượng được khai báo ở bước 1.
//https://medium.com/@huynhquangthao/m%E1%BA%ABu-thi%E1%BA%BFt-k%E1%BA%BF-singleton-5997128c71b9
//https://viblo.asia/p/tong-hop-mot-so-design-pattern-trong-java-qzaGzZWRGyO
package example.parttern.creational.singleton;

/*
	Tạo thể hiện của Class Singleton trong method access.
	Cách này có nhược điểm là không hoạt động đúng trong trư�?ng hợp có nhi�?u thread,
	giả sử có nhi�?u thread cùng lúc g�?i method getInstance() sẽ có nhi�?u thể hiện khác nhau được tạo.
*/

public class LazyInitializedSingleton {
	// private static instance
	private static LazyInitializedSingleton sInstance;

	// private constructor for prevent outside initialization
	private LazyInitializedSingleton() {
	}

	// static getter
	public static LazyInitializedSingleton getInstance() {
		if (sInstance == null) {
			sInstance = new LazyInitializedSingleton();
		}
		return sInstance;
	}
}
