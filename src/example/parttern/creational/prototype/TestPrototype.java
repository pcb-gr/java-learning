/*
 	https://stackjava.com/design-pattern/prototype-pattern.html
	Prototype Pattern là một mẫu tạo dựng (Creation Pattern).

Prototype Pattern được dùng khi việc tạo một object tốn nhiều chi phí và thời gian trong khi bạn đã có một object tương tự tồn tại.

Prototype Pattern cung cấp cơ chế để copy từ object ban đầu sang object mới và thay đổi giá trị một số thuộc tính nếu cần.

Trong Java cung cấp sẵn mẫu prototype pattern này bằng việc implement interface Cloneable và sử dụng method clone() để copy object.
*/
package example.parttern.creational.prototype;

public class TestPrototype {
	public static void main(String[] args) {
		Address address = new Address("Ha Noi", "Ha Dong", "Nguyen Trai");
		User originalUser = new User("firstName", "lastName", "stackjava", "abc@gmail.com", address);
		User userShallowCopy = originalUser.shallowCopy();
		User userDeepCopy = originalUser.deepCopy();

		System.out.println("Before change address:");
		System.out.println("original user: " + originalUser);
		System.out.println("shallow user: " + userShallowCopy);
		System.out.println("deep user: " + userDeepCopy);
		System.out.println("-----------------------------------");
		System.out.println("After shallow user change address:");
		userShallowCopy.getAddress().setDistrict("Thanh Xuan");
		System.out.println("original user: " + originalUser);
		System.out.println("shallow user: " + userShallowCopy);
		System.out.println("deep user: " + userDeepCopy);
		System.out.println("-----------------------------------");
		System.out.println("After deep user change address:");
		userDeepCopy.getAddress().setDistrict("Cau Giay");
		System.out.println("original user: " + originalUser);
		System.out.println("shallow user: " + userShallowCopy);
		System.out.println("deep user: " + userDeepCopy);
	}
}
