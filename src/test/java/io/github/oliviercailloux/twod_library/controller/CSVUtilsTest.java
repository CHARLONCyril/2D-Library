package io.github.oliviercailloux.twod_library.controller;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class CSVUtilsTest {
	private static final char DEFAULT_SEPARATOR = ',';
	private static final char DEFAULT_QUOTE = '"';

	@Test
	public void test_parsing_line() {

		String line = "Background Color :,Auto,false";
		List<String> result = CSVUtils.parseLine(line, DEFAULT_SEPARATOR, DEFAULT_QUOTE);

		assertEquals(3, result.size());
		assertEquals("Background Color :", result.get(0));
		assertEquals("Auto", result.get(1));
		assertEquals("false", result.get(2));

	}

	@Test
	public void test_reading_file() {
		HashMap<String, Map<String, String>> UserSettings = CSVUtils.read("/src/main/resources/controller/",
				"UserPreference.csv");
		assertEquals(6, UserSettings.size());
		HashMap<String, String> expectedKey = new HashMap<String, String>();
		expectedKey.put("Auto", "false");
		expectedKey.put("Light", "true");
		expectedKey.put("Dark", "false");
		assertEquals(UserSettings.get("Background Color :").toString(), expectedKey.toString());
	}

}
