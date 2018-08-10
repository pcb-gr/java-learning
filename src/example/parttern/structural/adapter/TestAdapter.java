package example.parttern.structural.adapter;

public class TestAdapter {
	public static void main(String[] args) {
		PhoneTarget phoneTarget = new Adapter();
		String input1 = "sdflkqweqweq";
		String input2 = "123";
		String input3 = "01234342342";
		System.out.println(input1 + " is phone number: " + phoneTarget.checkPhoneNumber(input1));
		System.out.println(input2 + " is phone number: " + phoneTarget.checkPhoneNumber(input2));
		System.out.println(input3 + " is phone number: " + phoneTarget.checkPhoneNumber(input3));
	}
}
