package ex2;

import java.util.Scanner;

public class UserApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		UserService service = new UserService();
		ErrorCode code = new ErrorCode();

		while (true) {
			try {
				System.out.println("-------------------------------------");
				System.out.println("1.ȸ������	2.�α���	3.��й�ȣ����	0.����");
				System.out.println("-------------------------------------");

				System.out.println("�޴��� �����ϼ���: ");
				int menuNo = scanner.nextInt();

				if(menuNo == 1) {
					System.out.println("[ȸ������]");
					System.out.println("���̵� �Է��ϼ���: ");
					String id = scanner.next();
					System.out.println("�̸��� �Է��ϼ���: ");
					String name = scanner.next();
					System.out.println("��й�ȣ�� �Է��ϼ���: ");
					String pwd = scanner.next();
					
					service.addNewUser(id, name, pwd);					// HTA ���ܹ߻��� ����� �޼ҵ� ����
					
					System.out.println("### ȸ�������� �Ϸ�Ǿ����ϴ� ###");		// ����� ���ܰ� �߻����� ���� ��쿡�� ����ȴ�. ���� �߻��ϸ� catch�� ������ ������.
					
				} else if(menuNo == 2) {
					System.out.println("[�α���]");
					System.out.println("���̵� �Է��ϼ���: ");
					String id = scanner.next();
					System.out.println("��й�ȣ�� �Է��ϼ���: ");
					String pwd = scanner.next();
					
					service.login(id, pwd);
					
					System.out.println("### �α����� �Ϸ�Ǿ����ϴ� ###");
					
				} else if(menuNo == 3) {
					System.out.println("[��й�ȣ����]");
					System.out.println("���̵� �Է��ϼ���: ");
					String id = scanner.next();
					System.out.println("��й�ȣ�� �Է��ϼ���: ");
					String oldPwd = scanner.next();
					System.out.println("���ο� ��й�ȣ�� �Է��ϼ���: ");
					String newPwd = scanner.next();
					
					service.changePassword(id, oldPwd, newPwd);
					
					System.out.println("### ��й�ȣ ������ �Ϸ�Ǿ����ϴ� ###");
					
				} else if(menuNo == 0) {
					System.out.println("### ���α׷� ���� ###");
					break;
				}
				
							
			} catch (HTAException e) {
//				String errorMessage = e.getMessage();
//				System.err.println("[�����޼���] -> " + errorMessage);
				System.out.println(e);
				String errorCode = e.getErrorCode();
				String errorDescription = code.getDescription(errorCode);
				System.out.println("["+errorCode+"] -> "+ errorDescription);
			}
		}
		
		
		
	}
}
