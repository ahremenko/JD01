package by.htp.ahremenko;

public class Rational {
	private int num; // числитель
	private int den; // знаменатель
	
	public Rational (int n, int d) {
		if (d <= 0) {
			System.err.println("Denominator must be > 0!");
			return;
			}
		num = n;
		den = d;
	}
	public int getNum () {
		return num;
	}
	public int getDen () {
		return den;
	}
	//public void setNew (int i)
	public void printRational () {
		System.out.print( num + "/" + den );
	}
	
	public String getRationalAsString() {
		return ( num + "/" + den );
	}
	
	public Rational addRational ( Rational r) { // добавление дроби
		int d = NumbersActions.getNOK(r.getDen(), den);  // общий знаменатель
		int n1 = r.getNum() * d / r.getDen();    // числитель добавляемой дроби
		int n2 = num * d / den;					// числитель дроби, к которой добавляем
		Rational sumR = new Rational(n1 + n2, d);
		sumR.Reduct();
		return sumR;
	}
	
	public void Reduct() { // сокращение дроби
		int i = NumbersActions.getMaxDivisor(num, den);
		if ( i > 1) {
			num = num / i;
			den = den / i;
		}
	}
}
