package com.sample.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sample.bookstore.util.ConnectionUtil;
import com.sample.bookstore.util.QueryUtil;
import com.sample.bookstore.vo.Order;
import com.sample.bookstore.vo.User;

public class UserDAO {
	public void addUser(User user) throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("user.addUser"));
		pstmt.setString(1, user.getId());
		pstmt.setString(2, user.getPassword());
		pstmt.setString(3, user.getName());
		pstmt.setString(4, user.getEmail());		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
	
	public User getUserById(String userId) throws Exception {		
		User user = null;
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("user.getUserById")); 
		pstmt.setString(1, userId);
		
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			user = resultSetToUser(rs);
		}	
		rs.close();
		pstmt.close();
		connection.close();
			
		return user;
	}
	
	public void updateUser(User user) throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("user.updateUser"));
		pstmt.setString(1, user.getPassword());
		pstmt.setString(2, user.getEmail());
		pstmt.setInt(3, user.getPoint());
		pstmt.setString(4, user.getId());
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
	
	public List<User> getUserByName(String userName) throws Exception {
		List<User> users = new ArrayList<User>();
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("user.getUserByName"));
		pstmt.setString(1, userName);
		
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			users.add(resultSetToUser(rs));
		}
		rs.close();
		pstmt.close();
		connection.close();
		
		return users;
	}
	
	public static User resultSetToUser(ResultSet rs) throws SQLException {
		User user = new User();
		user.setId(rs.getString("user_id"));
		user.setPassword(rs.getString("user_password"));
		user.setName(rs.getString("user_name"));
		user.setEmail(rs.getString("user_email"));
		user.setPoint(rs.getInt("user_point"));
		user.setDate(rs.getDate("user_registered_date"));
		return user;
	}
}















