package date1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo3 {
	
	public static void main(String[] args) {
		/*
		 * Date�� ������ ������ ���ڿ��� ��ȯ�ϱ�
		 */
		
		
		Date today = new Date();
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy�� M�� d�� EEEE a H");
		String formatedDateText = df.format(today);
		
		System.out.println(formatedDateText);
	}
}
/*
*	����					��³���
*	-----------------------------------------------------------
*	yyyy				��			2020
*	MM					��			04				1~9���� 01, 02, ..., 09�� ǥ��
*	M					��			4				
*	dd					��			06
*	d					��			6
*	yyyy-MM-dd						2020-04-06
*	yyyy.M.d						2020-4-6
*	yyyy�� M�� d��						2020�� 4�� 6��
*	EEEE				����			������
*	a					����/����		����
*	HH					0~23��
*	H
*	hh					1-12��
*	h
*	mm					0~59��
*	m
*	ss					0~59��
*	s
*				
*/