package test.invoketest;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InvokeSetGetTest {

	public static void main(String[] args) throws Exception {
		// test1();
		test2();
	}

	public static void test2() throws ClassNotFoundException,
			NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException,
			InstantiationException, NoSuchFieldException {
		Class<?> c1 = Class.forName("test.invoketest.Person");
		Object obj = c1.newInstance();
		Field nameField = c1.getDeclaredField("name");
		nameField.setAccessible(true);
		nameField.set(obj, "张三");
		System.out.println(nameField.get(obj));

		Field ageField = c1.getDeclaredField("age");
		ageField.setAccessible(true);
		ageField.set(obj, 30);
		System.out.println(ageField.get(obj));
	}

	public static void test1() throws ClassNotFoundException,
			NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException,
			InstantiationException {
		Class<?> c1 = Class.forName("test.invoketest.Person");
		Object obj = c1.newInstance();
		setter(obj, "name", "张三", String.class);
		System.out.println(getter(obj, "name"));

		setter(obj, "age", 30, int.class);
		System.out.println(getter(obj, "age"));
	}

	private static Object getter(Object obj, String attr)
			throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		String methodName = "get" + firstUpperCase(attr);
		Method m1 = obj.getClass().getMethod(methodName);
		return m1.invoke(obj);
	}

	private static void setter(Object obj, String attr, Object value,
			Class<?> type) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		String methodName = "set" + firstUpperCase(attr);
		Method m1 = obj.getClass().getMethod(methodName, type);
		m1.invoke(obj, value);
	}

	private static String firstUpperCase(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}
}
