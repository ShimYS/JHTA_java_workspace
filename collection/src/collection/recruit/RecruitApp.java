package collection.recruit;

import java.util.Scanner;

import collection.recruit.vo.Career;
import collection.recruit.vo.Resume;
import colletion.recruit.service.RecruitmentService;

public class RecruitApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		RecruitmentService service = new RecruitmentService();
		
		while(true) {
			System.out.println("==============================");
			System.out.println("1.구직자2.인사담당자0.종료");
			System.out.println("==============================");
			
			System.out.print("메뉴를 선택하세요: ");
			int menuNo = scanner.nextInt();
			
			if(menuNo == 1) {
				System.out.println("=========================================================");
				System.out.println("1.이력서등록 2.경력사항등록 3.채용상태확인 4.이력서수정 5.구직신청삭제 6.경력사항수정/삭제 7.구직신청현황조회");
				System.out.println("=========================================================");
				
				System.out.print("구직자 메뉴를 선택하세요: ");
				int empMenuNo = scanner.nextInt();
				
				//이력서등록
				if(empMenuNo == 1) {
					// 이름, 전화번호, 지원부서를 입력받는다.
					System.out.println("[이력서 등록]");
					
					System.out.print("이름을 입력하세요: ");
					String name = scanner.next();
					System.out.print("전화번호를 입력하세요: ");
					String tel = scanner.next();
					System.out.print("지원부서를 입력하세요: ");
					String dept = scanner.next();
					
					Resume resume = new Resume();
					resume.setName(name);
					resume.setTel(tel);
					resume.setDept(dept);
					
					service.addNewResume(resume);
					System.out.println("### 이력서 등록이 완료되었습니다 ###");
					
				} else if(empMenuNo == 2) {
					// 재직회사명, 근무부서, 직위, 근무년수를 입력받는다.
					System.out.println("[경력사항 등록]");
					
					System.out.print("구직신청번호를 입력하세요: ");
					int recruitmentNo = scanner.nextInt();
					System.out.print("재직했던 회사명을 입력하세요: ");
					String companyName = scanner.next();
					System.out.print("근무했던 부서명을 입력하세요: ");
					String dept = scanner.next();
					System.out.print("최종 직급을 입력하세요: ");
					String position = scanner.next();
					System.out.print("근무기간(년단위)을 입력하세요: ");
					int year = scanner.nextInt();
					
					Career career = new Career();
					career.setCompanyName(companyName);
					career.setDept(dept);
					career.setPosition(position);
					career.setYear(year);
					
					service.addCareer(recruitmentNo, career);
					System.out.println("### 경력사항 등록이 완료되었습니다 ###");
					
				} else if(empMenuNo == 3) {
					// 구직신청번호를 입력받는다.
					System.out.println("[채용상태 확인]");
					System.out.print("구직신청번호를 입력하세요: ");
					int recruitmentNo = scanner.nextInt();
					
					service.printRecruitmentDetail(recruitmentNo);
					System.out.println("### 채용상태 확인이 완료되었습니다 ###");
					
				} else if(empMenuNo == 4) {
					// 구직신청번호, 이름, 전화번호, 지원부서를 입력받는다.
					System.out.println("[이력서 수정]");
					System.out.print("구직신청번호를 입력하세요: ");
					int recruitmentNo = scanner.nextInt();
					System.out.print("이름을 입력하세요: ");
					String name = scanner.next();
					System.out.print("전화번호를 입력하세요: ");
					String tel = scanner.next();
					System.out.print("지원부서를 입력하세요: ");
					String dept = scanner.next();
					
					Resume resume = new Resume();
					resume.setName(name);
					resume.setTel(tel);
					resume.setDept(dept);
					
					service.updateResume(recruitmentNo, resume);
					System.out.println("### 이력서 수정이 완료되었습니다 ###");
					
				} else if(empMenuNo == 5) {
					// 구직신청번호를 입력받는다.
					System.out.println("[구직신청 취소]");
					System.out.print("구직신청번호를 입력하세요: ");
					int recruitmentNo = scanner.nextInt();
					
					service.deleteRecruitment(recruitmentNo);
					System.out.println("### 구직신청 취소가 완료되었습니다 ###");
					
				} else if(empMenuNo == 6) {
					System.out.println("[경력사항 수정/삭제");
					System.out.print("구직신청번호를 입력하세요: ");
					int recruitmentNo = scanner.nextInt();
					System.out.print("회사명을 입력하세요: ");
					String companyName = scanner.next();
					
					service.updateCareer(recruitmentNo, companyName);
					System.out.println("### 경력사항 수정/삭제가 완료되었습니다 ###");
								
				} else if(empMenuNo == 7) {
					System.out.println("[구직신청 현황 조회]");
					System.out.print("구직신청번호를 입력하세요: ");
					int recruitmentNo = scanner.nextInt();
					
					service.printRecruitmentByDeptYear(recruitmentNo);
					System.out.println("### 구직신청 현황 조회가 완료되었습니다 ###");
					
				}
				
			} else if(menuNo == 2) {
				System.out.println("=========================================================");
				System.out.println("1.채용신청서 조회2.채용신청서 상세조회3.채용신청서 심사");
				System.out.println("=========================================================");
				
				System.out.print("인사담당자 메뉴를 선택하세요: ");
				int managerMenuNo = scanner.nextInt();
				
				if(managerMenuNo == 1) {
					// 입력값 없음
					System.out.println("[채용신청서 조회]");
					
					service.printAllRecruitment();
					System.out.println("### 채용신청서 조회가 완료되었습니다 ###");
					
				} else if(managerMenuNo == 2) {
					// 구직신청번호를 입력받는다.
					System.out.println("[채용신청서 상세조회]");
					System.out.print("구직신청번호를 입력하세요: ");
					int recruitmentNo = scanner.nextInt();
					
					service.printRecruitmentDetail(recruitmentNo);
					System.out.println("### 채용신청서 상세조회가 완료되었습니다 ###");
					
				} else if(managerMenuNo == 3) {
					// 구직신청번호와 합격불합격여부를 Y/N으로 입력받는다.
					System.out.println("[채용신청서 심사]");
					System.out.print("구직신청번호를 입력하세요: ");
					int recruitmentNo = scanner.nextInt();
					System.out.print("합격여부(Y, N)를 입력하세요: ");
					String result = scanner.next();
					
					service.checkRecruitment(recruitmentNo, result);
					System.out.println("### 채용신청서 심사가 완료되었습니다 ###");
					
				}
				
			} else if(menuNo == 0) {
				System.out.println("[프로그램을 종료합니다]");
				break;
			}
			System.out.println();
		}
		scanner.close();
	}

}
