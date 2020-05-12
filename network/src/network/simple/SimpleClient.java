package network.simple;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class SimpleClient {

	public static void main(String[] args) throws Exception {
		// Socket
		//		Ŭ���̾�Ʈ�� �������� ������ ��ȯ�� ����ϴ� ��ü��
		//		��ü ������ ������ ip�ּҿ� �ش� ������ ����ϴ� ��Ʈ��ȣ�� �����ؾ� �Ѵ�.
		
		System.out.println("Ŭ���̾�Ʈ ���α׷� ���۵� ...");
		// 192.168.10.65�� ��ǻ���� 80�� ��Ʈ�� ����ϴ� ���� ���α׷��� �����û �޽����� ������.
		Socket socket = new Socket("192.168.10.65", 8000);
		System.out.println("192.168.10.65�� 8000�� ��Ʈ���� �������� ������ �����û�� ����...");
		
		// �б�, ���� ��Ʈ�� ȹ���ϱ�
		OutputStream os = socket.getOutputStream(); //���ڷ� �ۿ� ������
		InputStream is = socket.getInputStream();
		
		// �ؽ�Ʈ �����͸� �����ϱ� ���ؼ� PrintWriter�� BufferedReader�� ����
		PrintWriter out = new PrintWriter(os, true); //Writer�迭�� stream���� �ؽ�Ʈ ��ü�� �а� ���� ����, ���߿��� printwriter�� ����ϸ� �ٹٲ� ���ڰ� �� ���� ���ԵǼ� ���޵Ǳ� �����̴�.(������ ������)
		BufferedReader in = new BufferedReader(new InputStreamReader(is, "utf-8")); // bufferedReader�� �ٹٲ� ���� �ٷ� �ձ��� �о���ϼ� �ֱ⿡(������ �б�)
		
		// ������ �޼��� ������
		out.println("�ɿ���");
		
		// �޼��� �����ϱ�
		String message = in.readLine();
		System.out.println("���Ÿ޼���: " + message);

	}

}
