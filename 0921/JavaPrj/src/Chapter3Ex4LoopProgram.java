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
		String word = scan.next();//���Ⱑ ������ �� ���� �ܾ ������
		//String word2 = scan.next();
		String line = scan.nextLine();//���⸦ ������ ���� ��ü�� ������
		String line2 = scan.nextLine();
		//System.out.println(a);
		System.out.println(word);
		//System.out.println(word2);
		
		System.out.println(line);//�ٹٲ޵� ���ڷ� �ν��ؼ�  �� ������ ������.
		System.out.println(line2);
		*/
		int i=0;
		while(scan.hasNextInt()) {
			int num = scan.nextInt();
			/*
			System.out.println(num);
			if((i+1) ==4) {//��ü�� �ݺ��ϴ� �߿� ~������ �ض�~ �ϸ� break�� ���� Ȱ������!!
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
