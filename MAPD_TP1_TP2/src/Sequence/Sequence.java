package Sequence;
import java.util.Iterator;

import Rational.UndefinedRational;
import Rational.Rational;

public class Sequence implements Iterator<Rational> {
	
	final private Rational a;
	final private Rational b;
	final private Rational u0;
	private Rational current;

	public Sequence(Rational a, Rational b, Rational u0) {
		this.a = a;
		this.b = b;
		this.u0 = u0;
		this.current = u0;
	}
	
	@Override
	public boolean hasNext() {
		return true;
	}

	@Override
	public Rational next() {
		try {
			this.current = this.current.multiply(this.a).add(this.b);
		} catch (UndefinedRational e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.current;
	}
	
	public Rational index(int i) throws UndefinedRational {
		Rational result = this.u0;
		for (int n = 0; n<i; n++) {
			result = result.multiply(this.a).add(this.b);
		}
		return result;
	}

}
