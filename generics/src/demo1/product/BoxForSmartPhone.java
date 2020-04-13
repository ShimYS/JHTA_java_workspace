package demo1.product;

// 제네릭스의 제한
// 제네릭타입에 extends를 사용하면 특정 타입의 자손들만 타입파라미터로 대입할 수 있다.
// SmartPhone의 자식들만 저장하겠다.
// 여기서는 extends가 상속이 아님
public class BoxForSmartPhone<T extends SmartPhone> {
	private T t;
	
	public void add(T t) {
		this.t = t;
	}
	
	public T get() {
		return t;
	}
}
