package bytestream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.commons.io.IOUtils;

public class FileCopyDemo8 {

	public static void main(String[] args) throws IOException {
		// 사이트에서 접근권할을 주지 않아 Error발생
		URL url = new URL("https://kr.vuejs.org/v2/guide/index.html");
		
		InputStream is = url.openStream();
		FileOutputStream fos = new FileOutputStream("c:/files/vuejsGuide.html");
		
		IOUtils.copy(is, fos);
	}

}
