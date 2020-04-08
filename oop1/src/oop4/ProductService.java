package oop4;
/**
 * 상품 관리 서비스를 제공하는 클래스다.
 * 신규 상품 등록, 이월상품 등록, 전체 상품 조회,
 * 검색기능(제목, 제조사, 카테고리, 가격기준)
 * 입고 기능, 판매기능을 제공한다.
 * @author ShimYS
 *
 */
public class ProductService {
	
	Product[] db = new Product[20];
	int position = 0;
		
	// 배열에 저장된 모든 상품정보를 출력한다.
	void printAllProducts() {
		System.out.println("=============================================================");
		System.out.println("도서명	출판사	카테고리	가격	할인율	재고량	절판여부");
		System.out.println("=============================================================");
		for(int i=0; i<position; i++) {
			Product product = db[i];
			System.out.print(product.name + "	");
			System.out.print(product.maker + "	");
			System.out.print(product.category + "	");
			System.out.print(product.price + "	");
			System.out.print(product.discountRate + "	");
			System.out.print(product.stock + "	");
			System.out.println(product.isSoldOut);
		}
		System.out.println("=============================================================");
	}
		
	// 상품객체(새 상품, 이월상품)를 전달받아서 배열에 저장한다.
	void insertProduct(Product product) {
		db[position] = product;
		position++;
	}
	// 상품명과 입고량을 전달받아서 이미 배열에 저장된 상품의 재고량을 증가시킨다.
	void addProductStock(String name, int stock) {		
		Product findProduct = this.searchName(name);

		if(findProduct != null) {
			findProduct.stock += stock;
			if(findProduct.isSoldOut) {
				findProduct.isSoldOut = false;
			}
		} else {
			System.out.println("검색명과 일치하는 상품이 존재하지 않습니다.");
		}
	}
	
	// 상품명과 출고량을 전달받아서 배열에서 해당 상품을 찾아서 재고량을 감소시킨다.
	// 단, 재고량보다 출고량이 많은 경우 오류 메세지를 표시한다.
	// 단, 재고량이 0이 되면 해당상품의 절판여부를 true로 설정한다.
	void exportProduct(String name, int amount) {
		Product findProduct = this.searchName(name);

		if(findProduct != null) {
			if(findProduct.stock < amount) {
				System.out.println("재고량이 부족합니다.");
			} else {
				findProduct.stock -= amount;
				if(findProduct.stock == 0) {
					findProduct.isSoldOut = true;
				}
			}
		} else {
			System.out.println("검색명과 일치하는 상품이 존재하지 않습니다.");
		}
	}
	
	// 상품명을 전달받아서 배열에서 상품명이 일치하는 상품정보를 출력한다.
	void printProductByName(String name) {
		Product findProduct = this.searchName(name);

		if(findProduct != null) {
			findProduct.display();
		} else {
			System.out.println("검색명과 일치하는 상품이 존재하지 않습니다.");
		}
	}

	// 제조사명을 전달받아서 배열에서 상품명이 일치하는 상품정보를 출력한다.
	void printProductByMaker(String maker) {
		for(int i=0; i<position; i++) {
			Product product = db[i];
			if(maker.equals(product.maker)) {
				product.display();
			} else {
				System.out.println("검색명과 일치하는 제조사가 존재하지 않습니다.");
			}			
		}
	}
	
	// 카테고리명을 전달받아서 배열에서 상품명이 일치하는 상품정보를 출력한다.
	void printProductByCategory(String category) {
		for(int i=0; i<position; i++) {
			Product product = db[i];
			if(category.equals(product.category)) {
				product.display();
			} else {
				System.out.println("검색명과 일치하는 상품명이 존재하지 않습니다.");
			}			
		}		
	}
	
	// 최저가격과 최고가격을 전달받아서 배열에서 해당 가격범위에 속하는 상품정보를 출력한다.
	void printProductByPrice(int minPrice, int maxPrice) {
		Product findProduct = null;
		for(int i=0; i<position; i++) {
			Product product = db[i];
			if(product.price >= minPrice && product.price <= maxPrice) {
				findProduct = product;
				findProduct.display();
			} 		
		}		
	}
	
	// 배열에서 입력받은 상품명을 찾아 해당 객체를 반환한다. 
	Product searchName(String name) {
		Product product = null;
		for(int i=0; i<position; i++) {
			if(name.equals(db[i].name)) {
				product = db[i];
				break;
			}
		}
		return product;
	}
}
