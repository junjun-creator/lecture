package chapter7ex4.oop1;

public class StoneBowl {
	private int stoneColor;
	private Stone[] stone;
	private int size;
	
	public StoneBowl() {
		stoneColor = 0;//black
		size=100;
		stone = new Stone[size];
		for(int i=0;i<size;i++) {
			stone[i] = new Stone();
			stone[i].setColor(stoneColor);
		}
	}
	
	public void setStoneColor(int color) {
		this.stoneColor = color;
		for(int i=0;i<size;i++) {
			this.stone[i].setColor(color);
		}
	}
	
	public void print() {
		char c = '¡Ü';
		
		if(this.stoneColor ==1)
			c = '¡Û';
		
		System.out.printf("%c [%d]",c,this.size);
	}
	
	public Stone pickStone() {
		return this.stone[(this.size--)-1];
	}
}
