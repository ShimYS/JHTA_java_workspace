package oop2;

public class BankingDemo2 {

	public static void main(String[] args) {
		
		Banking banking = new Banking();
		
		banking.name = "ȫ�浿";
		banking.no = "11-1111-1100";
		banking.password = 1234;
		banking.balance = 2000000;
		banking.period = 6;
		
		// ���� �������� ��ȸ
		banking.display();
		
		// �Ա��ϱ�
		banking.deposit(100000);
		banking.display();
		
		// ����ϱ�
		long money1 = banking.withDraw(50000, 1234);
		System.out.println("��ݾ�: " + money1);
		banking.display();
		
		// �����ϱ�
		long money2 = banking.close(1234);
		System.out.println("���� �����ݾ�: " + money2);
		banking.display();

	}

}
