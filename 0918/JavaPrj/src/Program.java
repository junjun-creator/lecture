public class Program{
	public static void main(String[] args){

		int kor1,kor2,kor3,total;
		double avg;

		kor1 = 50;
		kor2 = 60;
		kor3 = 80;

		total = kor1+kor2+kor3;
		avg = total/3.0;
		System.out.printf("total is %d\n", total);
		System.out.printf("avg is %.1f\n", avg);
		
	}
}