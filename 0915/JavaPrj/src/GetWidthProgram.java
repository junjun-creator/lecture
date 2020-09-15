import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GetWidthProgram {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Work\\img1.bmp");
		
		for(int i=0;i<18;i++) {
			fis.read();
		}
		
		int b1 = fis.read();
		int b2 = fis.read();
		int b3 = fis.read();
		int b4 = fis.read();
		
		int totalSize;
		totalSize = (b4&0xff)<<24 | (b3&0xff)<<16 | (b2&0xff)<<8 | (b1&0xff); //LE방식으로 읽어야 하기때문
		
		System.out.printf("file size is %d\n",totalSize);
		fis.close();

	}

}
