package oop3;

public class ArgSample {
	
	// �⺻�ڷ��� Ÿ���� ���� �Ű������� ���޹޴� ���
	void changeValue(int num) {		
		System.out.println("changeValue()������ before num -----> " + num);
		num = 150;
		System.out.println("changeValue()������ after num -----> " + num);
	}
	
	// ������ Ÿ���� ���� �Ű������� ���޹޴� ���
	void changeDataValue(Data data) {
		System.out.println("changeDataValue()������ before num -----> " + data.num);
		data.num = 300;
		System.out.println("changeDataValue()������ after num -----> " + data.num);
	}
}
