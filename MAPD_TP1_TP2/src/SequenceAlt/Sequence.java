package SequenceAlt;

import java.util.Iterator;
import Rational.Rational;
import Rational.UndefinedRational;

public class Sequence implements Iterable<Rational> {
	final private Rational a;
	final private Rational b;
	final private Rational u0;
	private Iter iter;
	
	public Sequence(Rational a, Rational b, Rational u0) {
		this.a = a;
		this.b = b;
		this.u0 = u0;
		this.iter = new Iter();
	}
	
	public class Iter implements Iterator<Rational>{

		private Rational current;
		
		public Iter() {
			this.current = u0;
		}

		@Override
		public boolean hasNext() {
			return true;
		}

		@Override
		public Rational next() {
			try {
				this.current = this.current.multiply(a).add(b);
			} catch (UndefinedRational e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return this.current;
		}
		
	}

	@Override
	public Iterator<Rational> iterator() {
		return this.iter;
	}
	
	public Rational next() {
		return this.iter.next();
	}
	
	public Rational index(int i) {
		Iter iter = new Iter();
		for (int n=0; n<i-1; n++) {iter.next();}
		return iter.next();
	}
	
}
