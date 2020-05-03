package com.sample.school.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sample.school.util.ConnectionUtil;
import com.sample.school.util.QueryUtil;
import com.sample.school.vo.Course;
import com.sample.school.vo.Major;
import com.sample.school.vo.Professor;
import com.sample.school.vo.Subject;

public class CourseDAO {
	
	public List<Course> getCourseByMajorno(int majorNo) throws SQLException {
		List<Course> courses = new ArrayList<Course>();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("course.getCourseByMajorNo"));
		pstmt.setInt(1, majorNo);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {

			Course course = new Course();
			course.setNo(rs.getInt("course_no"));
			course.setName(rs.getString("course_name"));
			course.setParticipants(rs.getInt("course_participants"));
			course.setStatus(rs.getString("course_status"));
			course.setDate(rs.getDate("course_registered_date"));
			
			Major major = new Major();
			major.setNo(rs.getInt("major_no"));
			course.setMajor(major);
			
			Subject subject = new Subject();
			subject.setNo(rs.getInt("subject_no"));
			course.setSubject(subject);
			
			Professor professor = new Professor();
			professor.setNo(rs.getInt("professor_no"));
			course.setProfessor(professor);
			courses.add(course);
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		return courses;
	}
	
	public List<Course> getCourseByStudentno(int studentNo) throws SQLException{
		List<Course> courses = new ArrayList<Course>();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("course.getCourseByStudentNo"));
		pstmt.setInt(1, studentNo);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {

			Course course = new Course();
			course.setNo(rs.getInt("course_no"));
			course.setName(rs.getString("course_name"));
			course.setParticipants(rs.getInt("course_participants"));
			course.setStatus(rs.getString("course_status"));
			course.setDate(rs.getDate("course_registered_date"));
			
			Major major = new Major();
			major.setNo(rs.getInt("major_no"));
			course.setMajor(major);
			
			Subject subject = new Subject();
			subject.setNo(rs.getInt("subject_no"));
			course.setSubject(subject);
			
			Professor professor = new Professor();
			professor.setNo(rs.getInt("professor_no"));
			course.setProfessor(professor);
			courses.add(course);
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		return courses;
	}
	
	public Course getCourseDetail(int courseNo) throws SQLException {
		Course course = new Course();
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("course.getCourseDetail"));
		pstmt.setInt(1, courseNo);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			course.setNo(rs.getInt("course_no"));
			course.setName(rs.getString("course_name"));
			course.setParticipants(rs.getInt("course_participants"));
			course.setStatus(rs.getString("course_status"));
			course.setDate(rs.getDate("course_registered_date"));
			
			Major major = new Major();
			major.setNo(rs.getInt("major_no"));
			course.setMajor(major);
			
			Subject subject = new Subject();
			subject.setNo(rs.getInt("subject_no"));
			course.setSubject(subject);
			
			Professor professor = new Professor();
			professor.setNo(rs.getInt("professor_no"));
			course.setProfessor(professor);
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return course;
	}
	
	public boolean addCourse (Course course) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("course.addCourse"));
		pstmt.setString(1, course.getName());
		pstmt.setInt(2, course.getMajor().getNo());
		pstmt.setInt(3, course.getSubject().getNo());
		pstmt.setInt(4, course.getProfessor().getNo());
		pstmt.executeUpdate();		
		return true;
	}
	
	public void updateCourse(Course course) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("course.updateCourse"));
		pstmt.setString(1, course.getName());
		pstmt.setInt(2, course.getMajor().getNo());
		pstmt.setInt(3, course.getSubject().getNo());
		pstmt.setInt(4, course.getProfessor().getNo());
		pstmt.setInt(5, course.getParticipants());
		pstmt.setString(6, course.getStatus());
		pstmt.setInt(7, course.getNo());
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
	
}
