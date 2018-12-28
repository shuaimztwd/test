package test.synrunnable;

public class ThreadTest implements Runnable {

	private int ticket = 50;

	public ThreadTest() {
	}

	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			// sale();
			try {
				Thread.sleep(600);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " ticket = "
					+ i);
		}
	}

	private void sale() {
		if (this.ticket > 0) {
			// try {
			// Thread.sleep(300);
			// } catch (InterruptedException e) {
			// e.printStackTrace();
			// }
			System.out.println(Thread.currentThread().getName() + " ticket = "
					+ ticket--);
		}
	}
}
