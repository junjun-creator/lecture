import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Chapter3Ex2FileCopy {
	public static void main(String[] args) throws IOException {
		
		//fos�� �̸����� ���� fileoutputstream ��ü�� �����Ѵ�. ���ϸ��� C:\\Work\\img1-copy.bmp�� �Ѵ�.
		FileOutputStream fos = new FileOutputStream("res/data.txt");
		
		//fos.write('A');
		//fos.write(65);
		
		int alphaSize = 'Z'-'A'+1;//26
		int i=0;
		while(i<alphaSize) {//�̰� �����ڵ�� 
			fos.write('A'+(i%13));
			i++;
		}
		/*
		int alphaSize = 'Z'-'A'+1;
		int i=alphaSize-1;//26���ϱ� A>Z 25�� ���ϸ� �Ǵϱ�
		while(i>=0) {
			fos.write('A'+i);//ZYX```````
			i--;
		}*/
		fos.flush();
		//���ҽ��� �ݴ� �Լ�
		fos.close();
		
		int z = 'Z';
		System.out.println(z);
	}
}