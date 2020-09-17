import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Chapter4Ex4 {
	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream("res/list.txt");
		Scanner scan = new Scanner(fis,"UTF-8");//char-set 설정해주기
		
		String[] list = new String[27];
		
		{
			int i=0;
			
			while(scan.hasNextLine()) {
				list[i]=scan.nextLine();
				i++;
			}
		}
		
		fis.close();
		
		{//나중에 이 블럭이 함수화 된다
			Random rand = new Random();
			for(int i=0;i<1000;i++) {
				int s = rand.nextInt(27);
				int d = rand.nextInt(27);
				String temp;
				temp = list[s];
				list[s]=list[d];
				list[d]=temp;
			}
		}
		
		//출력
		int length = list.length;
		
		for(int i=0;i<length;i++) {
			if(i%4==0 && i/4==length/4)
				System.out.println("----깍두기----");
			else if(i%4==0 && i/4<length/4)
				System.out.println("-----"+ (i/4+1) +"조-----");
			System.out.println(list[i]);
		}
	}
}