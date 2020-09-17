import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		/*
		for(int i=0;i<12;i++) {
			for(int j=0;j<12;j++) {
				if((j == 0 || j == 11) && i> 0 && i<11)
					System.out.print((i)%10);
				else if((j == 0 || j == 11) && (i == 0 || i==11))
					System.out.print(" ");
				else if(j != 0 && j != 11 && i == 0)
					System.out.print('┬');
				else if(j != 0 && j != 11 && i == 11)
					System.out.print('┴');
				else if(j != 0 && j != 11 && i==(11-j))
					System.out.print('○');
				else
					System.out.print('┼');
				
			}
			System.out.println();
		}*/
		
		int[] array_ = {1, 5, 2, 6, 3, 7, 4};
		Scanner in = new Scanner(System.in);
		int i,j,k,commandCnt;
		
		System.out.println("commands의 갯수를 입력하시오.");
		commandCnt = in.nextInt();
		in.nextLine();
		
		int[][] commands = new int[commandCnt][3];
		int[] returns = new int[commandCnt];
		
		System.out.println("배열 array에서 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을때 k번째에 있는 수를 출력하고자 한다. i,j,k값을 순서대로 입력하시오.(각 값을 콤마로 구분하여 입력)");
		for(int a=0;a<commandCnt;a++) {
			String[] tokens = in.nextLine().split(",");
			for(int b=0;b<3;b++) {
				commands[a][b] = Integer.parseInt(tokens[b]);
			}
		}
		in.close();
		for(int a=0;a<commandCnt;a++) {
			int newArrayLength = commands[a][1]-commands[a][0]+1;
			int[] new_array = new int[newArrayLength];
			for(int c=0;c<newArrayLength;c++) {
				new_array[c] = array_[c+commands[a][0]-1];
			}
			int temp;
			for(int d=0;d<newArrayLength-1;d++) {
				for(int e=0;e<newArrayLength-1-d;e++) {
					if(new_array[e] > new_array[e+1]) {
						temp = new_array[e];
						new_array[e]=new_array[e+1];
						new_array[e+1] = temp;
					}
				}
			}
			returns[a] = new_array[commands[a][2]-1];
		}
		
		for(int a=0;a<commandCnt;a++) {
			System.out.println(returns[a]);
		}
		
		
	}
}
