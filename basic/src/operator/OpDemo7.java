package operator;

public class OpDemo7 {
	
	public static void main(String[] args) {
		// ��������(���� ������)
		// &&   ||   !
		// and  or  not
		// ���������� �ǿ����ڴ� boolean���� �����ϴ� �����(Ȥ�� ǥ����)�̾�� �Ѵ�.
		// ���������� ���� ����� �׻� true/false �߿� �ϳ���.
		// �������ڴ� ���������� ������ �ʼ������� ���ȴ�.
		
		// ����Ÿ��� 50000km�̻��̰ų� ���ԱⰣ�� 5���� ���� ��� ����ó���Ѵ�.(OR����)
		int distance = 60000;
		int usedYear = 3;
		boolean isPay = (distance >= 50000 || usedYear > 5);
		boolean isPay2 = !(distance < 50000 && usedYear < 5);	//�������� �����ʴ�.
		System.out.println("����������� : " + isPay);
		System.out.println("����������� : " + isPay2);
		
		// ���� ���űݾ��� 100�����̻��̰�, 100��°, 200��°, 300��°, ...�� �湮�� ���� ����ǰ�� �����Ѵ�.(AND����)
		int orderPrice = 1400000;
		int visitCount = 157;
		boolean isGift = (orderPrice >= 1000000 && visitCount%100 == 0);
		System.out.println("����ǰ ���޿��� : " + isGift);
		
		// ���輺���� 90�� �̻��̰�, �г⼮���� 3�� �̳��� �л����� ���� ���б��� �����Ѵ�.(AND����)
		int score = 94;
		int ranking = 2;
		boolean isScholarship = (score >= 90 && ranking <= 3);
		System.out.println("���б� ���޿��� : " + isScholarship);
		
		String message = "�ȳ��ϼ���";
		boolean empty = message.isEmpty();
		System.out.println("�޼����� �����ϱ�? " + empty);
		System.out.println("�޼����� �ֽ��ϱ�? " + !empty);
	}
}
