/*
	https://stackjava.com/design-pattern/composite-pattern.html
	Composite Pattern là một mẫu cấu trúc (Structural Pattern).

	Composite Pattern cho phép tương tác với tất cả các đối tượng tương tự nhau giống như là các đối tượng đơn hoặc collections.

	Ví dụ: Đối tượng File sẽ là 1 đối tượng đơn nếu bên trong nó không có file nào khác, nhưng đối tượng file sẽ được đối xử giống như 1 collections nếu bên trong nó lại có những File khác.

	Khi tính kích thước của File ta sẽ cần tính kích thước của tất cả các file bên trong nó.
*/
package example.parttern.structural.composite;

import java.util.ArrayList;

public class TestComposite {
	public static void main(String[] args) {
		Task task1 = new Task("requirement", 50);
		Task task2 = new Task("analysis", 34);
		Task task3 = new Task("design", 65);
		Task task4 = new Task("implement", 23);
		Task task5 = new Task("test", 65);
		Task task6 = new Task("maintain", 32);
		ArrayList<TaskItem> subTask = new ArrayList<>();
		subTask.add(task1);
		subTask.add(task2);
		subTask.add(task3);
		subTask.add(task4);
		subTask.add(task5);
		subTask.add(task6);
		Project project = new Project("quan li diem", subTask);
		// tinh tong thoi gian du an
		System.out.println("total time: " + project.getTime());
		// tinh tong thoi gian du an sau khi bo task: maintain
		project.removeTask(task6);
		System.out.println("total time after remove maintain task: " + project.getTime());
	}
}
