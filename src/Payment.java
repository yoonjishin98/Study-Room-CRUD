
public class Payment {
	
	static int total_Income = 0;
	final static int FEE_PER_MINUTE=100;
	final static int FEE_PER_HOUR=5000;
	
	
	public static int calculateFee (long startTime, long endTime) {
		
		long duration = endTime - startTime;	//duration�� ������ second���� ��
		long fee;
		
		duration = duration /1000;
		long min = duration / 60;
		long hour = min/60;
		long sec = duration % 60;
		min = min % 60;
				
		if (sec > 30)
			fee = hour*FEE_PER_HOUR + min*FEE_PER_MINUTE + FEE_PER_MINUTE;
		else
			fee = hour*FEE_PER_HOUR + min*FEE_PER_MINUTE;
		
		System.out.println("\n�ӹ��� �ð��� " + hour + "�ð� " + min + "�� " + sec + "��. ���� ����� " + fee);
		
		
		total_Income += fee;
		
		return total_Income;
	}
	
	public static long setCheckIn() {

		long time = System.currentTimeMillis();
		
		return time;
	}
	
	public static long setCheckOut() {
		
		long time = System.currentTimeMillis();
		
		return time;
		
	}

	
}
