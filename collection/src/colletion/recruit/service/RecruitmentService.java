package colletion.recruit.service;

import java.util.ArrayList;
import java.util.Scanner;

import collection.recruit.repo.RecruitmentRepository;
import collection.recruit.vo.Career;
import collection.recruit.vo.Recruitment;
import collection.recruit.vo.Resume;

public class RecruitmentService {
	Scanner scanner = new Scanner(System.in);
	private RecruitmentRepository repo = new RecruitmentRepository();

	// 이력서 등록기능
	public void addNewResume(Resume resume) {
		// 구직신청객체 생성
		// 구직신청객체에 전달받은 이력서 객체 저장
		// 레포지토리객체를 사용해서 db에 저장하고, 자신의 구직선청번호를 출력한다.
		// 구직신청번호를 반환한다.
		Recruitment recruitment = new Recruitment();
		recruitment.setResume(resume);
		repo.addRecruitment(recruitment);
		System.out.println("구직신청번호: "+recruitment.getNo());
	}

	// 경력사항 등록기능
	public void addCareer(int recruitmentNo, Career career) {
		// 레포지토리에서 구직신청번호에 해당하는 구직신청객체를 조회한다.
		// 구직신청객체의 경력사항에 전달받은 경력사항객체를 추가한다.
		Recruitment recruitment = repo.getRecruitmentByNo(recruitmentNo);
		if(recruitment == null) {
			System.out.println(recruitmentNo + "와 일치하는 구직신청서가 없습니다.");
		}
		recruitment.addCareer(career);		
//		ArrayList<Career> careers = new ArrayList<Career>();
//		careers.add(career);
	}

	// 구직신청 상태 조회 기능
	public void printRecruitmentDetail(int recruitmentNo) {
		// 레포지토리에서 구직신청번호에 해당하는 구직신청객체를 조회해서 화면에 출력한다.
		Recruitment recruitment = repo.getRecruitmentByNo(recruitmentNo);
		if(recruitment == null) {
			System.out.println(recruitmentNo + "와 일치하는 구직신청서가 없습니다.");
		}
		
		System.out.println("구직신청번호: " + recruitment.getNo());
		System.out.println("구직자 이름: " + recruitment.getResume().getName());
		System.out.println("전화번호: " + recruitment.getResume().getTel());
		System.out.println("지원부서: " + recruitment.getResume().getDept());
		ArrayList<Career> careers = recruitment.getCareers();
		for(Career career : careers) {
			System.out.println("재직했던 회사명: " + career.getCompanyName());
			System.out.println("근무했던 부서명: " + career.getDept());
			System.out.println("최종직급: " + career.getPosition());
			System.out.println("근무기간: " + career.getYear());
		}
		System.out.println("합격여부: " + recruitment.isPassed());
		
	}

	// 이력서 수정 기능
	public void updateResume(int recruitmentNo, Resume resume) {
		// 레포지토리에서 구직신청번호에 해당하는 구직신청객체를 조회한다.
		// 구직신청객체의 이력서정보를 전달받은 이력서 정보로 교체한다.
		Recruitment recruitment = repo.getRecruitmentByNo(recruitmentNo);
		if(recruitment == null) {
			System.out.println(recruitmentNo + "와 일치하는 구직신청서가 없습니다.");
		}
		
		recruitment.getResume().setName(resume.getName());
		recruitment.getResume().setTel(resume.getTel());
		recruitment.getResume().setDept(resume.getDept());
	}
	
	// 경력사항 수정/삭제 기능
	public void updateCareer(int recruitmentNo, String companyName) {
		Career result = null;
		Recruitment recruitment = repo.getRecruitmentByNo(recruitmentNo);
		if(recruitment == null) {
			System.out.println(recruitmentNo + "와 일치하는 구직신청서가 없습니다.");
		}
		
		ArrayList<Career> careers = recruitment.getCareers();
		for(Career career : careers) {
			if(companyName.equals(career.getCompanyName())) {
				result = career;
				System.out.println("재직했던 회사명\t근무했던 부서명\t최종직급\t근무기간");
				System.out.print(career.getCompanyName()+"\t");
				System.out.print(career.getDept()+"\t");
				System.out.print(career.getPosition()+"\t");
				System.out.println(career.getYear());
				break;
			}
		}
		
		System.out.println("1.수정 2.삭제");
		int careerMenuNo = scanner.nextInt();
		if(careerMenuNo == 1) {
			System.out.print("재직했던 회사명을 입력하세요: ");
			String companyName2 = scanner.next();
			System.out.print("근무했던 부서명을 입력하세요: ");
			String dept = scanner.next();
			System.out.print("최종 직급을 입력하세요: ");
			String position = scanner.next();
			System.out.print("근무기간(년단위)을 입력하세요: ");
			int year = scanner.nextInt();
			
			result.setCompanyName(companyName2);
			result.setDept(dept);
			result.setPosition(position);
			result.setYear(year);
						
		} else if(careerMenuNo == 2) {
			careers.remove(result);
		}
	}
	
	// 구직신청 현황 조회
	public void printRecruitmentByDeptYear(int recruitmentNo) {
		Recruitment recruitment = repo.getRecruitmentByNo(recruitmentNo);
		if(recruitment == null) {
			System.out.println(recruitmentNo + "와 일치하는 구직신청서가 없습니다.");
		}
		Resume resume = recruitment.getResume();
		String myDept = resume.getDept(); //내가 지원한 부서
		
		ArrayList<Recruitment> recruitments = repo.getAllRecruitments();
		int count = 0;	 // 지원한 사람수
		int time = 0;	 // 근무시간
		int timeCount = 0;
		for(Recruitment otherRecruitment :recruitments) {
			Resume otherResume = otherRecruitment.getResume();
			if(myDept.equals(otherResume.getDept())) {
				ArrayList<Career> career = otherRecruitment.getCareers();
				for(Career timeCareer:career) {
					time += timeCareer.getYear();
					timeCount++;
				}
				count++;
			}
		}
		int averageYear = time/timeCount;
		System.out.println("같은 부서에 지원한 인원은 " + count + "명 입니다.");
		System.out.println("같은 부서에 지원한 인원의 평균 근속년수는 " + averageYear + "년 입니다.");
	}

	// 구직신청 삭제하기
	public void deleteRecruitment(int recruitmentNo) {
		// 레포지토리에서 구직신청번호에 해당하는 구직신청객체를 삭제한다.
		Recruitment recruitment = repo.getRecruitmentByNo(recruitmentNo);
		if(recruitment == null) {
			System.out.println(recruitmentNo + "와 일치하는 구직신청서가 없습니다.");
		}
		
		repo.deleteRecruitmentByNo(recruitmentNo);	
	}

	// 전체 구직신청정보 간단 조회
	public void printAllRecruitment() {
		// 레포지토리에서 모든 구직신청 정보를 조회해서 화면에 출력한다.
		ArrayList<Recruitment> recruitments = repo.getAllRecruitments();
		if(recruitments.isEmpty()) {
			System.out.println("구직신청정보가 없습니다.");
		}
			
		System.out.println("구직신청번호	구직자이름	전화번호	지원부서	합격여부");
		for(Recruitment recruitment :recruitments) {
			System.out.print(recruitment.getNo() + "\t");
			System.out.print(recruitment.getResume().getName() + "\t");
			System.out.print(recruitment.getResume().getTel() + "\t");
			System.out.print(recruitment.getResume().getDept() + "\t");
			System.out.println(recruitment.isPassed());
		}
		
	}

	// 구직신청 심사하기
	public void checkRecruitment(int recruitmentNo, String result) {
		// 레포지토리에서 구직신청번호에 해당하는 구직신청객체를 조회한다.
		// 합격/불합격여부를 결정한다.
		Recruitment recruitment = repo.getRecruitmentByNo(recruitmentNo);
		if(recruitment == null) {
			System.out.println(recruitmentNo + "와 일치하는 구직신청서가 없습니다.");
		}
		
		if(result.equals("Y")) {
			recruitment.setPassed(true);
		} else if(result.equals("N")) {
			recruitment.setPassed(false);
		} else {
			System.out.println("합격여부를 정확히 입력해주세요.");
		}
		
		
	}
}
