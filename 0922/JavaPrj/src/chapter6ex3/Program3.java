package chapter6ex3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Program3 {
	
	public static void main(String[] args) throws IOException {
		
		NumList list  = new NumList();
		
		//메인함수가 load의 길이를 알게 해라!
				
		load(list);
		printKors(list);
		
		printSum(list);
		printEvenNumberCount(list);
		
	}

	static void load(NumList list) throws IOException {
		FileInputStream fis = new FileInputStream("res/data.txt");
		Scanner scan = new Scanner(fis);
		
		//int size = scan.nextInt();
		list.size = scan.nextInt();
		list.kors = new int[10];
		
		for(int i=0;i<list.size;i++) {
			list.kors[i] = scan.nextInt();
		}
		fis.close();
		scan.close();
	}
	
	static void printKors(NumList list) {
		for(int i=0;i<list.size;i++) {
			System.out.printf("%4d",list.kors[i]);
		}System.out.println();
	}
	
	static void printSum(NumList list) {
		int sum=0;
		
		for(int i=0;i<list.size;i++) {
			sum += list.kors[i];
		}
		
		System.out.println("합계 :" + sum);
	}
	
	static void printEvenNumberCount(NumList list) {
		int count=0;
		
		for(int i=0;i<list.size;i++) {
			if(list.kors[i]%2 ==0)
				count++;
		}
		
		System.out.println("짝수의 갯수 " + count);
	}
}
