package chapter6ex4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Program4 {
	
	public static void main(String[] args) throws IOException {
		
		NumList list  = new NumList();
		//메인함수가 load의 길이를 알게 해라!
				
		NumList.load(list);
		while(true) {
			System.out.println("<<메뉴>>");
			System.out.println("1. 값 추가");
			System.out.println("2. 총합 출력");
			System.out.println("3. 짝수의 갯수 출력");
			System.out.println("4. 종료");
			
			Scanner scan = new Scanner(System.in);
			int menu = scan.nextInt();
			
			if(menu == 1) {//스위치문으로 바꾸기... 
				System.out.print("숫자 하나를 입력하시오 >>");
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
