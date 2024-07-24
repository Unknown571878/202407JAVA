package java0723;

import java.time.LocalTime;

public class Tr implements Runnable{

	@Override
	public void run() {
		LocalTime localTime = LocalTime.now();
		for (int i = 0; i < 5; i++) {
			System.out.printf("%d:%d:%d\n",
					localTime.getHour(), localTime.getMinute(), localTime.getSecond());
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
