/*
	https://stackjava.com/design-pattern/factory-pattern.html
	Factory Pattern được sử dụng khi có một class cha (super class) với nhi�?u class con (sub-class),
	dựa trên đầu vào và phải trả v�? 1 trong những class con đó.
*/
package example.parttern.creational.factory;

public class TestFactory {
	public static void main(String[] args) {
		Computer pc = ComputerFactory.getComputer("pc", "2 GB", "500 GB", "2.4 GHz");
		Computer server = ComputerFactory.getComputer("server", "16 GB", "1 TB", "2.9 GHz");
		System.out.println("Factory PC Config::" + pc);
		System.out.println("Factory Server Config::" + server);
	}
}
