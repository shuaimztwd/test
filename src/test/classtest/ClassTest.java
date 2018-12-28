package test.classtest;

class X {

}

public class ClassTest {

	public static void main(String[] args) throws ClassNotFoundException {
		test1();

	}

	private static void test1() throws ClassNotFoundException {
		X x = new X();
		System.out.println(x.getClass().getName());

		Class<?> c1 = Class.forName("test.classtest.X");
		Class<?> c2 = new X().getClass();
		Class<X> c3 = X.class;

		System.out.println(c1.getName());
		System.out.println(c2.getName());
		System.out.println(c3.getName());
	}
}
