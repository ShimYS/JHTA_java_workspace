package collection.recruit.vo;
/**
 * ��»��� ������ ��� ��ü�� ���赵.
 * @author ShimYS
 *
 */
public class Career {

	private String companyName; // �����ߴ� ȸ���
	private String dept;		// �ٹ��ߴ� �μ���
	private String position;	// ���� ����(���, �븮, ����, ����, ����, �̻�)
	private int year;			// �ٹ��Ⱓ(�����)
	
	public Career() {}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
}
