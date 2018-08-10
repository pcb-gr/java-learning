/*
	https://www.stdio.vn/articles/design-pattern-proxy-pattern-601
	Virtual Proxy: khi có nhiều lượt truy xuất vào một đối tượng cấu trúc phức tạp, chứa dữ liệu lớn (hình ảnh, video,..) trường hợp này chúng ta sẽ tạo ra một Proxy để đại diện cho đối tượng đó. Đối tượng chỉ được tạo ở lần truy xuất đầu tiên sau đó những lần truy xuất tiếp theo chỉ cần tái sử dụng lại mà không cần khởi tạo để tránh trường hợp sao chép ra nhiều đối tượng, vì vậy sẽ tiếp kiệm được nhiều tài nguyên.
	Protection Proxy: muốn kiểm tra một yêu cầu có quyền truy cập vào một nội dung nào đó hay không.
	Remote Proxy: trường hợp bạn muốn thực thi một phương thức của đối tượng đang tồn tại khác vùng địa chỉ hoặc ở máy tính khác.
*/
package example.parttern.structural.proxy;


public class TestProxy {
	public static void main(String[] args) {
		Image image1  = new VirtualProxyImage("VirtualProxyImage-1.jpg");
		image1.display();
		image1.setFileName("VirtualProxyImage-2.jpg");
		image1.display();
		
		new ProtectionProxyImage("ProtectionProxyImage.jpg").display();
		new ProtectionProxyImage("ProtectionProxyImage.jpg", "admin").display();
	}
}
