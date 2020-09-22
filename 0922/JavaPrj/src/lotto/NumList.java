package lotto;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class NumList {
	int[][] nums;
	int count=0;
	int lottoLength=6;
	
	public static void menu3(NumList list) throws IOException {
		FileInputStream fis2 = new FileInputStream("res/lottoNumbers.txt");
		Scanner scan2 = new Scanner(fis2);
		FileInputStream fis = new FileInputStream("res/lottoNumbers.txt");
		Scanner scan = new Scanner(fis);
		
		list.count=0;
		while(scan.hasNextLine()) {
			scan.nextLine();
			list.count++;
		}
				
		list.nums = new int[list.count][list.lottoLength];
	    int index=0;
	    while(scan2.hasNextLine()) {
	    	String[] tokens = scan2.nextLine().split(" ");
	    	for(int i=0;i<list.lottoLength;i++) {
	    		list.nums[index][i] = Integer.parseInt(tokens[i]);
	    	}
	    	index++;
	    }
	    
	    
	}

	public static void menu2(Scanner scan,NumList list) throws IOException {
		
		list.count = 0;
	    System.out.println("번호를 입력하세요(예 6 7 10 20 30 40)\n(단, 그만입력하려면 -1을 입력하세요.");
	    FileWriter fw = new FileWriter("res/lottoString.txt");
	    while(true) {
	    	String input = scan.nextLine();
	    	if(input.equals("-1"))
	    		break;
	    	fw.write(input+"\n");
	    	list.count++;
	    }
	    fw.close();
	    FileInputStream fis = new FileInputStream("res/lottoString.txt");
	    Scanner scan2 = new Scanner(fis);
	    list.nums = new int[list.count][list.lottoLength];
	    int index=0;
	    while(scan2.hasNextLine()) {
	    	String[] tokens = scan2.nextLine().split(" ");
	    	for(int i=0;i<tokens.length;i++) {
	    		list.nums[index][i] = Integer.parseInt(tokens[i]);
	    	}
	    	index++;
	    }
	}
	
	public static void template2() {
		System.out.print("┌─────────────────────────────────────┐\n");
	    System.out.print("│          2.  LOTTO번호 수동생성                      │\n");
	    System.out.print("└─────────────────────────────────────┘\n");
	}

	public static void menu1(Scanner scan, NumList list) throws IOException {
		
	    System.out.print("생성할 개수 : ");
	    list.count = scan.nextInt();
	}
	
	public static void template1() {
		System.out.print("┌─────────────────────────────────────┐\n");
	    System.out.printf("│          1.  LOTTO번호 자동생성                      │\n");
	    System.out.print("└─────────────────────────────────────┘\n");
	}

	public static void setLottoNum(NumList list) throws IOException {

	    //로또 번호 생성
	    list.nums = new int[list.count][list.lottoLength];
	    
	    for(int i=0;i<list.count;i++) {
	    	for(int j=0;j<list.lottoLength;j++) {
	    		while(true) {
	    			int num = (int) (Math.random()*45+1);
			    	int check =0;
			    	for(int k=0;k<list.lottoLength;k++) {
			    		if(list.nums[i][k] == num)
			    			check++;
			    	}
			    	if(check ==0) {
			    		list.nums[i][j] = num;
			    		break;
			    	}
	    		}
		    }
	    }
	}
	
	public static void sort(NumList list){
		for(int i=0;i<list.count;i++) {
	    	for(int j=0;j<list.lottoLength-1;j++) {
	    		for(int k=0;k<list.lottoLength-1-j;k++) {
	    			if(list.nums[i][k] > list.nums[i][k+1]) {
	    				int temp = list.nums[i][k];
	    				list.nums[i][k] = list.nums[i][k+1];
	    				list.nums[i][k+1] = temp;
	    			}
	    		}
	    	}
	    }
	}

	public static void printLotto(NumList list, int select) throws IOException {
		
	    for(int i=0;i<list.count;i++) {
	    	for(int j=0;j<list.lottoLength;j++) {
	    		if(j==0)
	    			System.out.printf("\t%d >> ",i+1);
	    		System.out.printf("%3d",list.nums[i][j]);
	    	}System.out.println();
	    }
	    if(select == 1 || select == 2) {
	    	L1:
	    	while(true) {
	    		int select2 = printSubMenu(select);
			    
			    switch(select2) {
			    case 1:
			    	store(list);
			    	break L1;
			    case 2:
			    	break L1;
			    default :
			    	System.out.println("없는 메뉴입니다.");
			    	break;
			    }
	    	}
	    	
	    }
	    else {
	    	L1:
	    	while(true) {
	    		int select2 = printSubMenu(select);
		    	switch(select2) {
			    case 1:
			    	System.out.println("메인메뉴로 이동합니다.");
			    	break L1;
			    default :
			    	System.out.println("없는 메뉴 입니다.");
			    	break;
			    }
	    	}
	    }
	}

	public static void store(NumList list) throws IOException {
		FileWriter fw = new FileWriter("res/lottoNumbers.txt",true);
		
		for(int i=0;i<list.count;i++) {
			String line="";
			for(int j=0;j<list.lottoLength;j++) {
				line += Integer.toString(list.nums[i][j]);
				line += " ";
			}
			fw.write(line+"\n");
		}
		
		fw.close();
	}

	public static int printSubMenu(int select) {
		int select2;
		Scanner scan = new Scanner(System.in);
		if(select == 1 || select == 2) {
			System.out.println("\t\t1. 저장하기");
		    System.out.println("\t\t2. 상위메뉴로 가기");
		    
		    select2 = scan.nextInt();
		}
		else {
			System.out.println();
			System.out.println("\t\t1. 상위메뉴로 가기");
			select2 = scan.nextInt();
		}
		
	    
	    return select2;
	}

	public static void printMenu() {
		System.out.print("┌─────────────────────────────────────┐\n");
	    System.out.printf("│            LOTTO 관리 프로그램                        │\n");
	    System.out.print("└─────────────────────────────────────┘\n");
	    
	    System.out.println("\t     1. 번호 자동 생성");
	    System.out.println("\t     2. 번호 수동 생성");
	    System.out.println("\t     3. 내 로또 번호 보기");
	    System.out.println("\t     4. 종료");
	}
}
