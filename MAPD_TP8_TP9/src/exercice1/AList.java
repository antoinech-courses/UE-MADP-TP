package exercice1;

public abstract class AList<E> {
	
	abstract public int size();
	abstract public boolean isEmpty();
	
	abstract public E getHead();
	abstract public AList<E> getTail();
	abstract public E getSecond();

}
