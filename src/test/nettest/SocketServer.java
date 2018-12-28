package test.nettest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

class SocketServerThread implements Runnable {

	private Socket client;

	public SocketServerThread(Socket client) {
		this.client = client;
	}

	@Override
	public void run() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(
					client.getInputStream()));
			PrintStream print = new PrintStream(client.getOutputStream());
			boolean flag = true;
			while (flag) {
				String str = br.readLine();
				if (str == null || "".equals(str) || "bye".equals(str)) {
					flag = false;
				} else {
					System.out.println("接收到Client端数据：" + str);
					print.println("ECHO：" + str);
				}
			}
			br.close();
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

public class SocketServer {

	public static void main(String[] args) throws IOException {
		ServerSocket serv = new ServerSocket(8888);
		boolean f = true;
		while (f) {
			System.out.println("**********Server准备接收**********");
			Socket client = serv.accept();
			new Thread(new SocketServerThread(client)).start();
		}
		serv.close();
		System.out.println("**********Server关闭**********");
	}
}
