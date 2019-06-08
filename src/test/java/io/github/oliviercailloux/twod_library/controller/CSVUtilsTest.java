package io.github.oliviercailloux.twod_library.controller;

import static org.junit.Assert.assertEquals;

import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class CSVUtilsTest {

	public void test_parseCSVFile() throws URISyntaxException {
		HashMap<String, Map<String, String>> UserSettings;
		try {
			UserSettings = CSVUtils.parseCSVFile("UserPreferenceTest.csv");
		} catch (URISyntaxException e) {
			throw e;
		}
		assertEquals(1, UserSettings.size());
		HashMap<String, String> expectedKey = new HashMap<String, String>();
		expectedKey.put("Auto", "true");
		expectedKey.put("Light", "false");
		expectedKey.put("Dark", "false");
		assertEquals(UserSettings.get("Background Color :").toString(), expectedKey.toString());
	}

	@Test
	public void test_writeIntoCSVFile() throws URISyntaxException {

		List<List<String>> expected = Arrays
				.asList(Arrays.asList("Background Color :", "Auto", "true", "Light", "false", "Dark", "false"));
		try {
			CSVUtils.writeIntoCSVFile("UserPreferenceTest.csv", expected);
		} catch (URISyntaxException e) {
			throw e;
		}
		test_parseCSVFile();
	}

}
