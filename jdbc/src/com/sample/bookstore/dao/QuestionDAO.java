package com.sample.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sample.bookstore.util.ConnectionUtil;
import com.sample.bookstore.util.QueryUtil;
import com.sample.bookstore.vo.Question;
import com.sample.bookstore.vo.User;

public class QuestionDAO {

	public void addQuestion(Question question) throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("question.addQuestion"));

		pstmt.setString(1, question.getTitle());
		pstmt.setString(2, question.getUser().getId());
		pstmt.setString(3, question.getContent());
		pstmt.setString(4, question.getType());
		pstmt.executeUpdate();

		pstmt.close();
		connection.close();
	}

	public List<Question> getAllQuestion() throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("question.getAllQuestion"));

		ResultSet rs = pstmt.executeQuery();

		List<Question> questions = new ArrayList<Question>();
		while (rs.next()) {
			questions.add(resultSetToQuestion(rs));
		}
		rs.close();
		pstmt.close();
		connection.close();

		return questions;
	}

	public Question getQuestionByNo(int questionNo) throws Exception {
		Question question = null;

		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("question.getQuestionByNo"));
		pstmt.setInt(1, questionNo);
		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) {
			question = resultSetToQuestion(rs);
		}
		
		rs.close();
		pstmt.close();
		connection.close();

		return question;
	}

	public void removeQuestion(int questionNo, String userId) throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("question.removeQuestion"));
		pstmt.setInt(1, questionNo);
		pstmt.setString(2, userId);
		pstmt.executeUpdate();

		pstmt.close();
		connection.close();
	}
	
	public void updateQuestion(Question question) throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("question.updateQuestion"));
		pstmt.setString(1, question.getTitle());
		pstmt.setString(2, question.getContent());
		pstmt.setInt(3, question.getViewCount());
		pstmt.setString(4, question.getStatus());
		pstmt.setString(5, question.getType());
		pstmt.setInt(6, question.getNo());		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}

	public  Question resultSetToQuestion(ResultSet rs) throws Exception {
		Question question = new Question();
		question.setNo(rs.getInt("question_no"));
		question.setTitle(rs.getString("question_title"));
		question.setContent(rs.getString("question_content"));
		question.setType(rs.getString("question_type"));
		question.setStatus(rs.getString("question_status"));
		question.setRegisteredDate(rs.getDate("question_registered_date"));
		question.setViewCount(rs.getInt("question_view_count"));
		
		User user = new User();
		user.setId(rs.getString("user_id"));
		question.setUser(user);
		
		return question;
	}
	
	

}
