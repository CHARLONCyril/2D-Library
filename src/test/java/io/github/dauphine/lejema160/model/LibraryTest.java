package io.github.dauphine.lejema160.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import io.github.dauphine.lejema160.model.Author;
import io.github.dauphine.lejema160.model.Book;
import io.github.dauphine.lejema160.model.Library;
import io.github.dauphine.lejema160.model.Shelf;

/**
 * @author lejema160
 * @author OlympieSuquet
 *
 */
public class LibraryTest {

	/**
	 * Test method for {@link main.java.model.Library#Library(java.util.List)}.
	 */
	@Test
	public void testLibraryListOfShelf() {
		Author olympie = new Author("Olympie", "Suquet");
		Author merlene = new Author("Merlène", "Lejeune");
		Book book1 = new Book();
		book1.setAuthor(olympie);
		book1.setTitle("Titre popo");
		book1.setYear(2014);
		Book book2 = new Book();
		book2.setAuthor(olympie);
		book2.setTitle("tutitre pam");
		book2.setYear(202);
		Book book3 = new Book();
		book3.setAuthor(merlene);
		book3.setTitle("Tuto beauté");
		book3.setYear(2506);
		List<Book> books = new ArrayList<>();
		books.add(book1);
		books.add(book2);
		books.add(book3);
		int nbBooksPerShelf = 4;
		Library library = new Library(books, nbBooksPerShelf);
		
		//Library librarytest = new Library(books, 6);
		
		//assertEquals(library.getShelves().size(), librarytest.getShelves().size());
		
	}


}