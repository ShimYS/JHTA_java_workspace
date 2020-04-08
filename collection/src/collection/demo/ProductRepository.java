package collection.demo;

import java.util.ArrayList;

import vo.Product;

public class ProductRepository {

	ArrayList<Product> db = new ArrayList<Product>();
	int sequence = 10000;
	
	// �� ��ǰ ��� ����
	public void insertProduct(Product product) {
		product.setNo(sequence++);
		db.add(product);
	}
	
	// ��ϵ� ��� ��ǰ�� ��ȯ�ϴ� ���
	public ArrayList<Product> getAllProducts(){
		return db;
	}
	
	// ���޹��� ��ǰ��ȣ�� �ش��ϴ� ��ǰ�� ��ȯ�ϴ� ���
	public Product getProductByNo(int productNo) {
		Product result = null;
		
		for(Product product : db) {
			if(productNo == product.getNo()) {
				result = product;
				break;
			}
		}
		
		return result;
	}
	
	// ���޹��� ��ǰ�� �ش��ϴ� ��ǰ�� ��ȯ�ϴ� ���
	public ArrayList<Product> searchProducts(String keyword){
		ArrayList<Product> result = new ArrayList<Product>();
		
		for(Product product : db) {
			String productName = product.getName();
			String productMaker = product.getMaker();
			
			if(productName.contains(keyword) || productMaker.contains(keyword)) {
				result.add(product); 
			}
		}
		
		return result;
	}
	
	// ���޹��� ��ǰ��ȣ�� �ش��ϴ� ��ǰ�� �����ϴ� ���
	public void deleteProduct(int productNo) {
		for(Product product : db) {
			if(productNo == product.getNo()) {
				db.remove(product);
			}
		}
	}
	
}
