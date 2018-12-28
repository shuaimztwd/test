package test.pipedstream;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

class Send implements Runnable {

	private PipedOutputStream pos = null;

	public Send() {
		this.pos = new PipedOutputStream();
	}

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		try {
			pos.write("hello world".getBytes());
			pos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the pos
	 */
	public PipedOutputStream getPos() {
		return pos;
	}

}

class Receive implements Runnable {

	private PipedInputStream pis;

	public Receive() {
		this.pis = new PipedInputStream();
	}

	@Override
	public void run() {
		byte[] b = new byte[1024];
		try {
			int len = pis.read(b);
			System.out.println(new String(b, 0, len));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the pis
	 */
	public PipedInputStream getPis() {
		return pis;
	}

}

public class PipedTest {

	public static void main(String[] args) throws IOException {
		Send send = new Send();
		Receive receive = new Receive();
		send.getPos().connect(receive.getPis());
		new Thread(send).start();
		new Thread(receive).start();
	}
}
