package bytestream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

public class FileCopyDemo6 {

	public static void main(String[] args) throws FileNotFoundException, IOException {		
		FileInputStream fis = new FileInputStream("C:/files/picpick_inst_kr.exe");
		FileOutputStream fos = new FileOutputStream("C:/files/picpick_inst_kr_copy2.exe");
		
		IOUtils.copy(fis, fos);
	}

}
