package oop4;
/**
 * ��ǰ ���� ���񽺸� �����ϴ� Ŭ������.
 * �ű� ��ǰ ���, �̿���ǰ ���, ��ü ��ǰ ��ȸ,
 * �˻����(����, ������, ī�װ�, ���ݱ���)
 * �԰� ���, �Ǹű���� �����Ѵ�.
 * @author ShimYS
 *
 */
public class ProductService {
	
	Product[] db = new Product[20];
	int position = 0;
		
	// �迭�� ����� ��� ��ǰ������ ����Ѵ�.
	void printAllProducts() {
		System.out.println("=============================================================");
		System.out.println("������	���ǻ�	ī�װ�	����	������	���	���ǿ���");
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
		
	// ��ǰ��ü(�� ��ǰ, �̿���ǰ)�� ���޹޾Ƽ� �迭�� �����Ѵ�.
	void insertProduct(Product product) {
		db[position] = product;
		position++;
	}
	// ��ǰ��� �԰��� ���޹޾Ƽ� �̹� �迭�� ����� ��ǰ�� ����� ������Ų��.
	void addProductStock(String name, int stock) {		
		Product findProduct = this.searchName(name);

		if(findProduct != null) {
			findProduct.stock += stock;
			if(findProduct.isSoldOut) {
				findProduct.isSoldOut = false;
			}
		} else {
			System.out.println("�˻���� ��ġ�ϴ� ��ǰ�� �������� �ʽ��ϴ�.");
		}
	}
	
	// ��ǰ��� ����� ���޹޾Ƽ� �迭���� �ش� ��ǰ�� ã�Ƽ� ����� ���ҽ�Ų��.
	// ��, ������� ����� ���� ��� ���� �޼����� ǥ���Ѵ�.
	// ��, ����� 0�� �Ǹ� �ش��ǰ�� ���ǿ��θ� true�� �����Ѵ�.
	void exportProduct(String name, int amount) {
		Product findProduct = this.searchName(name);

		if(findProduct != null) {
			if(findProduct.stock < amount) {
				System.out.println("����� �����մϴ�.");
			} else {
				findProduct.stock -= amount;
				if(findProduct.stock == 0) {
					findProduct.isSoldOut = true;
				}
			}
		} else {
			System.out.println("�˻���� ��ġ�ϴ� ��ǰ�� �������� �ʽ��ϴ�.");
		}
	}
	
	// ��ǰ���� ���޹޾Ƽ� �迭���� ��ǰ���� ��ġ�ϴ� ��ǰ������ ����Ѵ�.
	void printProductByName(String name) {
		Product findProduct = this.searchName(name);

		if(findProduct != null) {
			findProduct.display();
		} else {
			System.out.println("�˻���� ��ġ�ϴ� ��ǰ�� �������� �ʽ��ϴ�.");
		}
	}

	// ��������� ���޹޾Ƽ� �迭���� ��ǰ���� ��ġ�ϴ� ��ǰ������ ����Ѵ�.
	void printProductByMaker(String maker) {
		for(int i=0; i<position; i++) {
			Product product = db[i];
			if(maker.equals(product.maker)) {
				product.display();
			} else {
				System.out.println("�˻���� ��ġ�ϴ� �����簡 �������� �ʽ��ϴ�.");
			}			
		}
	}
	
	// ī�װ����� ���޹޾Ƽ� �迭���� ��ǰ���� ��ġ�ϴ� ��ǰ������ ����Ѵ�.
	void printProductByCategory(String category) {
		for(int i=0; i<position; i++) {
			Product product = db[i];
			if(category.equals(product.category)) {
				product.display();
			} else {
				System.out.println("�˻���� ��ġ�ϴ� ��ǰ���� �������� �ʽ��ϴ�.");
			}			
		}		
	}
	
	// �������ݰ� �ְ����� ���޹޾Ƽ� �迭���� �ش� ���ݹ����� ���ϴ� ��ǰ������ ����Ѵ�.
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
	
	// �迭���� �Է¹��� ��ǰ���� ã�� �ش� ��ü�� ��ȯ�Ѵ�. 
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
