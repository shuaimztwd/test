package test.thread;

public class Test {

	public static void main(String[] args) {
		ThreadTest t1 = new ThreadTest("aaa");
		ThreadTest t2 = new ThreadTest("bbb");
		t1.start();
		t2.start();
	}
}
