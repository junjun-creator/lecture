package chapter7ex1.entity;

import java.util.Random;

public class Lotto {
	public int[] nums;
	
	public static void init(Lotto lotto) {
		lotto.nums = new int[6];
	}
	
	public static void gen(Lotto lotto) {
		Random rand = new Random();
	      for(int i=0; i<6; i++)
	         lotto.nums[i] = rand.nextInt(45)+1;
	}

	public static void sort(Lotto lotto) {
		for(int j=0; j<5; j++)
	         for(int i=0; i<5-j; i++) 
	            if(lotto.nums[i] > lotto.nums[i+1]) {
	               int temp = lotto.nums[i];
	               lotto.nums[i] = lotto.nums[i+1];
	               lotto.nums[i+1] = temp;
	            }
	}

	public static void print(Lotto lotto) {
		for(int i=0; i<6; i++)
	         System.out.printf("%d ", lotto.nums[i]);
	      
	      System.out.println();
	}

	
}
