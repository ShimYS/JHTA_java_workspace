package sort;

import java.util.TreeSet;

public class SortDemo2 {
	public static void main(String[] args) {
		
		TreeSet<String> set = new TreeSet<String>();
		set.add("������");
		set.add("�̼���");
		set.add("���߱�");
		set.add("������");
		set.add("������");
		set.add("�豸");
		set.add("������");
		
		for ( String value :set ) {
			 System.out.println(value+"\t");
		}
	}
}
