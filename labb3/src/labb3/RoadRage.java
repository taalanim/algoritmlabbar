package labb3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class RoadRage {
	private ArrayList<Road> roads;
	private HashMap<String, Integer> cities;
	private ArrayList<Integer> connected;
	private int nextGroup;
	private int totalSpan;
	
	public RoadRage() {
		loadLists();
		doTheThing();
		for(Road r: roads){
		System.out.println(r.getC1()+ " -- " +r.getC2()+": "+r.getLength());	
		}
		System.out.println("total length is: "+totalSpan);
	}

	private void loadLists() {
		roads = new ArrayList<Road>();
		ArrayList<String> temp = new ArrayList<String>();
		try {
			temp = Reader.readDocRoads("USA-highway-miles.in");
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (String s : temp) {
			roads.add(new Road(s));
		}
		cities = new HashMap<String, Integer>();
		try {
			temp.clear();
			temp = Reader.readDocCities("USA-highway-miles.in");
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (String s : temp) {
			cities.put(s.trim(), 0);
		}
		roads.sort(new RoadComparator());
	}

	private void doTheThing() {
		nextGroup = 1;
		String currentC1;
		String currentC2;
		for (int i = 0; i < roads.size(); i++) {
			currentC1 = roads.get(i).getC1();
			currentC2 = roads.get(i).getC2();
			if (cities.get(currentC1) == 0) {
				if (cities.get(currentC2) == 0) {
					cities.put(currentC1, nextGroup);
					cities.put(currentC2, nextGroup);
					nextGroup++;
					totalSpan = totalSpan + roads.get(i).getLength();
				} else {
					cities.put(currentC1, cities.get(currentC2));
					totalSpan = totalSpan + roads.get(i).getLength();
				}
			} else {
				if (cities.get(currentC2) == 0) {
					cities.put(currentC2, cities.get(currentC1));
					totalSpan = totalSpan + roads.get(i).getLength();
				} else {
					int oldC2 = cities.get(currentC2);
					int newC2 = cities.get(currentC1);
					if (oldC2 == newC2) {
						roads.remove(i);
						i--;
					} else {
						totalSpan = totalSpan + roads.get(i).getLength();
						for (String s : cities.keySet()) {
							if (cities.get(s) == oldC2) {
								cities.put(s, newC2);
							}
						}
					}
				}
			}
		}
	}
}
