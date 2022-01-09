import java.util.*;

public class Menu {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in); 
		Management management = new Management();	//이 부분 잘못됐었음....
		
		while(true) {
			
			System.out.println();
			System.out.println("####### LaLa StudyRoom #######");
			System.out.println("1. 입장");
			System.out.println("2. 퇴장");
			System.out.println("3. 관리자");
			System.out.println("4. 종료");
			System.out.print("--->");

			
			int input = scan.nextInt();
			
			
			if (input == 1) {
				management.setIn();
			}
			else if (input == 2) {
				management.setOut();
			}
			else if (input == 3) {
				management.admin();
			}
			else if (input == 4) {
				System.out.print("프로그램이 종료됩니다.");
				break;
			}else
				System.out.println("1~4번 중에서 입력해주세요.");
		}
		
		scan.close();
			
	}

}
