package hr;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Demo3 {
	Scanner scanner = new Scanner(System.in);
	
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
	
	private static String nextString() throws Exception {
		return reader.readLine();
	}
	public static void main(String[] args) throws Exception {		
		System.out.println("[���� �˻��ϱ�]");		
		System.out.println("������ �Է��ϼ���: ");
		String keyword = nextString();
		
		Class.forName("oracle.jdbc.OracleDriver");
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";	//thin������ �׻� ����. �� �κ��� �����ͺ��̽�, ��ǻ�͸��� �ٸ� �� ����
		String user = "hr";
		String password = "zxcv1234";		
		Connection connection = DriverManager.getConnection(url, user, password);
		
		String sql = "select * "
				+ "from sample_books "
				+ "where book_title like '%' || ? || '%' "
				+ "order by book_no desc ";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, keyword);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			int no = rs.getInt("book_no");
			String title = rs.getString("book_title");		
			String writer = rs.getString("book_writer");		 	
			String genre = rs.getString("book_genre");			
			String publisher = rs.getString("book_publisher");			
			int price = rs.getInt("book_price");
			int discountPrice =  rs.getInt("book_discount_price");
			Date date = rs.getDate("book_registered_date");
			
			System.out.println(no +", "+ title +", "+ writer +", "+ genre +", "+ publisher +", "+ price +"��, "+ discountPrice +"��");
//			System.out.println("------------------");
//			System.out.println("��      ȣ: " + no);
//			System.out.println("��      ��: " + title);
//			System.out.println("��      ��: " + writer);
//			System.out.println("��      ��: " + genre);
//			System.out.println("�� �� �� : " + publisher);
//			System.out.println("��      ��: " + price);
//			System.out.println("���ΰ���: " + discountPrice);
//			System.out.println("�� �� �� : " + date);
//			System.out.println("------------------");
		}
		
		pstmt.close();
		connection.close();
		
	}

}
