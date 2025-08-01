package rational;

/**
 * @author Cheucle
 *
 */
public class Rational extends Number{
	
	private int nominator;
	private int denominator;

	/**
	 * @param nominator Numérateur du rationnel
	 * @param denominator Dénominateur du rationnel
	 * @throws UndefinedRational Dénominateur nul
	 */
	public Rational(int nominator, int denominator) throws UndefinedRational{
		if (denominator == 0) {
			throw new UndefinedRational();
		}
		this.nominator = nominator;
		this.denominator = denominator;
	}

	/**
	 * Retourne le plus grand dénominateur commun entre deux entiers
	 * @param a Entier 1
	 * @param b Entier 2
	 * @return Plus grand dénominateur commun entre a et b
	 */
	public static int pgcd(int a, int b) {
		for(int i = Math.min(a, b); i > 0; i--){
		if(a % i == 0 && b % i == 0) return i;
		}
		return 1;
	}
	
	/**
	 * Réduit en un rationnel irréductible (quotient d'entiers premiers entre eux)
	 * @param r Rationnel à réduire
	 * @return Rationnel irréductible
	 * @throws UndefinedRational 
	 */
	public static Rational reduct(Rational r) throws UndefinedRational {
		int pgcd = Rational.pgcd(r.getNominator(), r.getDenominator());
		return new Rational(r.getNominator()/pgcd, r.getDenominator()/pgcd);
	}
	
	public String toString() {
		return this.nominator + "/" + this.denominator;
	}
	
	
	public int getNominator() {
		return nominator;
	}

	public int getDenominator() {
		return denominator;
	}

	public boolean equals(Object o) {
		int compareNum = ((Rational) o).getNominator();
		int compareDenum = ((Rational) o).getDenominator();
		/*int quotient = this.nominator/this.denominator;
		int quotientCompare = compareNum/compareDenum;
		int reste = this.nominator % quotient;
		int resteCompare = compareNum % quotientCompare;
		return ((quotient == quotientCompare) && (reste == resteCompare));*/
		return (compareNum * this.denominator == compareDenum * this.nominator);
	}
	
	/**
	 * Ajoute un rationnel
	 * @param r Rationnel à ajouter
	 * @return Somme de this et r
	 * @throws UndefinedRational 
	 */
	public Rational add(Rational r) throws UndefinedRational {
		return Rational.reduct(new Rational(this.getNominator()*r.getDenominator() + this.getDenominator()*r.getNominator(), this.getDenominator()*r.getDenominator()));
	}
	
	/**
	 * Inverse le rationnel
	 * @return Rationnel inverse
	 * @throws UndefinedRational 
	 */
	public Rational invert() throws UndefinedRational {
		return Rational.reduct(new Rational(this.getDenominator(), this.getNominator()));
	}
	
	/**
	 * Multiplie deux rationnels
	 * @param r Rationnel à multiplier
	 * @return Multiplication de r et this
	 * @throws UndefinedRational 
	 */
	public Rational multiply(Rational r) throws UndefinedRational {
		return Rational.reduct(new Rational(this.getNominator() * r.getNominator(), this.getDenominator() * r.getDenominator()));
	}
	
	public static void main(String[] args) throws UndefinedRational {
		Rational a = new Rational(1, 2);
		Rational a2 = new Rational(6, 12);
		Rational b = new Rational(8, 1);
		Rational c = new Rational(23, 456);
		@SuppressWarnings("unused")
		Rational d = new Rational(1, 4);
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(a.equals(a2));
		System.out.println(a.equals(c));
		System.out.println(a.add(a));
		System.out.println(c.floatValue());
	}

	@Override
	public int intValue() {
		return this.nominator/this.denominator;
	}

	@Override
	public long longValue() {
		return (long)this.nominator/(long)this.denominator;
	}

	@Override
	public float floatValue() {
		return (float)this.nominator/(float)this.denominator;
	}

	@Override
	public double doubleValue() {
		return (double)this.nominator/(double)this.denominator;
	}
}
