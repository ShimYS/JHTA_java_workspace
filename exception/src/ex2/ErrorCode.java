package ex2;

import java.util.HashMap;
import java.util.Map;

public class ErrorCode {
	
	private Map<String, String> errorCodes = new HashMap<String, String>();
	
	public ErrorCode() {
		errorCodes.put("ERROR_USER_001", "���̵� �ߺ��Ǿ����ϴ�.");
		errorCodes.put("ERROR_USER_002", "���Ե��� ���� ���̵��Դϴ�.");
		errorCodes.put("ERROR_USER_003", "��й�ȣ�� �������� �ʽ��ϴ�.");
		errorCodes.put("ERROR_USER_004", "�������� ���̵��Դϴ�.");
		errorCodes.put("ERROR_USER_005", "�������� ���� ��й�ȣ �����Դϴ�.");
	}
	
	public String getDescription(String errorCode) {
		return errorCodes.get(errorCode);
	}
}
