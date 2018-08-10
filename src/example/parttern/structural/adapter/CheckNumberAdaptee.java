package example.parttern.structural.adapter;

public class CheckNumberAdaptee {
	public boolean checkNumber(String input) {
		String regex = "[0-9]+";
		return input.matches(regex);
	}
}
