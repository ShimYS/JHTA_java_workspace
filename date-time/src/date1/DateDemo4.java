package date1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo4 {

	public static void main(String[] args) throws ParseException {
		/*s
		 * �ۼ��� ���ڿ��� ������ ��¥ �������� ��ȯ�ϱ�
		 */
		
		String text = "1990.03.05.";
		SimpleDateFormat df = new SimpleDateFormat("yyyy.M.d");
//		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd"); => ������ Ʋ���� ���� ���Ѵ�. => Ʋ���� ����ó��
		Date date = df.parse(text);
		System.out.println(date);
	}

}
