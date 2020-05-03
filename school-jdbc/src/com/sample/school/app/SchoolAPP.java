package com.sample.school.app;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.sample.school.service.SchoolService;
import com.sample.school.util.KeyboardUtil;
import com.sample.school.vo.Course;
import com.sample.school.vo.Major;
import com.sample.school.vo.Professor;
import com.sample.school.vo.Request;
import com.sample.school.vo.Student;
import com.sample.school.vo.Subject;

public class SchoolAPP {

	public static void main(String[] args) throws NumberFormatException, IOException, SQLException {
		
		SchoolService service = new SchoolService();
		
		while(true) {
			System.out.println("-------------------------------------------------");
			System.out.println("1.����  2.�л�  0.����");
			System.out.println("-------------------------------------------------");
			
			System.out.print("�޴��� �����ϼ���: ");
			int menuNo = KeyboardUtil.nextInt();
			
			if(menuNo == 1) {
				System.out.println("[�������ռ���]");
				System.out.println("-------------------------------------------------");
				System.out.println("1.�а�������ȸ  2.�а�������  3.����������ȸ  4.��������ȸ  5.�������");
				System.out.println("-------------------------------------------------");
				
				System.out.print("�޴��� �����ϼ���: ");
				int professorMenuNo = KeyboardUtil.nextInt();
				
				if(professorMenuNo==1) {
					System.out.println("[�а�������ȸ]");
					
					System.out.println("�а���ȣ�� �Է��ϼ���.");
					int majorNo = KeyboardUtil.nextInt();
					
					List<Subject> subjects = service.�а�������ȸ(majorNo);
					if(subjects.isEmpty()) {
						System.out.println("�а���ȣ "+majorNo+"�� ��ġ�ϴ� ���������� �������� �ʽ��ϴ�.");
					} else {
						System.out.println("�����ȣ\t�����̸�\t�а���ȣ\t�����ϳ�¥");
						for(Subject subject : subjects) {
							System.out.print(subject.getNo()+"\t");
							System.out.print(subject.getName()+"\t");
							System.out.print(subject.getMajor().getNo()+"\t");
							System.out.println(subject.getDate());
						}
						System.out.println("##### �а�������ȸ�� �Ϸ��߽��ϴ� #####");
					}
					
				} else if(professorMenuNo==2) {
					System.out.println("[�а�������]");
					
					System.out.println("�Ҽ��а� ��ȣ�� �Է��ϼ���.");
					int majorNo = KeyboardUtil.nextInt();
					System.out.println("������� �Է��ϼ���.");
					String subjectName = KeyboardUtil.nextString();
					
					Subject subject = new Subject();
					subject.setName(subjectName);
					
					Major major = new Major();
					major.setNo(majorNo);
					subject.setMajor(major);
					
					boolean isSuccess = service.�а�������(subject);
					if(isSuccess) {
						System.out.println("##### �������� �Ϸ��߽��ϴ� #####");
					} else {
						System.out.println("�����Ͽ� �����߽��ϴ�.");
					}
					
				} else if(professorMenuNo==3) {
					System.out.println("[����������ȸ]");
					
					System.out.println("�Ҽ��а� ��ȣ�� �Է��ϼ���.");
					int majorNo = KeyboardUtil.nextInt();
					
					List<Course> courses = service.����������ȸ����(majorNo);
					if(courses.isEmpty()) {
						System.out.println("�а���ȣ "+majorNo+"�� ��ġ�ϴ� ���������� �������� �ʽ��ϴ�.");
					} else {
						System.out.println("������ȣ\t�����̸�\t�а���ȣ\t������ȣ\t�����ο�");
						for(Course course : courses) {
							System.out.print(course.getNo()+"\t");
							System.out.print(course.getName()+"\t");
							System.out.print(course.getMajor().getNo()+"\t");
							System.out.print(course.getProfessor().getNo()+"\t");
							System.out.println(course.getParticipants());
						}
						System.out.println("##### �������� ��ȸ�� �Ϸ��߽��ϴ� #####");
					}
					
				} else if(professorMenuNo==4) {
					System.out.println("[������������ȸ]");
					
					System.out.println("�������� ��ȣ�� �Է��ϼ���.");
					int courseNo = KeyboardUtil.nextInt();
					
					Course course = service.������������ȸ(courseNo);
					if(course != null) {
						System.out.println("=====================");				
						System.out.println("������ȣ: "+course.getNo());
						System.out.println("�����̸�: "+course.getName());
						System.out.println("�а���ȣ: "+course.getMajor().getNo());
						System.out.println("�����ȣ: "+course.getSubject().getNo());
						System.out.println("������ȣ: "+course.getProfessor().getNo());
						System.out.println("�����ο�: "+course.getParticipants());
						System.out.println("��������: "+course.getStatus());
						System.out.println("��ϳ�¥: "+course.getDate());
						System.out.println("=====================");
						System.out.println("##### �������� ��ȸ�� �Ϸ��߽��ϴ� #####");
					} else {
						System.out.println("���������� �������� �ʽ��ϴ�.");
					}
					
				} else if(professorMenuNo==5) {
					System.out.println("[��������]");
					
					System.out.println("�������� �Է��ϼ���.");
					String courseName = KeyboardUtil.nextString();
					System.out.println("�Ҽ��а� ��ȣ�� �Է��ϼ���.");
					int majorNo = KeyboardUtil.nextInt();
					System.out.println("���� ��ȣ�� �Է��ϼ���.");
					int subjectNo = KeyboardUtil.nextInt();
					System.out.println("��米�� ��ȣ�� �Է��ϼ���.");
					int professorNo = KeyboardUtil.nextInt();

					Course course = new Course();
					course.setName(courseName);
					
					Major major = new Major();
					major.setNo(majorNo);
					course.setMajor(major);
					
					Subject subject = new Subject();
					subject.setNo(subjectNo);
					course.setSubject(subject);
					
					Professor professor = new Professor();
					professor.setNo(professorNo);
					course.setProfessor(professor);
					
					boolean isSuccess = service.��������(course);
					if(isSuccess) {
						System.out.println("##### �ű� ���� ������ �Ϸ��߽��ϴ� #####");
					} else {
						System.out.println("���������� �����߽��ϴ�.");
					}
				}
				
			} else if(menuNo == 2) {
				System.out.println("[�л����ռ���]");
				System.out.println("-------------------------------------------------");
				System.out.println("1.����������ȸ  2.������û  3.�������  4.������������ȸ");
				System.out.println("-------------------------------------------------");
				
				System.out.print("�޴��� �����ϼ���: ");
				int studentMenuNo = KeyboardUtil.nextInt();
				
				if(studentMenuNo==1) {
					System.out.println("[����������ȸ]");
					
					System.out.println("�л���ȣ�� �Է��ϼ���.");
					int studentNo = KeyboardUtil.nextInt();
					
					List<Course> courses = service.����������ȸ�л�(studentNo);
					if(courses.isEmpty()) {
						System.out.println("�а���ȣ "+studentNo+"�� ��ġ�ϴ� ���������� �������� �ʽ��ϴ�.");
					} else {
						System.out.println("������ȣ\t�����̸�\t�а���ȣ\t������ȣ\t�����ο�");
						for(Course course : courses) {
							System.out.print(course.getNo()+"\t");
							System.out.print(course.getName()+"\t");
							System.out.print(course.getMajor().getNo()+"\t");
							System.out.print(course.getProfessor().getNo()+"\t");
							System.out.println(course.getParticipants());
						}
						System.out.println("##### �������� ��ȸ�� �Ϸ��߽��ϴ� #####");
					}
					
				} else if(studentMenuNo==2) {
					System.out.println("[������û]");
					
					System.out.println("�������� ��ȣ�� �Է��ϼ���.");
					int courseNo = KeyboardUtil.nextInt();
					System.out.println("�л���ȣ�� �Է��ϼ���.");
					int studentNo = KeyboardUtil.nextInt();
					
					Request request = new Request();
					
					Course course = new Course();
					course.setNo(courseNo);					
					request.setCourse(course);

					Student student = new Student();
					student.setNo(studentNo);
					request.setStudent(student);
					
					boolean isSuccess = service.������û(request);
					if(isSuccess) {
						System.out.println("##### ������û�� �Ϸ��߽��ϴ� #####");
					} else {
						System.out.println("������û�� �����߽��ϴ�.");
					}
					
				} else if(studentMenuNo==3) {
					System.out.println("[�������]");
					
					System.out.println("������û ��ȣ�� �Է��ϼ���.");
					int requestNo = KeyboardUtil.nextInt();
					System.out.println("�л���ȣ�� �Է��ϼ���.");
					int studentNo = KeyboardUtil.nextInt();
					
					boolean isSuccess = service.�������(requestNo, studentNo);
					if(isSuccess) {
						System.out.println("##### ������Ҹ� �Ϸ��߽��ϴ� #####");
					} else {
						System.out.println("������ҿ� �����߽��ϴ�.");
					}
					
				} else if(studentMenuNo==4) {
					System.out.println("[�������� ����ȸ]");
					
					System.out.println("������û ��ȣ�� �Է��ϼ���.");
					int requestNo = KeyboardUtil.nextInt();
					
					Request request = service.������������ȸ(requestNo);
					if(request != null) {
						System.out.println("=====================");				
						System.out.println("������ȣ: "+request.getNo());
						System.out.println("������ȣ: "+request.getCourse().getNo());
						System.out.println("�л���ȣ: "+request.getStudent().getNo());
						System.out.println("��������: "+request.getStatus());
						System.out.println("�н�����: "+request.getPass());
						System.out.println("��      ��: "+request.getScore());
						System.out.println("��ϳ�¥: "+request.getDate());
						System.out.println("=====================");
						System.out.println("##### �������� ����ȸ�� �Ϸ��߽��ϴ� #####");
						
					} else {
						System.out.println("������û��ȣ "+requestNo+"�� ��ġ�ϴ� ���������� �������� �ʽ��ϴ�.");			
					}					
				} 

			} else if(menuNo == 0) {
				System.out.println("##### ���α׷��� �����մϴ� #####");
				break;
			}
			
			System.out.println();
			System.out.println();
			System.out.println();
		}

	}

}
