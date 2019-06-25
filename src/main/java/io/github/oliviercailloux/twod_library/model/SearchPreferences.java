package io.github.oliviercailloux.twod_library.model;

public class SearchPreferences {
	private ColorShade backgroundColor;
	private ColorShade bookColor;
	private ColorShade shelvesColor;
	private BookPosition bookPosition;
	private SortType sortType;
	private int nbBookPerShelf;

	public SearchPreferences(ColorShade bk, ColorShade bc, ColorShade sh, BookPosition bp, SortType s, int nbBook) {
		this.backgroundColor = bk;
		this.bookColor = bc;
		this.shelvesColor = sh;
		this.bookPosition = bp;
		this.sortType = s;
		this.nbBookPerShelf = nbBook;
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
