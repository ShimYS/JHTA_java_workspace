package collection.recruit.repo;

import java.util.ArrayList;

import collection.recruit.vo.Recruitment;

public class RecruitmentRepository {
	
	private ArrayList<Recruitment> db = new ArrayList<Recruitment>();
	private int sequence = 100;
	
	// ������û �����ϱ�
	public int addRecruitment(Recruitment recruitment) {
		recruitment.setNo(sequence++);
		db.add(recruitment);
		return sequence - 1;
	}
	
	
	// ���� ������û �����ϱ�
	public void deleteRecruitmentByNo(int recruitmentNo) {
		for(Recruitment recruitment : db) {
			if(recruitmentNo == recruitment.getNo()) {
				db.remove(recruitment);
				break;
			}
		}
	}
	
	// ���� ������û ��Ȳ ��ȸ�ϱ�
	public Recruitment getRecruitmentByNo(int recruitmentNo) {
		Recruitment result = null;
		for(Recruitment recruitments : db) {
			if(recruitmentNo == recruitments.getNo()) {
				result = recruitments;
				break;
			}
		}
		return result;
		
	}

	// ��ü ������Ȳ ��ȸ�ϱ�
	public ArrayList<Recruitment> getAllRecruitments(){
		return db;
	}

}
