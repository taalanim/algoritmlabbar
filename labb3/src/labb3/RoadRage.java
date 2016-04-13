package labb3;

import java.util.ArrayList;
import java.util.Collections;

public class RoadRage {
	private ArrayList<Road> roads;

	public RoadRage() {
		loadList();
		doTheThing();

	}

	private void loadList() {
		// reader do things

		Collections.sort(roads);
	}

	private void doTheThing() {
		ArrayList<String> connected = new ArrayList<String>();

		for (Road r : roads) {
			if (!r.shouldAdd(connected)) {
				roads.remove(r);
			}
		}

	}

}
