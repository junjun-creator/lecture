package chapter6ex2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Program {
	
	public static void main(String[] args) throws IOException {
		
		String path = "res/data.txt";
		
		int[] kors = load(path);
		printKors(kors);
		
		printSum(kors);
		printEvenNumberCount(kors);
		
	}

	static int[] load(String x) throws IOException {
		FileInputStream fis = new FileInputStream(x);
		Scanner scan = new Scanner(fis);
		
		int size = scan.nextInt();
		int[] kors = new int[size];
		
		for(int i=0;i<size;i++) {
			kors[i] = scan.nextInt();
		}
		fis.close();
		scan.close();
		return kors;
	}
	
	static void printKors(int[] kors) {
		for(int i=0;i<kors.length;i++) {
			System.out.printf("%4d",kors[i]);
		}System.out.println();
	}
	
	static void printSum(int[] x) {
		int sum=0;
		
		for(int i=0;i<x.length;i++) {
			sum += x[i];
		}
		
		System.out.println("ÇÕ°è :" + sum);
	}
	
	static void printEvenNumberCount(int[] x) {
		int count=0;
		
		for(int i=0;i<x.length;i++) {
			if(x[i]%2 ==0)
				count++;
		}
		
		System.out.println("Â¦¼öÀÇ °¹¼ö " + count);
	}
}
