package chapter7ex4.practice;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		int turnColor=0;
		/*
		GoBoard goBoard = new GoBoard();
		StatusBoard status = new StatusBoard();
		StoneBowl bowl1 = new StoneBowl();
		StoneBowl bowl2 = new StoneBowl(1);*/
		
		GoConsole goConsole = new GoConsole();
		
		/*
		goBoard.print();//���� ��ü �����ؼ� GoBoard~StoneBowl��ü�� �����ϰ�, �ű⼭ ����Ʈ �ϵ���.
		bowl1.print();
		bowl2.print();
		System.out.println();
		status.print();*/
		
		goConsole.printBoard();
		goConsole.printBowl();
		goConsole.printStatus();
		
		
		int count =0;
		while(count < 20) {
			/*
			System.out.print("\n���� ���� ��ġ�� �Է��Ͻÿ� ��) x,y");
			String inputString = scan.nextLine();
			x = Integer.parseInt(inputString.split(",")[0]);
			y = Integer.parseInt(inputString.split(",")[1]);
			
			Stone s = new Stone();
			
			if(turnColor == 0)
				s = bowl1.pickedStone();
			else 
				s = bowl2.pickedStone();
			
			
			goBoard.put(s);
			goBoard.print();
			bowl1.print();
			bowl2.print();
			System.out.println();
			
			if(turnColor == 0) {
				status.setMyColor(1);
				status.setTurn(1);
				
				turnColor++;
			}
			else {
				status.setMyColor(0);
				status.setTurn(0);
				
				turnColor--;
			}
			
			status.print();*/
			
			goConsole.input();
			count++;
		}
	}

}
