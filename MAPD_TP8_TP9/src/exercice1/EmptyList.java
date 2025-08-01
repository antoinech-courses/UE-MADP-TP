package exercice1;

import java.util.NoSuchElementException;

public class EmptyList<E> extends AList<E> {
	
	public EmptyList() {
		
	}

	@Override
	public int size() {
		return 0;
	}

	@Override
	public boolean isEmpty() {
		return true;
	}

	@Override
	public E getHead() {
		throw new NoSuchElementException();
	}

	@Override
	public AList<E> getTail() {
		throw new NoSuchElementException();
	}

	@Override
	public E getSecond() {
		throw new NoSuchElementException();
	}

}
