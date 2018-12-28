package test.runnablediff;

public class Test {

	public static void main(String[] args) {
		ThreadTest t1 = new ThreadTest();
		new Thread(t1).start();
		new Thread(t1).start();
		new Thread(t1).start();
	}
}
