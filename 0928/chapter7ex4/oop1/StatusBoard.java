package chapter7ex4.oop1;

public class StatusBoard {
	private int color;
	private int turn;
	
	public void print() {
		char c = '��'; //mycolor
		char t = '��'; //turn
		
		if(color == 1) 
			c = '��';
		
		if(turn == 1)
			t = '��';
		
		System.out.printf("�� ���� : %c // ���� turn : %c\n",c, t);
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}
	
	
}
