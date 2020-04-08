package oop2;

import java.util.Scanner;

public class BankingDemo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Banking[] bankings = new Banking[100];
		int savePosition = 0;

		while (true) {
			System.out.println("-----------------------------------------------------");
			System.out.println("1.신규	2.조회	3.입금	4.출금	5.비번변경	6.해지	0.종료");
			System.out.println("-----------------------------------------------------");

			System.out.print("번호를 입력하세요> ");
			int menuNum = scanner.nextInt();

			// 1.신규
			if (menuNum == 1) {
				System.out.print("이름을 입력하세요: ");
				String name = scanner.next();

				System.out.print("계좌번호를 입력하세요: ");
				String no = scanner.next();

				System.out.print("비밀번호를 입력하세요: ");
				int password = scanner.nextInt();

				System.out.print("잔액을 입력하세요: ");
				long balance = scanner.nextInt();

				System.out.print("가입기간을 입력하세요: ");
				int period = scanner.nextInt();

				Banking banking = new Banking();
				banking.name = name;
				banking.no = no;
				banking.password = password;
				banking.balance = balance;
				banking.period = period;

				bankings[savePosition] = banking;
				savePosition++;

				// 2.조회
			} else if (menuNum == 2) {
				System.out.print("계좌번호를 입력하세요: ");
				String no = scanner.next();
							
				boolean isFound = false;
				for (int i = 0; i < savePosition; i++) {
					Banking banking = bankings[i];
					
					// NullPointerException Error
					// null 객체에서 method를 호출하는 경우 => 예외발생
					// banking.no.equals(no)  => 해지하면 null객체에서 equals()메소드를 호출 => 예외발생가능
					// no.equals(banking.no)  => scanner 입력값에서  equals()메소드를 호출 => 문제없음
					if (no.equals(banking.no)) {
						isFound = true;
					} else {
						isFound = false;
					}

					if (isFound) {
						banking.display();
					}
				}
				// 3.입금
			} else if (menuNum == 3) {
				System.out.print("계좌번호를 입력하세요: ");
				String no = scanner.next();
				System.out.print("입금액을 입력하세요: ");
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

				// 4.출금
			} else if (menuNum == 4) {
				System.out.print("계좌번호를 입력하세요: ");
				String no = scanner.next();
				System.out.print("비밀번호를 입력하세요: ");
				int password = scanner.nextInt();
				System.out.print("출금액을 입력하세요: ");
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
				System.out.print("계좌번호를 입력하세요: ");
				String no = scanner.next();
				System.out.print("비밀번호를 입력하세요: ");
				int oldPwd = scanner.nextInt();
				System.out.print("새 비밀번호를 입력하세요: ");
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

				// 6.해지
			} else if (menuNum == 6) {
				System.out.print("계좌번호를 입력하세요: ");
				String no = scanner.next();
				System.out.print("비밀번호를 입력하세요: ");
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
						System.out.println("최종 해지금액: " + closeAccount);
					
					}

				}

			} else if (menuNum == 0) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else {
				System.out.println("번호를 잘못 입력하였습니다.");
			}
		}
	}

}
