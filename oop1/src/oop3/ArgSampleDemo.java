package oop3;

public class ArgSampleDemo {

	public static void main(String[] args) {
		
		
		// �⺻�ڷ��� ������ ������ �ִ� ���� �޼ҵ� ȣ�� �� ������ ���
		int num = 100;
		
		ArgSample sample = new ArgSample();
		
		System.out.println("main()���� changeValue() ���� �� num ---> " + num);
		sample.changeValue(num); // <--- num ������ ������ �ִ� ���� ����
		System.out.println("main()���� changeValue() ���� �� num ---> " + num);
		
		// ������ ������ ������ �ִ� �ּҰ��� �޼ҵ� ȣ�� �� ������ ���
		Data data = new Data();
		data.num = 200;
		
		System.out.println("main()���� changeDataValue() ���� �� num ---> " + data.num);
		sample.changeDataValue(data); // <--- data ������ ������ �ִ� �ּҰ��� ����
		System.out.println("main()���� changeDataValue() ���� �� num ---> " + data.num);
	}

}
