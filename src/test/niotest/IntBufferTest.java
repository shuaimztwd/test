package test.niotest;

import java.nio.IntBuffer;

public class IntBufferTest {

	public static void main(String[] args) {
		IntBuffer buf = IntBuffer.allocate(10);
		for (int i = 0; i < buf.capacity() - 1; i++) {
			buf.put(2 * i + 1);
		}
		out1(buf);
		out2(buf);
		buf.position(3);
		buf.limit(6);
		IntBuffer subBuf = buf.slice();
		// IntBuffer subBuf = buf.asReadOnlyBuffer();
		for (int i = 0; i < subBuf.capacity(); i++) {
			subBuf.put(subBuf.get(i) - 1);
		}
		buf.limit(buf.capacity());
		out2(buf);
	}

	private static void out1(IntBuffer buf) {
		buf.flip();
		while (buf.hasRemaining()) {
			System.out.print(buf.get() + "、");
		}
		System.out.println();
	}

	private static void out2(IntBuffer buf) {
		buf.limit(buf.capacity());
		for (int i = 0; i < buf.capacity(); i++) {
			System.out.print(buf.get(i) + "、");
		}
		System.out.println();
	}
}
