package sort;

import java.util.ArrayList;
import java.util.Collections;

public class SortDemo4 {

	public static void main(String[] args) {
		
		ArrayList<Contact> contacts = new ArrayList<Contact>();
		
		contacts.add(new Contact(10, "������", "010-1111-2222", "ryu@gmail.com"));
		contacts.add(new Contact(7, "������", "010-2222-3333", "kang@gmail.com"));
		contacts.add(new Contact(3, "�̼���", "010-3333-4444", "lee@gmail.com"));
		contacts.add(new Contact(6, "������", "010-4444-5555", "kim@gmail.com"));
		contacts.add(new Contact(2, "������", "010-5555-6666", "yoon@gmail.com"));
		
		Collections.sort(contacts);
		
		for(Contact c : contacts) {
			System.out.println(c.getNo()+"\t"+c.getName()+"\t"+c.getTel()+"\t"+c.getEmail());
		}
	}

}
