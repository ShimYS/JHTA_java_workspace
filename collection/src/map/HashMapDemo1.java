package map;

import java.util.HashMap;

public class HashMapDemo1 {
	
	public static void main(String[] args) {
		HashMap<String, String> contacts = new HashMap<String, String>();
		
		
		// HashMap객체에 key/value쌍으로 저장하기
		contacts.put("eungsu", "이응수");
		contacts.put("hong", "홍길동");
		contacts.put("hong123", "홍길동");
		contacts.put("kang", "강감찬");
		
		// HashMap객체에 저장된 값 조회하기
		String value = contacts.get("hong");
		System.out.println("key[hong]으로 조회한 값: " + value);
		
		// HashMap객체에 key가 이미 존재하는지 확인하기
		boolean exist = contacts.containsKey("kang");
		System.out.println("key[kang]가 존재하는가? " + exist);
		
		// HashMap객체에 저장된 entry(키/값의 쌍)의 갯수 조회하기
		int size = contacts.size();
		System.out.println("HashMap객체에 저장된 Entry의 총 갯수: " + size);
		
		// HashMap객체에 저장된 Entry 삭제하기
		contacts.remove("hong");
		
		// HashMap객체에 저장된 모둔 Entry 삭제하기
		contacts.clear();
		
		System.out.println(contacts);
	}
}
