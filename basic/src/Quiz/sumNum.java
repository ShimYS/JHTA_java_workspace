package Quiz;

public class sumNum {
	int a = 987;
	String b = Integer.toString(a);
	String[] c = b.split("");
	int sum = 0;
	for(int i=0; i<c.length; i++) {
		sum += Integer.parseInt(c[i]);
		System.out.println(i+", "+ c[i]);
	}
		System.out.println(sum);
		
		
		
//		int a = 12345;
//		int sum = 0;
//		
//		while(a != 0) {
//			sum += a%10;
//			a = a/10;
//		}
//		
//		System.out.println(sum);

}
