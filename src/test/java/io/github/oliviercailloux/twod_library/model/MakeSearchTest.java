package io.github.oliviercailloux.twod_library.model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MakeSearchTest {

	Library library;
	MakeSearch s;

	public MakeSearchTest() {
		library = new Library();
		List<Book> expected = new ArrayList<>();

		Author a1 = new Author("HUGO", "Victor");
		Author a2 = new Author("ROWLING", "JK");
		Author a3 = new Author("BAUDELAIRE", "Charles");
		Author a4 = new Author("CHUNG", "Hugo");

		Book b1 = new Book();
		b1.setAuthor(a1);
		b1.setTitle("Les misérables");
		b1.setYear(2015);
		expected.add(b1);

		Book b2 = new Book();
		b2.setAuthor(a2);
		b2.setTitle("Harry Poopper");
		b2.setYear(2005);
		expected.add(b2);

		Book b3 = new Book();
		b3.setAuthor(a3);
		b3.setTitle("Une vie de coccinelle");
		b3.setYear(1860);
		expected.add(b3);

		Book b4 = new Book();
		b4.setAuthor(a4);
		b4.setTitle("J'aime le java");
		b4.setYear(1860);
		expected.add(b4);

		this.library.setShelves(Library.createLibrary(expected, 1));
		this.s = new MakeSearch();
	}

	@Test
	public void search_by_author_should_Return_list_of_book_for_author_corresponding() {
		SearchData search = SearchData.createSearchDataObject("hugo", SearchData.generateRangeInteger(-1, -1), null);
		List<Book> resultSearch = s.getResultSearchData(search, library.getListOfAllTheBooks());
		assertEquals(2, resultSearch.size());
		assertEquals("J'aime le java", resultSearch.get(0).getTitle());
		assertEquals("Les misérables", resultSearch.get(1).getTitle());
	}

	@Test
	public void search_by_title_should_Return_list_of_book_for_title_corresponding() {
		SearchData search = SearchData.createSearchDataObject(null, SearchData.generateRangeInteger(-1, -1),
				"Les misÊrables");
		List<Book> resultSearch = s.getResultSearchData(search, library.getListOfAllTheBooks());
		assertEquals(1, resultSearch.size());
		assertEquals("Les misérables", resultSearch.get(0).getTitle());
	}

	@Test
	public void search_by_rangeOfYear_should_Return_list_of_book_for_rangeOfYear_corresponding() {
		SearchData search = SearchData.createSearchDataObject(null, SearchData.generateRangeInteger(1860, 2015), null);
		List<Book> resultSearch = s.getResultSearchData(search, library.getListOfAllTheBooks());
		assertEquals(4, resultSearch.size());
		assertEquals("Une vie de coccinelle", resultSearch.get(0).getTitle());
		assertEquals("J'aime le java", resultSearch.get(1).getTitle());
		assertEquals("Harry Poopper", resultSearch.get(2).getTitle());
		assertEquals("Les misérables", resultSearch.get(3).getTitle());
	}

	@Test
	public void test_accent_insensitive() {
		assertEquals(MakeSearch.isSame("les misÉrables", "Les misérables"), true);
		assertEquals(MakeSearch.isSame("les misêrables", "Les misérables"), true);
		assertEquals(MakeSearch.isSame("les miserables", "Les misérables"), true);
	}

}
