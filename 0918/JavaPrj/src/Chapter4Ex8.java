import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Chapter4Ex8 {
	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream("res/data3.txt");
		Scanner scan = new Scanner(fis);
		/*
		int[] nums1 = {1,2,3,4,5};
		int[] nums2 = {4,5,6};
		int[][] nums = new int[2][];
		nums[0]=nums1;
		nums[1]=nums2;
		
		nums[0][2]=40;*/
		
		int[] lengths = {8,5,9};
		int len = lengths.length;
		int[][] gs = new int[len][];
		
		for(int i=0;i<len;i++) {
			int hcount = lengths[i];
			gs[i] = new int[hcount];
		}
		
		for(int i=0;i<gs.length;i++) {
			String line = scan.nextLine();
			String[] tokens = line.split(",");
			
			for(int j=0;j<tokens.length;j++) {
				gs[i][j] = Integer.parseInt(tokens[j]);
			}
		}
		
		fis.close();
		scan.close();
		
		//정렬
		for(int i=0;i<gs.length;i++) {
			int[] g1 = gs[i];
			for(int j=0;j<g1.length-1;j++) {
				for(int k=0;k<g1.length-1-j;k++) {
					if(g1[k] < g1[k+1]) {
						int temp = g1[k];
						g1[k] = g1[k+1];
						g1[k+1] = temp;
					}
				}
			}
		}
		
		for(int i=0;i<gs.length-1;i++) {
			for(int j=0;j<gs.length-1-i;j++) {
				if(gs[j][0] < gs[j+1][0]) {
					int[] gtemp = gs[j];
					gs[j] = gs[j+1];
					gs[j+1] = gtemp;
				}
			}
		}
		
		//출력
		for (int j = 0; j < gs.length; j++) {
	         
			for (int i = 0; i < gs[j].length; i++) {
				System.out.printf("%d", gs[j][i]);
	            if(i<gs[j].length-1)
	            	System.out.printf(",");
			}
			System.out.println();
		}
	}
}