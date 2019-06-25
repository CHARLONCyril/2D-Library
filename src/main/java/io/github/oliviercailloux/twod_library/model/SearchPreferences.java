package io.github.oliviercailloux.twod_library.model;

import com.univocity.parsers.annotations.Parsed;

public class SearchPreferences {
	@Parsed(field = "Background_color")
	private ColorShade backgroundColor;
	@Parsed(field = "Shelves_Color")
	private ColorShade bookColor;
	@Parsed(field = "Books_Color")
	private ColorShade shelvesColor;
	@Parsed(field = "Position_of_books")
	private BookPosition bookPosition;
	@Parsed(field = "Sort_books_by")
	private SortType sortType;
	@Parsed(field = "Books_per_shelf")
	private int nbBookPerShelf;

	public SearchPreferences() {
	}

	public ColorShade getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(ColorShade backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public ColorShade getBookColor() {
		return bookColor;
	}

	public void setBookColor(ColorShade bookColor) {
		this.bookColor = bookColor;
	}

	public ColorShade getShelvesColor() {
		return shelvesColor;
	}

	public void setShelvesColor(ColorShade shelvesColor) {
		this.shelvesColor = shelvesColor;
	}

	public BookPosition getBookPosition() {
		return bookPosition;
	}

	public void setBookPosition(BookPosition bookPosition) {
		this.bookPosition = bookPosition;
	}

	public SortType getSortType() {
		return sortType;
	}

	public void setSortType(SortType sortType) {
		this.sortType = sortType;
	}

	public int getNbBookPerShelf() {
		return nbBookPerShelf;
	}

	public void setNbBookPerShelf(int nbBookPerShelf) {
		this.nbBookPerShelf = nbBookPerShelf;
	}

}
