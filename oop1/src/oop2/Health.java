package oop2;

/**
 * �ǰ����� ������ ����ϴ� ����� �����ϴ� Ŭ������.
 * @author ShimYS
 *
 */
public class Health {
	
	/**
	 * ü���������� ����ؼ� �� ���� ��ȯ�Ѵ�.
	 * @param weight ������, Kg����
	 * @param height Ű, m����
	 * @return ü��������
	 */
	double bmi(double weight, double height) {
		double bodyMassIndex = weight/(height*height);
		return bodyMassIndex;
	}
	
	/**
	 * ü���������� ����ؼ�, ������ ���� ��, ����, ��ü�� ���� ���� ��ȯ�Ѵ�.
	 * @param weight ������, Kg����
	 * @param height Ű, m����
	 * @return ü��������, ����/��������/�浵��/��ü��/����/��ü�� �� �ϳ��� ��ȯ
	 */
	String bmiText(double weight, double height) {
		String bmiGrade = "";
		double bmi = weight/(height*height);
		
		if(bmi >= 40) {
			bmiGrade = "����";
		} else if(bmi >= 35) {
			bmiGrade = "��������";
		} else if(bmi >= 30) {
			bmiGrade = "�浵��";
		} else if(bmi >= 25) {
			bmiGrade = "��ü��";
		} else if(bmi >= 18.5) {
			bmiGrade = "����";
		} else {
			bmiGrade = "��ü��";
		}
		
		return bmiGrade;
	}
}
