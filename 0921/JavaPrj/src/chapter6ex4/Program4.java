package chapter6ex4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Program4 {
	
	public static void main(String[] args) throws IOException {
		
		NumList list  = new NumList();
		//�����Լ��� load�� ���̸� �˰� �ض�!
				
		NumList.load(list);
		while(true) {
			System.out.println("<<�޴�>>");
			System.out.println("1. �� �߰�");
			System.out.println("2. ���� ���");
			System.out.println("3. ¦���� ���� ���");
			System.out.println("4. ����");
			
			Scanner scan = new Scanner(System.in);
			int menu = scan.nextInt();
			
			if(menu == 1) {//����ġ������ �ٲٱ�... 
				System.out.print("���� �ϳ��� �Է��Ͻÿ� >>");
				int num = scan.nextInt();
				
				NumList.add(list,num);
			}
			else if(menu == 2) {
				int sum = NumList.Sum(list);
				System.out.println(sum);
			}		
			else if(menu == 3){
				int count = NumList.getEvenNumberCount(list);
				System.out.println(count);
			}
			else
				break;
		}
		
		
	}
}
