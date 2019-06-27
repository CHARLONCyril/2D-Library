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

import com.univocity.parsers.common.processor.BeanListProcessor;
import com.univocity.parsers.common.processor.BeanWriterProcessor;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import com.univocity.parsers.csv.CsvWriter;
import com.univocity.parsers.csv.CsvWriterSettings;

import io.github.oliviercailloux.twod_library.model.SearchPreferences;

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
	public static List<SearchPreferences> parseCSVFile(File fileName) throws URISyntaxException {
		CsvParserSettings parserSettings = new CsvParserSettings();
		parserSettings.setLineSeparatorDetectionEnabled(true);
		parserSettings.setHeaderExtractionEnabled(true);
		BeanListProcessor<SearchPreferences> rowProcessor = new BeanListProcessor<>(SearchPreferences.class);
		parserSettings.setProcessor(rowProcessor);
		CsvParser parser = new CsvParser(parserSettings);
		parser.parse(fileName);
		return rowProcessor.getBeans();
	}

	/**
	 * 
	 * @param fileName the name of the file
	 * @param list     is what we will write inside the file
	 * @throws URISyntaxException
	 * @see <a href=
	 *      "https://www.univocity.com/pages/univocity_parsers_writing.html#writing">univocity_parsers_writing.html#writing</a>
	 */
	public static void writeIntoCSVFile(String fileName, List<SearchPreferences> list) throws URISyntaxException {
		CsvWriterSettings settings = new CsvWriterSettings();
		settings.setRowWriterProcessor(new BeanWriterProcessor<>(SearchPreferences.class));
		settings.setHeaders("Background_color", "Shelves_Color", "Books_Color", "Position_of_books", "Sort_books_by",
				"Books_per_shelf");
		CsvWriter writer = new CsvWriter(new File(new URI(getPathLocation() + fileName).getPath()), settings);
		writer.writeHeaders();
		writer.processRecords(list);
		writer.close();
	}

	public static Path getPathLocation() {
		return Paths.get(new File("C:/twod_library/controller/").toURI());
	}

	public static void initializeSettingFile(String fileName) throws IOException, URISyntaxException {
		Path directoryName = getPathLocation();
		File directory = new File(directoryName.toString());
		if (!directory.exists()) {
			directory.mkdirs();
			Path pathSourceFile = Paths.get(getURLSettingFile());
			Path pathDestFile = Paths.get(getPathLocation() + fileName);
			Files.copy(pathSourceFile, pathDestFile);
		} else {
			LOGGER.info("The file " + fileName + " already exists.");
		}
	}

	public static URI getURLSettingFile() throws URISyntaxException {
		return CSVUtils.class.getResource("DefaultUserPreference.csv").toURI();
	}

}