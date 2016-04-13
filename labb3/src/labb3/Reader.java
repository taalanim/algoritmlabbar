package labb3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {
	public static void writeToFile(String out, String filePath) throws IOException {
		FileWriter writer = new FileWriter(filePath, false);
		writer.write(out);
		writer.close();
	}

	public static void writeToFile(int out, String filePath) throws IOException {
		FileWriter writer = new FileWriter(filePath, false);
		writer.write(out);
		writer.close();
	}

	public static ArrayList<String> readDocRoads(String filePath) throws IOException {
		URL url = RoadRage.class.getResource(filePath);
		ArrayList<String> lines = new ArrayList<String>();
		Scanner scan = null;
		try {
			scan = new Scanner(new File(url.toURI()));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		while (scan.hasNext()) {
			lines.add(scan.nextLine());
		}
		scan.close();
		for (String s : lines) {
			if (s.contains("--") || s.isEmpty()) {
				lines.remove(s);
			} else{
				System.out.println(s);
			}
		}
		return lines;
	}
}