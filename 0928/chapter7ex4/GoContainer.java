package chapter7ex4;

public class GoContainer {
	String color;
	int count;
	public GoContainer(String color) {
		this.color = color;
		this.count = 100;
	}
	
	public void pickStone() {
		this.count--;
	}

	public int getCount() {
		return this.count;
	}

	public String getColor() {
		return this.color;
	}
}
