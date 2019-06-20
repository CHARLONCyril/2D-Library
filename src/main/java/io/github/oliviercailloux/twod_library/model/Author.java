package io.github.oliviercailloux.twod_library.model;

import java.util.Objects;

import org.glassfish.jersey.internal.guava.MoreObjects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Author is a class that describes the author of a book.
 */
public class Author {

	public static final Logger LOGGER = LoggerFactory.getLogger(Author.class);

	/**
	 * The author's first name.
	 */
	private String firstName;

	/**
	 * The author's last name.
	 */
	private String lastName;

	/**
	 * Author's constructor.
	 * 
	 * @param author's first name
	 * @param author's last name
	 */
	public Author(String lastName, String firstName) {
		this.lastName = lastName;
		this.firstName = firstName;
	}

	/***
	 * @param the author to compare
	 * @return true if the author is equal to the parameter
	 */
	@Override
	public boolean equals(Object author) {
		if (author == null) {
			return false;
		}
		if (author == this) {
			return true;
		}
		if (!(author instanceof Author)) {
			return false;
		}
		Author castedAuthor = (Author) author;
		return this.lastName.equalsIgnoreCase(castedAuthor.lastName)
				&& this.firstName.equalsIgnoreCase(castedAuthor.firstName);
	}

	/**
	 * 
	 * @param regex the string to compare
	 * @return true if author containing in firstName or lastName attributes the
	 *         regex and it's insensitive to case and accents.
	 */
	public boolean checkAuthorRegex(String regex) {
		return getLastName().toLowerCase().contains(regex.toLowerCase()) || getFirstName().toLowerCase().contains(regex)
				|| MakeSearch.isSame(getLastName(), regex) || MakeSearch.isSame(getFirstName(), regex);
	}

	/**
	 * Author's first name getter
	 * 
	 * @return author's first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Author's last name getter
	 * 
	 * @return author's last name
	 */
	public String getLastName() {
		return lastName;
	}

	/***
	 * @return the hashcode of the author
	 */
	@Override
	public int hashCode() {
		return Objects.hash(lastName, firstName);
	}

	/**
	 * Author's first name setter
	 * 
	 * @param author's first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Author's last name setter
	 * 
	 * @param author's last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * using to represent the object Author
	 */
	public String toString() {

		return MoreObjects.toStringHelper(this).add("firstname", getFirstName()).add("lastname", getLastName())
				.toString();
	}
}