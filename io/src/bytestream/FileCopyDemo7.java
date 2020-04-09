package bytestream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.commons.io.IOUtils;

public class FileCopyDemo7 {

	public static void main(String[] args) throws IOException {
		
		URL url = new URL("http://imgnews.naver.net/image/410/2020/02/17/0000669910_001_20200217103612773.jpg");
		
		InputStream is = url.openStream();
		FileOutputStream fos = new FileOutputStream("C:/files/image.jpg");
		
		IOUtils.copy(is, fos);
	}

}
