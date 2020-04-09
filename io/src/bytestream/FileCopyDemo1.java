package bytestream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyDemo1 {

	public static void main(String[] args) throws FileNotFoundException, IOException{
		// sample2.txt�� �о���� ��Ʈ��
		FileInputStream fis = new FileInputStream("c:/files/sample2.txt");
		// sample3.txt���Ͽ� ����ϴ� ��Ʈ��
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
		// ���ϼ� ���ڷ��� �� �� ����. => FileCopyDemo2���� �ذ�
		
		fis.close();
		fos.close();
	}

}
