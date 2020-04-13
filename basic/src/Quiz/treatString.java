package Quiz;

public class treatString {
	
	if(s.length() != 4 && s.length() != 6){
		return false;
	}
	
	boolean answer = true;
    char[] arr = s.toCharArray();
    int count = 0;
    for(int i=0; i<arr.length; i++){
        if(Character.isDigit(arr[i])){
            count++;
        }
    }
    if(count == s.length()){
        answer = true;
    } else {
        answer = false;
    }
    return answer;
    
    
    
    
//    try {
//        Integer.parseInt(s);
//        return true;
//    } catch (Exception e){
//        return false;
//    }
}
