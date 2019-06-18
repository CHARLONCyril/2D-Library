package io.github.oliviercailloux.twod_library.model;

import org.glassfish.jersey.internal.guava.MoreObjects;

public final class SearchData {

	private final String authorRegex;
	private final PublicationRange publication;
	private final String titleRegex;

	public String getAuthorRegex() {
		return authorRegex;
	}

	public PublicationRange getPublication() {
		return publication;
	}

	public String getTitleRegex() {
		return titleRegex;
	}

	private SearchData(String authorRegex1, PublicationRange publication, String titleRegex) {
		this.authorRegex = authorRegex1;
		this.publication = publication;
		this.titleRegex = titleRegex;
	}

	public static SearchData createSearchDataObject(String authorRegex, PublicationRange publication,
			String titleRegex) {
		return new SearchData(authorRegex, publication, titleRegex);
	}

	public String toString() {

		return MoreObjects.toStringHelper(this).add("authorRegex", getAuthorRegex())
				.add("publication", getPublication()).add("titleRegex", getTitleRegex()).toString();
	}

}
