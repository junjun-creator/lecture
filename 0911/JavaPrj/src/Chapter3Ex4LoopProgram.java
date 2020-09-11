import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Chapter3Ex4LoopProgram {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream("res/data.txt");
		Scanner scan = new Scanner(fis);
		/*
		//int a = scan.nextInt();
		String word = scan.next();//띄어쓰기가 있으면 그 앞의 단어만 가져옴
		//String word2 = scan.next();
		String line = scan.nextLine();//띄어쓰기를 포함한 라인 전체를 가져옴
		String line2 = scan.nextLine();
		//System.out.println(a);
		System.out.println(word);
		//System.out.println(word2);
		
		System.out.println(line);//줄바꿈도 문자로 인식해서  그 라인을 가져옴.
		System.out.println(line2);
		*/
		int i=0;
		while(scan.hasNextInt()) {
			int num = scan.nextInt();
			/*
			System.out.println(num);
			if((i+1) ==4) {//전체를 반복하는 중에 ~까지만 해라~ 하면 break를 적극 활용하자!!
				break;
			}*/
			
			if((i+1)<4) {
				i++;
				continue;
			}
			System.out.println(num);
			
			i++;
		}
		fis.close();
	}

}
