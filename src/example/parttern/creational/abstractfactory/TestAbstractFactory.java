/*	
 	https://stackjava.com/design-pattern/abstract-factory-pattern.html
	Nếu bạn đã quen với  Factory Pattern thì bạn sẽ thấy nó chỉ có 1 Factory class, factory class này sẽ trả v�? các class con (sub-class) dựa trên dầu vào (factory class sử dụng if-else hoặc switch để xác định class con đầu ra).

	Trong Abstract Factory pattern, chúng ta không cần if-else hoặc switch. Mỗi sub-class sẽ có một factory class. Abstract Factory class sẽ trả v�? sub-class dựa trên đầu vào là factory class.

	Một số ví dụ v�? Abstract Factory trong JDK:
	javax.xml.parsers.DocumentBuilderFactory#newInstance()
	javax.xml.transform.TransformerFactory#newInstance()
	javax.xml.xpath.XPathFactory#newInstance()
	 Lợi ích của Abstract Factory Pattern.
	Abstract Factory pattern cung cấp hưỡng tiếp cận code bằng interface thay vì các cài đặt (Giống với Factory Pattern)
	Abstract Factory pattern là “factory của các factory�? và có thể dễ dạng mở rộng để chứa thêm các factory và các sub-class
	Abstract Factory giúp tránh được việc sử dụng đi�?u kiện logic như bên trong Factory Pattern.
*/
package example.parttern.creational.abstractfactory;

import example.parttern.creational.factory.Computer;

public class TestAbstractFactory {
	public static void main(String[] args) {
		testAbstractFactory();
	}

	private static void testAbstractFactory() {
		Computer pc = ComputerFactory.getComputer(new PCFactory("2 GB", "500 GB", "2.4 GHz"));
		Computer server = ComputerFactory.getComputer(new ServerFactory("16 GB", "1 TB", "2.9 GHz"));
		System.out.println("AbstractFactory PC Config::" + pc);
		System.out.println("AbstractFactory Server Config::" + server);
	}
}
