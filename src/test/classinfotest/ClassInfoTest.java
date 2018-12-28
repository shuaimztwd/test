package test.classinfotest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ClassInfoTest {

	public static void main(String[] args) throws ClassNotFoundException {
		// test1();
		// test2();
		// test3();
		test4();
		test5();
	}

	private static void test5() throws ClassNotFoundException {
		Class<?> c1 = null;
		c1 = Class.forName("test.classinfotest.Person");
		Field[] f = c1.getFields();
		for (int i = 0; i < f.length; i++) {
			// System.out.print("方法：" + m[i]);
			System.out.print("属性：" + Modifier.toString(f[i].getModifiers())
					+ " ");
			System.out.print(f[i].getType().getTypeName() + " ");
			System.out.println(f[i].getName());
		}
	}

	private static void test4() throws ClassNotFoundException {
		Class<?> c1 = null;
		c1 = Class.forName("test.classinfotest.Person");
		Field[] f = c1.getDeclaredFields();
		for (int i = 0; i < f.length; i++) {
			// System.out.print("方法：" + m[i]);
			System.out.print("属性：" + Modifier.toString(f[i].getModifiers())
					+ " ");
			System.out.print(f[i].getType().getTypeName() + " ");
			System.out.println(f[i].getName());
		}
	}

	private static void test3() throws ClassNotFoundException {
		Class<?> c1 = null;
		c1 = Class.forName("test.classinfotest.Person");
		Method[] m = c1.getMethods();
		for (int i = 0; i < m.length; i++) {
			// System.out.print("方法：" + m[i]);
			System.out.print("方法：" + Modifier.toString(m[i].getModifiers())
					+ " ");
			System.out.print(m[i].getReturnType().getName() + " ");
			System.out.print(m[i].getName());
			System.out.print("(");
			Class<?>[] p = m[i].getParameterTypes();
			for (int j = 0; j < p.length; j++) {
				if (j > 0) {
					System.out.print("，");
				}
				System.out.print(p[j].getTypeName() + " arg" + j);
			}
			System.out.print(")");
			Class<?>[] ex = m[i].getExceptionTypes();
			if (ex.length > 0) {
				System.out.print(" throws ");
				for (int k = 0; k < ex.length; k++) {
					System.out.print(ex[k].getTypeName());
				}
			}
			System.out.println("{} ");
		}
	}

	private static void test2() throws ClassNotFoundException {
		Class<?> c1 = null;
		c1 = Class.forName("test.classinfotest.Person");
		Method[] m = c1.getDeclaredMethods();
		for (int i = 0; i < m.length; i++) {
			// System.out.print("方法：" + m[i]);
			System.out.print("方法：" + Modifier.toString(m[i].getModifiers())
					+ " ");
			System.out.print(m[i].getReturnType().getName() + " ");
			System.out.print(m[i].getName());
			System.out.print("(");
			Class<?>[] p = m[i].getParameterTypes();
			for (int j = 0; j < p.length; j++) {
				if (j > 0) {
					System.out.print("，");
				}
				System.out.print(p[j].getTypeName() + " arg" + j);
			}
			System.out.println("){}");
		}
	}

	private static void test1() throws ClassNotFoundException {
		Class<?> c1 = null;
		c1 = Class.forName("test.classinfotest.Person");
		Class<?>[] c = c1.getInterfaces();
		for (int i = 0; i < c.length; i++) {
			System.out.println("接口：" + c[i].getName());
		}
		Class<?> s = c1.getSuperclass();
		System.out.println("父类：" + s.getName());

		Constructor<?>[] cons = c1.getConstructors();
		for (int i = 0; i < cons.length; i++) {
			System.out.print("构造方法：" + cons[i]);
			System.out.print("、单取：" + Modifier.toString(cons[i].getModifiers())
					+ " ");
			System.out.print(cons[i].getName());
			System.out.print("(");
			Class<?>[] p = cons[i].getParameterTypes();
			for (int j = 0; j < p.length; j++) {
				if (j > 0) {
					System.out.print("，");
				}
				System.out.print(p[j].getTypeName() + " arg" + j);
			}
			System.out.println("){}");
		}
	}

}
