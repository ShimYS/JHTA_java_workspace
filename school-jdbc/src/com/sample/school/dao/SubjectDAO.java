package com.sample.school.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sample.school.util.ConnectionUtil;
import com.sample.school.util.QueryUtil;
import com.sample.school.vo.Major;
import com.sample.school.vo.Subject;

public class SubjectDAO {
	
	public void addSubject(Subject subject) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("subject.addSubject"));
		pstmt.setString(1, subject.getName());
		pstmt.setInt(2, subject.getMajor().getNo());
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
	
	public List<Subject> getSubjectByMajorNo(int majorNo) throws SQLException {
		List<Subject> subjects = new ArrayList<Subject>();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("subject.getSubjectByMajorNo"));
		pstmt.setInt(1, majorNo);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			Subject subject = new Subject();
			subject.setNo(rs.getInt("subject_no"));
			subject.setName(rs.getString("subject_name"));
			subject.setDate(rs.getDate("subject_registered_date"));
			
			Major major = new Major();
			major.setNo(rs.getInt("major_no"));
			subject.setMajor(major);
			
			subjects.add(subject);
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		return subjects;
	}
}
