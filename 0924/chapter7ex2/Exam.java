package chapter7ex2;

public class Exam {
	private int kor;
	private int eng;
	private int math;//캡슐화를 깨지 못하도록 private 키워드 등장

	public int getKor() {
		return this.kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int total() {
		return kor+ eng + math;
	}
	   
	public float avg() {
	   return total()/3.0f;
	}
	
}
