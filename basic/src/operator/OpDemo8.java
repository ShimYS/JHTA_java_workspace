package operator;

public class OpDemo8 {
	public static void main(String[] args) {
		// ���� ������(���׿�����)
		// ���ǽ�  ? ��1 : ��2
		// ���ǽ��� true/false ����� �����Ǵ� ���̾�� �Ѵ�.
		// ���ǽ��� �������� true�� ��� ��1
		//				false�� ��� ��2�� �������� �ȴ�.
		// ��1/��2�� ���� ���갪�� ������ Ÿ���̾�� �Ѵ�.
		
		int score = 67;
		String result = score >= 60 ? "�հ��Դϴ�" : "���հ��Դϴ�";
		System.out.println(result);
		
		// ������� "guest", "bronze", "silver"�� ��� ���űݾ��� 3%�� ����Ʈ�� �����ϰ�,
		// ������� "gold"�� ��� ���űݾ��� 5%�� ����Ʈ�� �����Ѵ�.
		String grade = "silver";
		int orderPrice = 500000;
		int point = grade.equals("gold") ? (int)(orderPrice * 0.05) : (int)(orderPrice * 0.03);
		System.out.println("��������Ʈ : " + point);
		
	}
}
