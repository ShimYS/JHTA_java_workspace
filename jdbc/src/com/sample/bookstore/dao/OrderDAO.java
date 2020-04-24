package com.sample.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sample.bookstore.util.ConnectionUtil;
import com.sample.bookstore.vo.Order;

public class OrderDAO {
	
	public void addOrder(Order order) throws SQLException {
		String sql = "insert into sample_book_order " 
				+ "(order_no, user_id, book_no, order_price, order_amount, order_registered_date)" 
				+ "values" 
				+ "(sample_order_seq.nextval, ?, ?, ?, ?, sysdate)";
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, order.getUserId());
		pstmt.setInt(2, order.getBookNo());
		pstmt.setInt(3, order.getPrice());
		pstmt.setInt(4, order.getAmount());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
	
	public List<Order> getrOrderByUserId(String userId) throws SQLException{
		List<Order> orders = new ArrayList<Order>();
		
		String sql = "select * "
					+ "from sample_book_order "
					+ "where user_id = ?";
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, userId);
		
		ResultSet rs = pstmt.executeQuery();		
		while(rs.next()) {
			Order order = new Order();
			order.setNo(rs.getInt("order_no"));
			order.setUserId(rs.getString("user_id"));
			order.setBookNo(rs.getInt("book_no"));
			order.setPrice(rs.getInt("order_price"));
			order.setAmount(rs.getInt("order_amount"));
			order.setDate(rs.getDate("order_registered_date"));
			orders.add(order);
		}
		rs.close();
		pstmt.close();
		connection.close();
		
		return orders;
	}
	
	public Order getOrderByNo(int orderNo) throws Exception {
		
		String sql = "select * "
					+ "from sample_book_order "
					+ "where order_no = ? ";
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, orderNo);
		
		ResultSet rs = pstmt.executeQuery();
		
		Order order = new Order();
		if(rs.next()) {
			order.setNo(rs.getInt("order_no"));
			order.setUserId(rs.getString("user_id"));
			order.setBookNo(rs.getInt("book_no"));
			order.setPrice(rs.getInt("order_price"));
			order.setAmount(rs.getInt("order_amount"));
			order.setDate(rs.getDate("order_registered_date"));
		}		
		rs.close();
		pstmt.close();
		connection.close();
		
		return order;
	}
	
}
