package io.github.oliviercailloux.twod_library.model;

import java.text.Collator;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.glassfish.jersey.internal.guava.Preconditions;

public class MakeSearch implements JavaSearcher<Book> {

	/**
	 * This function call the good search function according to the user's choice
	 *
	 * @param s          are the search criteria entered by the user
	 * @param collection is the collection where we use the search criteria to
	 *                   filter our library
	 * @return a list containing all books corresponding to all search criteria
	 */

	@SuppressWarnings("unchecked")
	public List<Book> getResultSearchData(SearchData s, Collection<Book> collection) {
		Preconditions.checkArgument(!collection.isEmpty());// We can't do a search if there is no books in library
		HashSet<Book> resultSearching = new HashSet<Book>();
		if (s.getAuthorRegex() != null)
			resultSearching = search(collection, "author", s.getAuthorRegex());
		if (s.getTitleRegex() != null)
			resultSearching = intersection(resultSearching, search(collection, "title", s.getTitleRegex()));
		if (s.getPublication().getMinRange() != null || s.getPublication().getMaxRange() != null)
			resultSearching = intersection(resultSearching, search(collection, "date", s.getPublication()));
		return (List<Book>) convertToList(resultSearching);

	}

	@Override
	public HashSet<Book> search(Collection<Book> collection, String filter, Object value) {
		HashSet<Book> books = new HashSet<>();
		if (filter == "author") {
			collection.stream().filter(b -> b.getAuthor().checkAuthorRegex(value.toString())).forEach(books::add);
		}

		else if (filter == "title") {
			collection.stream().filter(b -> b.getTitle().toLowerCase().contains(value.toString().toLowerCase())
					|| isSame(b.getTitle(), value.toString())).forEach(books::add);
		} else {
			PublicationRange p = (PublicationRange) value;
			collection.stream().filter(b -> p.checkRange(b.getYear())).forEach(books::add);
		}
		return books;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	/**
	 * Generic function to convert set to list
	 * 
	 * @param set the collection to convert into list
	 * @return the set converted into list
	 */
	public static Collection convertToList(Collection set) {
		return (Collection) set.stream().collect(Collectors.toList());
	}

	/**
	 * 
	 * @param list1 the first list to compare
	 * @param list2 the second list to compare
	 * @return the intersection if the list are not empty
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static HashSet<Book> intersection(Collection list1, Collection list2) {
		if (list1.isEmpty())
			return new HashSet<>(list2);
		else if (list2.isEmpty())
			return new HashSet<>(list1);

		HashSet<Book> intersect = (HashSet<Book>) list1.stream().filter(list2::contains).collect(Collectors.toSet());
		return intersect;
	}

	/**
	 * 
	 * @param a the first string to compare
	 * @param b the second string to compare
	 * @return true even if accent is missing or not and insensitive
	 */
	public static boolean isSame(String a, String b) {
		Collator insenstiveStringComparator = Collator.getInstance();
		insenstiveStringComparator.setStrength(Collator.PRIMARY);
		return insenstiveStringComparator.compare(a, b) == 0;
	}

}
