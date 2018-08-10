package example.parttern.creational.singleton;
//https://dzone.com/articles/java-singletons-using-enum
public enum EnumSingleton {
	INSTANCE1, INSTANCE2;
	int value = 1;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public int getValue2() {
		return value;
	}

	public static void main(String[] args) {
		EnumSingleton singleton = EnumSingleton.INSTANCE1;
		System.out.println(singleton.getValue());
		singleton.setValue(2);
		System.out.println(singleton.getValue());
		System.out.println(EnumSingleton.INSTANCE2.getValue2());
	}
}
