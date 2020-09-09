
public class Test {

	public static void main(String[] args) {
		
		for(int i=0;i<12;i++) {
			for(int j=0;j<12;j++) {
				if(j == 0 || j == 11)
					if(i> 0 && i<11) 
						System.out.print((i)%10);
					else
						System.out.print(" ");
				else
					if(i == 0)
						System.out.print('¦¨');
					else if(i == 11)
						System.out.print('¦ª');
					else if(i==(11-j))
						System.out.print('¡Û');
					else
						System.out.print('¦«');
			}
			System.out.println();
		}
	}
}
