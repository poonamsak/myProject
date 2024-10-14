package project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class FileOpration {

	public static void main(String[] args) throws IOException {
		//Solution 1: Using core java and NIO.
		StringBuffer dataToWrite = readFile();
		try {
			if (Objects.nonNull(dataToWrite))
				writeDataInFile(dataToWrite);
		} catch (IOException e) {
			System.err.println("Error in file operation:  " + e);
		}
		//Solution 2: Using File and stream.
		FileOperationUsingStream();

	}

	private static StringBuffer readFile() {
		Path path = Paths.get("src/main/resources/InputFile.txt");
		StringBuffer data = new StringBuffer();
		StringBuffer dataToWrite = new StringBuffer();
		try (BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"))) {

			String currentLine = null;
			List<String> allLines = Files.readAllLines(path);

			while ((currentLine = reader.readLine()) != null) {// while there is content
				data.append(currentLine).append("\n");
				System.out.println(currentLine); // print the current line
			}
			if (Objects.nonNull(data)) {
				dataToWrite = data;
			}
		} catch (IOException ex) {
			ex.printStackTrace(); // handle an exception here
		}
		return dataToWrite;
	}

	private static void writeDataInFile(StringBuffer content) throws IOException {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/OutputFile.txt"))) {
			writer.write(content.reverse().toString().trim());
			System.out.println("Data write operation is done successfully...");
		}
	}

	private static void FileOperationUsingStream() throws IOException {
		Path inputPath = Paths.get("src/main/resources/InputFile.txt");
		Path outputPath = Paths.get("src/main/resources/OutputFileUsingStream.txt");

		try {
			// Read all lines from the input file
			List<String> lines = Files.readAllLines(inputPath);

			// Reverse each string in the list
			List<String> reversedList = lines.stream().map(str -> new StringBuilder(str).reverse().toString())
					.collect(Collectors.toList());

			// Write all lines to the output file
			if (Objects.nonNull(reversedList)) {
				Files.write(outputPath, reversedList);
				System.out.println("File content write successfully!");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
