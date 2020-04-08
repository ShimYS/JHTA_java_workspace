package set;

import java.util.HashSet;
import java.util.Iterator;

import vo.Product;

public class HashSetDemo2 {

	public static void main(String[] args) {
		HashSet<Product> products = new HashSet<Product>();
		
		Product p1 = new Product(100, "공책", "모나미", 3000); 
		Product p2 = new Product(120, "샤프", "모나미", 7000); 
		Product p3 = new Product(131, "수첩", "양지다이어리", 13000); 
		Product p4 = new Product(121, "색연필", "모나미", 7000); 
		Product p5 = new Product(167, "볼펜", "모나미", 3000);
		
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
			System.out.println("상품 번호: " + p.getNo());
			System.out.println("상  품  명: " + p.getName());
			System.out.println("제  조  사: " + p.getMaker());
			System.out.println("가       격: " + p.getPrice());
		}
		
		int size = products.size();
		System.out.println("저장된 상품객체 갯수: " + size);
		
		System.out.println(products);
	}

}
