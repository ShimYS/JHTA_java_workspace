package map;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapDemo5 {

	public static void main(String[] args) {
		
		HashMap<String, Integer> result = new HashMap<String, Integer>();
		result.put("����", 25);
		result.put("��õ", 4);
		result.put("���", 19);
		result.put("����", 3);
		result.put("��û", 6);
		result.put("����", 10);
		
		// HashMap�� ���  Key�� ��ȸ�ϱ�
		Set<String> keys = result.keySet();
		
		for(String key :keys) {
			int count = result.get(key);
			System.out.println("["+key+"] " + count);
		}
		
		System.out.println();
		
		// HashMap�� ��� Entry�� ��ȸ�ϱ�
		Set<Entry<String, Integer>> entries = result.entrySet();
		
		for(Entry<String, Integer> entry : entries) {
			String key = entry.getKey();
			int value = entry.getValue();
			System.out.println("["+key+"] "+ value);
		}
	}

}
