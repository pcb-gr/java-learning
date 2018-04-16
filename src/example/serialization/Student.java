package example.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Student implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void main(String[] args) throws Exception {
		// Create Student object
		Student student = new Student();
		student.setName("Jeff");

		// Use FileOutputStream to save the Student object into a file
		try (FileOutputStream fos = new FileOutputStream("F:\\student.txt");
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			oos.writeObject(student);
		} catch (IOException i) {
			i.printStackTrace();
		}
		
		student = null;
		 
		try ( FileInputStream fos = new FileInputStream("F:\\student.txt");
			  ObjectInputStream oos = new ObjectInputStream(fos); ) {
			student = (Student) oos.readObject();
		} catch (IOException i) {
			i.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
 
		System.out.println(student.getName());
	}
}
