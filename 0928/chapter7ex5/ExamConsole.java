package chapter7ex5;

import java.util.Scanner;

public class ExamConsole {
	Exam exam;//this 영역에 넣어서 input과 print 메서드가 함께 공유할수 있게 하기위해
	//ExamConsole의 구성 부품이다.(상속)
	public void input() {
		Scanner scan = new Scanner(System.in);
		System.out.print("국어점수 : ");
		int kor = scan.nextInt();
		System.out.print("영어점수 : ");
		int eng = scan.nextInt();
		System.out.print("수학점수 : ");
		int math = scan.nextInt();
		
		this.exam = new Exam(kor, eng, math);
	}
	
	public void print() {
		System.out.printf("총점 : %d\n", this.exam.total());
		System.out.printf("평균 : %f\n", this.exam.avg());
	}
}
