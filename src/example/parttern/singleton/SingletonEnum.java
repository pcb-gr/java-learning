package example.parttern.singleton;
//https://dzone.com/articles/java-singletons-using-enum
public enum SingletonEnum {
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
		SingletonEnum singleton = SingletonEnum.INSTANCE1;
		System.out.println(singleton.getValue());
		singleton.setValue(2);
		System.out.println(singleton.getValue());
		System.out.println(SingletonEnum.INSTANCE2.getValue2());
	}
}
