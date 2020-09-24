package chapter7ex2;

import java.util.Random;

public class Lotto {
	public int[] nums;
	
	public Lotto() {//한정자 Lotto 형식의 객체만 나를 호출할 수 있다. 진정한 초기화함수.
		//생성자 라고 한다(얘는 함수가 아니다) 객체가 생성될때 가장 먼저 실행되게 한다
		this.nums = new int[6];
	}
	
	public static void gen(Lotto lotto) {
		Random rand = new Random();
	      for(int i=0; i<6; i++)
	         lotto.nums[i] = rand.nextInt(45)+1;
	}
	
	public void gen() {
		Random rand = new Random();
	    for(int i=0; i<6; i++)
	    	this.nums[i] = rand.nextInt(45)+1;
	}

	public void sort() {
		for(int j=0; j<5; j++)
	         for(int i=0; i<5-j; i++) 
	            if(this.nums[i] > this.nums[i+1]) {
	               int temp = this.nums[i];
	               this.nums[i] = this.nums[i+1];
	               this.nums[i+1] = temp;
	            }
	}

	
}
