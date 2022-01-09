import java.util.ArrayList;
import java.text.SimpleDateFormat;

import java.util.Scanner;

public class Management {
	private int currentNo = 0;
	
	//Customer cst[] = new Customer[10];
	ArrayList<Customer> cst =new ArrayList <Customer>(10);
	SeatManage seatMan = new SeatManage();
	
	Scanner scan = new Scanner(System.in);
	
	
	public Management() {
		
		this.currentNo = 0;
	}

	
	
	
	public void setIn() {
		int check = 0;

		System.out.print("�̸��� �Է��ϼ���: ");
		String inputName = scan.next();
		
		for (int i=0; i<cst.size(); i++) {
			
			if(inputName.equals(cst.get(i).name) ) {
				inputName = inputName + i;
				System.out.println("���������� �־� ����� �̸��� " + inputName+ "���� �����˴ϴ�. \n���Ŀ� �ش� �̸����� ����� �������ּ���.");
			}
			
		}
		
		seatMan.print();
		System.out.println("���� ���� �¼��� " + (10-currentNo) +"�� �Դϴ�(V:���¼�/C:���¼�)");
		System.out.print("���ϴ� �¼��� ������: ");
		
		try {
			int inputSeat = scan.nextInt();
			
			seatMan.setSeat(inputSeat/10, inputSeat%10);
			
			for (int i=0; i<cst.size(); i++) {
				if(cst.get(i).seatID == inputSeat) {
					check = 1;
					break;
				}else {
					check = 0;
				}
			}
			
			if (check == 0) {
				cst.add(new Customer(inputName));
				cst.get(currentNo).seatID = inputSeat;
				cst.get(currentNo).startTime = Payment.setCheckIn();
				
				String s = new SimpleDateFormat("HH:mm:ss").format(cst.get(currentNo).startTime);
				System.out.println("--����ð� " +  s);
				
				currentNo++;
			}
			
		}catch(Exception e) {
			
			System.out.println("�������� ���� �¼� ��ȣ�Դϴ�.");
			
		}
						
		
	}
	
	public void setOut() {
		System.out.print("�̸��� �Է��ϼ���: ");
		String inputName = scan.next();
		int check = 1;
		
		for (int i=0; i<cst.size(); i++) {	
			if (inputName.equals( cst.get(i).name)) {	
				check = 1;
				
				System.out.println("����� �¼���ȣ�� " + cst.get(i).seatID + "�Դϴ�.");
				System.out.println("�����Ǿ����ϴ�.");
				
				cst.get(i).endTime = Payment.setCheckOut();
				String s = new SimpleDateFormat("HH:mm:ss").format(cst.get(i).endTime);
				System.out.println("--����ð� " + s);
				Payment.calculateFee(cst.get(i).startTime, cst.get(i).endTime);
				
				seatMan.releaseSeat(cst.get(i).seatID/10, cst.get(i).seatID%10);
				
				currentNo--;
				cst.remove(i);
				break;
			}else
				check = -1;
			
		}
		
		if (check == -1)
			System.out.println("�������� �ʴ� �̸��Դϴ�.");
		
	}
	
	public void admin() {
		System.out.println();
		System.out.println("[������ �޴�]");
		System.out.println("1. ���� �¼� ���� ����");
		System.out.println("2. ��ü �¼� ���� �ϱ�");
		System.out.println("3. �մ� ��Ȳ ����");
		System.out.println("4. �� ���� Ȯ���ϱ�");
		System.out.print("--->");
		
		int inputAdmin = scan.nextInt();
		
		switch(inputAdmin) {
			case 1:
				seatMan.print();
				System.out.print("�� �¼�: " + currentNo + "/");
				System.out.println("���� �¼�: " + (10 - currentNo));
				break;
				
			case 2: 
				seatMan.clear();
				cst.clear();
				currentNo = 0;
				
				System.out.println("��� �¼��� �����Ǿ����ϴ�.");
				
				break;
				
			case 3: 
				System.out.println("�¼���ȣ\t" + "�̸�	");
				System.out.println("--------------------");
				
				for (int i=0; i<cst.size(); i++) {		//cst.length
					System.out.print(cst.get(i).seatID + "	  " + cst.get(i).name);		//cst.get(i).seatID, cst.get(i).name
					System.out.println();
				}
				
				break;
				
			case 4: 
				System.out.print("���� �� ����: " + Payment.total_Income + "��");
				
				break;
				
			default:
				System.out.println("1~4�� �߿��� �������ּ���.");
		}
		
		
	}

}
