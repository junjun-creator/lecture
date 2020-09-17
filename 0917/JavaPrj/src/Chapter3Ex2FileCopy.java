import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Chapter3Ex2FileCopy {
	public static void main(String[] args) throws IOException {
		
		//fos를 이름으로 갖는 fileoutputstream 객체를 생성한다. 파일명은 C:\\Work\\img1-copy.bmp로 한다.
		FileOutputStream fos = new FileOutputStream("res/data.txt");
		
		//fos.write('A');
		//fos.write(65);
		
		int alphaSize = 'Z'-'A'+1;//26
		int i=0;
		while(i<alphaSize) {//이게 좋은코드다 
			fos.write('A'+(i%13));
			i++;
		}
		/*
		int alphaSize = 'Z'-'A'+1;
		int i=alphaSize-1;//26개니까 A>Z 25를 더하면 되니까
		while(i>=0) {
			fos.write('A'+i);//ZYX```````
			i--;
		}*/
		fos.flush();
		//리소스를 닫는 함수
		fos.close();
		
		int z = 'Z';
		System.out.println(z);
	}
}