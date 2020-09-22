package chapter6ex1;

public class Program {
	
	static int sum(int x, int y) {
		return x+y;
	}
	
	static String getName(int x, String y) {
		return y;
	}

	static void print(int x, float y, char z) {
		
	}
	
	public static void main(String[] args) {
		
		int x = 3;
		int y = 4;
		
		System.out.println(sum(x,y));
		
		String s = getName(2,"hello");
	}

}
