package set;

import java.util.HashSet;
import java.util.Iterator;

import vo.Product;

public class HashSetDemo2 {

	public static void main(String[] args) {
		HashSet<Product> products = new HashSet<Product>();
		
		Product p1 = new Product(100, "��å", "�𳪹�", 3000); 
		Product p2 = new Product(120, "����", "�𳪹�", 7000); 
		Product p3 = new Product(131, "��ø", "�������̾", 13000); 
		Product p4 = new Product(121, "������", "�𳪹�", 7000); 
		Product p5 = new Product(167, "����", "�𳪹�", 3000);
		
		products.add(p1);
		products.add(p2);
		products.add(p3);
		products.add(p4);
		products.add(p5);
		
		Iterator<Product> itr = products.iterator();
		while(itr.hasNext()) {
			Product p = itr.next();
			if(p.getPrice() > 10000) {
				itr.remove();
			}
		}
		
		for(Product p :products) {
			System.out.println("��ǰ ��ȣ: " + p.getNo());
			System.out.println("��  ǰ  ��: " + p.getName());
			System.out.println("��  ��  ��: " + p.getMaker());
			System.out.println("��       ��: " + p.getPrice());
		}
		
		int size = products.size();
		System.out.println("����� ��ǰ��ü ����: " + size);
		
		System.out.println(products);
	}

}
