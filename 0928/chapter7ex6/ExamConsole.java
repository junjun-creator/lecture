package chapter7ex6;

import java.util.Scanner;

// ��ǰ
// dependency
// ������ҷν��� ��ǰ(dependency) - has a (���)����

// �����ֱ�� ��ü�� ����
//composition  has a ���� - ��ü��
//association  				   - �и���


public class ExamConsole {
	
	// ��ǰ���� ��ü�� �������ν� ���� �ɷ��� ��� �޴� has a ���
	private Exam exam; // ExamConsole�� ���� (��ǰ)�̴�.
	
	public ExamConsole() {
		exam = new Exam(0, 0, 0);
	}

	
	
	public void setExam(Exam exam) {
		this.exam = exam;
	}



	public void input() {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		System.out.print("kor:");
		int kor = scan.nextInt();
		System.out.print("eng:");
		int eng = scan.nextInt();
		System.out.print("math:");
		int math = scan.nextInt();
		
		//exam = new Exam(kor, eng, math);
		exam.setKor(kor);
		exam.setEng(eng);
		exam.setMath(math);
	}

	public void print() {
		System.out.printf("kor : %d, eng : %d, math: %d, total : %d, avg : %f\n",
				exam.getKor(), exam.getEng(), exam.getMath(),
				exam.total(), exam.avg());
	}
	
}
