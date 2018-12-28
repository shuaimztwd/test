package test.invoketest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InvokeTest {

	public static void main(String[] args) throws Exception {
		test1();
		test2();
	}

	public static void test2() throws ClassNotFoundException,
			NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException,
			InstantiationException {
		Class<?> c1 = Class.forName("test.invoketest.Person");
		Method m1 = c1.getMethod("sayHello", String.class, int.class);
		System.out.println(m1.invoke(c1.newInstance(), "张三", 30));
	}

	public static void test1() throws ClassNotFoundException,
			NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException,
			InstantiationException {
		Class<?> c1 = Class.forName("test.invoketest.Person");
		Method m1 = c1.getMethod("sayChina");
		m1.invoke(c1.newInstance());
	}
}
