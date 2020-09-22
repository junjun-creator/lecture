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
	public static void main(String[] args) throws IOException, InterruptedException {
		
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
		
		Member[] Members = new Member[cnt];
		
		for(int i=0;i<cnt;i++) {       
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
		}
		
		fis.close();
		scan.close();
		
		//나이를 기준으로 내림차순으로 만들어라.
		for(int i=0;i<cnt-1;i++) {
			int complete=cnt-i;
			for(int j=0;j<cnt-1-i;j++) {
				
				for(int a=0;a<20;a++) 
					System.out.println();
				
				System.out.println("[변경 전]");
				for(int a=0;a<cnt;a++) {
					Member m = Members[a];
					if(a==j || a==j+1)
						System.out.printf("*%d, %s, %s, %d\n",m.id,m.uid,m.name,m.age);
					else if(a >= complete)
						System.out.printf("[%d, %s, %s, %d]\n",m.id,m.uid,m.name,m.age);
					else
						System.out.printf("%d, %s, %s, %d\n",m.id,m.uid,m.name,m.age);
				}
				
				boolean check = false;
				if(Members[j].age<Members[j+1].age) {
					Member mtemp = Members[j];
					Members[j] = Members[j+1];
					Members[j+1] = mtemp;
					
					check = true;
				}
				System.out.println();
				System.out.println();
				
				
				for(int a=0;a<cnt;a++) {
					Member m = Members[a];
					if(a==0 && check)
						System.out.println("[변경 후]");
					else if(a==0 && !check)
						System.out.println("[변경 없음]");
					
					if((a==j || a==j+1) && check)
						System.out.printf("ㅡ>%d, %s, %s, %d\n",m.id,m.uid,m.name,m.age);
					else if(a >= complete || complete <=2)
						System.out.printf("[%d, %s, %s, %d]\n",m.id,m.uid,m.name,m.age);
					else
						System.out.printf("%d, %s, %s, %d\n",m.id,m.uid,m.name,m.age);
				}
				
				Thread.sleep(1000);
			}
			
		}
		
		for(int i=0;i<cnt;i++) {
			System.out.printf("id : %d, nickname : %s, name : %s, kors : %d\n",Members[i].id, Members[i].uid, Members[i].name, Members[i].age);
		}
		
		
	}
}