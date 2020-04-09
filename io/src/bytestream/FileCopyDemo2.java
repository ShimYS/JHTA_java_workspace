package bytestream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyDemo2 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		FileInputStream fis = new FileInputStream("C:/files/sample2.txt");
		FileOutputStream fos = new FileOutputStream("C:/files/sample4.txt");
		
		
		// read() 메소드
		// 		return 
		//			next byte => 다음 읽어올 데이터가 있을때
		//			-1 		  => 다음 읽어올 데이터가 없을때
		int value = 0;
		while((value = fis.read()) != -1) {
			fos.write(value);
		}
		fis.close();
		fos.close();
	}

}
