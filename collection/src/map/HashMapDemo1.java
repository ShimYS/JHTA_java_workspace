package map;

import java.util.HashMap;

public class HashMapDemo1 {
	
	public static void main(String[] args) {
		HashMap<String, String> contacts = new HashMap<String, String>();
		
		
		// HashMap��ü�� key/value������ �����ϱ�
		contacts.put("eungsu", "������");
		contacts.put("hong", "ȫ�浿");
		contacts.put("hong123", "ȫ�浿");
		contacts.put("kang", "������");
		
		// HashMap��ü�� ����� �� ��ȸ�ϱ�
		String value = contacts.get("hong");
		System.out.println("key[hong]���� ��ȸ�� ��: " + value);
		
		// HashMap��ü�� key�� �̹� �����ϴ��� Ȯ���ϱ�
		boolean exist = contacts.containsKey("kang");
		System.out.println("key[kang]�� �����ϴ°�? " + exist);
		
		// HashMap��ü�� ����� entry(Ű/���� ��)�� ���� ��ȸ�ϱ�
		int size = contacts.size();
		System.out.println("HashMap��ü�� ����� Entry�� �� ����: " + size);
		
		// HashMap��ü�� ����� Entry �����ϱ�
		contacts.remove("hong");
		
		// HashMap��ü�� ����� ��� Entry �����ϱ�
		contacts.clear();
		
		System.out.println(contacts);
	}
}
