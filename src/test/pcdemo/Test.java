package test.pcdemo;

public class Test {

	public static void main(String[] args) {
		Info info = new Info("张三", "zhangsan");
		Producer p = new Producer(info);
		Consumer c = new Consumer(info);
		new Thread(p).start();
		new Thread(c).start();
	}

}
