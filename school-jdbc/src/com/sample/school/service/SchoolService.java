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
	
	//��������
	public List<Subject> �а�������ȸ(int majorNo) throws SQLException {
		//�а���ȣ �����ϴ��� Ȯ��

		return subjectDAO.getSubjectByMajorNo(majorNo);
	}
	
	public boolean �а�������(Subject subject) throws SQLException {
		//����� �ߺ��˻�
		
		//�а���ȣ �����ϴ��� Ȯ��
		
		subjectDAO.addSubject(subject);
		return true;
	}
	
	public List<Course> ����������ȸ����(int majorNo) throws SQLException{
		
		
		return courseDAO.getCourseByMajorno(majorNo);
	}
	
	public Course ������������ȸ(int courseNo) throws SQLException {
		
		
		return courseDAO.getCourseDetail(courseNo);
	}
	
	
	public boolean ��������(Course course) throws SQLException {		
		return courseDAO.addCourse(course);
	}

	
	//�л�����
	public List<Course> ����������ȸ�л�(int studentNo) throws SQLException{
		
		
		return courseDAO.getCourseByStudentno(studentNo);
	}
	
	public boolean ������û(Request request) throws SQLException {
		// �������� �������� Ȯ�� 'N'�̸� ��û���� 'Y'�̸� �Ұ�
		Course course = courseDAO.getCourseDetail(request.getCourse().getNo());
		if(course.getStatus().equals("Y")) {
			return false;
		}
		
		requestDAO.addRequest(request);	
		
		// �������� �����ο��� ������Ű��
		course.setParticipants(course.getParticipants()+1);
		courseDAO.updateCourse(course);
		
		return true;
	}
	
	public boolean �������(int requestNo, int studentNo) throws SQLException {
		// �������� �������� Ȯ�� 'N'�̸� ��Ұ��� 'Y'�̸� ��ҺҰ�
		Request request = ������������ȸ(requestNo);
		Course course = courseDAO.getCourseDetail(request.getCourse().getNo());
		if(course.getStatus().equals("Y")) {
			return false;
		}
		
		requestDAO.deleteRequest(requestNo, studentNo);
		
		// �������� �����ο��� ���ҽ�Ű��
		course.setParticipants(course.getParticipants()-1);
		courseDAO.updateCourse(course);
		return true;
	}
	
	
	
	public Request ������������ȸ(int requestNo) throws SQLException {		
		return requestDAO.getRequestDetail(requestNo);
	}
}



















