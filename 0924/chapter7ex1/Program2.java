package chapter7ex1;

import java.util.Random;

import chapter7ex1.entity.Lotto;

public class Program2 {

	public static void main(String[] args) {
		
		 /*
	       * 1. �˸��� : ���� ������ �׸�(��������� �׸�)-��ƼƼ:��ü
	       * 2. ���� : �˸��̵��� ������ �ִ��� ����������..�ؼ� �˸��̵��� �������ִ� ����
	       * 3. ������ : ������� �Է�/����� �����ִ� ����� ������ӽ�
	       */
	      
	      // �˸��� > �⺻���������� �����ϸ� �̰� ���� �������� �˼��� ����.
		  //�׷��� �˸����� Entity�� �����Ͽ� entity�� ��ü�� ���� ����Ѵ�.
	      
	      Lotto lotto = new Lotto();;
	      Lotto.init(lotto);
	      //��ȣ�� ���� gen
	      Lotto.gen(lotto);//�ְ��� ���� �ȰŰ��Ƽ� ���δ�! �ζǰ�ü�� �����ش޶�� �־ �ڷ� �зȴ�
	      lotto.gen(lotto);//�� ����� �����ϴ� �� ��ü���� ����̴�.
	      	      
	      // ��ȣ�� ��� print
	      Lotto.print(lotto); 
	      	      
	      // ��ȣ�� ���� sort
	      Lotto.sort(lotto);
	         	      
	      // ��ȣ�� ��� print
	      Lotto.print(lotto);
	      

	}

	

}
