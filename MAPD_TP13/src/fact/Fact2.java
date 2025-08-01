package fact;

import java.math.BigInteger;
import java.util.function.IntFunction; 

public class Fact2 {
	public static IntFunction<BigInteger> fact = null;

	public static void main(String[] args) {
		fact = value -> (value <= 1) ? BigInteger.ONE : 
			BigInteger.valueOf(value).multiply(fact.apply(value - 1));
		System.out.println(Fact2.fact.apply(1000));
		System.out.println(Fact2.fact.apply(1000).toString().length());
	}
}