package sequence;

import java.util.Iterator;
import java.util.function.UnaryOperator;

import rational.Rational;

public class Sequence implements Iterator<Rational> {
	private UnaryOperator<Rational> f;
	private Rational u;

	public Sequence(UnaryOperator<Rational> f, Rational u0) {
		this.f = f;
		this.u = u0;
	}

	@Override
	public boolean hasNext() {
		return true;
	}

	@Override
	public Rational next() {
		this.u = this.f.apply(this.u);
		return this.u;
	}
	public static void main(String[] args) {
		Rational a, b, u0;
		a = new Rational(3, 2);
		b = new Rational(1, 2);
		u0 = new Rational(0, 1);
		UnaryOperator<Rational> f = q -> q.multiply(a).add(b);
		Sequence s = new Sequence(f, u0);
		System.out.println("0 : " + u0);
		for (int i = 1; i < 19; i++) {
			System.out.println(i + " : " + s.next());
		}
	}
}