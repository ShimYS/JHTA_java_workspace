package hr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;


public class Demo1 {
	
	public static void main(String[] args) throws Exception {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("����� �Է��ϼ���: ");
		String g = scanner.next();
		
		// 1. JDBC ����̹��� JVM�� ����̹� ������Ʈ���� ����ϱ�
		Class.forName("oracle.jdbc.OracleDriver"); // ������ Ŭ���� ������ �޸𸮿� �ε� ��Ų��.
												   // OracleDriver => ����Ŭ JDBC �ٽɵ���̹����� ��Ͻ�Ű�� ������ �Ѵ�.
		// 2. �����ͺ��̽��� ������ ����ϴ� Connection��ü ȹ���ϱ�
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // ����ǻ�� 1521����Ʈ��  �������� xe��� �ĺ��ڸ� �����Ϳ� jdbc����̹��� ������ ������ �õ��ض�
		String user = "hr";
		String password = "zxcv1234";
		Connection connection = DriverManager.getConnection(url, user, password); // Oracle Connection(�θ� Connection)�� ����
		
		// 3. SQL ����, �������ȯ�� ����ϴ� PreparedStatement��ü ȹ���ϱ�
		String sql = "select gra, lowest_sal, highest_sal from job_grades where gra = ?";  // ����ڷκ��� �Է¹��� ���� ? �� �ִ´�.   '%'||?||'%'
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, g);
		
		// 4. SQL �����ϰ�, ��ȸ��� ȹ��
		ResultSet rs = pstmt.executeQuery();
		
		// 5. ��ȸ��� ��������
		while(rs.next()) {
			String grade = rs.getString("gra");
			int min_sal = rs.getInt("lowest_sal");
			int max_sal = rs.getInt("highest_sal");
			
			System.out.println(grade + " " + min_sal + " " + max_sal);
		}
		
		// 6. �����ͺ��̽��� ����� ��� �ڿ� �����ϱ�, ȹ���� ������ �������� ����
		rs.close();
		pstmt.close();
		connection.close();
		
	}
}
