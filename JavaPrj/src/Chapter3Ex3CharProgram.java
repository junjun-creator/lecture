import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Chapter3Ex3CharProgram {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Work\\img1.bmp");//file�� �о� �鿩���� ��Ʈ�� ��ü ����
		FileOutputStream fos = new FileOutputStream("C:\\Work\\img1-copy.bmp");
		
		
		
		while(true) {
			int b = fis.read();
			if(b == -1)
				break;
			fos.write(b);
			
		}
		fis.close();
		fos.close();
	}
}