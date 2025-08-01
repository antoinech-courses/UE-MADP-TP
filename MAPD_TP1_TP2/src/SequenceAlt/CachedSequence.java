package SequenceAlt;

import java.util.ArrayList;
import java.util.List;

import Rational.Rational;

public class CachedSequence extends Sequence {

	private List<Rational> cache;
	private int i;
	
	public CachedSequence(Rational a, Rational b, Rational u0) {
		super(a, b, u0);
		this.i = 0;
		this.cache = new ArrayList<Rational>();
		this.cache.add(u0);
	}
	
	@Override
	public Rational next() {
		this.i += 1;
		if (i < this.cache.size()) {
			return this.cache.get(i);
		}
		else {
			Rational result = super.next();
			this.cache.add(result);
			return result;
		}
	}
	
	@Override
	public Rational index(int i) {
		if (i < this.cache.size()) {
			return this.cache.get(i);
		}
		else {
			return super.index(i);
		}		
	}
	
}
