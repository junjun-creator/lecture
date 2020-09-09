import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReadProgram {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Work\\img1.bmp");//file�� �о� �鿩���� ��Ʈ�� ��ü ����
		
		fis.read();
		fis.read();
		
		int b1 = fis.read();
		int b2 = fis.read();
		int b3 = fis.read();
		int b4 = fis.read();
		System.out.printf("%x\n",b1);
		System.out.printf("%x\n",b2);
		
		int totalSize;
		totalSize = (b4&0xff)<<24 | (b3&0xff)<<16 | (b2&0xff)<<8 | (b1&0xff); //LE������� �о�� �ϱ⶧��
		
		System.out.printf("file size is %d\n",totalSize);
		fis.close();
	}
}