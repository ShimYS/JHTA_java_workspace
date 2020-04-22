package Quiz;

public class cal2016 {
	class Solution {
		  public String solution(int a, int b) {
		      String[] months = {"FRI","SAT","SUN","MON","TUE","WED","THU",};
		      int[] lastday = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		      int day = 0;
		      for(int i=0; i<(a-1); i++){
		          day += lastday[i];
		      }
		      day += b-1;
		      int count = day%7;
		      String answer = months[count];
		      
		      return answer;
		  }
		}
}
