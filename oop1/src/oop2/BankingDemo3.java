package oop2;

import java.util.Scanner;

public class BankingDemo3 {
	
	public static void main(String[] args) {
		// ����ڿ��� �޴������ְ� �Է������� ���޹޾Ƽ� �Ѱ��ִ°͸���.
		
		BankingService service = new BankingService();
		Scanner scanner = new Scanner(System.in);
					
		while(true) {
			System.out.println();
			System.out.println("[���°��� ���α׷�]");
			System.out.println("-------------------------------------------------------");
			System.out.println("1.��ȸ	2.�˻�	3.�ű�	4.�Ա�	5.���	6.����	0.����");
			System.out.println("-------------------------------------------------------");			
			System.out.print("�޴��� �����ϼ���: ");
			int menuNo = scanner.nextInt();			
			if(menuNo == 1) {
				System.out.println("[���� ��ȸ]");				
				service.printAllBankings();
				
			} else if(menuNo == 2) {
				System.out.println("[���� �˻�]");				
				String no = service.getBankingNo();				
				service.printBankingByNo(no);
				
			} else if(menuNo == 3) {
				System.out.println("[�ű԰��� ����]");
				String name = service.getName();
				int pwd = service.getPwd();
				int money = service.getSaveMoney();
				service.addNewBanking(name, pwd, money);
				
			} else if(menuNo == 4) {
				System.out.println("[�Ա� ����]");				
				String no = service.getBankingNo();
				long money = service.getSaveMoney();
				service.depositToBanking(no, money);
				
			} else if(menuNo == 5) {
				System.out.println("[��� ����]");				
				String no = service.getBankingNo();	
				int pwd = service.getPwd();	
				long money = service.getWithdrawMoney();				
				long withdrawMoney = service.withdrawFromBanking(no, pwd, money);
				System.out.println(withdrawMoney + "���� ����߽��ϴ�.");
				
			} else if(menuNo == 6) {
				System.out.println("[���� ����]");				
				String no = service.getBankingNo();
				int pwd = service.getPwd();				
				long finalMoney = service.closeBanking(no, pwd);				
				System.out.println("������ �� ���� ȯ�ޱ��� " + finalMoney + "�� �Դϴ�.");
				
			} else if(menuNo == 0) {
				System.out.println("���°��� ���α׷��� ����Ǿ����ϴ�.");
				break;
			}			
		}
		scanner.close();
	}	
}
