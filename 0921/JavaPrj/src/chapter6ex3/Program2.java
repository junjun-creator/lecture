package chapter6ex3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Program2 {
	
	public static void main(String[] args) throws IOException {
		
		//메인함수가 load의 길이를 알게 해라!
		int[] kors = new int[10];
		int size=0;
		load(kors,size);
		printKors(kors,size);
		
		printKors(kors,size);
		printEvenNumberCount(kors,size);
		
	}

	static void load(int[] kors, int size) throws IOException {
		FileInputStream fis = new FileInputStream("res/data.txt");
		Scanner scan = new Scanner(fis);
		
		//int size = scan.nextInt();
		size = scan.nextInt();
		
		for(int i=0;i<size;i++) {
			kors[i] = scan.nextInt();
		}
		fis.close();
		scan.close();
	}
	
	static void printKors(int[] kors, int size) {
		for(int i=0;i<size;i++) {
			System.out.printf("%4d",kors[i]);
		}System.out.println();
	}
	/*
	static void printSum(int[] x) {
		int sum=0;
		
		for(int i=0;i<x.length;i++) {
			sum += x[i];
		}
		
		System.out.println("합계 :" + sum);
	}*/
	
	static void printEvenNumberCount(int[] kors, int size) {
		int count=0;
		
		for(int i=0;i<size;i++) {
			if(kors[i]%2 ==0)
				count++;
		}
		
		System.out.println("짝수의 갯수 " + count);
	}
}
