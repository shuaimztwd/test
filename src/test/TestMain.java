package test;

public class TestMain {

	public static void main(String[] args) {
		String str = "A";
		long s = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			String str1 = (str + i).intern();
			System.out.println(str1);
		}
		long e = System.currentTimeMillis();
		System.gc();
		System.out.println((e - s) + "ms");
	}
}
