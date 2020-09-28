package chapter7ex4.oop1;

public class GoBoard {
	private char[][] board;
	
	public GoBoard() {
		board = new char[20][20];
		for(int i=0;i<20;i++) {
			for(int j=0;j<20;j++) {
				board[i][j] = '¦¶';
			}
		}
	}
	
	public void print() {
		for(int i=0;i<20;i++) {
			for(int j=0;j<20;j++) {
				System.out.print(this.board[i][j]);
			}System.out.println();
		}
	}
	
	public void put(Stone stone) {
		char c = '¡Ü';
		
		if(stone.getColor() == 1)
			c = '¡Û';
		
		board[stone.getX()-1][stone.getY()-1] = c;
	}
}
