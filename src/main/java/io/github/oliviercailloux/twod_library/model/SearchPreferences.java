package io.github.oliviercailloux.twod_library.model;

import com.univocity.parsers.annotations.Parsed;

public final class SearchPreferences {
	@Parsed(field = "Background_color")
	private final ColorShade backgroundColor;
	@Parsed(field = "Shelves_Color")
	private final ColorShade bookColor;
	@Parsed(field = "Books_Color")
	private final ColorShade shelvesColor;
	@Parsed(field = "Position_of_books")
	private final BookPosition bookPosition;
	@Parsed(field = "Sort_books_by")
	private final SortType sortType;
	@Parsed(field = "Books_per_shelf")
	private final int nbBookPerShelf;

	public SearchPreferences(ColorShade bK, ColorShade bC, ColorShade sC, BookPosition bP, SortType sT, int nbP) {
		this.backgroundColor = bK;
		this.bookColor = bC;
		this.shelvesColor = sC;
		this.bookPosition = bP;
		this.sortType = sT;
		this.nbBookPerShelf = nbP;

	}

	public ColorShade getBackgroundColor() {
		return backgroundColor;
	}

	public ColorShade getBookColor() {
		return bookColor;
	}

	public ColorShade getShelvesColor() {
		return shelvesColor;
	}

	public BookPosition getBookPosition() {
		return bookPosition;
	}

	public SortType getSortType() {
		return sortType;
	}

	public int getNbBookPerShelf() {
		return nbBookPerShelf;
	}

}
