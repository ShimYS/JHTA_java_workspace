package bytestream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyDemo2 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		FileInputStream fis = new FileInputStream("C:/files/sample2.txt");
		FileOutputStream fos = new FileOutputStream("C:/files/sample4.txt");
		
		
		// read() �޼ҵ�
		// 		return 
		//			next byte => ���� �о�� �����Ͱ� ������
		//			-1 		  => ���� �о�� �����Ͱ� ������
		int value = 0;
		while((value = fis.read()) != -1) {
			fos.write(value);
		}
		fis.close();
		fos.close();
	}

}
