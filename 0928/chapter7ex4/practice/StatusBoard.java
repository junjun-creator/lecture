package chapter7ex4.practice;

public class StatusBoard {
	/*��Ȳ�ǿ� �ʿ��� ���
	 myColor, turn �Ӽ�
	 �Ӽ� �ʱ�ȭ
	 setMyColor(), setTurn() �޼ҵ�
	  print()
	  
	 */
	
	private int myColor;//�ʱ�ȭ �ϰ��� �ϴ� �Ӽ�(������)�� ����
	private int turn;
	
	public StatusBoard() {//������
		this.myColor = 0; // black �ʱ�ȭ
		this.turn = 0;
	}

	public void setMyColor(int myColor) {//�� ���� ���� �����ϱ� ���� setter
		this.myColor = myColor;
	}

	public void setTurn(int turn) { // ���� ���ʸ� �����ϱ� ���� setter
		this.turn = turn;
	}
	
	public int getMyColor() {
		return myColor;
	}

	public int getTurn() {
		return turn;
	}

	public void print() {//�� ���� ���� ���� ���ʸ� ���
		char my = '��';//�⺻���� black���� �ϰ�, 
		char t = '��';
		
		if(this.myColor == 1)//�� ���� ���� white�� ��쿡 ����
			my = '��';
		
		if(this.turn == 1) 
			t = '��';
		
		System.out.printf("�� �� : %c , ���� ���� : %c",my, t);
	}
	
	
}
