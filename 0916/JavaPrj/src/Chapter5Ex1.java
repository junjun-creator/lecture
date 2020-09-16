import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

class Student{
	int id;
	String name;
	int kor;
}

public class Chapter5Ex1 {
	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream("res/data4.txt");
		Scanner scan = new Scanner(fis,"UTF-8");
		FileInputStream fis2 = new FileInputStream("res/data4.txt");
		Scanner scan2 = new Scanner(fis2);
		
		int cnt=0;
		while(scan2.hasNextLine()) {
			scan2.nextLine();
			cnt++;
		}
		scan2.close();
		fis2.close();
		
		//int[] ids = new int[cnt];
		//String[] names = new String[cnt];
		//int[] kors = new int[cnt];
		
		Student[] allStudent = new Student[cnt];
		for(int i=0;i<cnt;i++) {
			allStudent[i] = new Student();
		}
		
		for(int i=0;i<cnt;i++) {
			String line = scan.nextLine();
			String[] tokens = line.split(",");
			int tokenLength = tokens.length;
			int j=0;
			allStudent[i].id = Integer.parseInt(tokens[j++]);
			allStudent[i].name = tokens[j++];
			allStudent[i].kor = Integer.parseInt(tokens[j]);
		}
		
		fis.close();
		scan.close();
		
		for(int i=0;i<cnt;i++) {
			System.out.printf("id : %d, name : %s, kors : %d\n",allStudent[i].id, allStudent[i].name, allStudent[i].kor);
		}
		
		
	}
}