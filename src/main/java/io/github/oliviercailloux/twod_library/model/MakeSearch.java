package io.github.oliviercailloux.twod_library.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.glassfish.jersey.internal.guava.Preconditions;

public class MakeSearch implements JavaSearcher<Book, SearchData, String, Integer> {

//	private JavaSearcher<???> stringSearcher = new StringJavaSearcher;
//	private JavaSearcher<???> dateSearcher;
	/*
	 * @Override public HashSet<Book> searchBy(Collection<Book> collection,
	 * Collection<String> filter, Collection<Function<Book, String>> mapper) {
	 * HashSet<Book> books = new HashSet<>(); ((Collection<Book>)
	 * collection).stream() .filter(b -> filter.stream() .anyMatch(sub ->
	 * mapper.stream().anyMatch(f -> f.apply(b).contains(sub.toLowerCase()))))
	 * .forEach(books::add); return books; }
	 */
	@SuppressWarnings("unchecked")
	/**
	 * This function call the good search function according to the user's choice
	 */

	public List<Book> getResultSearchData(SearchData s, Collection<Book> collection) {
		Preconditions.checkArgument(!collection.isEmpty());// We can't do a search if there is no books in library
		HashSet<Book> resultSearching = new HashSet<Book>();
		// resultSearching = searchByString(collection, s.getTitleRegex());
		System.out.println(s.getTitleRegex());
		System.out.println(resultSearching);
		return convertToList(resultSearching);

	}

	// Generic function to convert set to list
	public static <T> List<T> convertToList(Set<T> set) {
		return set.stream().collect(Collectors.toList());
	}

	@Override
	public Collection<Book> searchByInterval(Collection<Book> collection, Function<SearchData, Integer> filter) {

		return null;
	}

	@Override
	public Collection<Book> searchByString(Collection<Book> collection, Collection<Function<SearchData, String>> o) {
		HashSet<Book> books = new HashSet<>();
		collection.stream().filter(b -> b.getTitle().contains(o.toString())).forEach(books::add);
		return books;
	}

//	public Collection<Book> collection, Function<SearchData,W>filter)
//	{
//		// TODO Auto-generated method stub
//		return null;
//	}

	// public <W> Collection<Book> searchBgy(Collection<Book> collection,
	// Function<SearchData, W> filter) {
	/*
	 * HashSet<Book> books = new HashSet<>(); collection.stream().filter(b ->
	 * filter.stream().allMatch( sub -> b.getAuthor().equals(sub.getAuthorRegex())))
	 * 
	 * .forEach(books::add); return books;
	 */

//		HashSet<Book> books = new HashSet<>(); 
//		collection).stream() .filter(b -> filter.stream() .anyMatch(
//				sub -> mapper.stream().anyMatch(f -> f.apply(b).contains(sub.toLowerCase()))))
//				 .forEach(books::add); 
//		return books; 
	// }

}
