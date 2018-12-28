package test.synrunnable;

public class Test {

	public static void main(String[] args) {
		ThreadTest t = new ThreadTest();
		Thread t1 = new Thread(t, "票贩子-A");
		Thread t2 = new Thread(t, "票贩子-B");
		Thread t3 = new Thread(t, "票贩子-C");
		t1.setPriority(Thread.NORM_PRIORITY);
		t2.setPriority(Thread.MIN_PRIORITY);
		t3.setPriority(Thread.MAX_PRIORITY);
		t1.start();
		t2.start();
		t3.start();
	}
}
