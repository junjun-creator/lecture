package chapter6ex3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Program4 {
	
	public static void main(String[] args) throws IOException {
		
		NumList list  = new NumList();
		
		//메인함수가 load의 길이를 알게 해라!
				
		load(list);
		printKors(list);
		
		int sum = Sum(list);
		System.out.println(sum);
		int count = getEvenNumberCount(list);
		System.out.println(count);
		
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
	
	static int Sum(NumList list) {
		int sum=0;
		
		for(int i=0;i<list.size;i++) {
			sum += list.kors[i];
		}
		
		return sum;
	}
	
	static int getEvenNumberCount(NumList list) {
		int count=0;
		
		for(int i=0;i<list.size;i++) {
			if(list.kors[i]%2 ==0)
				count++;
		}
		
		return count;
	}
}
