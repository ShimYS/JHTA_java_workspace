package collection.recruit.vo;

import java.util.ArrayList;

/**
 * ���������� ��� ��ü�� ���赵
 * @author ShimYS
 *
 */

//����ڰ� ���������� �����ϴ� �̷¼�
public class Recruitment {
	
	private int no;		// ������û��ȣ, Repository���� �ڵ�����
	private Resume resume;		// �̷¼�����													
	private ArrayList<Career> careers = new ArrayList<Career>();	// ��»���
	private boolean isPassed;		// �հݿ���
	
	public Recruitment () {}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}

	public ArrayList<Career> getCareers() {
		return careers;
	}
	
	/**
	 * �Ѱ��� ��»��� �߰�
	 * @param career
	 */
	public void addCareer(Career career) {
		this.careers.add(career);
	}
	
	/**
	 * �������� ��»��� �߰�
	 * @param careers
	 */
	public void setCareers(ArrayList<Career> careers) {
		this.careers = careers;
	}

	public boolean isPassed() {
		return isPassed;
	}

	public void setPassed(boolean isPassed) {
		this.isPassed = isPassed;
	}
	
}
