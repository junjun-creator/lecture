import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Chapter4Ex6 {
	public static void main(String[] args) throws IOException {
		
		String a = "아이유";
		String b = "아이유";
		System.out.println(a!=b);
		System.out.println(a.equals(b));
		
		String fileName = "photo.jpg";
		System.out.println(fileName.indexOf("."));
		
		String name = fileName.substring(0, fileName.indexOf("."));
		String ext = fileName.substring(fileName.indexOf(".")+1,fileName.length());
		System.out.println(name); //첫 인덱스부터 마지막 인덱스 위치. 마지막 인덱스는 exclusive
		System.out.println(ext);
		
		String fileNames = "photo.jpg,aa.png,bb.gif,cc.png";
		String[] s1 = fileNames.split(",");
		
		for(int i=0;i<s1.length;i++) {
			System.out.println(s1[i]);
		}
		
		
	}
}