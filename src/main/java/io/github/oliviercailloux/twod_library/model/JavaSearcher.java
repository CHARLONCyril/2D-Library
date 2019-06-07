package io.github.oliviercailloux.twod_library.model;

import java.util.Collection;
import java.util.function.Function;

public interface JavaSearcher<E, T, W, R> {
	/**
	 * 
	 * @param collection represent the set where we will perform the search.
	 * @param filter     set of filters which will be applied to @param collection
	 * @param mapper     a set of subroutines who will be call for every element of
	 *                   set and use for the search
	 * @return all the element who will correspond for the search
	 */

	public Collection<E> searchByString(Collection<E> collection, Collection<Function<T, W>> filter);

	public Collection<E> searchByInterval(Collection<E> collection, Function<T, R> filter);

}