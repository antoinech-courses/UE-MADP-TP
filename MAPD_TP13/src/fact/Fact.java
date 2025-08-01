package fact;

import java.math.BigInteger;

public class Fact {
	public static BigInteger fact(int n) {
		return (n <= 1) ? BigInteger.ONE : BigInteger.valueOf(n).multiply(fact(n - 1));
	}

	public static void main(String[] args) {
		System.out.println(Fact.fact(1000));
		System.out.println(Fact.fact(1000).toString().length());
	}
}