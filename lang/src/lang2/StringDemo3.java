package lang2;

import java.util.StringJoiner;

public class StringDemo3 {
	
	public static void main(String[] args) {
		
		// String.join(CharSequence ������, CharSequence... element)
		// CharSequence... => �������� �Ű�����(�׻� �Ű����� �� �������� ��ġ�ؾ��Ѵ�) => �迭�� �ְų�, �������� �ְų�
		// CharSequence => 
		
		String[] names = {"������", "�̼���", "������", "������"};
		String text1 = String.join(":", names);
		System.out.println(text1);
		
		String text2 = String.join("_", "�ڹ�","���̽�","���","��","��","�ٸ���","��Ʋ��");
		System.out.println(text2);
		
		// StringJoiner
		// new StringJoiner(CharSequence ������)
		// new StringJoiner(CharSequence ������, CharSequence ���λ�, CharSequence ���̻�)
		// void add(CharSequence item) : StringJoiner�� �������� �߰��Ѵ�.
		// String toString() : StringJoiner�� �߰��� �������� ���� �̾�ٿ��� ���ڿ��� ��ȯ�Ѵ�.
		String[] fileNames = {"�ް���û��", "������û��", "������"};
		StringJoiner joiner1 = new StringJoiner(",");
		for(String name : fileNames) {
			joiner1.add(name);
		}
		String text3 = joiner1.toString();
		System.out.println(text3);
		
	}
}
