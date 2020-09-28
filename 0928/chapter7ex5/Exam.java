package chapter7ex5;

import java.util.Scanner;

public class Exam {
	private int kor;
	private int math;
	private int eng;
	
	public Exam() {
		this(0,0,0);
	}
	
	public Exam(int kor, int eng, int math) {
		this.kor = kor;
		this.math = math;
		this.eng = eng;
	}
	/*
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}*/
	/*
	public void input() {
		Scanner scan = new Scanner(System.in);
		System.out.print("국어점수 : ");
		this.kor = scan.nextInt();
		System.out.print("영어점수 : ");
		this.eng = scan.nextInt();
		System.out.println("수학점수 : ");
		this.math = scan.nextInt();
	}*/
	
	public int total() {
		return this.kor+this.eng+this.math;
	}
	
	public double avg() {
		return total()/3.0;
	}
}
