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
		/*
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
		*/
		
		String word = inputString();
		int shift = inputShift();
		
		
		//String result = shiftString(word, shift);
		String result = shiftString(word, shift);
		System.out.println("shift 된 결과 : " + result);
		
		String a = new String("hello");
		String b = a;
		System.out.println(b);
		b = "hi";//"hi"  = new String("hi");
		System.out.println(a);
		System.out.println(b);
	}

	static String shiftString(String word, int shift) {
		char[] splitWord = word.toCharArray();
		int wordLength = splitWord.length;
		String result="";
		
		for(int i=0;i<wordLength;i++) {
			if(splitWord[i] >= 'a' && splitWord[i] <= 'z') {
				splitWord[i]+=shift;
				if(splitWord[i] > 'z') {
					splitWord[i] = (char) ('a'+(splitWord[i]-'z'-1));
				}
			}
			else if(splitWord[i] >= 'A' && splitWord[i] <= 'Z') {
				splitWord[i]+=shift;
				if(splitWord[i] > 'Z') {
					splitWord[i] = (char) ('a'+(splitWord[i]-'Z'-1));
				}
			}
			result += Character.toString(splitWord[i]);
		}
		
		return result;
	}

	static int inputShift() {
		boolean check = true;
		int shift;
		
		do {
			Scanner scan = new Scanner(System.in);
			System.out.println("얼마만큼 shift 할 것인가?");
			shift = scan.nextInt();
			if(shift > 25 || shift < 1) 
				System.out.println("1~25 사이의 숫자만 입력 가능합니다.");
			else
				check = false;
		}while(check);
		
		return shift;
	}

	static String inputString() {
		boolean checkWord = true;
		boolean checkCount = true;
		String word;
		do {
			Scanner scan = new Scanner(System.in);
			System.out.println("8000자 이하의 변경할 문자를 입력하시오");
			word = scan.nextLine();
			char[] token = word.toCharArray();
			int tokenLength = token.length;
			for(int i=0;i<tokenLength;i++) 
				if(!(token[i] >='a' && token[i]<='z') && !(token[i] >='A' && token[i]<='Z') && !(token[i]==' ')) {
					System.out.println("영문자 또는 공백만 입력 가능합니다.");
					break;
				}					
				else
					checkWord = false;
			
			if(word.length() > 5) 
				System.out.println("8000자가 초과됩니다.");
			else
				checkCount = false;
			
		}while((checkWord || checkCount));		
		
		return word;
	}
}
