package oop2;

import java.util.Scanner;

/**
 * ������ ���������� �����Ѵ�.
 * �ű԰����� ���, ���¿� ���� �����/���� ���� ���񽺸� �����Ѵ�.
 * @author ShimYS
 *
 */
public class BankingService {
	Scanner scanner = new Scanner(System.in);
	
	// ��� ������ ���������� �����ϴ� �迭
	Banking[] db = null;
	int savePosition = 0;
	
	// �⺻�����ڸ� ����ϴ� ��� �������� 100���� ������ �� �ִ� �迭�� ������
	BankingService(){
		db = new Banking[100];
	}
	
	// �� �����ڸ� ����ϴ� ��� ���޹��� size��ŭ ���������� ������ �� �ִ� �迭�� ������
	BankingService(int size) {
		db = new Banking[size];
	}
		
	// ��ϵ� ��ü ���������� ����ϴ� ����
	void printAllBankings() {
		System.out.println("========================================");
		System.out.println("������	���¹�ȣ	�ܾ�	���ԱⰣ");
		System.out.println("========================================");
		for(int i=0; i<savePosition; i++) {
			Banking banking = db[i];
			System.out.print(banking.name + "\t");
			System.out.print(banking.no + "\t");
			System.out.print(banking.balance + "\t");
			System.out.println(banking.period + "\t");			
		}
		System.out.println("========================================");
	}

	// �ű԰��¸� ����ϴ� ����
	void addNewBanking(String name, int pwd, long money) {
		Banking banking = new Banking();
		banking.name = name;
		banking.no = "" + (int)(Math.random()*100000 + 10000); //5�ڸ� ���¹�ȣ
		banking.password = pwd;
		banking.balance = money;
		banking.period = 24;
		
		db[savePosition] = banking;
		savePosition++;
	}
	
	// ���¹�ȣ�� �ش��ϴ� ���������� ��ȸ(���)�ϴ� ����
	void printBankingByNo(String bankingNo) {
		Banking foundBankingNo = findBankingByNo(bankingNo);
		
		if(foundBankingNo!=null) {
			foundBankingNo.display();
		} else {
			System.out.println("�Է��� ���¹�ȣ�� ��ġ�ϴ� ������ ã�� �� �����ϴ�.");
		}				
	}
	
	// ���¹�ȣ, �Աݾ��� ���޹޾Ƽ� �ش� ���¿� �Ա��ϴ� ����
	void depositToBanking(String bankingNo, long money) {
		Banking foundBankingNoForDeposit = findBankingByNo(bankingNo);
		
		if(foundBankingNoForDeposit!=null) {
			foundBankingNoForDeposit.deposit(money);
		} else {
			System.out.println("�Է��� ���¹�ȣ�� ��ġ�ϴ� ������ ã�� �� �����ϴ�.");
		}		
	}
	
	// ���¹�ȣ, ��й�ȣ, ��ݾ��� ���޹޾Ƽ� ��ݾ׸�ŭ ��ȯ�ϴ� ����
	long withdrawFromBanking(String bankingNo, int pwd, long money) {
		long result = 0L;
		Banking foundBankingNoForWithdraw = findBankingByNo(bankingNo);
			
		if(foundBankingNoForWithdraw!=null) {
			result = foundBankingNoForWithdraw.withDraw(money, pwd);
		} else {
			System.out.println("�Է��� ���¹�ȣ�� ��ġ�ϴ� ������ ã�� �� �����ϴ�.");
		}		
		return result;
	}
	
	// ���¹�ȣ, ��й�ȣ�� ���޹޾Ƽ� ���¸� �����ϰ�, �����ݾ� ��ü�� ��ȯ�ϴ� ����
	long closeBanking(String bankingNo, int pwd) {
		long result = 0;
		Banking foundBankingNoForClose = findBankingByNo(bankingNo);;
			
		if(foundBankingNoForClose!=null) {
			result = foundBankingNoForClose.close(pwd);
		} else {
			System.out.println("�Է��� ���¹�ȣ�� ��ġ�ϴ� ������ ã�� �� �����ϴ�.");
		}		
		return result;
	}
	
	// ���񽺿��� ���� ���Ǵ� ���¹�ȣ�� �ش��ϴ� ���������� ã�Ƽ� ��ȯ�ϴ� ���
	Banking findBankingByNo(String bankingNo) {
		Banking result = null;
		for(int i=0; i<savePosition; i++) {
			Banking banking = db[i];
			if(bankingNo.equals(banking.no)) {
				result = banking;
				break;
			}
		}
		return result;
	}
	
	// ������ �޾Ƽ� ��ȯ���ش�.
	String getName() {
		System.out.print("������ �Է��ϼ���: ");
		return scanner.next(); 
	}
	// ���¹�ȣ�� �޾Ƽ� ��ȯ���ش�.
	String getBankingNo() {
		System.out.print("���¹�ȣ�� �Է��ϼ���: ");
		return scanner.next(); 
	}
	// ��й�ȣ�� �޾Ƽ� ��ȯ���ش�.
	int getPwd() {
		System.out.print("��й�ȣ�� �Է��ϼ���: ");
		return scanner.nextInt();
	}
	// �Աݾ��� �޾Ƽ� ��ȯ���ش�.
	int getSaveMoney() {
		System.out.print("�Ա��� �ݾ��� �Է��ϼ���: ");
		return scanner.nextInt();
	}
	// ��ݾ��� �޾Ƽ� ��ȯ���ش�.
	int getWithdrawMoney() {
		System.out.print("����� �ݾ��� �Է��ϼ���: ");
		return scanner.nextInt();
	}
}
