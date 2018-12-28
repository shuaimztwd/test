package test.runnable;

public class ThreadTest implements Runnable {

	private String name;

	public ThreadTest(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			System.out.println("i=" + i + "：" + name);
		}
	}
}
