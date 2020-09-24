package chapter7ex2;

import java.util.Random;

public class Lotto {
	public int[] nums;
	
	public Lotto() {//������ Lotto ������ ��ü�� ���� ȣ���� �� �ִ�. ������ �ʱ�ȭ�Լ�.
		//������ ��� �Ѵ�(��� �Լ��� �ƴϴ�) ��ü�� �����ɶ� ���� ���� ����ǰ� �Ѵ�
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
