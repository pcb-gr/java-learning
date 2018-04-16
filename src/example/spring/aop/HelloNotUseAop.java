package example.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloNotUseAop {
	public void method1() {
		System.out.println("+++++++++++++++++++++++++++++++");
		System.out.println("method 1");
	}

	public void method2() {
		System.out.println("+++++++++++++++++++++++++++++++");
		System.out.println("method 2");
	}

	public void method3() {
		System.out.println("+++++++++++++++++++++++++++++++");
		System.out.println("method 3");
		throw new IllegalArgumentException();
	}

	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloNotUseAop hello = (HelloNotUseAop) context.getBean("helloNotUseAop");
		hello.method1();
		hello.method2();
	}
}
