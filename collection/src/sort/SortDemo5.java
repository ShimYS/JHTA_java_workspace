package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortDemo5 {

	public static void main(String[] args) {
		ArrayList<Score> list = new ArrayList<Score>();
		list.add(new Score(10, "김유신", 289));
		list.add(new Score(12, "이순신", 258));
		list.add(new Score(3, "강감찬", 284));
		list.add(new Score(6, "류관순", 249));
		list.add(new Score(31, "윤봉길", 279));
		list.add(new Score(18, "안중근", 164));
		list.add(new Score(21, "이봉창", 210));
		
		Collections.sort(list, new Comparator<Score>() {
			@Override
			public int compare(Score score1, Score score2) {
				// 비교값이 정수인 경우 빼주기만 하면 된다. => 오름차순 정렬
				// 전체에 -1을 곱해주면 => 내림차순 정렬
				return (score1.getTotalScore() - score2.getTotalScore()) * -1 ;
			}
		});
		
		Collections.sort(list, (score1, score2) -> score1.getTotalScore() - score2.getTotalScore());
		
		for(Score score : list) {
			System.out.println(score.getNo()+"\t"+score.getName()+"\t"+score.getTotalScore());
		}
	}

}
