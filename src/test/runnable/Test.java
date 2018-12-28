package test.runnable;

public class Test {

	public static void main(String[] args) {
		ThreadTest t1 = new ThreadTest("aaa");
		ThreadTest t2 = new ThreadTest("bbb");
		new Thread(t1).start();
		new Thread(t2).start();
	}

}
