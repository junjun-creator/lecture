package chapter4ex5;

public class Program {
	
	static int sum(int n) {
		
		if(n== 1)
			return 3;
		
		return sum(n-1)+an(n);
	}
	
	static int an(int n) {
		return 3+(n-1)*7;
	}

	public static void main(String[] args) {
		System.out.println(sum(100));
	}

}
