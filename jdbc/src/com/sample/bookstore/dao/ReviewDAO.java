package com.sample.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.sample.bookstore.util.ConnectionUtil;
import com.sample.bookstore.util.QueryUtil;
import com.sample.bookstore.vo.Review;

public class ReviewDAO {
	
	public void addReview(Review review) throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("book.addReview"));
		pstmt.setString(1, review.getContent());
		pstmt.setDouble(2, review.getPoint());
		pstmt.setInt(3, review.getBook().getNo());
		pstmt.setString(4, review.getUser().getId());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
}
