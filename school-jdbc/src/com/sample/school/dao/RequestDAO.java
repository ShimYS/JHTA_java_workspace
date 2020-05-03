package com.sample.school.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sample.school.util.ConnectionUtil;
import com.sample.school.util.QueryUtil;
import com.sample.school.vo.Course;
import com.sample.school.vo.Request;
import com.sample.school.vo.Student;

public class RequestDAO {
	
	public void addRequest(Request request) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("request.addRequest"));
		pstmt.setInt(1, request.getCourse().getNo());
		pstmt.setInt(2, request.getStudent().getNo());
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
	
	public void deleteRequest(int requestNo, int studentNo) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("request.removeRequest"));
		pstmt.setInt(1, requestNo);
		pstmt.setInt(2, studentNo);
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
	
	public Request getRequestDetail(int requestNo) throws SQLException {
		Request request = new Request();
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("request.getRequestDetail"));
		pstmt.setInt(1, requestNo);
		
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			request.setNo(rs.getInt("request_no"));
			request.setStatus(rs.getString("request_status"));
			request.setPass(rs.getString("request_pass"));
			request.setScore(rs.getInt("request_score"));
			request.setDate(rs.getDate("request_registered_date"));
			
			Course course = new Course();
			course.setNo(rs.getInt("course_no"));
			request.setCourse(course);
			
			Student student = new Student();
			student.setNo(rs.getInt("student_no"));
			request.setStudent(student);						
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return request;
	}
}
