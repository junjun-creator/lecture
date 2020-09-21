package chapter6ex2;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Chapter4Ex2Sum {
	public static void main(String[] args) throws IOException {
		
		//������ �ε�
		//fos�� �̸����� ���� fileoutputstream ��ü�� �����Ѵ�. ���ϸ��� C:\\Work\\img1-copy.bmp�� �Ѵ�.
		FileInputStream fis = new FileInputStream("res/data.txt");
		FileOutputStream fos = new FileOutputStream("res/result.txt");
		Scanner scan = new Scanner(fis);
		
		int size = scan.nextInt();
		int[] nums = new int[size];
		int sum=0;
		int count =0;
		int temp;
		
		for(int i=0;i<size;i++) {
			nums[i]= scan.nextInt();
			sum += nums[i];
			if(nums[i] %2 ==0)
				count++;
		}
		for(int i=0;i<size;i++) {
			System.out.printf("%d ", nums[i]);
		}System.out.println("\n�հ� : " +sum);
		System.out.println("¦���� ���� : "+count);
		
		for(int i=0;i<size;i++) {
			System.out.printf("%d ",nums[i]);
		}System.out.println();
		
		for(int j=0;j<size-1;j++) {
			for(int i=0;i<size-1-j;i++) {
				if(nums[i]>nums[i+1]) {
					temp = nums[i];
					nums[i] = nums[i+1];
					nums[i+1] = temp;
				}
			}
		}
		
		for(int i=0;i<8;i++) {
			System.out.printf("%d ",nums[i]);
		}
		
		fis.close();
		fos.close();
	}
}