package example.parttern.structural.composite;

public class Task extends TaskItem {
	String name;
	double time;

	public Task() {
	}

	public Task(String name, double time) {
		this.name = name;
		this.time = time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}
}