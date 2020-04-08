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
			System.out.println("1.������2.�λ�����0.����");
			System.out.println("==============================");
			
			System.out.print("�޴��� �����ϼ���: ");
			int menuNo = scanner.nextInt();
			
			if(menuNo == 1) {
				System.out.println("=========================================================");
				System.out.println("1.�̷¼���� 2.��»��׵�� 3.ä�����Ȯ�� 4.�̷¼����� 5.������û���� 6.��»��׼���/���� 7.������û��Ȳ��ȸ");
				System.out.println("=========================================================");
				
				System.out.print("������ �޴��� �����ϼ���: ");
				int empMenuNo = scanner.nextInt();
				
				//�̷¼����
				if(empMenuNo == 1) {
					// �̸�, ��ȭ��ȣ, �����μ��� �Է¹޴´�.
					System.out.println("[�̷¼� ���]");
					
					System.out.print("�̸��� �Է��ϼ���: ");
					String name = scanner.next();
					System.out.print("��ȭ��ȣ�� �Է��ϼ���: ");
					String tel = scanner.next();
					System.out.print("�����μ��� �Է��ϼ���: ");
					String dept = scanner.next();
					
					Resume resume = new Resume();
					resume.setName(name);
					resume.setTel(tel);
					resume.setDept(dept);
					
					service.addNewResume(resume);
					System.out.println("### �̷¼� ����� �Ϸ�Ǿ����ϴ� ###");
					
				} else if(empMenuNo == 2) {
					// ����ȸ���, �ٹ��μ�, ����, �ٹ������ �Է¹޴´�.
					System.out.println("[��»��� ���]");
					
					System.out.print("������û��ȣ�� �Է��ϼ���: ");
					int recruitmentNo = scanner.nextInt();
					System.out.print("�����ߴ� ȸ����� �Է��ϼ���: ");
					String companyName = scanner.next();
					System.out.print("�ٹ��ߴ� �μ����� �Է��ϼ���: ");
					String dept = scanner.next();
					System.out.print("���� ������ �Է��ϼ���: ");
					String position = scanner.next();
					System.out.print("�ٹ��Ⱓ(�����)�� �Է��ϼ���: ");
					int year = scanner.nextInt();
					
					Career career = new Career();
					career.setCompanyName(companyName);
					career.setDept(dept);
					career.setPosition(position);
					career.setYear(year);
					
					service.addCareer(recruitmentNo, career);
					System.out.println("### ��»��� ����� �Ϸ�Ǿ����ϴ� ###");
					
				} else if(empMenuNo == 3) {
					// ������û��ȣ�� �Է¹޴´�.
					System.out.println("[ä����� Ȯ��]");
					System.out.print("������û��ȣ�� �Է��ϼ���: ");
					int recruitmentNo = scanner.nextInt();
					
					service.printRecruitmentDetail(recruitmentNo);
					System.out.println("### ä����� Ȯ���� �Ϸ�Ǿ����ϴ� ###");
					
				} else if(empMenuNo == 4) {
					// ������û��ȣ, �̸�, ��ȭ��ȣ, �����μ��� �Է¹޴´�.
					System.out.println("[�̷¼� ����]");
					System.out.print("������û��ȣ�� �Է��ϼ���: ");
					int recruitmentNo = scanner.nextInt();
					System.out.print("�̸��� �Է��ϼ���: ");
					String name = scanner.next();
					System.out.print("��ȭ��ȣ�� �Է��ϼ���: ");
					String tel = scanner.next();
					System.out.print("�����μ��� �Է��ϼ���: ");
					String dept = scanner.next();
					
					Resume resume = new Resume();
					resume.setName(name);
					resume.setTel(tel);
					resume.setDept(dept);
					
					service.updateResume(recruitmentNo, resume);
					System.out.println("### �̷¼� ������ �Ϸ�Ǿ����ϴ� ###");
					
				} else if(empMenuNo == 5) {
					// ������û��ȣ�� �Է¹޴´�.
					System.out.println("[������û ���]");
					System.out.print("������û��ȣ�� �Է��ϼ���: ");
					int recruitmentNo = scanner.nextInt();
					
					service.deleteRecruitment(recruitmentNo);
					System.out.println("### ������û ��Ұ� �Ϸ�Ǿ����ϴ� ###");
					
				} else if(empMenuNo == 6) {
					System.out.println("[��»��� ����/����");
					System.out.print("������û��ȣ�� �Է��ϼ���: ");
					int recruitmentNo = scanner.nextInt();
					System.out.print("ȸ����� �Է��ϼ���: ");
					String companyName = scanner.next();
					
					service.updateCareer(recruitmentNo, companyName);
					System.out.println("### ��»��� ����/������ �Ϸ�Ǿ����ϴ� ###");
								
				} else if(empMenuNo == 7) {
					System.out.println("[������û ��Ȳ ��ȸ]");
					System.out.print("������û��ȣ�� �Է��ϼ���: ");
					int recruitmentNo = scanner.nextInt();
					
					service.printRecruitmentByDeptYear(recruitmentNo);
					System.out.println("### ������û ��Ȳ ��ȸ�� �Ϸ�Ǿ����ϴ� ###");
					
				}
				
			} else if(menuNo == 2) {
				System.out.println("=========================================================");
				System.out.println("1.ä���û�� ��ȸ2.ä���û�� ����ȸ3.ä���û�� �ɻ�");
				System.out.println("=========================================================");
				
				System.out.print("�λ����� �޴��� �����ϼ���: ");
				int managerMenuNo = scanner.nextInt();
				
				if(managerMenuNo == 1) {
					// �Է°� ����
					System.out.println("[ä���û�� ��ȸ]");
					
					service.printAllRecruitment();
					System.out.println("### ä���û�� ��ȸ�� �Ϸ�Ǿ����ϴ� ###");
					
				} else if(managerMenuNo == 2) {
					// ������û��ȣ�� �Է¹޴´�.
					System.out.println("[ä���û�� ����ȸ]");
					System.out.print("������û��ȣ�� �Է��ϼ���: ");
					int recruitmentNo = scanner.nextInt();
					
					service.printRecruitmentDetail(recruitmentNo);
					System.out.println("### ä���û�� ����ȸ�� �Ϸ�Ǿ����ϴ� ###");
					
				} else if(managerMenuNo == 3) {
					// ������û��ȣ�� �հݺ��հݿ��θ� Y/N���� �Է¹޴´�.
					System.out.println("[ä���û�� �ɻ�]");
					System.out.print("������û��ȣ�� �Է��ϼ���: ");
					int recruitmentNo = scanner.nextInt();
					System.out.print("�հݿ���(Y, N)�� �Է��ϼ���: ");
					String result = scanner.next();
					
					service.checkRecruitment(recruitmentNo, result);
					System.out.println("### ä���û�� �ɻ簡 �Ϸ�Ǿ����ϴ� ###");
					
				}
				
			} else if(menuNo == 0) {
				System.out.println("[���α׷��� �����մϴ�]");
				break;
			}
			System.out.println();
		}
		scanner.close();
	}

}
