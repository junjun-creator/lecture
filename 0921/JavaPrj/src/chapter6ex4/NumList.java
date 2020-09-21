package chapter6ex4;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class NumList {
	int[] kors;
	int size = 0;
	
	public static void add(NumList list, int num) {
		if(list.kors.length <= list.size) {
			int[] temp = new int[list.size+5];
			for(int i=0;i<list.size;i++) {
				temp[i] = list.kors[i];
			}
			list.kors= temp;
		}
		list.kors[list.size] = num;
		list.size++;
	}

	public static void load(NumList list) throws IOException {
		FileInputStream fis = new FileInputStream("res/data.txt");
		Scanner scan = new Scanner(fis);
		
		//int size = scan.nextInt();
		list.size = scan.nextInt();
		list.kors = new int[list.size];
		
		for(int i=0;i<list.size;i++) {
			list.kors[i] = scan.nextInt();
		}
		fis.close();
		scan.close();
	}
	
	public static void printKors(NumList list) {
		for(int i=0;i<list.size;i++) {
			System.out.printf("%4d",list.kors[i]);
		}System.out.println();
	}
	
	public static int Sum(NumList list) {
		int sum=0;
		
		for(int i=0;i<list.size;i++) {
			sum += list.kors[i];
		}
		
		return sum;
	}
	
	public static int getEvenNumberCount(NumList list) {
		int count=0;
		
		for(int i=0;i<list.size;i++) {
			if(list.kors[i]%2 ==0)
				count++;
		}
		
		return count;
	}
}
