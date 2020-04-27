package com.sample.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.sample.bookstore.util.ConnectionUtil;
import com.sample.bookstore.util.QueryUtil;
import com.sample.bookstore.vo.Answer;

public class AnswerDAO {
	public void addAnswer(Answer answer) throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("answer.addAnswer"));
		pstmt.setString(1, answer.getContent());
		pstmt.setInt(2, answer.getQuestionNo());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
	
	public Answer getAnswer(int questionNo) {
		return null;
	}
}
