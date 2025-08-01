package exercice1;

public class NotEmptyList<E> extends AList<E> {

	private final E head;
	private final AList<E> tail;
	
	
	public NotEmptyList(E head, AList<E> tail) {
		super();
		this.head = head;
		this.tail = tail;
	}

	@Override
	public int size() {
		return 1 + this.tail.size();
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public E getHead() {
		return this.head;
	}

	@Override
	public AList<E> getTail() {
		return this.tail;
	}

	@Override
	public E getSecond() {
		return this.tail.getHead();
	}

}
