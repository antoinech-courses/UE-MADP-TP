package fact;

import java.math.BigInteger;
import java.util.function.IntFunction; 

public class Fact1 {
	public static IntFunction<BigInteger> fact = new IntFunction<BigInteger>(){

		@Override
		public BigInteger apply(int value) {
			return (value <= 1) ? BigInteger.ONE : 
				BigInteger.valueOf(value).multiply(fact.apply(value - 1));
		}
	};

	public static void main(String[] args) {
		System.out.println(Fact1.fact.apply(1000));
		System.out.println(Fact1.fact.apply(1000).toString().length());
	}
}