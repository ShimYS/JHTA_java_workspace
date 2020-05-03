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
			System.out.println("1.교수  2.학생  0.종료");
			System.out.println("-------------------------------------------------");
			
			System.out.print("메뉴를 선택하세요: ");
			int menuNo = KeyboardUtil.nextInt();
			
			if(menuNo == 1) {
				System.out.println("[교수통합서비스]");
				System.out.println("-------------------------------------------------");
				System.out.println("1.학과과목조회  2.학과과목등록  3.개설과정조회  4.과정상세조회  5.과정등록");
				System.out.println("-------------------------------------------------");
				
				System.out.print("메뉴를 선택하세요: ");
				int professorMenuNo = KeyboardUtil.nextInt();
				
				if(professorMenuNo==1) {
					System.out.println("[학과과목조회]");
					
					System.out.println("학과번호를 입력하세요.");
					int majorNo = KeyboardUtil.nextInt();
					
					List<Subject> subjects = service.학과과목조회(majorNo);
					if(subjects.isEmpty()) {
						System.out.println("학과번호 "+majorNo+"와 일치하는 과목정보가 존재하지 않습니다.");
					} else {
						System.out.println("과목번호\t과목이름\t학과번호\t과목등록날짜");
						for(Subject subject : subjects) {
							System.out.print(subject.getNo()+"\t");
							System.out.print(subject.getName()+"\t");
							System.out.print(subject.getMajor().getNo()+"\t");
							System.out.println(subject.getDate());
						}
						System.out.println("##### 학과과목조회를 완료했습니다 #####");
					}
					
				} else if(professorMenuNo==2) {
					System.out.println("[학과과목등록]");
					
					System.out.println("소속학과 번호를 입력하세요.");
					int majorNo = KeyboardUtil.nextInt();
					System.out.println("과목명을 입력하세요.");
					String subjectName = KeyboardUtil.nextString();
					
					Subject subject = new Subject();
					subject.setName(subjectName);
					
					Major major = new Major();
					major.setNo(majorNo);
					subject.setMajor(major);
					
					boolean isSuccess = service.학과과목등록(subject);
					if(isSuccess) {
						System.out.println("##### 과목등록을 완료했습니다 #####");
					} else {
						System.out.println("과목등록에 실패했습니다.");
					}
					
				} else if(professorMenuNo==3) {
					System.out.println("[개설과정조회]");
					
					System.out.println("소속학과 번호를 입력하세요.");
					int majorNo = KeyboardUtil.nextInt();
					
					List<Course> courses = service.개설과정조회교수(majorNo);
					if(courses.isEmpty()) {
						System.out.println("학과번호 "+majorNo+"와 일치하는 개설과정이 존재하지 않습니다.");
					} else {
						System.out.println("과정번호\t과정이름\t학과번호\t교수번호\t수강인원");
						for(Course course : courses) {
							System.out.print(course.getNo()+"\t");
							System.out.print(course.getName()+"\t");
							System.out.print(course.getMajor().getNo()+"\t");
							System.out.print(course.getProfessor().getNo()+"\t");
							System.out.println(course.getParticipants());
						}
						System.out.println("##### 개설과정 조회를 완료했습니다 #####");
					}
					
				} else if(professorMenuNo==4) {
					System.out.println("[개설과정상세조회]");
					
					System.out.println("개설과정 번호를 입력하세요.");
					int courseNo = KeyboardUtil.nextInt();
					
					Course course = service.개설과정상세조회(courseNo);
					if(course != null) {
						System.out.println("=====================");				
						System.out.println("과정번호: "+course.getNo());
						System.out.println("과정이름: "+course.getName());
						System.out.println("학과번호: "+course.getMajor().getNo());
						System.out.println("과목번호: "+course.getSubject().getNo());
						System.out.println("교수번호: "+course.getProfessor().getNo());
						System.out.println("수강인원: "+course.getParticipants());
						System.out.println("마감여부: "+course.getStatus());
						System.out.println("등록날짜: "+course.getDate());
						System.out.println("=====================");
						System.out.println("##### 개설과정 조회를 완료했습니다 #####");
					} else {
						System.out.println("개설과정이 존재하지 않습니다.");
					}
					
				} else if(professorMenuNo==5) {
					System.out.println("[과정개설]");
					
					System.out.println("과정명을 입력하세요.");
					String courseName = KeyboardUtil.nextString();
					System.out.println("소속학과 번호를 입력하세요.");
					int majorNo = KeyboardUtil.nextInt();
					System.out.println("과목 번호를 입력하세요.");
					int subjectNo = KeyboardUtil.nextInt();
					System.out.println("담당교수 번호를 입력하세요.");
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
					
					boolean isSuccess = service.과정개설(course);
					if(isSuccess) {
						System.out.println("##### 신규 과정 개설을 완료했습니다 #####");
					} else {
						System.out.println("과정개설에 실패했습니다.");
					}
				}
				
			} else if(menuNo == 2) {
				System.out.println("[학생통합서비스]");
				System.out.println("-------------------------------------------------");
				System.out.println("1.개설과정조회  2.수강신청  3.수강취소  4.수강내역상세조회");
				System.out.println("-------------------------------------------------");
				
				System.out.print("메뉴를 선택하세요: ");
				int studentMenuNo = KeyboardUtil.nextInt();
				
				if(studentMenuNo==1) {
					System.out.println("[개설과정조회]");
					
					System.out.println("학생번호를 입력하세요.");
					int studentNo = KeyboardUtil.nextInt();
					
					List<Course> courses = service.개설과정조회학생(studentNo);
					if(courses.isEmpty()) {
						System.out.println("학과번호 "+studentNo+"와 일치하는 개설과정이 존재하지 않습니다.");
					} else {
						System.out.println("과정번호\t과정이름\t학과번호\t교수번호\t수강인원");
						for(Course course : courses) {
							System.out.print(course.getNo()+"\t");
							System.out.print(course.getName()+"\t");
							System.out.print(course.getMajor().getNo()+"\t");
							System.out.print(course.getProfessor().getNo()+"\t");
							System.out.println(course.getParticipants());
						}
						System.out.println("##### 개설과정 조회를 완료했습니다 #####");
					}
					
				} else if(studentMenuNo==2) {
					System.out.println("[수강신청]");
					
					System.out.println("개설과정 번호를 입력하세요.");
					int courseNo = KeyboardUtil.nextInt();
					System.out.println("학생번호를 입력하세요.");
					int studentNo = KeyboardUtil.nextInt();
					
					Request request = new Request();
					
					Course course = new Course();
					course.setNo(courseNo);					
					request.setCourse(course);

					Student student = new Student();
					student.setNo(studentNo);
					request.setStudent(student);
					
					boolean isSuccess = service.수강신청(request);
					if(isSuccess) {
						System.out.println("##### 수강신청을 완료했습니다 #####");
					} else {
						System.out.println("수강신청에 실패했습니다.");
					}
					
				} else if(studentMenuNo==3) {
					System.out.println("[수강취소]");
					
					System.out.println("수강신청 번호를 입력하세요.");
					int requestNo = KeyboardUtil.nextInt();
					System.out.println("학생번호를 입력하세요.");
					int studentNo = KeyboardUtil.nextInt();
					
					boolean isSuccess = service.수강취소(requestNo, studentNo);
					if(isSuccess) {
						System.out.println("##### 수강취소를 완료했습니다 #####");
					} else {
						System.out.println("수강취소에 실패했습니다.");
					}
					
				} else if(studentMenuNo==4) {
					System.out.println("[수강내역 상세조회]");
					
					System.out.println("수강신청 번호를 입력하세요.");
					int requestNo = KeyboardUtil.nextInt();
					
					Request request = service.수강내역상세조회(requestNo);
					if(request != null) {
						System.out.println("=====================");				
						System.out.println("수강번호: "+request.getNo());
						System.out.println("과정번호: "+request.getCourse().getNo());
						System.out.println("학생번호: "+request.getStudent().getNo());
						System.out.println("마감여부: "+request.getStatus());
						System.out.println("패스여부: "+request.getPass());
						System.out.println("점      수: "+request.getScore());
						System.out.println("등록날짜: "+request.getDate());
						System.out.println("=====================");
						System.out.println("##### 수강내역 상세조회를 완료했습니다 #####");
						
					} else {
						System.out.println("수강신청번호 "+requestNo+"와 일치하는 수강내역이 존재하지 않습니다.");			
					}					
				} 

			} else if(menuNo == 0) {
				System.out.println("##### 프로그램을 종료합니다 #####");
				break;
			}
			
			System.out.println();
			System.out.println();
			System.out.println();
		}

	}

}
