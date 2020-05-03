package com.sample.school.service;

import java.sql.SQLException;
import java.util.List;

import com.sample.school.dao.CourseDAO;
import com.sample.school.dao.MajorDAO;
import com.sample.school.dao.ProfessorDAO;
import com.sample.school.dao.RequestDAO;
import com.sample.school.dao.StudentDAO;
import com.sample.school.dao.SubjectDAO;
import com.sample.school.vo.Course;
import com.sample.school.vo.Major;
import com.sample.school.vo.Request;
import com.sample.school.vo.Subject;

public class SchoolService {

	CourseDAO courseDAO = new CourseDAO();
	ProfessorDAO professorDAO = new ProfessorDAO();
	RequestDAO requestDAO = new RequestDAO();
	StudentDAO studentDAO = new StudentDAO();
	SubjectDAO subjectDAO = new SubjectDAO();
	MajorDAO majorDAO = new MajorDAO();
	
	//교수서비스
	public List<Subject> 학과과목조회(int majorNo) throws SQLException {
		//학과번호 존재하는지 확인

		return subjectDAO.getSubjectByMajorNo(majorNo);
	}
	
	public boolean 학과과목등록(Subject subject) throws SQLException {
		//과목명 중복검사
		
		//학과번호 존재하는지 확인
		
		subjectDAO.addSubject(subject);
		return true;
	}
	
	public List<Course> 개설과정조회교수(int majorNo) throws SQLException{
		
		
		return courseDAO.getCourseByMajorno(majorNo);
	}
	
	public Course 개설과정상세조회(int courseNo) throws SQLException {
		
		
		return courseDAO.getCourseDetail(courseNo);
	}
	
	
	public boolean 과정개설(Course course) throws SQLException {		
		return courseDAO.addCourse(course);
	}

	
	//학생서비스
	public List<Course> 개설과정조회학생(int studentNo) throws SQLException{
		
		
		return courseDAO.getCourseByStudentno(studentNo);
	}
	
	public boolean 수강신청(Request request) throws SQLException {
		// 개설과정 마감여부 확인 'N'이면 신청가능 'Y'이면 불가
		Course course = courseDAO.getCourseDetail(request.getCourse().getNo());
		if(course.getStatus().equals("Y")) {
			return false;
		}
		
		requestDAO.addRequest(request);	
		
		// 개설과정 수강인원수 증가시키기
		course.setParticipants(course.getParticipants()+1);
		courseDAO.updateCourse(course);
		
		return true;
	}
	
	public boolean 수강취소(int requestNo, int studentNo) throws SQLException {
		// 개설과정 마감여부 확인 'N'이면 취소가능 'Y'이면 취소불가
		Request request = 수강내역상세조회(requestNo);
		Course course = courseDAO.getCourseDetail(request.getCourse().getNo());
		if(course.getStatus().equals("Y")) {
			return false;
		}
		
		requestDAO.deleteRequest(requestNo, studentNo);
		
		// 개설과정 수강인원수 감소시키기
		course.setParticipants(course.getParticipants()-1);
		courseDAO.updateCourse(course);
		return true;
	}
	
	
	
	public Request 수강내역상세조회(int requestNo) throws SQLException {		
		return requestDAO.getRequestDetail(requestNo);
	}
}



















