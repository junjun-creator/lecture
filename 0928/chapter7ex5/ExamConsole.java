package chapter7ex5;

import java.util.Scanner;

public class ExamConsole {
	Exam exam;//this ������ �־ input�� print �޼��尡 �Բ� �����Ҽ� �ְ� �ϱ�����
	//ExamConsole�� ���� ��ǰ�̴�.(���)
	public void input() {
		Scanner scan = new Scanner(System.in);
		System.out.print("�������� : ");
		int kor = scan.nextInt();
		System.out.print("�������� : ");
		int eng = scan.nextInt();
		System.out.print("�������� : ");
		int math = scan.nextInt();
		
		this.exam = new Exam(kor, eng, math);
	}
	
	public void print() {
		System.out.printf("���� : %d\n", this.exam.total());
		System.out.printf("��� : %f\n", this.exam.avg());
	}
}
