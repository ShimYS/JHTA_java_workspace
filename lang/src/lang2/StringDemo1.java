package lang2;

public class StringDemo1 {

	public static void main(String[] args) {
		// StringŬ������  �ֿ� �޼ҵ�
		// ���ڿ��� �ѹ� ��������� �Һ��̴�.
		
		// int length() : ���ڿ��� ���̸� ��ȯ�Ѵ�.
		String str1 = "hello";
		int len = str1.length();
		System.out.println("���ڿ��� ����: " + len);
		
		// boolean equals(Object other) : �ڽŰ� other�� ���޹��� ������ ���ؼ� ��� ��ȯ.
		// boolean equalsIgnoreCase(String other) : ��ҹ��ڸ� �������� �ʰ� ���ؼ� �� ����� ��ȯ�Ѵ�.
		boolean b1 = str1.equals("HELLO");
		boolean b2 = str1.equalsIgnoreCase("HELLO");
		System.out.println("hello�� HELLO�� ������? " + b1);
		System.out.println("hello�� HELLO�� ������? " + b2);
		
		// String substring(int begin) : ������ ��ġ�������� ������ ���Ե� ���ο� ���ڿ��� ��ȯ�Ѵ�.
		// String substring(int begin, int end) : ������ ������ ���Ե� ���ο� ���ڿ��� ��ȯ�Ѵ�.
		// �߶󳻴°� �ƴ϶� ���ο� ���ڿ��� ����°� 
		String str2 = "�������� ���� ������5 ����5��";
		String s1 = str2.substring(8);
		String s2 = str2.substring(3, 9);
		System.out.println("8��°���� �������� �����ϴ� ���ڿ�: " + s1);
		System.out.println("3��°���� 9��°������ �����ϴ� ���ڿ�: " + s2);
		
		// String toUpperCase() : �빮�ڷ� ��ȯ�� ���ο� ���ڿ��� ��ȯ�Ѵ�.
		// String toLowerCase() : �ҹ��ڷ� ��ȯ�� ���ο� ���ڿ��� ��ȯ�Ѵ�.
		// ������ �״�� �ְ� ���ο� ���ڿ��� ������.
		String str3 = "Return TRUE if, and only if, length() is 0.";
		String s3 = str3.toUpperCase();
		String s4 = str3.toLowerCase();
		System.out.println("���� ���ڿ�: " + str3);
		System.out.println("�빮�ڷ� ������ ���ڿ�: " + s3);
		System.out.println("�ҹ��ڷ� ������ ���ڿ�: " + s4);
		
		// String replace(CharSequence old, CharSequence new) : ������ ���ڿ�(old)�� �����ڿ�(nw)�� ��ȯ�Ͽ� ��ȯ�Ѵ�.  
		// String replaceAll(String regex, String replacement) : ���ڿ����� ������ ����ǥ���İ� ��ġ�ϴ� ���ڿ��� ã�Ƽ� �� ���ڿ��� ��ȯ�Ͽ� ��ȯ�Ѵ�.
		String str5 = "�߾�HTA�п��� ���߾�HTA�п��� ������ �����̴�";
		String s5 = str5.replace("�߾�", "����");		
		System.out.println("���� ���ڿ�: " + str5);
		System.out.println("�ٲ� ���ڿ�: " + s5);
		
		String str6 = "010-1111-2222, 010-2222-3333";
		String s6 = str6.replaceAll("\\d{3}", "***");
		System.out.println("���ڸ� *�� �ٲ� �����ڿ�: " + s6);
		
		// String[] split(String regexp) : ���ڿ��� ������ ǥ����(Ȥ�� ���й���)�� �ڸ� ���ο� �迭�� ��ȯ�Ѵ�.
		String str7 = "S0001,���ڰ��а�,ȸ���̷нǽ�,ȫ�浿,3";
		String[] items = str7.split(",");
		System.out.println("�����ڵ�:\t" + items[0]);
		System.out.println("��      ��:\t" + items[1]);
		System.out.println("��  ��  ��:\t" + items[2]);
		System.out.println("��米��:\t" + items[3]);
		System.out.println("��      ��:\t" + items[4]);
		
		// boolean contains(CharSequence s) : ���ڿ��� ������ ���ڿ��� ���ԵǾ� ������ true�� ��ȯ�ϴ�.
		// int indexOf(String str) : ���ڿ��� ������ ���ڿ��� ������ �� ��ġ�� ��ȯ�Ѵ�. ������ -1�� ��ȯ�Ѵ�.
		// int lastIndexOf(String str) : ���ڿ��� ������ ���ڿ��� ���������� �����ϴ� ��ġ�� ��ȯ�Ѵ�. ������ -1�� ��ȯ�Ѵ�.
		String str8 = "ȫ�浿�� ���� ������ ����. �������� �ֻ縦 �¾Ҵ�.";
		boolean b3 = str8.contains("�ֻ�");
		int pos1 = str8.indexOf("����");
		int pos2 = str8.lastIndexOf("����");
		System.out.println("���ڿ��� '�ֻ�'�� �����ϰ� �ֳ�? " + b3);
		System.out.println("���ڿ����� '����'�� ó������ �����ϴ� ��ġ��? " + pos1);
		System.out.println("���ڿ����� '����'�� ���������� �����ϴ� ��ġ��? " + pos2);
		
		// boolean isEmpty() : ���ڿ��� ���̤Ӱ� 0�̸� true�� 
		boolean b4 = "�ȳ��ϼ���".isEmpty();
		boolean b5 = "".isEmpty();
		boolean b6 = "      ".isEmpty();
		System.out.println("�� ���ڿ��ΰ���? " + b4);
		System.out.println("�� ���ڿ��ΰ���? " + b5);
		System.out.println("�� ���ڿ��ΰ���? " + b6);
		
		// boolean startWith(String prefix) : ���ڿ��� ������ ���ڿ��� �����ϸ� true�� ��ȯ�Ѵ�.
		// boolean endsWith(String suffix) : ���ڿ��� ������ ���ڿ��� ������ true�� ��ȯ�Ѵ�.
		// Ư�����ڷ� ���۵Ǵ��� Ȥ�� ���������� �˰� ������ ���.
		boolean b7 = "�ް���û��_ȫ�浿.docx".startsWith("�ް���û��");
		boolean b8 = "�ް���û��_ȫ�浿.docx".endsWith("docx");
		System.out.println("���ϸ��� �ް���û���� ���۵Ǵ°�? " + b7);
		System.out.println("ms���� �����ΰ�? " + b8);
		
		// int compareTo(String other) : �ٸ� ���ڿ��� ���������� �������� ������ ��, ������ 0, ������ ����, ������ ����� ��ȯ�Ѵ�.
		int n1 = "�̼���".compareTo("������");
		int n2 = "�̼���".compareTo("�̼���");
		int n3 = "�̼���".compareTo("���");
		System.out.println("�̼��Ű� �������� ��: " + n1);
		System.out.println("�̼��Ű� �̼����� ��: " + n2);
		System.out.println("�̼��Ű� ����� ��: " + n3);
		
		// String trim() : ���ڿ����� ���ʿ��� �¿������ ������ ���ο� ���ڿ��� ��ȯ�Ѵ�.
		// �¿� ���鸸 ���ش�. �߰� ������ �ǵ����̶�� �Ǵ��Ѵ�.
		String str9 = "    �ȳ�     ���� �κ��̾�         ";
		String s7 = str9.trim();
		System.out.println("�������� �� ["+str9+"]");
		System.out.println("�������� �� ["+s7+"]");
		
		// String String.valueOf(�پ��� ��) : ���޹��� ���� ���ڿ��� ��ȯ�ؼ� ��ȯ�Ѵ�.
		int num1 = 123456;
		int num2 = 7890;
		String s8 = String.valueOf(num1);
		String s9 = String.valueOf(num2);
		System.out.println(num1 + num2);
		System.out.println(s8 + s9);
	}

}
