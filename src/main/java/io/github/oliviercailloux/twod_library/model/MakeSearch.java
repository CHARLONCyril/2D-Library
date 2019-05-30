package io.github.oliviercailloux.twod_library.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.glassfish.jersey.internal.guava.Preconditions;

public class MakeSearch implements JavaSearcher<Book, String> {

	@Override
	public HashSet<Book> searchBy(Collection<Book> collection, Collection<String> filter,
			Collection<Function<Book, String>> mapper) {
		HashSet<Book> books = new HashSet<>();
		((Collection<Book>) collection).stream()
				.filter(b -> filter.stream()
						.anyMatch(sub -> mapper.stream().anyMatch(f -> f.apply(b).contains(sub.toLowerCase()))))
				.forEach(books::add);
		return books;
	}

	@SuppressWarnings("unchecked")
	/**
	 * This function call the good search function according to the user's choice
	 */
	public List<Book> getResultSearchData(SearchData s, Collection<Book> collection) {
		Preconditions.checkArgument(!s.getSearchCriteria().isEmpty());// We can't do a search if there is no criteria
		Preconditions.checkArgument(!collection.isEmpty());// We can't do a search if there is no books in library
		HashSet<Book> resultSearching = new HashSet<Book>();
		switch (s.getTypeOfSearch()) {
		case "auteur":
			resultSearching = searchBy(collection, s.getSearchCriteria(),
					new ArrayList<Function<Book, String>>(Arrays.asList(b -> b.getAuthor().getFirstName().toLowerCase(),
							b -> b.getAuthor().getLastName().toLowerCase())));
			break;

		case "titre":
			resultSearching = searchBy(collection, s.getSearchCriteria(),
					new ArrayList<Function<Book, String>>(Arrays.asList(b -> b.getTitle().toLowerCase())));
			break;

		case "date":
			resultSearching = searchBy(collection, s.getSearchCriteria(),
					new ArrayList<Function<Book, String>>(Arrays.asList(b -> String.valueOf(b.getYear()))));
			break;
		case "tout":
			resultSearching = searchBy(collection, s.getSearchCriteria(),
					new ArrayList<Function<Book, String>>(Arrays.asList(b -> b.getAuthor().getFirstName().toLowerCase(),
							b -> b.getAuthor().getLastName().toLowerCase(), b -> b.getTitle().toLowerCase(),
							b -> String.valueOf(b.getYear()))));
			break;
		}
		return convertToList(resultSearching);
	}

	// Generic function to convert set to list
	public static <T> List<T> convertToList(Set<T> set) {
		return set.stream().collect(Collectors.toList());
	}

}
