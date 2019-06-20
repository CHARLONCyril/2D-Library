package io.github.oliviercailloux.twod_library.model;

import java.util.Collection;

public interface JavaSearcher<E> {

	/**
	 * 
	 * @param collection represent the set where we will perform the search.
	 * @param filter     represent the filter using to filter the collection
	 * @param value      represent the value that we looking for in our library
	 *                   according to the filter
	 * @return a collection containing all Object E founded with the filter
	 */
	public Collection<E> search(Collection<E> collection, String filter, Object value);

}