package ex2;


// ��� ���� Ŭ������ �������� ����ϴ� �Ӽ��̳� ����� �����Ѵ�.
public abstract class CommonService {
	
	public void processError(String errorCode, String msg) {
		throw new HTAException(errorCode, msg);
	}
}
