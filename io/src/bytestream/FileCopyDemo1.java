package bytestream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyDemo1 {

	public static void main(String[] args) throws FileNotFoundException, IOException{
		// sample2.txt를 읽어오는 스트림
		FileInputStream fis = new FileInputStream("c:/files/sample2.txt");
		// sample3.txt파일에 기록하는 스트림
		FileOutputStream fos = new FileOutputStream("c:/files/sample3.txt");
		
		int value1 = fis.read();
		fos.write(value1);
		int value2 = fis.read();
		fos.write(value2);
		int value3 = fis.read();
		fos.write(value3);
		int value4 = fis.read();
		fos.write(value4);
		int value5 = fis.read();
		fos.write(value5);
		// 파일속 글자량을 알 수 없다. => FileCopyDemo2에서 해결
		
		fis.close();
		fos.close();
	}

}
