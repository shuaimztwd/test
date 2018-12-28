package test.datainout;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class DataOutputStreamDemo {
	public static void main(String args[]) throws Exception { // �����쳣�׳�
		DataOutputStream dos = null; // �����������������
		File f = new File("d:" + File.separator + "order.txt"); // �ļ��ı���·��
		dos = new DataOutputStream(new FileOutputStream(f)); // ʵ�����������������
		String names[] = { "����", "����", "Χ��" }; // ��Ʒ����
		float prices[] = { 98.3f, 30.3f, 50.5f }; // ��Ʒ�۸�
		int nums[] = { 3, 2, 1 }; // ��Ʒ����
		for (int i = 0; i < names.length; i++) { // ѭ�����
			dos.writeChars(names[i]); // д���ַ���
			dos.writeChar('\t'); // д��ָ���
			dos.writeFloat(prices[i]); // д��۸�
			dos.writeChar('\t'); // д��ָ���
			dos.writeInt(nums[i]); // д������
			dos.writeChar('\n'); // ����
		}
		dos.close(); // �ر������
	}
};