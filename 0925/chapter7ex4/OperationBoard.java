package chapter7ex4;

public class OperationBoard {
	private String myColor;
	private String turn;
	
	public OperationBoard() {
		this.myColor = "White";
		this.turn = "Black";
	}

	public String getMyColor() {
		return myColor;
	}

	public void setMyColor(String myColor) {
		this.myColor = myColor;
	}

	public String getTurn() {
		return turn;
	}

	public void setTurn(String turn) {
		this.turn = turn;
	}
	
	public void print(int black,int white) {
		System.out.printf("���� ���� : %s / �� ����� : %s / ������ : B(%d), W(%d)\n",this.turn,this.myColor,black,white);
	}
}
