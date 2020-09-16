package chapter5ex2;
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


public class Program {
	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream("res/data5.txt");
		Scanner scan = new Scanner(fis,"UTF-8");
		FileInputStream fis2 = new FileInputStream("res/data5.txt");
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
		
		Member[] Members = new Member[cnt];
		
		for(int i=0;i<cnt;i++) {
			//Members[i] = new Member();
			String line = scan.nextLine();
			String[] tokens = line.split(",");
			int tokenLength = tokens.length;
			int j=0;
			Member m = new Member();
			m.id = Integer.parseInt(tokens[j++]);
			m.uid = tokens[j++];
			m.name = tokens[j++];
			m.age = Integer.parseInt(tokens[j]);
			
			Members[i] = m;
			/*
			Members[i].id = Integer.parseInt(tokens[j++]);
			Members[i].uid = tokens[j++];
			Members[i].name = tokens[j++];
			Members[i].age = Integer.parseInt(tokens[j]);*/
		}
		
		fis.close();
		scan.close();
		
		//나이를 기준으로 내림차순으로 만들어라.
		for(int i=0;i<cnt-1;i++) {
			for(int j=0;j<cnt-1-i;j++) {
				if(Members[j].age<Members[j+1].age) {
					Member mtemp = Members[j];
					Members[j] = Members[j+1];
					Members[j+1] = mtemp;
				}
			}
		}
		
		for(int i=0;i<cnt;i++) {
			System.out.printf("id : %d, nickname : %s, name : %s, kors : %d\n",Members[i].id, Members[i].uid, Members[i].name, Members[i].age);
		}
		
		
	}
}