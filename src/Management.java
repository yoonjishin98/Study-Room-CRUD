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

		System.out.print("이름을 입력하세요: ");
		String inputName = scan.next();
		
		for (int i=0; i<cst.size(); i++) {
			
			if(inputName.equals(cst.get(i).name) ) {
				inputName = inputName + i;
				System.out.println("동명이인이 있어 당신의 이름은 " + inputName+ "으로 수정됩니다. \n추후에 해당 이름으로 퇴실을 진행해주세요.");
			}
			
		}
		
		seatMan.print();
		System.out.println("현재 남은 좌석은 " + (10-currentNo) +"석 입니다(V:빈좌석/C:찬좌석)");
		System.out.print("원하는 좌석을 고르세요: ");
		
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
				System.out.println("--입장시간 " +  s);
				
				currentNo++;
			}
			
		}catch(Exception e) {
			
			System.out.println("존재하지 않은 좌석 번호입니다.");
			
		}
						
		
	}
	
	public void setOut() {
		System.out.print("이름을 입력하세요: ");
		String inputName = scan.next();
		int check = 1;
		
		for (int i=0; i<cst.size(); i++) {	
			if (inputName.equals( cst.get(i).name)) {	
				check = 1;
				
				System.out.println("당신의 좌석번호는 " + cst.get(i).seatID + "입니다.");
				System.out.println("해제되었습니다.");
				
				cst.get(i).endTime = Payment.setCheckOut();
				String s = new SimpleDateFormat("HH:mm:ss").format(cst.get(i).endTime);
				System.out.println("--퇴장시간 " + s);
				Payment.calculateFee(cst.get(i).startTime, cst.get(i).endTime);
				
				seatMan.releaseSeat(cst.get(i).seatID/10, cst.get(i).seatID%10);
				
				currentNo--;
				cst.remove(i);
				break;
			}else
				check = -1;
			
		}
		
		if (check == -1)
			System.out.println("존재하지 않는 이름입니다.");
		
	}
	
	public void admin() {
		System.out.println();
		System.out.println("[관리자 메뉴]");
		System.out.println("1. 현재 좌석 상태 보기");
		System.out.println("2. 전체 좌석 리셋 하기");
		System.out.println("3. 손님 현황 보기");
		System.out.println("4. 총 수입 확인하기");
		System.out.print("--->");
		
		int inputAdmin = scan.nextInt();
		
		switch(inputAdmin) {
			case 1:
				seatMan.print();
				System.out.print("찬 좌석: " + currentNo + "/");
				System.out.println("남은 좌석: " + (10 - currentNo));
				break;
				
			case 2: 
				seatMan.clear();
				cst.clear();
				currentNo = 0;
				
				System.out.println("모든 좌석이 해제되었습니다.");
				
				break;
				
			case 3: 
				System.out.println("좌석번호\t" + "이름	");
				System.out.println("--------------------");
				
				for (int i=0; i<cst.size(); i++) {		//cst.length
					System.out.print(cst.get(i).seatID + "	  " + cst.get(i).name);		//cst.get(i).seatID, cst.get(i).name
					System.out.println();
				}
				
				break;
				
			case 4: 
				System.out.print("현재 총 수익: " + Payment.total_Income + "원");
				
				break;
				
			default:
				System.out.println("1~4번 중에서 선택해주세요.");
		}
		
		
	}

}
