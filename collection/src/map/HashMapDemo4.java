package map;

import java.util.ArrayList;
import java.util.HashMap;

public class HashMapDemo4 {

	public static void main(String[] args) {
		ArrayList<String> addresses = new ArrayList<String>();
		addresses.add("����Ư���� ���α� ���͵�");
		addresses.add("��⵵ ��õ�� ���̱�");
		addresses.add("��⵵ ������ �Ǽ���");
		addresses.add("����Ư���� ���빮�� �ϰ��µ�");
		addresses.add("��⵵ ����");
		addresses.add("���ϵ� ���̽�");
		addresses.add("��󳲵� ���ؽ�");
		addresses.add("��󳲵� â����");
		addresses.add("��󳲵� ���ֽ�");
		addresses.add("���ϵ� ���ֽ�");
		addresses.add("���ϵ� ���׽�");
		addresses.add("��õ������ ����");
		addresses.add("��⵵ ������");
		
		HashMap<String, Integer> result = new HashMap<String, Integer>();
		
		for(String addr : addresses) {
			int endPoint = addr.indexOf(" ");	// ���� ��ġ�� �˾Ƴ���.
			String sido = addr.substring(0, endPoint);	// 0���� ������ġ ������ ���ڿ��� �̾Ƴ���
			
			if(result.containsKey(sido)) {
				int count = result.get(sido);
				result.put(sido, count + 1);
				
			} else {
				result.put(sido, 1);
				
			}
		}	
	}
}
