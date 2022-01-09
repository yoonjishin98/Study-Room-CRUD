
public class SeatManage {

	boolean[][] setTable = new boolean[2][5];
	
	
	public SeatManage() {
	
		
		for (int i=1; i<=2; i++) {
			for (int j=1; j<=5; j++) {
				setTable[i-1][j-1] = false;
			}
		}
			
	}
	
	public void clear() {
		
		for (int i=1; i<=2; i++) {
			for (int j=1; j<=5; j++) {
				setTable[i-1][j-1] = false;
			}
		}
	}
	
	public void print() {
		System.out.println();
		
		for (int i=1; i<=2; i++) {
			for (int j=1; j<=5; j++) {
				
				if (setTable[i-1][j-1] == false)
					System.out.print("V"+ "["+i+"]"+"["+j+"]" + "  ");
				else
					System.out.print("C"+ "["+i+"]"+"["+j+"]" + "  ");
				
			}
			System.out.println();

		}
		
		System.out.println();
	}
	
	public void setSeat(int x, int y) {
		
		if (setTable[x-1][y-1] == false) {
			setTable[x-1][y-1] = true;
			System.out.println("선택되었습니다.");
		}
		else
			System.out.println("이미 사용 중입니다.");
	}
	
	public void releaseSeat(int x, int y) {
		if (setTable[x-1][y-1] == true)
			setTable[x-1][y-1] = false;
		
	}

}
