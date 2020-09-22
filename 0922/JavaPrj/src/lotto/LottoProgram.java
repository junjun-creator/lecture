package lotto;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class LottoProgram {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		NumList list = new NumList();
		//�޴� ���
		L1:
		while(true) {
			NumList.printMenu();
			
			int select = scan.nextInt();
			scan.nextLine();
			
			switch(select) {
			case 1:
				NumList.template1();
				NumList.menu1(scan,list);
				NumList.setLottoNum(list);
				NumList.sort(list);
				NumList.template1();
				NumList.printLotto(list,select);
				break;
			case 2:
				NumList.template2();
				NumList.menu2(scan,list);
				NumList.sort(list);
				if(list.count>0) {
					NumList.template2();
					NumList.printLotto(list,select);
				}
				break;
			case 3:
				NumList.menu3(list);
				NumList.printLotto(list,select);
				break;
			case 4:
				System.out.println("���α׷��� �����մϴ�.");
				break L1;
			default :
				System.out.println("���� �޴��Դϴ�. �ٽ� ����ּ���.");
			}
		}
	}

}
