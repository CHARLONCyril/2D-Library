package io.github.oliviercailloux.twod_library.controller;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.univocity.parsers.common.processor.RowListProcessor;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import com.univocity.parsers.csv.CsvWriter;
import com.univocity.parsers.csv.CsvWriterSettings;

public class CSVUtils {

	public static final Logger LOGGER = LoggerFactory.getLogger(CSVUtils.class);

	/**
	 * 
	 * @param fileName the name of the file
	 * @return List<String[]> with the value of all
	 * @throws URISyntaxException
	 * @see <a href=
	 *      "https://subscription.packtpub.com/book/big_data_and_business_intelligence/9781787122536/1/ch01lvl1sec15/parsing-comma-separated-value-csv-files-using-univocity">parsing-comma-separated-value-csv-files-using-univocity</a>
	 */
	public static List<String[]> parseCSVFile(String fileName) throws URISyntaxException {
		CsvParserSettings parserSettings = new CsvParserSettings();
		parserSettings.setLineSeparatorDetectionEnabled(true);
		parserSettings.setNumberOfRowsToSkip(1);
		RowListProcessor rowProcessor = new RowListProcessor();
		parserSettings.setProcessor(rowProcessor);
		CsvParser parser = new CsvParser(parserSettings);
		parser.parse(new File(getPathLocation() + "UserPreference.csv"));
		List<String[]> rows = rowProcessor.getRows();
		return rows;
	}

	/**
	 * 
	 * @param fileName the name of the file
	 * @param list     is what we will write inside the file
	 * @throws URISyntaxException
	 * @see <a href=
	 *      "https://www.univocity.com/pages/univocity_parsers_writing.html#writing">univocity_parsers_writing.html#writing</a>
	 */
	public static void writeIntoCSVFile(String fileName, List<List<Object>> list) throws URISyntaxException {
		CsvWriter writer = new CsvWriter(new File(new URI(getPathLocation() + fileName).getPath()),
				new CsvWriterSettings());
		writer.writeHeaders("Background_color", "Shelves_Color", "Books_Color", "Position_of_books", "Sort_books_by",
				"Most_recent_first", "Books_per_shelf");
		writer.writeRowsAndClose(list);
	}

	public static String getPathLocation() {
		return "C:/twod_library/controller/";
	}

	public static void initializeSettingFile(String fileName) throws IOException, URISyntaxException {
		String directoryName = getPathLocation();
		File directory = new File(directoryName);
		if (!directory.exists()) {
			directory.mkdirs();
			Path pathSourceFile = Paths.get(getURLSettingFile(fileName));
			Path pathDestFile = Paths.get(getPathLocation() + fileName);
			Files.copy(pathSourceFile, pathDestFile);
		} else {
			LOGGER.info("The file " + fileName + " already exists.");
		}
	}

	public static URI getURLSettingFile(String fileName) throws URISyntaxException {
		return CSVUtils.class.getResource(fileName).toURI();
	}

}