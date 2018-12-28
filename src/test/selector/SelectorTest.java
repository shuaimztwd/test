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

public class SelectorTest {

	public static void main(String[] args) throws Exception {
		int[] ports = { 8000, 8001, 8002 };
		// 打开Selector
		Selector selector = Selector.open();
		for (int i = 0; i < ports.length; i++) {
			// 打开服务器通道
			ServerSocketChannel server = ServerSocketChannel.open();
			// 设置为非阻塞
			server.configureBlocking(false);
			// 取得套接字
			ServerSocket socket = server.socket();
			// 绑定地址
			socket.bind(new InetSocketAddress(ports[i]));
			// 注册
			server.register(selector, SelectionKey.OP_ACCEPT);
			System.out.println("开始监听端口" + ports[i]);
		}

		while (selector.select() > 0) {
			// 循环取得key
			Set<SelectionKey> keys = selector.selectedKeys();
			Iterator<SelectionKey> iter = keys.iterator();
			while (iter.hasNext()) {
				// 判断key是否是可接受的
				SelectionKey key = iter.next();
				if (key.isAcceptable()) {
					// 取得服务器操作的通道
					ServerSocketChannel server = (ServerSocketChannel) key
							.channel();
					// 取得套接字操作的通道
					SocketChannel client = server.accept();
					// 接收数据
					ByteBuffer inBuf = ByteBuffer.allocateDirect(1024);
					int len = client.read(inBuf);
					byte[] data = new byte[len];
					inBuf.flip();
					inBuf.get(data, 0, len);
					System.out.println("接收数据：" + new String(data));

					// 返回数据
					ByteBuffer outBuf = ByteBuffer
							.wrap(("返回数据：\n当前时间为 " + new Date().getTime())
									.getBytes());
					// outBuf.flip(); // 使用wrap不需要调用此方法
					client.write(outBuf);
					Thread.sleep(10);
					client.close();
				}
			}
			// 清空keyset
			keys.clear();
		}
	}
}
