package by.htp.ahremenko.threads;

public class Account {
	private volatile float amount;
	private final float WITHDRAW_LIMIT = 500f;
	
	public Account() {
		amount = 1000f;
	}
	
	public synchronized boolean Deposit (float a) {
		float newBalance;
		newBalance = this.amount + ( a > 0 ? a : 0 );
		this.amount = newBalance;
		//System.out.print("+" + a + ".. ");
		System.out.print(".");
		return (a > 0);
	}
	
	public synchronized boolean Withdraw (float a) {
		float newBalance;
		if ( a > 0  && this.amount-a >= 0 && a <= WITHDRAW_LIMIT ) {
			newBalance = this.amount-a;
			this.amount = newBalance;
			//System.out.print("-" + a + ".. ");
			System.out.print(".");
			return true;
		} else {
			return false;
		}
	}
	
	public String toString() {
		return "CURRENT VALUE: " + amount;
	}
}
