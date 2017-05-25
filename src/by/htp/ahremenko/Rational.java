package by.htp.ahremenko;

public class Rational {
	private int num; // ���������
	private int den; // �����������
	
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
	
	public Rational addRational ( Rational r) { // ���������� �����
		int d = NumbersActions.getNOK(r.getDen(), den);  // ����� �����������
		int n1 = r.getNum() * d / r.getDen();    // ��������� ����������� �����
		int n2 = num * d / den;					// ��������� �����, � ������� ���������
		Rational sumR = new Rational(n1 + n2, d);
		sumR.Reduct();
		return sumR;
	}
	
	public void Reduct() { // ���������� �����
		int i = NumbersActions.getMaxDivisor(num, den);
		if ( i > 1) {
			num = num / i;
			den = den / i;
		}
	}
}
