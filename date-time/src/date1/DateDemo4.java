package date1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo4 {

	public static void main(String[] args) throws ParseException {
		/*s
		 * 작성된 문자열을 지정된 날짜 형식으로 변환하기
		 */
		
		String text = "1990.03.05.";
		SimpleDateFormat df = new SimpleDateFormat("yyyy.M.d");
//		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd"); => 형식이 틀리면 읽지 못한다. => 틀리면 예외처리
		Date date = df.parse(text);
		System.out.println(date);
	}

}
