package hr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;


public class Demo1 {
	
	public static void main(String[] args) throws Exception {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("등급을 입력하세요: ");
		String g = scanner.next();
		
		// 1. JDBC 드라이버를 JVM의 드라이버 레지스트리에 등록하기
		Class.forName("oracle.jdbc.OracleDriver"); // 지정된 클래스 파일을 메모리에 로딩 시킨다.
												   // OracleDriver => 오라클 JDBC 핵심드라이버들을 등록시키는 역할을 한다.
		// 2. 데이터베이스와 연결을 담당하는 Connection객체 획득하기
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 내컴퓨터 1521번포트에  구동준인 xe라는 식별자를 가진것에 jdbc드라이버를 가지고 연결을 시도해라
		String user = "hr";
		String password = "zxcv1234";
		Connection connection = DriverManager.getConnection(url, user, password); // Oracle Connection(부모가 Connection)을 얻음
		
		// 3. SQL 실행, 결과값반환을 담당하는 PreparedStatement객체 획득하기
		String sql = "select gra, lowest_sal, highest_sal from job_grades where gra = ?";  // 사용자로부터 입력받을 값은 ? 를 넣는다.   '%'||?||'%'
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, g);
		
		// 4. SQL 실행하고, 조회결과 획득
		ResultSet rs = pstmt.executeQuery();
		
		// 5. 조회결과 가져오기
		while(rs.next()) {
			String grade = rs.getString("gra");
			int min_sal = rs.getInt("lowest_sal");
			int max_sal = rs.getInt("highest_sal");
			
			System.out.println(grade + " " + min_sal + " " + max_sal);
		}
		
		// 6. 데이터베이스와 연결된 모든 자원 해제하기, 획득한 순서의 역순으로 해제
		rs.close();
		pstmt.close();
		connection.close();
		
	}
}
