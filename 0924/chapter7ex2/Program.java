package chapter7ex2;

import java.util.Random;

public class Program {

	public static void main(String[] args) {
		
		 /*
	       * 1. �˸��� : ���� ������ �׸�(��������� �׸�)-��ƼƼ:��ü
	       * 2. ���� : �˸��̵��� ������ �ִ��� ����������..�ؼ� �˸��̵��� �������ִ� ����
	       * 3. ������ : ������� �Է�/����� �����ִ� ����� ������ӽ�
	       */
	      
	      // �˸��� > �⺻���������� �����ϸ� �̰� ���� �������� �˼��� ����.
		  //�׷��� �˸����� Entity�� �����Ͽ� entity�� ��ü�� ���� ����Ѵ�.
	      int[] lotto = new int[6];
	      //Lotto lotto = new Lotto();;
	      
	      //��ȣ�� ���� gen
	      Random rand = new Random();
	      for(int i=0; i<6; i++)
	         lotto[i] = rand.nextInt(45)+1;
	      
	      // ��ȣ�� ��� print
	      for(int i=0; i<6; i++)
	         System.out.printf("%d ", lotto[i]);
	      
	      System.out.println();   
	      
	      
	      // ��ȣ�� ���� sort
	      for(int j=0; j<5; j++)
	         for(int i=0; i<5-j; i++) 
	            if(lotto[i] > lotto[i+1]) {
	               int temp = lotto[i];
	               lotto[i] = lotto[i+1];
	               lotto[i+1] = temp;
	            }
	         
	            
	      
	      // ��ȣ�� ��� print
	      for(int i=0; i<6; i++)
	         System.out.printf("%d ", lotto[i]);
	      
	      System.out.println();

	}

}
