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

public class Chapter4Ex9 {
	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream("res/img1.cmp");
		FileOutputStream fis2 = new FileOutputStream("res/img1-reverse.cmp");
		Scanner scan = new Scanner(fis,"UTF-8");
		PrintStream ps = new PrintStream(fis2,true,"UTF-8");
		
		String line = scan.nextLine();
		String[] tokens = line.split("");
		
		fis.close();
		scan.close();
		
		int length = tokens.length;
		/*
		for(int i=0;i<length;i++) {
			System.out.print(tokens[i]);
		}System.out.println();*/
		
		for(int i=0;i<length/2;i++) {
			String temp = tokens[i];
			tokens[i] = tokens[length-1-i];
			tokens[length-1-i] = temp;
		}
		
		for(int i=0;i<length;i++) {
			//byte[] bytes = tokens[i].getBytes();
			//fis2.write(bytes);
			ps.print(tokens[i]);
			System.out.print(tokens[i]);
		}
		fis2.close();
	}
}