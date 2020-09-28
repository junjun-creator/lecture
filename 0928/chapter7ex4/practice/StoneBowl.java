package chapter7ex4.practice;

public class StoneBowl {
	/* StoneBowl�� �ʿ��� ���
	  stone 100��
	  stoneColor, size(100��)
	  pickedStone() �޼���
	  print()
	  
	 */
	
	private int stoneColor;//�׸��� �� ���� ���� ������ ���� ���� ����
	private int size; // �׸��� �� ���� ���� ������ ���� ���� ����
	private Stone[] stone; // �׸��� ������ �� stone ��ü ������ ���� ���� ����
	
	public StoneBowl() {//������
		this(0);
	}
	
	public StoneBowl(int stoneColor) {
		this.stoneColor = stoneColor;
		this.size = 100;
		this.stone = new Stone[100]; // �� 100�� �迭 ����
		
		for(int i=0;i<size;i++) {
			this.stone[i] = new Stone(); // �� ���� ��ü ����
			this.stone[i].setColor(this.stoneColor); // ���� ���� �ʱ�ȭ
		}
	}
	
	public void setStoneColor(int stoneColor) {//���� ���� �����ϱ� ���� setter
		this.stoneColor = stoneColor;
		for(int i=0;i<size;i++) {
			this.stone[i].setColor(stoneColor);
		}
	}
	
	public void print() {//���� ����� �ش� ���� ���� ���
		char sc = '��';
		
		if(this.stoneColor == 1)
			sc = '��';
		
		System.out.printf("%c [%d]",sc,size);
	}
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Stone[] getStone() {
		return stone;
	}

	public void setStone(Stone[] stone) {
		this.stone = stone;
	}

	public int getStoneColor() {
		return stoneColor;
	}

	public Stone pickedStone() { // ���� ����
		Stone prot = new Stone(); //public �޼ҵ忡�� private �迭�� return���� �ʱ�
								//���ؼ� ������ ���� Stone ���� prototype ��ü ����
		
		prot = this.stone[(size)-1];//�� �迭�� ������ �ͺ��� ����
		this.stone[(size--)-1]= null;//����� �� �� �����ϴ� ��ü�� ������ null
		return prot;
	}
}
