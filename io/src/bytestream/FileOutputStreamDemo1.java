package bytestream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileOutputStream;

public class FileOutputStreamDemo1 {
	
	public static void main(String[] args) throws IOException, IOException{
		
		FileOutputStream fos = new FileOutputStream("c:/files/sample2.txt");
		
		fos.write('h');
		fos.write('e');
		fos.write('l');
		fos.write('l');
		fos.write('o');
		fos.write(',');
		fos.write(' ');
		fos.write('w');
		fos.write('o');
		fos.write('r');
		fos.write('l');
		fos.write('d');
	}

}
