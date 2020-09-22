import java.util.ArrayList;
import java.util.Scanner;

public class ProgrammersEx1 {

	public static void main(String[] args) {
	
		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		
		System.out.println(solution(board,moves));
		
	}

	private static int solution(int[][] board, int[] moves) {
		int deleteCount=0;
		
		ArrayList<Integer>[] list = new ArrayList[board.length];
		int count=0;
		for(int i=0;i<board.length;i++) {
			list[i] = new ArrayList<Integer>();
			for(int j=0;j<board.length;j++) {
				list[i].add(board[j][i]);
			}
		}

		ArrayList<Integer> pickedItem = new ArrayList<Integer>();
		for(int i=0;i<moves.length;i++) {
			for(int j=0;j<board.length;j++) {
				
				if(list[moves[i]-1].get(j) != 0) {
					pickedItem.add(list[moves[i]-1].get(j));
					list[moves[i]-1].set(j, 0);
					break;
				}
			}
			int size = pickedItem.size();
			for(int k=0;k<size-1;k++) {
				if(pickedItem.get(k)==pickedItem.get(k+1)) {
					pickedItem.remove(k);
					pickedItem.remove(k);
					deleteCount += 2;
					size-=2;
					break;
				}
			}
		}
		return deleteCount;
	}
/*
	private static int[] inputMoves() {
		Scanner scan = new Scanner(System.in);
		String moveLine = scan.nextLine();
		String[] tokens = moveLine.split(",");
		
		int[] moves = new int[tokens.length];
		for(int i=0;i<moves.length;i++) {
			moves[i] = Integer.parseInt(tokens[i]);
		}
		
		return moves;
	}*/
/*
	private static void printBoard(int listSize, ArrayList<Integer>[] list) {
		for(int i=0;i<listSize;i++) {
			for(int j=0;j<listSize;j++) {
				System.out.printf("%3d",list[j].get(i));
			}System.out.println();
		}
	}*/
/*
	private static void inputNum(int listSize, ArrayList<Integer>[] list) {
		Scanner scan = new Scanner(System.in);
		System.out.printf("board의 값을 입력하시오. \n");
		int count=0;
		do {
			String nums = scan.nextLine();
			String[] tokens = nums.split(",");
			for(int i=0;i<listSize;i++) {
				list[i].add(Integer.parseInt(tokens[i]));
			}
			count++;
		}while(count < listSize);
		
	}*/
/*
	static int inputListSize() {
		Scanner scan  = new Scanner(System.in);
		System.out.print("인형뽑기 크기를 입력하시오 : ");
		int listSize = scan.nextInt();
		scan.nextLine();
		return listSize;
	}*/

}
