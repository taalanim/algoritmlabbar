package labb4;

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

	public static ArrayList<String> readDoc(String filePath) throws IOException {
		String currentLine = "null";
		URL url = PairMain.class.getResource(filePath);
		ArrayList<String> lines = new ArrayList<String>();
		Scanner scan = null;
		try {
			scan = new Scanner(new File(url.toURI()));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		while (scan.hasNext()) {
			lines.add(scan.next());
		}
		scan.close();
		return lines;
	}

}