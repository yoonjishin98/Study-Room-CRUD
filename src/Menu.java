import java.util.*;

public class Menu {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in); 
		Management management = new Management();	//�� �κ� �߸��ƾ���....
		
		while(true) {
			
			System.out.println();
			System.out.println("####### LaLa StudyRoom #######");
			System.out.println("1. ����");
			System.out.println("2. ����");
			System.out.println("3. ������");
			System.out.println("4. ����");
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
				System.out.print("���α׷��� ����˴ϴ�.");
				break;
			}else
				System.out.println("1~4�� �߿��� �Է����ּ���.");
		}
		
		scan.close();
			
	}

}
