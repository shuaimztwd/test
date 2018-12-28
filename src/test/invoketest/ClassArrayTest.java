package test.invoketest;

import java.lang.reflect.Array;

public class ClassArrayTest {

	public static void main(String[] args) {
		// test1();
		test2();

		int[][] temp = { { 1, 2 } };
		Class<?> c = temp.getClass();
		System.out.println(c.getTypeName());
		System.out.println(c.getName());

		String[][] temp1 = { { "a", "b" } };
		Class<?> c1 = temp1.getClass();
		System.out.println(c1.getTypeName());
		System.out.println(c1.getName());
	}

	public static void test2() {
		int[] arr1 = { 1, 2, 3 };
		int[] arr2 = (int[]) arrayInc(arr1, 5);
		print(arr2);
		String[] strArr = { "a", "b", "c" };
		String[] newStrArr = (String[]) arrayInc(strArr, 8);
		print(newStrArr);
	}

	private static Object arrayInc(Object obj, int len) {
		Class<?> c = obj.getClass().getComponentType();
		Object newArr = Array.newInstance(c, len);
		int coLen = Array.getLength(obj);
		System.arraycopy(obj, 0, newArr, 0, coLen);
		return newArr;
	}

	private static void print(Object obj) {
		Class<?> c = obj.getClass();
		if (!c.isArray()) {
			return;
		}
		int len = Array.getLength(obj);
		System.out.println(c.getComponentType().getName() + "长度" + len);
		for (int i = 0; i < len; i++) {
			System.out.println(Array.get(obj, i));
		}
	}

	private static void test1() {
		int[] arr = { 1, 2, 3 };
		Class<?> c = arr.getClass().getComponentType();
		System.out.println("类型：" + c.getName());
		System.out.println("长度：" + Array.getLength(arr));
		System.out.println("取得第一个：" + Array.get(arr, 0));
		Array.set(arr, 0, 4);
		System.out.println("取得第一个：" + Array.get(arr, 0));
		Object newArr = Array.newInstance(c, 5);
		System.arraycopy(arr, 0, newArr, 0, 3);
		System.out.println(newArr);
	}
}
