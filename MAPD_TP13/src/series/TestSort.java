package series;

import java.util.List;

public class TestSort {

	public static void main(String[] args) {
		List<Series> coll = DB.getInstance().coll;
		System.out.println(coll);
		// sort series by title
		coll.sort((s1, s2) -> s1.getTitle().compareTo(s2.getTitle()));
		System.out.println(coll);
		// sort series by release date
		coll.sort((s1, s2) -> s1.getYear() - s2.getYear());
		System.out.println(coll);
	}
}
