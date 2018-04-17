//1. Tạo một đối tượng của chính lớp đó có thuộc tính private static.
//2. Tạo một private constructor để lớp này không thể khởi tạo bởi các đối tượng ở ngoài bản thân class đó.
//3. Tạo một method tên là getInstance() (Ohhhhh, Ok, bất cứ tên gì chúng ta muốn) và trả về đối tượng được khai báo ở bước 1.
//https://medium.com/@huynhquangthao/m%E1%BA%ABu-thi%E1%BA%BFt-k%E1%BA%BF-singleton-5997128c71b9
//https://viblo.asia/p/tong-hop-mot-so-design-pattern-trong-java-qzaGzZWRGyO
package example.parttern.singleton;

public class SingletonSimple {
	// private static instance
	private static SingletonSimple sInstance;

	// private constructor for prevent outside initialization
	private SingletonSimple() {
	}

	// static getter
	public static SingletonSimple getInstance() {
		if (sInstance == null) {
			sInstance = new SingletonSimple();
		}
		return sInstance;
	}
}
