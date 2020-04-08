package oop2;

import java.util.Scanner;

/**
 * ���¿� ���� �Աݱ��, ��ݱ��, ��ȸ���, ��й�ȣ ������, ��������� �����ϴ� Ŭ������.
 * @author ShimYS
 *
 */
public class Banking {
	
	static final double RATE_OF_INTEREST = 0.021;
	static final int COMISSION = 1300;
	String name;
	String no;
	int password;
	long balance;
	int period;
	
	// �Աݱ���� �Աݾ��� ���޹޾Ƽ� �ܾ��� ������Ų��.
	void deposit (long money) {
		balance += money;
		System.out.println("�Ա��� �Ϸ�Ǿ����ϴ�.");
		System.out.println("���� �ܾ��� " + balance + "�� �Դϴ�.");
	}
	
	// ��ݱ���� ��ݾװ� ��й�ȣ�� ���޹޾Ƽ� ��й�ȣ�� ��ġ�ϴ� ���
	// �ܾ��� ��ݾ׸�ŭ ���ҽ�Ű��, ��ݾ׿��� ������(1300��)�� �� �ݾ��� ��ȯ�Ѵ�.
	long withDraw(long money, int pwd) {
		long withdrawMoney = 0L;
		
		if(balance >= money + COMISSION) {
			if(password == pwd) {
				balance -= (money + COMISSION);
				withdrawMoney = money;
				System.out.println("����� �Ϸ�Ǿ����ϴ�.");
				System.out.println("��� �� ���� �ܾ��� " + balance + "�� �Դϴ�.");
			} else {
				System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
			}
			
		} else {
			System.out.println("�ܾ��� �����մϴ�.");
		}
		return withdrawMoney;
	}
	
	// ��ȸ����� ������, ���¹�ȣ, �����ܾ��� ȭ�鿡 ����Ѵ�.
	void display() {
		System.out.println("--------- �������� ---------");
		System.out.println("�� �� ��: " + name);
		System.out.println("���¹�ȣ: " + no);
		System.out.println("�����ܾ�: " + balance + "��");
		System.out.println("���ݱⰣ: " + period + "����");
		System.out.println("��      ��: " + Banking.RATE_OF_INTEREST*100 + "%");
		System.out.println("-------------------------");
	}
	
	// ��й�ȣ �������� ������й�ȣ�� ����й�ȣ�� ���޹޾Ƽ�
	// ������й�ȣ�� ��ġ�ϴ� ��쿡�� ��й�ȣ�� �� ��й�ȣ�� �ٲ۴�.
	void changePassword(int oldPwd, int newPwd) {
		if(password == oldPwd) {
			password = newPwd;
			System.out.println("�� ��й�ȣ�� ����Ǿ����ϴ�.");
		} else {
			System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
		}
	}
	
	// ��������� ��й�ȣ�� ���޹޾Ƽ� ��й�ȣ�� ��ġ�ϴ� ��쿡��
	// ���¸� �����ϰ�, �ݸ��� ������ �������ݾ��� ��ȯ�Ѵ�.
	long close(int pwd) {
		long finalMoney = 0L;
		if(password == pwd) {
			finalMoney = balance + (long)(balance*Banking.RATE_OF_INTEREST*period/12);
			// �������� ���
			name = null;
			no = null;
			password = 0;
			balance = 0L;
			period = 0;
			System.out.println("������ �Ϸ�Ǿ����ϴ�.");
		} else {
			System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
		}
		return finalMoney;
	}
	
	
	
	
	// ������ȸ �޼ҵ� ����
}
