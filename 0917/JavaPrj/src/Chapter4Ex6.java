import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Chapter4Ex6 {
	public static void main(String[] args) throws IOException {
		
		String a = "������";
		String b = "������";
		System.out.println(a!=b);
		System.out.println(a.equals(b));
		
		String fileName = "photo.jpg";
		System.out.println(fileName.indexOf("."));
		
		String name = fileName.substring(0, fileName.indexOf("."));
		String ext = fileName.substring(fileName.indexOf(".")+1,fileName.length());
		System.out.println(name); //ù �ε������� ������ �ε��� ��ġ. ������ �ε����� exclusive
		System.out.println(ext);
		
		String fileNames = "photo.jpg,aa.png,bb.gif,cc.png";
		String[] s1 = fileNames.split(",");
		
		for(int i=0;i<s1.length;i++) {
			System.out.println(s1[i]);
		}
		
		
	}
}