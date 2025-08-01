package Rational;

public class WithPGCD extends Rational {

	private int pgcd;
	
	WithPGCD(int nominator, int denominator) throws UndefinedRational {
		super(nominator, denominator);
		this.pgcd = Rational.pgcd(nominator, denominator);
	}
	
	@Override
	public String toString() {
		return super.toString() + ", PGCD = " + this.pgcd;
	}
	
}
