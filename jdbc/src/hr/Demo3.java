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
		System.out.println("[도서 검색하기]");		
		System.out.println("제목을 입력하세요: ");
		String keyword = nextString();
		
		Class.forName("oracle.jdbc.OracleDriver");
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";	//thin까지는 항상 고정. 뒷 부분은 데이터베이스, 컴퓨터마다 다를 수 있음
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
			
			System.out.println(no +", "+ title +", "+ writer +", "+ genre +", "+ publisher +", "+ price +"원, "+ discountPrice +"원");
//			System.out.println("------------------");
//			System.out.println("번      호: " + no);
//			System.out.println("제      목: " + title);
//			System.out.println("저      자: " + writer);
//			System.out.println("장      르: " + genre);
//			System.out.println("출 판 사 : " + publisher);
//			System.out.println("가      격: " + price);
//			System.out.println("할인가격: " + discountPrice);
//			System.out.println("등 록 일 : " + date);
//			System.out.println("------------------");
		}
		
		pstmt.close();
		connection.close();
		
	}

}
