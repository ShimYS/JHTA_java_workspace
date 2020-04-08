package oop2;

import java.util.Scanner;

public class BankingDemo3 {
	
	public static void main(String[] args) {
		// 사용자에게 메뉴보여주고 입력정보를 전달받아서 넘겨주는것만함.
		
		BankingService service = new BankingService();
		Scanner scanner = new Scanner(System.in);
					
		while(true) {
			System.out.println();
			System.out.println("[계좌관리 프로그램]");
			System.out.println("-------------------------------------------------------");
			System.out.println("1.조회	2.검색	3.신규	4.입금	5.출금	6.해지	0.종료");
			System.out.println("-------------------------------------------------------");			
			System.out.print("메뉴를 선택하세요: ");
			int menuNo = scanner.nextInt();			
			if(menuNo == 1) {
				System.out.println("[계좌 조회]");				
				service.printAllBankings();
				
			} else if(menuNo == 2) {
				System.out.println("[계좌 검색]");				
				String no = service.getBankingNo();				
				service.printBankingByNo(no);
				
			} else if(menuNo == 3) {
				System.out.println("[신규계좌 개설]");
				String name = service.getName();
				int pwd = service.getPwd();
				int money = service.getSaveMoney();
				service.addNewBanking(name, pwd, money);
				
			} else if(menuNo == 4) {
				System.out.println("[입금 서비스]");				
				String no = service.getBankingNo();
				long money = service.getSaveMoney();
				service.depositToBanking(no, money);
				
			} else if(menuNo == 5) {
				System.out.println("[출금 서비스]");				
				String no = service.getBankingNo();	
				int pwd = service.getPwd();	
				long money = service.getWithdrawMoney();				
				long withdrawMoney = service.withdrawFromBanking(no, pwd, money);
				System.out.println(withdrawMoney + "원을 출금했습니다.");
				
			} else if(menuNo == 6) {
				System.out.println("[계좌 해지]");				
				String no = service.getBankingNo();
				int pwd = service.getPwd();				
				long finalMoney = service.closeBanking(no, pwd);				
				System.out.println("고객님의 총 해지 환급금은 " + finalMoney + "원 입니다.");
				
			} else if(menuNo == 0) {
				System.out.println("계좌관리 프로그램이 종료되었습니다.");
				break;
			}			
		}
		scanner.close();
	}	
}
