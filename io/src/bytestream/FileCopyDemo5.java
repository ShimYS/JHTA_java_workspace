package bytestream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyDemo5 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		System.out.println("파일 복사를 시작합니다.");
		long startTime = System.currentTimeMillis();
		
		FileInputStream fis = new FileInputStream("C:/files/picpick_inst_kr.exe");
		FileOutputStream fos = new FileOutputStream("C:/files/picpick_inst_kr_copy.exe");
		BufferedInputStream bis = new BufferedInputStream(fis);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		
		long size = fis.getChannel().size();
		int count = 0;
		int value = 0;
		System.out.print("[");
		while( (value = bis.read()) != -1 ) {
			bos.write(value);
			if(++count % (size/10) == 0) {
				System.out.print("#");
			}
		}
		
		bis.close();
		bos.close();
		fis.close();
		fos.close();
		
		long endTime = System.currentTimeMillis();
		System.out.println("]");
		System.out.println("파일 복사가 종료되었습니다.");
		System.out.println("소요시간: " + (endTime - startTime)/1000 + "초");
	}

}
