package oop1;

import java.util.Scanner;

public class OrderDemo1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Order[] orders = new Order[100];
		int savePosition = 0;
			
		while(true) {
			//���������� + �޴� ��� �� �Է¹ޱ�
			System.out.println();
			System.out.println("-----------------------------------------------------");
			System.out.println("1.��ȸ	2.�˻�	3.�Է�	4.����");
			System.out.println("-----------------------------------------------------");
			
			System.out.print("��ȣ�� �Է��ϼ���: ");
			int menuNo = scanner.nextInt();
			System.out.println();
			
			//<�޴� 1 : ��ȸ>
			if(menuNo == 1) {
				System.out.println("[�� �ֹ����� ��ȸ]");
								
				if(savePosition == 0) {
					System.out.println("�� �ֹ������� �������� �ʽ��ϴ�.");
				} else {
					System.out.println("����	�����	�ѱ��űݾ�	��������Ʈ	����ǰ");
					System.out.println("-----------------------------------------------------");
					for(int i=0; i<savePosition; i++) {
						Order order = new Order();
						order = orders[i];
						
						System.out.print(order.name+"	");
						System.out.print(order.grade+"	");
						System.out.print(order.price+"	");
						System.out.print(order.point+"	");
						System.out.println(order.gift+"	");
					}
				}
							
			//<�޴� 2 : �˻�>		
			} else if(menuNo == 2) {				
				//�˻� ���� �Է¹ޱ�
				System.out.println("[�� �ֹ����� �˻�]");
				System.out.print("�˻������� �Է��ϼ���(N:�̸�, G:����ǰ):");
				String option = scanner.next();
				System.out.print("���ǰ��� �Է��ϼ���:");
				String text = scanner.next();
				
//				//�˻�����:����  => �Է¹ޱ�
//				if(option.equals("N")) {
//					System.out.print("�˻��� ������ �Է��ϼ���: ");
//					System.out.println();
//					String name = scanner.next();
//					
//					Order foundOrder = null;
//					for(int i=0; i<savePosition; i++) {
//						Order order = orders[i];
//						if(name.equals(order.name)) {
//							foundOrder = order;
//						} 
//					}
//					System.out.println("����: "+foundOrder.name+"\t");
//					System.out.println("�����: "+foundOrder.grade+"\t");
//					System.out.println("�ѱ��űݾ�: "+foundOrder.price+"\t");
//					System.out.println("��������Ʈ: "+foundOrder.point+"\t");
//					System.out.println("����ǰ: "+foundOrder.gift+"\t");
//				
//				//�˻�����:��ǰ��  => �Է¹ޱ�
//				} else if(option.equals("G")) {
//					System.out.print("�˻��� ��ǰ�� �Է��ϼ���(���ڱ�, ��ǰ��, ���α�, ������): ");
//					System.out.println();
//					String gift = scanner.next();
//					int savePointer = 0;
//					
//					Order[] foundGift = new Order[100];
//					for(int i=0; i<savePosition; i++) {
//						Order giftCheck = orders[i];
//						
//						if(gift.equals(giftCheck.gift)) {
//							foundGift[savePointer] = giftCheck;
//							savePointer++;
//						}
//					}
//					
//					for(int i=0; i<savePointer; i++) {
//						Order order = new Order();
//						order = foundGift[i];
//						System.out.println("����: "+order.name+"\t");
//						System.out.println("�����: "+order.grade+"\t");
//						System.out.println("�ѱ��űݾ�: "+order.price+"\t");
//						System.out.println("��������Ʈ: "+order.point+"\t");
//						System.out.println("����ǰ: "+order.gift+"\t");
//						System.out.println();
//					}
//				
//				//�˻����� �߸��Է� ��� �޽��� ���
//				} else {
//					System.out.println("["+option+"]�� ��ġ�ϴ� �˻������� ã�� �� �����ϴ�.");
//				}
				
				
				
				
				
				//�� ����
				
				boolean isFound = false;
				for(int i=0; i<savePosition; i++) {
					Order order = orders[i];
					if(option.equals("N") && text.equals(order.name)) {
						isFound = true;
					} else if(option.equals("G") && text.equals(order.gift)) {
						isFound = true;
					} else {
						isFound = false;
					}
					
					if(isFound) {
						System.out.println("����: "+order.name+"\t");
						System.out.println("�����: "+order.grade+"\t");
						System.out.println("�ѱ��űݾ�: "+order.price+"\t");
						System.out.println("��������Ʈ: "+order.point+"\t");
						System.out.println("����ǰ: "+order.gift+"\t");
						System.out.println();
					}
				}
				
				// ���� : ����� 'isFound'�� 'false'�� �ٲ���� �ϴ°� �ƴ���? 
				
				
				
				
				
				
				
			//<�޴� 3 : �Է�>	
			} else if(menuNo == 3) {				
				System.out.println("[������ �Է�]");
				
				//������ �Է� �ޱ�
				System.out.print("���� �̸��� �Է��ϼ���: ");
				String name = scanner.next();				
				System.out.print("���� ����� �Է��ϼ���(�����̾�, ���̽�, ����Ʈ, Ŭ����): ");
				String grade = scanner.next();				
				System.out.print("���� �ݾ��� �Է��ϼ���: ");
				int price = scanner.nextInt();
				
				//��ü����
				Order order = new Order();				
				order.name = name;
				order.grade = grade;
				order.price = price;
				
				//����Ʈ ���
				if(grade.equals("�����̾�")) {
					order.point = (int)(price * 0.05);				
				} else if(grade.equals("���̽�")) {
					order.point = (int)(price * 0.03);					
				} else if(grade.equals("����Ʈ")) {
					order.point = (int)(price * 0.02);				
				} else if(grade.equals("Ŭ����")) {
					order.point = (int)(price * 0.01);					
				}
				
				//���� ����
				if(price>=5000000) {
					order.gift = "���ڱ�";					
				} else if(price>=1000000) {
					order.gift = "��ǰ��";					
				} else if(price>=500000) {
					order.gift = "���α�";					
				} else {
					order.gift = "������";
				}				
				
				//��ü�迭�� ������ �� �Է� �� �迭 �ڸ��̵�
				orders[savePosition] = order;
				savePosition++;
			
			//<�޴� 4 : ����>
			} else if(menuNo == 4) {
				System.out.println("[���α׷��� �����մϴ�]");
				break;
			
			//<�޴� ��ȣ �߸��Է�>
			} else {
				System.out.println("["+menuNo+"]�� ��ġ�ϴ� �޴������� ã�� �� �����ϴ�.");
			}
			
		}
		scanner.close(); // �ڿ��� �ݳ�(�б⾲���ڿ�)�Ͽ� resource leak�� ����
		
	}

}
