package oop4;

import java.util.Scanner;

public class ProductDemo {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		ProductService service = new ProductService();
			
		while(true) {
			System.out.println();
			System.out.println("[��ǰ ���� ���α׷�]");
			System.out.println("================================================");
			System.out.println("1.��ȸ	2.�԰�	3.���	4.�˻�	0.����");
			System.out.println("================================================");
			
			System.out.print("�޴��� �����ϼ���: ");
			int menuNo = scanner.nextInt();
			
			if(menuNo == 1) {
				System.out.println("[��ü ��ǰ ��ȸ]");
				//TODO ������ ��ü ��ǰ ��ȸ����� �����Ű�ÿ�
				service.printAllProducts();
				
			} else if(menuNo == 2) {
				System.out.println("[�ű� �� ���� ��ǰ �԰�ó��]");
				
				System.out.println("================================");
				System.out.println("1.�űԻ�ǰ	2.�̿���ǰ	3.����߰�");
				System.out.println("================================");
				
				System.out.print("�԰�ó�� ����� �����ϼ���: ");
				int stockMenuNo = scanner.nextInt();
				
				
				if(stockMenuNo == 1) {
					// ��ǰ��, ������, ī�װ�, ����, �԰��� �Է¹޾Ƽ� �԰�ó���Ѵ�.
					//TODO ������ �űԻ�ǰ �԰����� �����Ű�ÿ�.
					System.out.print("��ǰ���� �Է��ϼ���: ");
					String name = scanner.next();
					System.out.print("�����縦 �Է��ϼ���: ");
					String maker = scanner.next();
					System.out.print("ī�װ��� �Է��ϼ���: ");
					String category = scanner.next();
					System.out.print("������ �Է��ϼ���: ");
					int price = scanner.nextInt();
					System.out.print("����� �Է��ϼ���: ");
					int stock = scanner.nextInt();
					
					Product product = new Product(name, maker, category, price, stock);
					service.insertProduct(product);
					
				} else if(stockMenuNo == 2) {
					// ��ǰ��, ������, ī�װ�, ����, ���η�, �԰��� �Է¹޾Ƽ� ó���Ѵ�.
					//TODO ������ ��ǰ �԰����� �����Ű�ÿ�.
					System.out.print("��ǰ���� �Է��ϼ���: ");
					String name = scanner.next();
					System.out.print("�����縦 �Է��ϼ���: ");
					String maker = scanner.next();
					System.out.print("ī�װ��� �Է��ϼ���: ");
					String category = scanner.next();
					System.out.print("������ �Է��ϼ���: ");
					int price = scanner.nextInt();
					System.out.print("����� �Է��ϼ���: ");
					int stock = scanner.nextInt();
					System.out.print("�������� �Է��ϼ���: ");
					double discountRate = scanner.nextDouble();
					
					Product product = new Product(name, maker, category, price, discountRate, stock);
					service.insertProduct(product);
					
				} else if(stockMenuNo == 3) {
					// ��ǰ��, �԰��� �Է¹޾Ƽ� �԰�ó���Ѵ�.
					//TODO ������ ��� ��������� �����Ű�ÿ�.
					System.out.print("��ǰ���� �Է��ϼ���: ");
					String name = scanner.next();
					System.out.print("����� �Է��ϼ���: ");
					int stock = scanner.nextInt();
					
					service.addProductStock(name, stock);
				}
				
				
			} else if(menuNo == 3) {
				
				System.out.println("[��ǰ ���ó��]");
				// ��ǰ��� ����� �Է¹޾Ƽ� ���ó���Ѵ�.
				//TODO ������ ��� ���ұ���� �����Ű�ÿ�.
				System.out.print("��ǰ���� �Է��ϼ���: ");
				String name = scanner.next();
				System.out.print("����� �Է��ϼ���: ");
				int amount = scanner.nextInt();
				
				service.exportProduct(name, amount);
				
			} else if(menuNo == 4) {
				System.out.println("[��ǰ �˻�]");
					
				System.out.println("================================");
				System.out.println("1.�̸�	2.������	3.ī�װ�	4.����");
				System.out.println("================================");
				
				System.out.print("�˻������ �����ϼ���: ");
				int searchMenuNo = scanner.nextInt();
				
				if(searchMenuNo == 1) {
					// ������ �Է¹޾Ƽ� ��ǰ�� �˻��Ͻÿ�.
					//TODO ������ ����˻������ �����Ͻÿ�
					System.out.print("��ǰ���� �Է��ϼ���: ");
					String name = scanner.next();
					
					service.printProductByName(name);
					
				} else if(searchMenuNo == 2) {
					// �����縦 �Է¹޾Ƽ� ��ǰ�� �˻��Ͻÿ�.
					//TODO ������ ������˻������ �����Ͻÿ�
					System.out.print("�����縦 �Է��ϼ���: ");
					String maker = scanner.next();
					
					service.printProductByMaker(maker);
					
				} else if(searchMenuNo == 3) {
					// ī�װ��� �Է¹޾Ƽ� ��ǰ�� �˻��Ͻÿ�.
					//TODO ������ ī�װ��˻������ �����Ͻÿ�
					System.out.print("ī�װ��� �Է��ϼ���: ");
					String category = scanner.next();
					
					service.printProductByCategory(category);
					
				} else if(searchMenuNo == 4) {
					// �ּҰ��ݰ� �ִ밡���� �Է¹޾Ƽ� �� ���ݹ������� ��ǰ�� �˻��Ͻÿ�.
					//TODO ������ ���ݰ˻������ �����Ͻÿ�
					System.out.print("�ּҰ����� �Է��ϼ���: ");
					int minPrice = scanner.nextInt();
					System.out.print("�ִ밡���� �Է��ϼ���: ");
					int maxPrice = scanner.nextInt();
					
					service.printProductByPrice(minPrice, maxPrice);
				}
				
			} else if(menuNo == 0) {
				System.out.println("[��ǰ ���� ���α׷� ����]");
				break;
			}
			
			
		}
		scanner.close();
	}

}