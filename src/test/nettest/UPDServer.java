package test.nettest;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UPDServer {

	public static void main(String[] args) throws IOException {
		String str = "hello world";
		DatagramPacket dp = new DatagramPacket(str.getBytes(), str.length(),
				InetAddress.getByName("localhost"), 9000);
		DatagramSocket ds = new DatagramSocket(3000);
		ds.send(dp);
		ds.close();
	}
}
