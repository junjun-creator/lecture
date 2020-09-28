package chapter7ex4.oop1;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GoBoard gameBoard = new GoBoard();
		StoneBowl s1 = new StoneBowl();
		StoneBowl s2 = new StoneBowl();
		StatusBoard sb = new StatusBoard();
		
		int x,y;
		int curColor=0;
		
		gameBoard.print();
		s2.setStoneColor(1);
		s1.print();
		s2.print();
		System.out.println();
		sb.print();
		
		Scanner scan = new Scanner(System.in);
		
		int count =0;
		while(count < 20) {
			if(curColor == 0) {
				System.out.print("돌을 놓을 위치를 입력하시오 예) x,y");
				String inputString = scan.nextLine();
				x = Integer.parseInt(inputString.split(",")[0]);
				y = Integer.parseInt(inputString.split(",")[1]);
				
				Stone s = s1.pickStone();
				s.setX(x);
				s.setY(y);
				gameBoard.put(s);
				gameBoard.print();
				s1.print();
				s2.print();
				System.out.println();
				sb.setColor(1);
				sb.setTurn(1);
				sb.print();
				curColor++;
			}
			else {
				System.out.print("돌을 놓을 위치를 입력하시오 예) x,y");
				String inputString = scan.nextLine();
				x = Integer.parseInt(inputString.split(",")[0]);
				y = Integer.parseInt(inputString.split(",")[1]);
				
				Stone s = s2.pickStone();
				s.setX(x);
				s.setY(y);
				gameBoard.put(s);
				gameBoard.print();
				s1.print();
				s2.print();
				System.out.println();
				sb.setColor(0);
				sb.setTurn(0);
				sb.print();
				curColor--;
			}
			count++;
		}
	}

}
