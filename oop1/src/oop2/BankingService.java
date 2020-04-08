package oop2;

import java.util.Scanner;

/**
 * 고객들의 계좌정보를 관리한다.
 * 신규계좌의 등록, 계좌에 대한 입출금/해지 등의 서비스를 제공한다.
 * @author ShimYS
 *
 */
public class BankingService {
	Scanner scanner = new Scanner(System.in);
	
	// 모든 개설된 계좌정보를 저장하는 배열
	Banking[] db = null;
	int savePosition = 0;
	
	// 기본생성자를 사용하는 경우 계좌정보 100개를 저장할 수 있는 배열을 생성함
	BankingService(){
		db = new Banking[100];
	}
	
	// 이 생성자를 사용하는 경우 전달받은 size만큼 계좌정보를 저장할 수 있는 배열을 생성함
	BankingService(int size) {
		db = new Banking[size];
	}
		
	// 등록된 전체 계좌정보를 출력하는 서비스
	void printAllBankings() {
		System.out.println("========================================");
		System.out.println("예금주	계좌번호	잔액	가입기간");
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

	// 신규계좌를 등록하는 서비스
	void addNewBanking(String name, int pwd, long money) {
		Banking banking = new Banking();
		banking.name = name;
		banking.no = "" + (int)(Math.random()*100000 + 10000); //5자리 계좌번호
		banking.password = pwd;
		banking.balance = money;
		banking.period = 24;
		
		db[savePosition] = banking;
		savePosition++;
	}
	
	// 계좌번호에 해당하는 계좌정보를 조회(출력)하는 서비스
	void printBankingByNo(String bankingNo) {
		Banking foundBankingNo = findBankingByNo(bankingNo);
		
		if(foundBankingNo!=null) {
			foundBankingNo.display();
		} else {
			System.out.println("입력한 계좌번호와 일치하는 정보를 찾을 수 없습니다.");
		}				
	}
	
	// 계좌번호, 입금액을 전달받아서 해당 계좌에 입금하는 서비스
	void depositToBanking(String bankingNo, long money) {
		Banking foundBankingNoForDeposit = findBankingByNo(bankingNo);
		
		if(foundBankingNoForDeposit!=null) {
			foundBankingNoForDeposit.deposit(money);
		} else {
			System.out.println("입력한 계좌번호와 일치하는 정보를 찾을 수 없습니다.");
		}		
	}
	
	// 계좌번호, 비밀번호, 출금액을 전달받아서 출금액만큼 반환하는 서비스
	long withdrawFromBanking(String bankingNo, int pwd, long money) {
		long result = 0L;
		Banking foundBankingNoForWithdraw = findBankingByNo(bankingNo);
			
		if(foundBankingNoForWithdraw!=null) {
			result = foundBankingNoForWithdraw.withDraw(money, pwd);
		} else {
			System.out.println("입력한 계좌번호와 일치하는 정보를 찾을 수 없습니다.");
		}		
		return result;
	}
	
	// 계좌번호, 비밀번호를 전달받아서 계좌를 해지하고, 해지금액 전체를 반환하는 서비스
	long closeBanking(String bankingNo, int pwd) {
		long result = 0;
		Banking foundBankingNoForClose = findBankingByNo(bankingNo);;
			
		if(foundBankingNoForClose!=null) {
			result = foundBankingNoForClose.close(pwd);
		} else {
			System.out.println("입력한 계좌번호와 일치하는 정보를 찾을 수 없습니다.");
		}		
		return result;
	}
	
	// 서비스에서 자주 사용되는 계좌번호에 해당하는 계좌정보를 찾아서 반환하는 기능
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
	
	// 고객명을 받아서 반환해준다.
	String getName() {
		System.out.print("고객명을 입력하세요: ");
		return scanner.next(); 
	}
	// 계좌번호를 받아서 반환해준다.
	String getBankingNo() {
		System.out.print("계좌번호를 입력하세요: ");
		return scanner.next(); 
	}
	// 비밀번호를 받아서 반환해준다.
	int getPwd() {
		System.out.print("비밀번호를 입력하세요: ");
		return scanner.nextInt();
	}
	// 입금액을 받아서 반환해준다.
	int getSaveMoney() {
		System.out.print("입금할 금액을 입력하세요: ");
		return scanner.nextInt();
	}
	// 출금액을 받아서 반환해준다.
	int getWithdrawMoney() {
		System.out.print("출금할 금액을 입력하세요: ");
		return scanner.nextInt();
	}
}
