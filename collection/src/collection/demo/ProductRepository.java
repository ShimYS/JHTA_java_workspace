package collection.demo;

import java.util.ArrayList;

import vo.Product;

public class ProductRepository {

	ArrayList<Product> db = new ArrayList<Product>();
	int sequence = 10000;
	
	// 새 상품 등록 가능
	public void insertProduct(Product product) {
		product.setNo(sequence++);
		db.add(product);
	}
	
	// 등록된 모든 상품을 반환하는 기능
	public ArrayList<Product> getAllProducts(){
		return db;
	}
	
	// 전달받은 상품번호에 해당하는 상품을 반환하는 기능
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
	
	// 전달받은 상품명에 해당하는 상품을 반환하는 기능
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
	
	// 전달받은 상품번호에 해당하는 상품을 삭제하는 기능
	public void deleteProduct(int productNo) {
		for(Product product : db) {
			if(productNo == product.getNo()) {
				db.remove(product);
			}
		}
	}
	
}
