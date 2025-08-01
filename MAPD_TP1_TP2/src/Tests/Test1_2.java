package Tests;

import Sequence.Sequence;
import Rational.Rational;
import Rational.UndefinedRational;

public class Test1_2 {
  public static void main(String[] args) throws UndefinedRational {
    Rational a, b, u0;
    a = new Rational(3, 2);
    b = new Rational(1, 2);
    u0 = new Rational(0, 1);
    Sequence s = new Sequence(a, b, u0);
    System.out.println("0 : " + u0);
    for (int i = 1; i < 15; i++) {
      System.out.println(i + " : " + s.next());
    }
    System.out.println("Direct access");
    System.out.println(3 + " : " + s.index(3));
    System.out.println(17 + " : " + s.index(17));
    // the iteration resumes at 15
    System.out.println(15 + " : " + s.next());
    // check direct access still works
    System.out.println(15 + " : " +s.index(15));
    System.out.println(16 + " : " +s.index(16));
    // the iteration resumes at 16
    System.out.println(16 + " : " + s.next());
    System.out.println(17 + " : " + s.next());
    System.out.println(18 + " : " + s.next());
  }
}