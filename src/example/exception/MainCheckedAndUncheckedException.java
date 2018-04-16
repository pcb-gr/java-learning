package example.exception;

import java.io.FileReader;
import java.io.IOException;

public class MainCheckedAndUncheckedException {

	public static void main(String[] args) {
		MainCheckedAndUncheckedException obj = new MainCheckedAndUncheckedException();

		try {
			obj.testCallChecked(); //This code won't compile because it can throw a checked exception.
		} catch (IOException e) {
			e.printStackTrace();
		} 
		obj.testCallUnChecked();
	}

	
	public void testCallChecked() throws IOException{
		 methodThrowsCheckedIOException(); //This code won't compile because it can throw a checked exception.
	}

	public void testCallUnChecked() {
		methodThrowsUnCheckedRuntimeException();
	}
	
	public void methodThrowsUnCheckedRuntimeException(){
		throw new RuntimeException("methodThrowsUnCheckedRuntimeException");
	}
	
	public void methodThrowsCheckedIOException() throws IOException{
		try {
			new FileReader("C:\\testing.txt");
		} catch (IOException e) {
			 e.printStackTrace();
			 throw new IOException("methodThrowsCheckedIOException");
		}
		//new FileReader("C:\\testing.txt");
		
	}
}