package com.sample.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import com.sample.bookstore.util.ConnectionUtil;
import com.sample.bookstore.vo.User;

public class UserDAO {
	public void addUser(User user) throws Exception {
		String sql = "insert into sample_book_users "
					+ "(user_id, user_password, user_name, user_email, user_point, user_registered_date) "
					+ "values "
					+ "(?, ?, ?, ?, ?, sysdate) ";
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, user.getId());
		pstmt.setString(2, user.getPassword());
		pstmt.setString(3, user.getName());
		pstmt.setString(4, user.getEmail());
		pstmt.setInt(5, user.getPoint());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
	
	public User getUserById(String userId) throws Exception {
		String sql = "select * "
				+ "from sample_book_users "
				+ "where user_id = ? ";
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql); 
		pstmt.setString(1, userId);
		
		ResultSet rs = pstmt.executeQuery();
		User user = new User();
		if(rs.next()) {
			user.setId(rs.getString("user_id"));
			user.setPassword(rs.getString("user_password"));
			user.setName(rs.getString("user_name"));
			user.setEmail(rs.getString("user_email"));
			user.setPoint(rs.getInt("user_point"));
			user.setDate(rs.getDate("user_registered_date"));
		}
		
		rs.close();
		pstmt.close();
		connection.close();
			
		return user;
	}
}















