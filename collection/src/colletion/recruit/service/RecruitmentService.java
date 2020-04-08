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

	// �̷¼� ��ϱ��
	public void addNewResume(Resume resume) {
		// ������û��ü ����
		// ������û��ü�� ���޹��� �̷¼� ��ü ����
		// �������丮��ü�� ����ؼ� db�� �����ϰ�, �ڽ��� ������û��ȣ�� ����Ѵ�.
		// ������û��ȣ�� ��ȯ�Ѵ�.
		Recruitment recruitment = new Recruitment();
		recruitment.setResume(resume);
		repo.addRecruitment(recruitment);
		System.out.println("������û��ȣ: "+recruitment.getNo());
	}

	// ��»��� ��ϱ��
	public void addCareer(int recruitmentNo, Career career) {
		// �������丮���� ������û��ȣ�� �ش��ϴ� ������û��ü�� ��ȸ�Ѵ�.
		// ������û��ü�� ��»��׿� ���޹��� ��»��װ�ü�� �߰��Ѵ�.
		Recruitment recruitment = repo.getRecruitmentByNo(recruitmentNo);
		if(recruitment == null) {
			System.out.println(recruitmentNo + "�� ��ġ�ϴ� ������û���� �����ϴ�.");
		}
		recruitment.addCareer(career);		
//		ArrayList<Career> careers = new ArrayList<Career>();
//		careers.add(career);
	}

	// ������û ���� ��ȸ ���
	public void printRecruitmentDetail(int recruitmentNo) {
		// �������丮���� ������û��ȣ�� �ش��ϴ� ������û��ü�� ��ȸ�ؼ� ȭ�鿡 ����Ѵ�.
		Recruitment recruitment = repo.getRecruitmentByNo(recruitmentNo);
		if(recruitment == null) {
			System.out.println(recruitmentNo + "�� ��ġ�ϴ� ������û���� �����ϴ�.");
		}
		
		System.out.println("������û��ȣ: " + recruitment.getNo());
		System.out.println("������ �̸�: " + recruitment.getResume().getName());
		System.out.println("��ȭ��ȣ: " + recruitment.getResume().getTel());
		System.out.println("�����μ�: " + recruitment.getResume().getDept());
		ArrayList<Career> careers = recruitment.getCareers();
		for(Career career : careers) {
			System.out.println("�����ߴ� ȸ���: " + career.getCompanyName());
			System.out.println("�ٹ��ߴ� �μ���: " + career.getDept());
			System.out.println("��������: " + career.getPosition());
			System.out.println("�ٹ��Ⱓ: " + career.getYear());
		}
		System.out.println("�հݿ���: " + recruitment.isPassed());
		
	}

	// �̷¼� ���� ���
	public void updateResume(int recruitmentNo, Resume resume) {
		// �������丮���� ������û��ȣ�� �ش��ϴ� ������û��ü�� ��ȸ�Ѵ�.
		// ������û��ü�� �̷¼������� ���޹��� �̷¼� ������ ��ü�Ѵ�.
		Recruitment recruitment = repo.getRecruitmentByNo(recruitmentNo);
		if(recruitment == null) {
			System.out.println(recruitmentNo + "�� ��ġ�ϴ� ������û���� �����ϴ�.");
		}
		
		recruitment.getResume().setName(resume.getName());
		recruitment.getResume().setTel(resume.getTel());
		recruitment.getResume().setDept(resume.getDept());
	}
	
	// ��»��� ����/���� ���
	public void updateCareer(int recruitmentNo, String companyName) {
		Career result = null;
		Recruitment recruitment = repo.getRecruitmentByNo(recruitmentNo);
		if(recruitment == null) {
			System.out.println(recruitmentNo + "�� ��ġ�ϴ� ������û���� �����ϴ�.");
		}
		
		ArrayList<Career> careers = recruitment.getCareers();
		for(Career career : careers) {
			if(companyName.equals(career.getCompanyName())) {
				result = career;
				System.out.println("�����ߴ� ȸ���\t�ٹ��ߴ� �μ���\t��������\t�ٹ��Ⱓ");
				System.out.print(career.getCompanyName()+"\t");
				System.out.print(career.getDept()+"\t");
				System.out.print(career.getPosition()+"\t");
				System.out.println(career.getYear());
				break;
			}
		}
		
		System.out.println("1.���� 2.����");
		int careerMenuNo = scanner.nextInt();
		if(careerMenuNo == 1) {
			System.out.print("�����ߴ� ȸ����� �Է��ϼ���: ");
			String companyName2 = scanner.next();
			System.out.print("�ٹ��ߴ� �μ����� �Է��ϼ���: ");
			String dept = scanner.next();
			System.out.print("���� ������ �Է��ϼ���: ");
			String position = scanner.next();
			System.out.print("�ٹ��Ⱓ(�����)�� �Է��ϼ���: ");
			int year = scanner.nextInt();
			
			result.setCompanyName(companyName2);
			result.setDept(dept);
			result.setPosition(position);
			result.setYear(year);
						
		} else if(careerMenuNo == 2) {
			careers.remove(result);
		}
	}
	
	// ������û ��Ȳ ��ȸ
	public void printRecruitmentByDeptYear(int recruitmentNo) {
		Recruitment recruitment = repo.getRecruitmentByNo(recruitmentNo);
		if(recruitment == null) {
			System.out.println(recruitmentNo + "�� ��ġ�ϴ� ������û���� �����ϴ�.");
		}
		Resume resume = recruitment.getResume();
		String myDept = resume.getDept(); //���� ������ �μ�
		
		ArrayList<Recruitment> recruitments = repo.getAllRecruitments();
		int count = 0;	 // ������ �����
		int time = 0;	 // �ٹ��ð�
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
		System.out.println("���� �μ��� ������ �ο��� " + count + "�� �Դϴ�.");
		System.out.println("���� �μ��� ������ �ο��� ��� �ټӳ���� " + averageYear + "�� �Դϴ�.");
	}

	// ������û �����ϱ�
	public void deleteRecruitment(int recruitmentNo) {
		// �������丮���� ������û��ȣ�� �ش��ϴ� ������û��ü�� �����Ѵ�.
		Recruitment recruitment = repo.getRecruitmentByNo(recruitmentNo);
		if(recruitment == null) {
			System.out.println(recruitmentNo + "�� ��ġ�ϴ� ������û���� �����ϴ�.");
		}
		
		repo.deleteRecruitmentByNo(recruitmentNo);	
	}

	// ��ü ������û���� ���� ��ȸ
	public void printAllRecruitment() {
		// �������丮���� ��� ������û ������ ��ȸ�ؼ� ȭ�鿡 ����Ѵ�.
		ArrayList<Recruitment> recruitments = repo.getAllRecruitments();
		if(recruitments.isEmpty()) {
			System.out.println("������û������ �����ϴ�.");
		}
			
		System.out.println("������û��ȣ	�������̸�	��ȭ��ȣ	�����μ�	�հݿ���");
		for(Recruitment recruitment :recruitments) {
			System.out.print(recruitment.getNo() + "\t");
			System.out.print(recruitment.getResume().getName() + "\t");
			System.out.print(recruitment.getResume().getTel() + "\t");
			System.out.print(recruitment.getResume().getDept() + "\t");
			System.out.println(recruitment.isPassed());
		}
		
	}

	// ������û �ɻ��ϱ�
	public void checkRecruitment(int recruitmentNo, String result) {
		// �������丮���� ������û��ȣ�� �ش��ϴ� ������û��ü�� ��ȸ�Ѵ�.
		// �հ�/���հݿ��θ� �����Ѵ�.
		Recruitment recruitment = repo.getRecruitmentByNo(recruitmentNo);
		if(recruitment == null) {
			System.out.println(recruitmentNo + "�� ��ġ�ϴ� ������û���� �����ϴ�.");
		}
		
		if(result.equals("Y")) {
			recruitment.setPassed(true);
		} else if(result.equals("N")) {
			recruitment.setPassed(false);
		} else {
			System.out.println("�հݿ��θ� ��Ȯ�� �Է����ּ���.");
		}
		
		
	}
}
