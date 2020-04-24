package com.sample.bookstore.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * �����ͺ��̽��� ������ ����ϴ� Connection ��ü�� �����ϴ� ��ƿŬ������.
 * @author ShimYS
 *
 */
public class ConnectionUtil {
	
	// ����ƽ �ʱ�ȭ ��� => �޸𸮰� �ε��ɋ� �� �ѹ��� ���� => getConnection�� ����ɶ� �����Ѵ�.
	/**
	 * Ŭ���� �ε��� JDBC ����̹��� JVM�� ����̹� ������Ʈ���� ����Ѵ�.
	 */
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * �����ͺ��̽��� ����� ���ο� Connection�� ��ȯ�Ѵ�.
	 * @return �����ͺ��̽� ����, SQL ���ۿ� �ʿ��� Connection ��ü
	 * @throws SQLException �����ͺ��̽� url, �������� ���� �ùٸ��� ���� ��� �߻��ȴ�.
	 */
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "zxcv1234";
		
		Connection connection = DriverManager.getConnection(url, user, password);
		return connection;
	}
	
	
	
}
