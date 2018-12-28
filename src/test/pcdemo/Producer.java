package test.pcdemo;

public class Producer implements Runnable {

	private Info info = null;

	public Producer(Info info) {
		this.info = info;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			if (i % 2 == 1) {
				this.info.set("张三", "zhangsan");
			} else {
				this.info.set("李四", "lisi");
			}
		}
	}

}
