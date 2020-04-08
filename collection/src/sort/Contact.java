package sort;

public class Contact implements Comparable<Contact> {
	
	private int no;
	private String name;
	private String tel;
	private String email;
	
	public Contact() {}

	public Contact(int no, String name, String tel, String email) {
		super();
		this.no = no;
		this.name = name;
		this.tel = tel;
		this.email = email;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	/*
	 * �� ��ü�� �ٸ� Contact�� ���ϴ� �޼ҵ带 �������Ѵ�.
	 * 		��ȣ(no)�� �������� ���ϴ� ���
	 * 			�� ��ü�� ��ȣ�� �ٸ� ��ü�� ��ȣ���� ũ�� 0���� ū ���� ��ȯ
	 * 			�� ��ü�� ��ȣ�� �ٸ� ��ü�� ��ȣ�� ������ 0�� ��ȯ
	 * 			�� ��ü�� ��ȣ�� �ٸ� ��ü�� ��ȣ���� ������ 0���� ���� ���� ��ȯ 
	 * 
	 * 		��ȣ�� �������̴�. 
	 * 		�� ��ü�� ��ȣ�� �ٸ� Contact��ü�� ��ȣ�� ���� �����ϸ� �ȴ�.
	 */
//	@Override
//	public int compareTo(Contact other) {
//		// �������� ��
//		return this.no - other.no;
//	}

	
	/*
	 * �� ��ü�� �ٸ� Contact�� ���ϴ� �޼ҵ带 �������Ѵ�.
	 * 		�̸�(name)�� �������� ���ϴ� ���
	 * 	
	 * 		�̸��� ���ڿ��̴�. String���� �ٸ� String�� ���ϴ� compareTo(String o)�� �̹� �����Ǿ� �ִ�.
	 * 		String�� ������ compareTo(String o)�� ����ؼ�
	 * 		�� ��ü�� �̸��� �ٸ� contact ��ü�� �̸��� ���ϸ� �ȴ�.
	 * 
	 * 		email�� name��� �־��ָ� email�� ���Ѵ�.
	 */
	@Override
	public int compareTo(Contact other) {
		return this.name.compareTo(other.getName());
	}
	
}
