package io.github.oliviercailloux.twod_library.controller;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.univocity.parsers.common.processor.RowListProcessor;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import com.univocity.parsers.csv.CsvWriter;
import com.univocity.parsers.csv.CsvWriterSettings;

public class CSVUtils {

	/**
	 * 
	 * @param fileName the name of the file
	 * @return HashMap with key representing the name of the attribute and values
	 *         representing the value chosen by the user.
	 * @throws URISyntaxException
	 * @see <a href=
	 *      "https://subscription.packtpub.com/book/big_data_and_business_intelligence/9781787122536/1/ch01lvl1sec15/parsing-comma-separated-value-csv-files-using-univocity">parsing-comma-separated-value-csv-files-using-univocity</a>
	 */
	public static Map<String, Map<String, String>> parseCSVFile(String fileName) throws URISyntaxException {
		CsvParserSettings parserSettings = new CsvParserSettings();
		parserSettings.setLineSeparatorDetectionEnabled(true);
		RowListProcessor rowProcessor = new RowListProcessor();
		parserSettings.setProcessor(rowProcessor);
		CsvParser parser = new CsvParser(parserSettings);
		URL resourceUrl = CSVUtils.class.getResource(fileName);
		parser.parse(new File(new URI(resourceUrl.getPath()).getPath()));
		List<String[]> rows = rowProcessor.getRows();
		return convertListToMap(rows);
	}

	/**
	 * 
	 * @param fileName the name of the file
	 * @param content  is what we will write inside the file
	 * @throws URISyntaxException
	 * @see <a href=
	 *      "https://www.univocity.com/pages/univocity_parsers_writing.html#writing">univocity_parsers_writing.html#writing</a>
	 */
	public static void writeIntoCSVFile(String fileName, List<List<String>> content) throws URISyntaxException {
		URL resourceUrl = CSVUtils.class.getResource(fileName);
		CsvWriter writer = new CsvWriter(new File(new URI(resourceUrl.getPath()).getPath()), new CsvWriterSettings());
		writer.writeRowsAndClose(content);
	}

	/**
	 * 
	 * @param content is a list containing array of strings
	 * @return the HashMap associated
	 */
	public static Map<String, Map<String, String>> convertListToMap(List<String[]> content) {

		LinkedHashMap<String, Map<String, String>> parsefile = new LinkedHashMap<String, Map<String, String>>();
		for (int i = 0; i < content.size(); i++) {
			LinkedHashMap<String, String> settings = new LinkedHashMap<String, String>();
			for (int j = 1; j < content.get(i).length - 1; j += 2) {
				settings.put(content.get(i)[j], content.get(i)[j + 1]);
			}
			parsefile.put(content.get(i)[0], settings);
		}

		return parsefile;

	}

}