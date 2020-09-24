package chapter7ex2;

import java.util.Random;

public class Program2 {

	public static void main(String[] args) {
		
		 /*
	       * 1. 알맹이 : 값을 가지는 그릇(개념단위의 그릇)-엔티티:개체
	       * 2. 서비스 : 알맹이들을 가지고 있던지 가져오던지..해서 알맹이들을 제공해주는 서비스
	       * 3. 껍데기 : 사용자의 입력/출력을 도와주는 사용자 인터페ㅣ스
	       */
	      
	      // 알맹이 > 기본변수형으로 선언하면 이게 무슨 변수인지 알수가 없다.
		  //그래서 알맹이의 Entity를 생성하여 entity로 객체를 만들어서 사용한다.
	      					//초기화 함수
	      Lotto lotto = new Lotto();
	      //Lotto.init(lotto); 함수로 만들면 계속 사용할수 있으므로 초기화의 의미가 안된다.
	      //번호를 생성 gen
	      //Lotto.gen(lotto);//주객이 전도 된거같아서 별로다! 로또객체를 생성해달라는 주어가 뒤로 밀렸다
	      lotto.gen();//이 방식을 지원하는 언어가 객체지향 언어이다.
	      	      
	      // 번호를 출력 print
	      //lotto.print(); 
	      	      
	      // 번호를 정렬 sort
	      lotto.sort();
	         	      
	      // 번호를 출력 print
	      //lotto.print();
	      

	}

	

}
