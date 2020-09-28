package chapter7ex4;

public class GoBoard {
	private String[][] stone;
	private int size = 20;
	public GoBoard() {
		this.stone = new String[size][size];
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				this.stone[i][j] = "¦«";
			}
		}
	}
	
	public void setStone(int x, int y, String Color) {
		switch(Color) {
		case "White":
			this.stone[x][y] = "¡Û";
			break;
		case "Black":
			this.stone[x][y] = "¡Ü";
			break;
		}
		
	}
	
	public void print() {
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				System.out.print(this.stone[i][j]);
			}System.out.println();
		}
	}
	
	
	
}
