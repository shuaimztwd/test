package test.socketchannel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class SocketServerChannel {

	public static void main(String[] args) throws IOException {
		int[] ports = { 8000, 8001, 8002 };
		Selector selector = Selector.open();
		for (int i = 0; i < ports[i]; i++) {
			ServerSocketChannel server = ServerSocketChannel.open();
			server.configureBlocking(false);
			ServerSocket socket = server.socket();
			socket.bind(new InetSocketAddress(ports[i]));
			server.register(selector, SelectionKey.OP_ACCEPT);
			System.out.println("" + ports[i]);
		}

		while (selector.select() > 0) {
			Set<SelectionKey> set = selector.selectedKeys();
			Iterator<SelectionKey> iter = set.iterator();
			while (iter.hasNext()) {
				SelectionKey key = iter.next();
				if (key.isAcceptable()) {
					ServerSocketChannel server = (ServerSocketChannel) key
							.channel();
					SocketChannel client = server.accept();
					ByteBuffer buf = ByteBuffer.allocateDirect(1024);
					buf.put("".getBytes());
					buf.flip();
					client.write(buf);
				}
			}
			set.clear();
		}
	}
}
