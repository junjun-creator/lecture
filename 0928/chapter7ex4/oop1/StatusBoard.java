package chapter7ex4.oop1;

public class StatusBoard {
	private int color;
	private int turn;
	
	public void print() {
		char c = '¡Ü'; //mycolor
		char t = '¡Ü'; //turn
		
		if(color == 1) 
			c = '¡Û';
		
		if(turn == 1)
			t = '¡Û';
		
		System.out.printf("³» »ö±ò : %c // ÇöÀç turn : %c\n",c, t);
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
