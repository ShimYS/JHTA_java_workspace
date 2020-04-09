package bytestream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyDemo3 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		FileInputStream fis = new FileInputStream("C:/files/java.png");
		FileOutputStream fos = new FileOutputStream("C:/files/java_copy.png");
		
		int value = 0;
		while( (value = fis.read()) != -1) {
			fos.write(value);
		}
		
		fis.close();
		fos.close();
	}

}
