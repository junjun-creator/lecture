import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Chapter4Ex1Array {
	public static void main(String[] args) throws IOException {
		
		//fos를 이름으로 갖는 fileoutputstream 객체를 생성한다. 파일명은 C:\\Work\\img1-copy.bmp로 한다.
		FileInputStream fis = new FileInputStream("res/data.txt");
		FileOutputStream fos = new FileOutputStream("res/result.txt");
		Scanner scan = new Scanner(fis);
		
		int[] nums = new int[10];
		int temp;
		
		for(int i=0;i<8;i++) {
			nums[i]= scan.nextInt();
		}
		for(int i=0;i<8;i++) {
			System.out.printf("%d ",nums[i]);
		}System.out.println();
		
		for(int j=0;j<8;j++) {
			for(int i=j;i<8;i++) {
				if(nums[j]>nums[i]) {
					temp = nums[j];
					nums[j] = nums[i];
					nums[i] = temp;
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