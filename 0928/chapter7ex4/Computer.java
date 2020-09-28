package chapter7ex4;

public class Computer {
	private int x;
	private int y;
	
	public void setXY() {
		this.x =	(int)Math.random()*20+1;
		this.y = (int)Math.random()*20+1;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
	
	
}
