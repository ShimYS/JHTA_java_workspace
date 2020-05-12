package network.simple;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
	
	public static void main(String[] args) throws Exception {
		// ServerSocket
		//  	Ŭ���̾�Ʈ�� �����û�� ��ٸ��� ��ü��.
		//		Ŭ���̾�Ʈ�� �����û�� �����Ǹ�, �ش� Ŭ�󸮾�Ʈ�� ������ ��ȯ�� ����ϴ� Socket������ ��ȯ 
		// 8000�� ��Ʈ�� ������ Ŭ���̾�Ʈ�� �����û�� ��ٸ��� �������� ����
		
		System.out.println("���� ���α׷� ���۵� ...");
		
		ServerSocket server = new ServerSocket(8000);
		
		System.out.println("Ŭ���̾�Ʈ�� �����û�� �����");
		// ���������� accept()�޼ҵ�� Ŭ���̾�Ʈ�� ������ �����Ǹ� ����Ǵ� �޼ҵ��.
		// Ŭ���̾�Ʈ�� �����û�� �����Ǹ� accept()�� ����ǰ�,
		// ������ ��û�� Ŭ���̾�Ʈ�� ������ ��ȯ�� �� Socket��ü�� �����ȴ�.
		Socket socket = server.accept();
		System.out.println("Ŭ���̾�Ʈ�� �����û�� ����...");
		
		// �а� ���� ��Ʈ�� ȸ��
		InputStream is = socket.getInputStream();
		OutputStream os = socket.getOutputStream();
		BufferedReader in = new BufferedReader(new InputStreamReader(is, "utf-8"));
		PrintWriter out = new PrintWriter(os, true);
		
		// �޼��� �����ϱ�
		String message = in.readLine();
		
		// Ŭ���ξ�Ʈ�� �޼��� ������
		out.println(message + "�� �ݰ����ϴ�.");
	}
}
