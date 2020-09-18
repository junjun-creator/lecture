import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Chapter4Ex7 {
	public static void main(String[] args) throws IOException {
		
		FileInputStream fis1 = new FileInputStream("res/data2.txt");
		FileInputStream fis2 = new FileInputStream("res/data2.txt");
		
		Scanner scan1 = new Scanner(fis1);
		Scanner scan2 = new Scanner(fis2);
		
		FileInputStream fis3 = new FileInputStream("res/data2.txt");
		Scanner scan3 = new Scanner(fis3);
		
		int classCnt=0;
		while(scan3.hasNextLine()) {
			scan3.nextLine();
			classCnt++;
		}
		scan3.close();
		fis3.close();
		
		String[] length_token = scan2.nextLine().split(",");
		int studentCnt=length_token.length;
		
		int[][] kors = new int[classCnt][studentCnt];
		int total_all=0;
		int classIndex=0;
		int[] total_each = new int[classCnt];
		
		
		while(scan1.hasNextLine()) {
			String[] tokens = scan1.nextLine().split(",");
			
			for(int i=0;i<studentCnt;i++) {
				kors[classIndex][i] = Integer.parseInt(tokens[i]);
			}classIndex++;
		}
		
		fis1.close();
		fis2.close();
		scan1.close();
		scan2.close();
		
		for(int i=0;i<classCnt;i++) {
			for(int j=0;j<studentCnt;j++) {
				total_each[i] += kors[i][j];
				total_all += kors[i][j];
			}
		}
		
		System.out.print("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖\n");
	    System.out.printf("弛                 撩瞳ル                                    弛\n");
	    System.out.print("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎\n");

	    System.out.printf("\t瞪羹 識薄 : %d, ゎ敕 :%.2f\n", total_all,total_all/(double)(studentCnt*classCnt));
		for(int i=0;i<classCnt;i++) {
			System.out.printf("\t[%d奩] 識薄 : %d, ゎ敕 : %.2f\n",i+1,total_each[i],total_each[i]/(double)studentCnt);
		}
	}
}