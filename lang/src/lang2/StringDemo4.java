package lang2;

public class StringDemo4 {

	public static void main(String[] args) {
		// StringBuilder�� StringBuffer
		// �� ��ü ��� ���ڿ��� �ٷ�� ���� ��ü��.
		// ���ο� ����(�����)�� ������ �־, ���ڿ��� �߰�, ����, �����ϴ� ���� �����ϴ�.
		// �ֿ� �޼ҵ�
		//      ��ȯ��		    �޼ҵ�
		//		StringBuilder append(�پ���Ÿ���� ��) : �� �ڿ� ���δ�.
		//		StringBuilder delete(int begin, int end) : ������ ������ ���ڿ��� �����Ѵ�.
		//		StringBuilder insert(int position, �پ���Ÿ�� ��) : ������ ��ġ�� ���ڿ��� �����Ѵ�.
		//		StringBuilder replace(int start, int end, String str) : ������ ������ ���ڿ��� �� ���ڿ��� �����Ѵ�.
		//		String		  toString() : ���ۿ� ����� ���� �ϳ��� ���ڿ��� ��ȯ�Ѵ�.
		
		String name = "ȫ�浿";
		String tel = "010-1111-1111";
		String dept = "������";
		int workedYear = 6;
		int salary = 3500000;
		
		StringBuilder sb = new StringBuilder();
		sb.append("�̸�:");
		sb.append(name);
		sb.append(", ��ȭ��ȣ:");
		sb.append(tel);
		sb.append(", �ҼӺμ�:");
		sb.append(dept);
		sb.append(", �ٹ�����:");
		sb.append(workedYear);
		sb.append(", �޿�:");
		sb.append(salary);
		
		String text = sb.toString();
		System.out.println(text);
		
		
		StringBuffer sb1 = new StringBuffer();
		// �ڱ��ڽ��� ��ȯ�ϴ� �޼ҵ���� �޼ҵ带 �̾ ����� �� �ִ� => ??
		// StringBuffer�� StringBuilder�� �޼ҵ�ü�̴��� �����Ѵ�.
		String result = sb1.append("�̸�:")
						   .append(name)
						   .append(", ��ȭ��ȣ:")
						   .append(tel)
						   .toString();
		System.out.println(result);
	}
}
