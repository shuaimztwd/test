package test.threaddiff;

public class ThreadTest extends Thread {

	private int ticket = 5;

	public ThreadTest() {
	}

	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			if (this.ticket > 0) {
				System.out.println("ticket = " + ticket--);
			}
		}
	}
}
