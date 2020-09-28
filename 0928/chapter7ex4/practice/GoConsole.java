package chapter7ex4.practice;

import java.util.Scanner;

public class GoConsole {//extends는 하나의 개체만 가능하다... 이래서 필요한게 interface가 아닐까 싶다.
	GoBoard goBoard;
	StatusBoard status;
	StoneBowl bowl1;
	StoneBowl bowl2;
	private int turnColor;
	
	public GoConsole() {
		goBoard = new GoBoard();
		status = new StatusBoard();
		bowl1 = new StoneBowl();
		bowl2 = new StoneBowl(1);
		turnColor = 0;
	}
	
	public void printBoard() {
		for(int i=0;i<20;i++) {
			for(int j=0;j<20;j++) {
				System.out.print(this.goBoard.getBoard()[i][j]);
			}System.out.println();
		}
	}
	
	public void printStatus() {
		char my = '●';//기본값을 black으로 하고, 
		char t = '●';
		
		if(this.status.getMyColor() == 1)//내 돌의 색이 white일 경우에 변경
			my = '○';
		
		if(this.status.getTurn() == 1) 
			t = '○';
		
		System.out.printf("내 돌 : %c , 현재 차례 : %c",my, t);
	}
	
	public void printBowl() {
		char sc1 = '●';
		char sc2 = '●';
		
		if(this.bowl1.getStoneColor() == 1)
			sc1 = '○';
		if(this.bowl2.getStoneColor() == 1)
			sc2 = '○';
		
		System.out.printf("%c [%d] , %c [%d]\n",sc1,this.bowl1.getSize(),sc2,this.bowl2.getSize());
	}
	
	public void input() {
		Scanner scan = new Scanner(System.in);
		int x,y;
		
		System.out.print("\n돌을 놓을 위치를 입력하시오 예) x,y");
		String inputString = scan.nextLine();
		x = Integer.parseInt(inputString.split(",")[0]);
		y = Integer.parseInt(inputString.split(",")[1]);
		
		Stone s = new Stone();
		
		if(this.turnColor == 0)
			s = this.bowl1.pickedStone();
		else 
			s = this.bowl2.pickedStone();
		
		s.setX(x);
		s.setY(y);
		
		goBoard.put(s);
		this.printBoard();
		this.printBowl();
		System.out.println();
		
		if(this.turnColor == 0) {
			this.status.setMyColor(1);
			this.status.setTurn(1);
			
			this.turnColor++;
		}
		else {
			this.status.setMyColor(0);
			this.status.setTurn(0);
			
			this.turnColor--;
		}
		
		this.printStatus();
	}
}
