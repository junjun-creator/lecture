package chapter7ex4.practice;

public class GoBoard {
	/*GoBoard�� �ʿ��� ���
	 �ٵ��� �ʱ�ȭ
	print()
	put(Stone stone);
	
	 */
	
	private char[][] board; // 1. ���带 �ʱ�ȭ �ϱ� ���� 2���� �迭 ����
	
	public GoBoard() {//������ �ʱ�ȭ(������)
		board = new char[20][20];
		
		for(int i=0;i<20;i++) {
			for(int j=0;j<20;j++) {
				board[i][j] = '��';
			}
		}
	}
	/*
	public void print() {// ���� ���
		for(int i=0;i<20;i++) {
			for(int j=0;j<20;j++) {
				System.out.print(this.board[i][j]);
			}System.out.println();
		}
	}*/
	
	public void put(Stone stone) { // stone�� ���ڷ� �޾Ƽ� stone�� ���� ���� ��ġ
		char color = '��';
		
		if(stone.getColor() == 1)
			color = '��';
		
		this.board[stone.getX()-1][stone.getY()-1] = color;
	}

	public char[][] getBoard() {
		return board;
	}

	public void setBoard(char[][] board) {
		this.board = board;
	}
}
