package hr;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Demo2 {
	Scanner scanner = new Scanner(System.in);
	
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
	
	private static String nextString() throws Exception {
		return reader.readLine();
	}
	
	private static int nextInt() throws Exception {
		return Integer.parseInt(reader.readLine());
	}

	public static void main(String[] args) throws Exception {
		
		System.out.println("[å ����ϱ�]");
		
		System.out.print("������ �Է��ϼ���: ");
		String title = nextString();
		System.out.print("���ڸ� �Է��ϼ���: ");
		String writer = nextString();
		System.out.print("�帣�� �Է��ϼ���: ");
		String genre = nextString();
		System.out.print("���ǻ縦 �Է��ϼ���: ");
		String publisher = nextString();
		System.out.print("������ �Է��ϼ���: ");
		int price = nextInt();
		System.out.print("���ΰ����� �Է��ϼ���: ");
		int discountPrice = nextInt();
		
		//jdbc driver �ε�
		Class.forName("oracle.jdbc.OracleDriver");	
		
		// Connection ��ü ȹ��
		String url = "jdbc:oracle:thin:@localhost:1521:xe";	//thin������ �׻� ����. �� �κ��� �����ͺ��̽�, ��ǻ�͸��� �ٸ� �� ����
		String user = "hr";
		String password = "zxcv1234";		
		Connection connection = DriverManager.getConnection(url, user, password);
		
		// PreparedStatement ��ü ȹ��
		String sql = "insert into sample_books "
				+ "(book_no, book_title, book_writer, book_genre, book_publisher, book_price, book_discount_price, book_registered_date)"
				+ "values"
				+ "(sample_book_seq.nextval, ?, ?, ?, ?, ?, ?, sysdate)";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, title);
		pstmt.setString(2, writer);
		pstmt.setString(3, genre);
		pstmt.setString(4, publisher);
		pstmt.setInt(5,  price);
		pstmt.setInt(6,  discountPrice);
		
		// SQL �����ϰ� ��ȸ��� ȹ��
		int count = pstmt.executeUpdate();
		System.out.println("["+count+"]���� å�� ��ϵǾ����ϴ�.");
		
		// ���ҽ� �ݳ�
		pstmt.close();
		connection.close();
	}

}
