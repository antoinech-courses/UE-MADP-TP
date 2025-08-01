package Tests;

import Rational.Rational;
import Rational.UndefinedRational;
import SequenceAlt.Sequence;

public class Test2_1 {
  public static void main(String[] args) throws UndefinedRational {
    Rational a, b, u0;
    a = new Rational(3, 2);
    b = new Rational(1, 2);
    u0 = new Rational(0, 1);
    Sequence s = new Sequence(a, b, u0);
    System.out.println("0 : " + u0);
    for (int i = 1; i < 19; i++) {
      System.out.println(i + " : " + s.next());
    }
  }
}
