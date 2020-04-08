package oop1;

public class AccountDemo {

	public static void main(String[] args) {
		// Ŭ�������� ����ϱ�
		// Ŭ���������� "Ŭ������.������"�� ���·� ��ü ������ ������� ��밡���ϴ�.
		System.out.println("�ݸ�: "+ Account.RATE_OF_INTEREST);
			
		Account acc1 = new Account();
		acc1.owner = "ȫ�浿";
		acc1.no = "010-1234-12";
		acc1.password = "1234";
		acc1.balance = 20000000;
		acc1.period = 24;
		
		Account acc2 = new Account();
		acc2.owner = "������";
		acc2.no = "110-4564-13";
		acc2.password = "5678";
		acc2.balance = 65000000;
		acc2.period = 27;
		
		// ����ȯ�ޱ� ����ϱ�
		// �ܾ�*�ݸ�*(������/12)
		long money1 = acc1.balance +(long)(acc1.balance * Account.RATE_OF_INTEREST * acc1.period / 12);
		long money2 = acc2.balance +(long)(acc2.balance * Account.RATE_OF_INTEREST * acc2.period / 12);
			
		System.out.println("ù��° ������ ����ȯ�ޱ�: " + money1);
		System.out.println("ù��° ������ ����ȯ�ޱ�: " + money2);
	}

}
