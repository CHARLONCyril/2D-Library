package io.github.oliviercailloux.twod_library.model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class SearchDataTest {

	@Test
	public void test() {
		ArrayList<String> filter = new ArrayList<String>();
		filter.add("2");
		filter.add("mis");
		SearchData s = SearchData.createSearchDataFilter(filter, "tout");
		int i = 0;
		for (Object criteria : s.getSearchCriteria()) {
			assertEquals(criteria, filter.get(i));
			i++;
		}

		assertEquals(s.getTypeOfSearch(), "tout");
	}

}
