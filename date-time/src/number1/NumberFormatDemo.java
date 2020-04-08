package number1;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class NumberFormatDemo {

	public static void main(String[] args) {
		
		double number = 1234567.89;
		
		// DecimalFormat
		// ���ڸ� ������ ������ �ؽ�Ʈ�� ��ȯ�Ѵ�.
		
//		DecimalFormat df = new DecimalFormat("0000000.00");
//		DecimalFormat df1 = new DecimalFormat("0");
//		DecimalFormat df = new DecimalFormat("00000000000000000");
//		DecimalFormat df = new DecimalFormat("#################");
//		DecimalFormat df = new DecimalFormat("0.0");
//		DecimalFormat df = new DecimalFormat("#.#");
//		DecimalFormat df = new DecimalFormat(",");
//		DecimalFormat df = new DecimalFormat("0.000");
//		DecimalFormat df = new DecimalFormat("#.###");
//		DecimalFormat df = new DecimalFormat("0,000");
//		DecimalFormat df = new DecimalFormat("#,###");
//		DecimalFormat df = new DecimalFormat("0,000.000");
		DecimalFormat df = new DecimalFormat("#,###.###");
		String text = df.format(number);
		System.out.println(text);
		/*
		 * "0"					1234568
		 * "#"					1234568
		 * "00000000000"		001234568
		 * "###########"		1234568
		 * "0.0"				1234567.9
		 * "#.#"				1234567.9
		 * "0.000"				1234567.890			//���° �ڸ����� �ݿø��Ѱ��� �� �� �ִ�.
		 * "#.###"				1234567.89
		 * "0,000"				1,234,568
		 * "#,###"				1,234,568
		 * "0,000.000"			1,234,567.890
		 * "#,###.###"			1,234,567.89
		 */
	}

}
/*
*	��ȣ		�ǹ�			����								
*	-------------------------------------------------------------------
*	0		����			�ش���ġ�� ���ڰ� ��� 0�� ǥ���Ѵ�.		
*	#		����			�ش���ġ�� ���ڰ� ������ ǥ������ �ʴ´�.		
*	.		�Ҽ���		
*	,		����������		
*/