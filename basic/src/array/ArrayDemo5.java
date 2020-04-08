package array;

public class ArrayDemo5 {

	public static void main(String[] args) {
		// 2차원배열
		int[][] scores = new int[2][3]; // 2행3열 배열
		// 0번행은 이순신의 국어, 영어, 수학점수
		scores[0][0] = 60;
		scores[0][1] = 80;
		scores[0][2] = 90;
		// 1번행은 김유신의 국어, 영어, 수학점수
		scores[1][0] = 50;
		scores[1][1] = 40;
		scores[1][2] = 40;
		
		for(int i=0; i<scores.length; i++) {
			for(int j=0; j<scores[i].length; j++) {
				System.out.println(i + "," + j + " ----> " + scores[i][j]);
			}
		}
		
		// 이순신의 점수 총점
		int total1 = 0;
		for(int i=0; i<3; i++) {
			total1 += scores[0][i];
		}
		System.out.println("이순신의 총점: "+total1);
		
		// 김유신의 점수 총점
		int total2 = 0;
		for(int i=0; i<3; i++) {
			total2 += scores[1][i];
		}
		System.out.println("김유신의 총점: "+total2);
		
		
	}

}
