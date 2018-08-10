package example.parttern.creational.abstractfactory;

import example.parttern.creational.factory.Computer;

public class ComputerFactory {
	public static Computer getComputer(ComputerAbstractFactory factory) {
		return factory.createComputer();
	}
}
