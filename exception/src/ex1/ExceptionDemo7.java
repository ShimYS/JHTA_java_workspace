package ex1;

public class ExceptionDemo7 {
	
	public static void main(String[] args) {
		
	}
	
	// CheckedException
	//		RuntimeException�� �ڼ��� �ƴ� ��� Exception�� CheckedException�̴�.
	//		CheckedException�� �����Ϸ��� ����ó�� ���� ���θ� �ݵ�� üũ�Ѵ�.
	//		try ~ catch�� throw�� �̿��� ����ó���� �ݵ�� �����Ǿ� �־�� �Ѵ�.
	public static void checkedException() {
		try {
			throw new Exception();
		} catch(Exception e) {
			//���๮;
		}
	}

	public static void checkedException2() throws Exception {
			throw new Exception();	
	}
	
	// UncheckedException
	//		RuntimeException�� ���� �ڼ��� ���� UncheckedException�̴�.
	//		UncheckedException�� �����Ϸ��� ����ó�� ���� ���θ� üũ���� �ʴ´�.
	//		���������� �ʿ��� ��� ����ó���� �ϴ� �͵� �����ϴ�.
	public static void uncheckedException() {
		throw new RuntimeException();
	}
}
