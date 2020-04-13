package Quiz;

import java.util.ArrayList;

public class hateSameNum {

	public static void main(String[] args) {
		int[] arr = {1,1,3,3,0,1,1};
		
		ArrayList answer = new ArrayList();
        int x = 0;
        int y = 0;
        int count = 0;
        
        for(int i=0; i<arr.length; i++){
            y = arr[i];
            if(x != y){
                answer.add(y);
                x = y;
                count++;
            }
        }
        
	}

}
