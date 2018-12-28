package test.nettest;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UPDClient {

	public static void main(String[] args) throws IOException {
		byte[] b = new byte[1024];
		DatagramPacket dp = new DatagramPacket(b, 1024);
		DatagramSocket ds = new DatagramSocket(9000);
		ds.receive(dp);
		String str = new String(dp.getData(), 0, dp.getLength()) + " from "
				+ dp.getAddress().getHostAddress() + ":" + dp.getPort();
		System.out.println(str);
		ds.close();
	}
}
