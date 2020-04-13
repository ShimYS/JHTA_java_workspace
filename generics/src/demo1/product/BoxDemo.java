package demo1.product;

public class BoxDemo {

	public static void main(String[] args) {
		
		// String 이 타입파라미터로 지정된 Box객체
		Box<String> box1 = new Box<String>();
		box1.add("안녕하세요");
		String value = box1.get();
		System.out.println(value);
		
		
		// Product가 타입파라미터로 지정된  Box객체
		Box<Product> box2 = new Box<Product>();
		box2.add(new Product("노트북", 1500000));
		Product p = box2.get();
		System.out.println(p.getName());
		System.out.println(p.getPrice());
	}

}
