package io.github.oliviercailloux.twod_library.controller;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.net.URISyntaxException;

import org.junit.Test;

import io.github.oliviercailloux.twod_library.model.SearchPreferences;

public class CSVUtilsTest {

	@Test
	public void test_parseCSVFile() throws URISyntaxException {
		java.util.List<SearchPreferences> actual = CSVUtils.parseCSVFile(new File(CSVUtils.getURLSettingFile()));
		assertEquals("AUTO", actual.get(0).getBackgroundColor().toString());
		assertEquals("AUTO", actual.get(0).getShelvesColor().toString());
		assertEquals("AUTO", actual.get(0).getBookColor().toString());
		assertEquals("LEANED", actual.get(0).getBookPosition().toString());
		assertEquals("AUTHOR", actual.get(0).getSortType().toString());
		assertEquals("19", String.valueOf(actual.get(0).getNbBookPerShelf()));
	}

}
