package collection.demo;

import java.util.ArrayList;
import java.util.Scanner;

import vo.Product;

public class ProductApp {

	public static void main(String[] args) {
		
		ProductRepository repo = new ProductRepository();
			
		while(true) {
			try {
				Scanner scanner = new Scanner(System.in);
				
				System.out.println("============================");
				System.out.println("1.��ü��ȸ	2.�˻�	3.���	0����");
				System.out.println("============================");
				
				System.out.print("�޴��� �����ϼ���: ");
				int menuNo = scanner.nextInt();
				if (menuNo == 1) {
					System.out.println("[��ü ��ǰ ��ȸ]");
					ArrayList<Product> products = repo.getAllProducts();
					if(products.isEmpty()) {
						System.out.println("��ȸ�� ��ǰ�� �����ϴ�.");
					}
					System.out.println("��ǰ��ȣ\t��ǰ��\t����");
					for(Product product : products) {
						System.out.print(product.getNo() +"\t");
						System.out.print(product.getName() +"\t");			
						System.out.println(product.getPrice());
					}
					
				} else if (menuNo == 2) {
					System.out.println("[��ǰ �˻�]");
					System.out.println("1.��ǰ��ȣ�� �˻�	2.Ű����� �˻�");
					int searchMenuNo = scanner.nextInt();
					
					if(searchMenuNo == 1) {
						System.out.println("[��ǰ��ȣ�� �˻�]");
						System.out.print("��ǰ��ȣ�� �Է��ϼ���: ");
						int productNo = scanner.nextInt();
						Product product = repo.getProductByNo(productNo);
						if(product == null) {
							System.out.println("�Է��� ��ȣ�� ��ġ�ϴ� ��ǰ�� �����ϴ�.");
						}
						System.out.println("��ǰ��ȣ: " + product.getNo());
						System.out.println("�� ǰ �� : " + product.getName());
						System.out.println("�� �� �� : " + product.getMaker());
						System.out.println("��      ��: " + product.getPrice());
						System.out.println("��������: " + product.getCreateDate());
						
					} else if(searchMenuNo == 2) {
						System.out.println("[��ǰ������ �˻�]");
						System.out.print("Ű���带 �Է��ϼ���: ");
						String keyword = scanner.next();
						ArrayList<Product> products = repo.searchProducts(keyword);
						if(products.isEmpty()) {
							System.out.println("["+keyword+"] �˻�� �ش��ϴ� ��ǰ�� ã�� �� �����ϴ�.");
						} else {
							System.out.println("��ü ["+ products.size() +"]���� �˻��Ǿ����ϴ�.");
						}
						System.out.println("��ǰ��ȣ\t��ǰ��\t����");
						for(Product product : products) {
							System.out.print(product.getNo() +"\t");
							System.out.print(product.getName() +"\t");			
							System.out.println(product.getPrice());
						}
					}
						
				} else if (menuNo == 3) {
					System.out.println("[�ű� ��ǰ ���]");
					
					System.out.print("��ǰ���� �Է��ϼ���: ");
					String name = scanner.next();
					System.out.print("�����縦 �Է��ϼ���: ");
					String maker = scanner.next();
					System.out.print("������ �Է��ϼ���: ");
					int price = scanner.nextInt();
					
					Product product = new Product();
					product.setName(name);
					product.setMaker(maker);
					product.setPrice(price);
					
					repo.insertProduct(product);
					System.out.println("### �űԻ�ǰ�� ��ϵǾ����ϴ� ###");
					
				} else if (menuNo == 0) {
					System.out.println("[���α׷� ����]");
					break;
				}
			} catch(Exception e) {
				System.out.println("### ���� �޴��� �ǵ��� ���ϴ� ###");
			}
		}
	}
}
