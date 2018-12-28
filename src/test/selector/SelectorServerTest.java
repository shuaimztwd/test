package test.selector;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public class SelectorServerTest {

	public static void main(String[] args) throws Exception {
		int[] ports = { 8000, 8001, 8002 };
		Selector selector = Selector.open(); // 打开Selector
		for (int i = 0; i < ports.length; i++) { // 循环监听端口
			ServerSocketChannel server = ServerSocketChannel.open(); // 打开服务器通道
			server.configureBlocking(false); // 设置为非阻塞
			ServerSocket socket = server.socket(); // 获取套接字
			InetSocketAddress address = new InetSocketAddress(ports[i]); // 绑定地址
			socket.bind(address);
			server.register(selector, SelectionKey.OP_ACCEPT);
			System.out.println("开始监听" + ports[i] + "端口");
		}

		while (selector.select() > 0) {
			Set<SelectionKey> keys = selector.selectedKeys();
			Iterator<SelectionKey> it = keys.iterator();
			while (it.hasNext()) {
				SelectionKey key = it.next(); // 获取操作key
				if (key.isAcceptable()) {
					ServerSocketChannel server = (ServerSocketChannel) key
							.channel(); // 获取key相关的通道
					SocketChannel client = server.accept(); // 获取套接字
					ByteBuffer dst = ByteBuffer.allocateDirect(1024);
					int len = client.read(dst);
					dst.flip();
					byte[] data = new byte[len];
					dst.get(data, 0, len);
					System.out.println("接收到：" + new String(data));
					ByteBuffer buf = ByteBuffer.allocateDirect(1024);
					buf.put(("当前时间是：" + new Date()).getBytes());
					buf.flip();
					client.write(buf);
					Thread.sleep(1);
					client.close();
				}
			}
			keys.clear();
		}
	}
}
