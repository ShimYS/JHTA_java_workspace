package operator;

public class OpDemo6 {
	public static void main(String[] args) {
		// ���ڿ� ��
		// equals() �޼ҵ带 ����ؼ� ���ڿ��� ������ ������.
		
		// ���ڿ� ���ͷ��� �̿��ؼ� String��ü�� �����ϰ� �Ǹ�
		// ������ ���ڿ��� ��� ���� ��ü�� ������ �ʰ� ���� ��ü�� ���� ����Ѵ�.
		// ��, str1�� str2�� �����ϴ� ��ü�� ������ ��ü��.(�����ּҰ��� ���� ����)
		String str1 = "ȫ�浿";
		String str2 = "ȫ�浿";
		
		System.out.println(str1 == str2);		//true (str1�� str2�� �����ּҰ��� �����ϱ� ������)
		System.out.println(str1.equals(str2));	//true
		System.out.println(str2.equals(str1));	//true
		
		// new Ű���带 �̿��ؼ� String��ü�� �����ϰ� �Ǹ�
		// �Ϲ����� ��ü��ó�� �Ź� ���ο� ��ü�� �����ϰ� �����ϰ� �ȴ�.
		// ��, str3�� str4�� �����ϴ� ��ü�� ���� �ٸ� ��ü��.(�����ּҰ��� ���� �ٸ���)
		String str3 = new String("ȫ�浿");
		String str4 = new String("ȫ�浿");
		
		System.out.println(str3 == str4);		//false
		System.out.println(str3.equals(str4));	//true
		System.out.println(str4.equals(str3));	//true
		
		// equals() �޼ҵ�� String��ü�� ������İ� ������� ���ڿ��� ������ ���ϱ� ������
		// ���ڿ��� ������ �����ϱ⸸ �ϸ� true�� ȹ��ȴ�.
		System.out.println(str1.equals(str3));	//true
		System.out.println(str2.equals(str4));	//true
		
	}
}
