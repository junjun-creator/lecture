import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Chapter4Ex5 {
	public static void main(String[] args) throws IOException {
		/*
		for(int i=0;i<31;i++) {
			System.out.printf("%3d",i+1);
			if((i+1)%7==0)
				System.out.println();
		}
		*/
		int year = 2020;
		int month = 9;
		int day=11;
		
		System.out.print("������������������������������������������������������������������������������\n");
	    System.out.printf("��              %04d-%02d-%02d             ��\n",year,month,day);
	    System.out.print("������������������������������������������������������������������������������\n");
	}
}