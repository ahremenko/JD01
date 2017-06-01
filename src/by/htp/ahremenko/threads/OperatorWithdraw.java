package by.htp.ahremenko.threads;

import java.util.Random;

public class OperatorWithdraw implements Runnable {
		Account acc;
		
		public OperatorWithdraw(Account a) {
			this.acc = a;
		}
		
		@Override
		public void run() {
			Random rnd = new Random();
	        //try {
	        	for (int i = 1; i <= 10; i++) {
		            this.acc.Withdraw(100f);
					//Thread.sleep(rnd.nextInt(500));
	        	}
			//} catch (InterruptedException e) {
			//	e.printStackTrace();
			//}
		}
		
}


