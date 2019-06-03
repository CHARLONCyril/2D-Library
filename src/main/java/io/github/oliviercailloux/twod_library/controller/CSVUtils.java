package io.github.oliviercailloux.twod_library.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @see <a href=
 *      "https://www.mkyong.com/java/how-to-read-and-parse-csv-file-in-java/">how-to-read-and-parse-csv-file-in-java</a>
 */
public class CSVUtils {

	private static final char DEFAULT_SEPARATOR = ',';
	private static final char DEFAULT_QUOTE = '"';

	/**
	 * 
	 * @param p       represent the path of the file
	 * @param csvFile the file to read
	 * @return list containing n list representing the n line of csvFile
	 * @throws Exception
	 */
	public static HashMap<String, Map<String, String>> read(String p, String csvFile) {

		LinkedHashMap<String, Map<String, String>> parsefile = new LinkedHashMap<String, Map<String, String>>();
		Path currentDirectory = Paths.get("").toAbsolutePath();
		Path path = FileSystems.getDefault().getPath(currentDirectory.toString() + p, csvFile);
		try (Scanner scanner = new Scanner(new File(path.toString()))) {
			while (scanner.hasNext()) {
				// convert to char and display it
				String t = scanner.nextLine();
				List<String> line = parseLine(t, DEFAULT_SEPARATOR, DEFAULT_QUOTE);
				LinkedHashMap<String, String> settings = new LinkedHashMap<String, String>();
				for (int i = 1; i < line.size() - 1; i += 2) {
					// System.out.println(line.get(i).toString() + " => " + line.get(i +
					// 1).toString());
					settings.put(line.get(i).toString(), line.get(i + 1).toString());
				}
				parsefile.put(line.get(0).toString(), settings);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return parsefile;

	}

	@SuppressWarnings("null")

	/**
	 * 
	 * @param cvsLine     the line to parse
	 * @param separators  the way to determine each element of a line
	 * @param customQuote useful if a file containing different type of quote
	 * @return
	 */
	public static List<String> parseLine(String csvLine, char separators, char customQuote) {

		List<String> result = new ArrayList<>();

		// if empty, return!
		// System.out.println("csv !!" + csvLine);
		if (csvLine == null && csvLine.isEmpty()) {
			return result;
		}

		StringBuffer curVal = new StringBuffer();
		boolean inQuotes = false;
		boolean startCollectChar = false;
		boolean doubleQuotesInColumn = false;

		char[] chars = csvLine.toCharArray();

		for (char ch : chars) {

			if (inQuotes) {
				startCollectChar = true;
				if (ch == customQuote) {
					inQuotes = false;
					doubleQuotesInColumn = false;
				} else {

					// Fixed : allow "" in custom quote enclosed
					if (ch == '\"') {
						if (!doubleQuotesInColumn) {
							curVal.append(ch);
							doubleQuotesInColumn = true;
						}
					} else {
						curVal.append(ch);
					}

				}
			} else {
				if (ch == customQuote) {

					inQuotes = true;

					// Fixed : allow "" in empty quote enclosed
					if (chars[0] != '"' && customQuote == '\"') {
						curVal.append('"');
					}

					// double quotes in column will hit this!
					if (startCollectChar) {
						curVal.append('"');
					}

				} else if (ch == separators) {

					result.add(curVal.toString());

					curVal = new StringBuffer();
					startCollectChar = false;

				} else if (ch == '\r') {
					// ignore LF characters
					continue;
				} else if (ch == '\n') {
					// the end, break!
					break;
				} else {
					curVal.append(ch);
				}
			}

		}

		result.add(curVal.toString());

		return result;
	}

	public static void writeCSVFile(String file, String filePath, List<List<String>> content) {
		Path currentDirectory = Paths.get("").toAbsolutePath();
		Path path = FileSystems.getDefault().getPath(currentDirectory.toString() + filePath, file);
		RemoveCSVContent(path.toString());
		int numberLine = 1;
		// System.out.println("lacazette" + content.size());

		for (List<String> line : content) {
			// System.out.println("liste" + line);
			boolean carriageReturn = (numberLine == content.size()) ? false : true;
			useBufferedOutPutStream(line, path.toString(), carriageReturn);
			numberLine++;
		}

	}

	/**
	 * 
	 * @param file the file that needs to be emptied
	 */
	public static void RemoveCSVContent(String file) {
		try {

			PrintWriter printwriter =

					new PrintWriter(new FileOutputStream(file));

			printwriter.print("");

			printwriter.close();

		}

		catch (Exception ex) {

			System.out.println("Error clear file" + file);

		}
	}

	/**
	 * Write raw data to a big file - use BufferedOutputStream
	 */
	public static void useBufferedOutPutStream(List<String> content, String filePath, boolean carriageReturn) {
		BufferedOutputStream bout = null;
		// System.out.println(" tttetrtereufyedgfdygfodv" + carriageReturn);
		try {

			bout = new BufferedOutputStream(new FileOutputStream(filePath, true));

			for (String word : content) {
				word += DEFAULT_SEPARATOR;
				System.out.println(word);
				bout.write(word.getBytes());
			}
			if (carriageReturn) {
				bout.write("\n".getBytes());
			}

		} catch (IOException e) {

		} finally {

			if (bout != null) {
				try {
					bout.close();
				} catch (Exception e) {

				}
			}
		}

	}

}
