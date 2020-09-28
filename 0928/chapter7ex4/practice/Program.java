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
		goBoard.print();//따로 개체 생성해서 GoBoard~StoneBowl객체를 생성하고, 거기서 프린트 하도록.
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
			System.out.print("\n돌을 놓을 위치를 입력하시오 예) x,y");
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
