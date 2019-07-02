package io.github.oliviercailloux.twod_library.main;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.xml.parsers.ParserConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.oliviercailloux.twod_library.controller.CSVUtils;
import io.github.oliviercailloux.twod_library.controller.DataFile;
import io.github.oliviercailloux.twod_library.model.Library;
import io.github.oliviercailloux.twod_library.view.SVGLibrary;
import io.github.oliviercailloux.twod_library.view.Window2DLibrary;

public class Main {

	public static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) throws IOException, ParserConfigurationException, URISyntaxException {
		CSVUtils.initializeSettingFile("DefaultUserPreference.csv");
		DataFile dataFile = new DataFile();
		Library library = new Library(dataFile.read(), 18);
		SVGLibrary svgLibrary = new SVGLibrary(library);
		new Window2DLibrary("2D_LIBRARY PROJECT", svgLibrary);
	}

}