package list;

import java.util.ArrayList;

import utils.commonUtils;
import vo.Product;

public class ArrayListDemo3 {

	public static void main(String[] args) {
		
		Product p1 = new Product(10000, "iphone XS", "apple", 1570000);
		Product p2 = new Product(10001, "ipad pro", "apple", 1200000);
		Product p3 = new Product(10002, "apple watch", "apple", 600000);
		Product p4 = new Product(10003, "macbook pro 13", "apple", 1700000);
		Product p5 = new Product(10004, "macbook pro 16", "apple", 3600000);
		
		ArrayList<Product> products = new ArrayList<Product>();
		products.add(p1);
		products.add(p2);
		products.add(p3);
		products.add(p4);
		products.add(p5);
		
		for(Product product : products) {
			System.out.println("��ǰ��ȣ : " + product.getNo());
			System.out.println("��ǰ�̸� : " + product.getName());
			System.out.println("��  ��  ��: " + product.getMaker());
			System.out.println("��ǰ ����: " + commonUtils.numberToString(product.getPrice()));
			System.out.println("��� ��¥: " + commonUtils.simpleDateString(product.getCreateDate()));			
			System.out.println();
		}
		
	}

}
