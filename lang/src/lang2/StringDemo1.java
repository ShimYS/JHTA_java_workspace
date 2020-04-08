package lang2;

public class StringDemo1 {

	public static void main(String[] args) {
		// String클래스의  주요 메소드
		// 문자열은 한번 만들어지면 불변이다.
		
		// int length() : 문자열의 길이를 반환한다.
		String str1 = "hello";
		int len = str1.length();
		System.out.println("문자열의 길이: " + len);
		
		// boolean equals(Object other) : 자신과 other로 전달받은 내용을 비교해서 결과 반환.
		// boolean equalsIgnoreCase(String other) : 대소문자를 구분하지 않고 비교해서 그 결과를 반환한다.
		boolean b1 = str1.equals("HELLO");
		boolean b2 = str1.equalsIgnoreCase("HELLO");
		System.out.println("hello와 HELLO가 같은가? " + b1);
		System.out.println("hello와 HELLO가 같은가? " + b2);
		
		// String substring(int begin) : 지정된 위치에서부터 끝까지 포함된 새로운 문자열을 반환한다.
		// String substring(int begin, int end) : 지정된 범위내 포함된 새로운 문자열을 반환한다.
		// 잘라내는게 아니라 새로운 문자열을 만드는것 
		String str2 = "전문가를 위한 스프링5 개정5판";
		String s1 = str2.substring(8);
		String s2 = str2.substring(3, 9);
		System.out.println("8번째부터 끝까지를 포함하는 문자열: " + s1);
		System.out.println("3번째부터 9번째까지를 포함하는 문자열: " + s2);
		
		// String toUpperCase() : 대문자로 변환된 새로운 문자열을 반환한다.
		// String toLowerCase() : 소문자로 변환된 새로운 문자열을 반환한다.
		// 원본은 그대로 있고 새로운 문자열을 만들어낸다.
		String str3 = "Return TRUE if, and only if, length() is 0.";
		String s3 = str3.toUpperCase();
		String s4 = str3.toLowerCase();
		System.out.println("원본 문자열: " + str3);
		System.out.println("대문자로 구성된 문자열: " + s3);
		System.out.println("소문자로 구성된 문자열: " + s4);
		
		// String replace(CharSequence old, CharSequence new) : 지정된 문자열(old)을 새문자열(nw)로 변환하여 반환한다.  
		// String replaceAll(String regex, String replacement) : 문자열에서 지정된 정규표현식과 일치하는 문자열을 찾아서 새 문자열로 반환하여 반환한다.
		String str5 = "중앙HTA학원과 새중앙HTA학원은 별도의 법인이다";
		String s5 = str5.replace("중앙", "현대");		
		System.out.println("원본 문자열: " + str5);
		System.out.println("바뀐 문자열: " + s5);
		
		String str6 = "010-1111-2222, 010-2222-3333";
		String s6 = str6.replaceAll("\\d{3}", "***");
		System.out.println("숫자를 *로 바꾼 새문자열: " + s6);
		
		// String[] split(String regexp) : 문자열을 지정된 표현식(혹은 구분문자)로 자른 새로운 배열을 반환한다.
		String str7 = "S0001,전자공학과,회로이론실습,홍길동,3";
		String[] items = str7.split(",");
		System.out.println("과목코드:\t" + items[0]);
		System.out.println("학      과:\t" + items[1]);
		System.out.println("과  목  명:\t" + items[2]);
		System.out.println("담당교수:\t" + items[3]);
		System.out.println("학      점:\t" + items[4]);
		
		// boolean contains(CharSequence s) : 문자열에 지정된 문자열이 포함되어 있으면 true를 반환하다.
		// int indexOf(String str) : 문자열에 지정된 문자열이 있으면 그 위치를 반환한다. 없으면 -1를 반환한다.
		// int lastIndexOf(String str) : 문자열에 지정된 문자열이 마지막으로 등장하는 위치를 반환한다. 없으면 -1를 반환한다.
		String str8 = "홍길동은 오늘 병원에 갔다. 병원에서 주사를 맞았다.";
		boolean b3 = str8.contains("주사");
		int pos1 = str8.indexOf("병원");
		int pos2 = str8.lastIndexOf("병원");
		System.out.println("문자열에 '주사'를 포함하고 있나? " + b3);
		System.out.println("문자열에서 '병원'이 처음으로 등장하는 위치는? " + pos1);
		System.out.println("문자열에서 '병원'이 마지막으로 등장하는 위치는? " + pos2);
		
		// boolean isEmpty() : 문자열의 길이ㅣ가 0이면 true를 
		boolean b4 = "안녕하세요".isEmpty();
		boolean b5 = "".isEmpty();
		boolean b6 = "      ".isEmpty();
		System.out.println("빈 문자열인가요? " + b4);
		System.out.println("빈 문자열인가요? " + b5);
		System.out.println("빈 문자열인가요? " + b6);
		
		// boolean startWith(String prefix) : 문자열이 지정된 문자열로 시작하면 true를 반환한다.
		// boolean endsWith(String suffix) : 문자열이 지정된 문자열로 끝나면 true를 반환한다.
		// 특정문자로 시작되는지 혹은 끝나는지를 알고 싶을때 사용.
		boolean b7 = "휴가신청서_홍길동.docx".startsWith("휴가신청서");
		boolean b8 = "휴가신청서_홍길동.docx".endsWith("docx");
		System.out.println("파일명이 휴가신청서로 시작되는가? " + b7);
		System.out.println("ms워드 파일인가? " + b8);
		
		// int compareTo(String other) : 다른 문자열과 사전순서를 기준으로 비교했을 때, 같으면 0, 빠르면 음수, 늦으면 양수를 반환한다.
		int n1 = "이순신".compareTo("김유신");
		int n2 = "이순신".compareTo("이순신");
		int n3 = "이순신".compareTo("허균");
		System.out.println("이순신과 김유신을 비교: " + n1);
		System.out.println("이순신과 이순신을 비교: " + n2);
		System.out.println("이순신과 허균을 비교: " + n3);
		
		// String trim() : 문자열에서 불필요한 좌우공백을 제거한 새로운 문자열을 반환한다.
		// 좌우 공백만 없앤다. 중간 공백은 의도적이라고 판단한다.
		String str9 = "    안녕     나는 로봇이야         ";
		String s7 = str9.trim();
		System.out.println("공백제거 전 ["+str9+"]");
		System.out.println("공백제거 후 ["+s7+"]");
		
		// String String.valueOf(다양한 값) : 전달받은 값을 문자열로 변환해서 반환한다.
		int num1 = 123456;
		int num2 = 7890;
		String s8 = String.valueOf(num1);
		String s9 = String.valueOf(num2);
		System.out.println(num1 + num2);
		System.out.println(s8 + s9);
	}

}
