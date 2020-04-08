package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortDemo5 {

	public static void main(String[] args) {
		ArrayList<Score> list = new ArrayList<Score>();
		list.add(new Score(10, "������", 289));
		list.add(new Score(12, "�̼���", 258));
		list.add(new Score(3, "������", 284));
		list.add(new Score(6, "������", 249));
		list.add(new Score(31, "������", 279));
		list.add(new Score(18, "���߱�", 164));
		list.add(new Score(21, "�̺�â", 210));
		
		Collections.sort(list, new Comparator<Score>() {
			@Override
			public int compare(Score score1, Score score2) {
				// �񱳰��� ������ ��� ���ֱ⸸ �ϸ� �ȴ�. => �������� ����
				// ��ü�� -1�� �����ָ� => �������� ����
				return (score1.getTotalScore() - score2.getTotalScore()) * -1 ;
			}
		});
		
		Collections.sort(list, (score1, score2) -> score1.getTotalScore() - score2.getTotalScore());
		
		for(Score score : list) {
			System.out.println(score.getNo()+"\t"+score.getName()+"\t"+score.getTotalScore());
		}
	}

}
