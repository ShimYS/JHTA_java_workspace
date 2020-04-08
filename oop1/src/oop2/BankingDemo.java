package oop2;

import java.util.Scanner;

public class BankingDemo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Banking[] bankings = new Banking[100];
		int savePosition = 0;

		while (true) {
			System.out.println("-----------------------------------------------------");
			System.out.println("1.�ű�	2.��ȸ	3.�Ա�	4.���	5.�������	6.����	0.����");
			System.out.println("-----------------------------------------------------");

			System.out.print("��ȣ�� �Է��ϼ���> ");
			int menuNum = scanner.nextInt();

			// 1.�ű�
			if (menuNum == 1) {
				System.out.print("�̸��� �Է��ϼ���: ");
				String name = scanner.next();

				System.out.print("���¹�ȣ�� �Է��ϼ���: ");
				String no = scanner.next();

				System.out.print("��й�ȣ�� �Է��ϼ���: ");
				int password = scanner.nextInt();

				System.out.print("�ܾ��� �Է��ϼ���: ");
				long balance = scanner.nextInt();

				System.out.print("���ԱⰣ�� �Է��ϼ���: ");
				int period = scanner.nextInt();

				Banking banking = new Banking();
				banking.name = name;
				banking.no = no;
				banking.password = password;
				banking.balance = balance;
				banking.period = period;

				bankings[savePosition] = banking;
				savePosition++;

				// 2.��ȸ
			} else if (menuNum == 2) {
				System.out.print("���¹�ȣ�� �Է��ϼ���: ");
				String no = scanner.next();
							
				boolean isFound = false;
				for (int i = 0; i < savePosition; i++) {
					Banking banking = bankings[i];
					
					// NullPointerException Error
					// null ��ü���� method�� ȣ���ϴ� ��� => ���ܹ߻�
					// banking.no.equals(no)  => �����ϸ� null��ü���� equals()�޼ҵ带 ȣ�� => ���ܹ߻�����
					// no.equals(banking.no)  => scanner �Է°�����  equals()�޼ҵ带 ȣ�� => ��������
					if (no.equals(banking.no)) {
						isFound = true;
					} else {
						isFound = false;
					}

					if (isFound) {
						banking.display();
					}
				}
				// 3.�Ա�
			} else if (menuNum == 3) {
				System.out.print("���¹�ȣ�� �Է��ϼ���: ");
				String no = scanner.next();
				System.out.print("�Աݾ��� �Է��ϼ���: ");
				long money = scanner.nextLong();

				boolean isFounded = false;
				for (int i = 0; i < savePosition; i++) {
					Banking banking = bankings[i];
					if (no.equals(banking.no)) {
						isFounded = true;
					} else {
						isFounded = false;
					}

					if (isFounded) {
						banking.deposit(money);
					}
				}

				// 4.���
			} else if (menuNum == 4) {
				System.out.print("���¹�ȣ�� �Է��ϼ���: ");
				String no = scanner.next();
				System.out.print("��й�ȣ�� �Է��ϼ���: ");
				int password = scanner.nextInt();
				System.out.print("��ݾ��� �Է��ϼ���: ");
				int money = scanner.nextInt();

				boolean isFounded = false;
				for (int i = 0; i < savePosition; i++) {
					Banking banking = bankings[i];

					if (no.equals(banking.no)) {
						isFounded = true;
					} else {
						isFounded = false;
					}

					if (isFounded) {
						banking.withDraw(money, password);
					}

				}

			} else if (menuNum == 5) {
				System.out.print("���¹�ȣ�� �Է��ϼ���: ");
				String no = scanner.next();
				System.out.print("��й�ȣ�� �Է��ϼ���: ");
				int oldPwd = scanner.nextInt();
				System.out.print("�� ��й�ȣ�� �Է��ϼ���: ");
				int newPwd = scanner.nextInt();

				boolean isFounded = false;
				for (int i = 0; i < savePosition; i++) {
					Banking banking = bankings[i];

					if (no.equals(banking.no)) {
						isFounded = true;
					} else {
						isFounded = false;
					}

					if (isFounded) {
						banking.changePassword(oldPwd, newPwd);
					}

				}

				// 6.����
			} else if (menuNum == 6) {
				System.out.print("���¹�ȣ�� �Է��ϼ���: ");
				String no = scanner.next();
				System.out.print("��й�ȣ�� �Է��ϼ���: ");
				int password = scanner.nextInt();

				boolean isFounded = false;
				for (int i = 0; i < savePosition; i++) {
					Banking banking = bankings[i];

					if (no.equals(banking.no)) {
						isFounded = true;
					} else {
						isFounded = false;
					}

					if (isFounded) {
						long closeAccount = banking.close(password);
						System.out.println("���� �����ݾ�: " + closeAccount);
					
					}

				}

			} else if (menuNum == 0) {
				System.out.println("���α׷��� �����մϴ�.");
				break;
			} else {
				System.out.println("��ȣ�� �߸� �Է��Ͽ����ϴ�.");
			}
		}
	}

}
