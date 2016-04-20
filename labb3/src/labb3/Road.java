package labb3;

import java.util.ArrayList;

public class Road {

	private String endPoint1;
	private String endPoint2;
	public int range;

	public Road(String input) {
		String temp = input.substring(0,input.indexOf('[')-1);
		String[] split = temp.split("--");
		endPoint1 = split[0];
		endPoint2 = split[1];
		range = Integer.parseInt(input.substring(input.indexOf('[')+1,input.length()-1));
		
		
		
//		String[] split = input.split("[");
//		String[] endpoints = split[1].split("--");
//		endPoint1 = endpoints[0];
//		endPoint2 = endpoints[1];
//		range = Integer.parseInt(split[1].substring(0, split[1].length() - 2));
	}

	public int getLength() {
		return range;
	}

	public String getC1() {
		return endPoint1;
	}

	public String getC2() {
		return endPoint2;
	}
	/*
	 * public int compareTo(Object arg0) { int a = range - ((Road) arg0).range;
	 * if (a == 0) { return a; } else { return a / a; } } public boolean
	 * shouldAdd(ArrayList<String> cities, ArrayList<Integer> groups) {
	 * 
	 * int aGrouping = groups.get(cities.indexOf(endpoint1)); int bGrouping =
	 * groups.get(cities.indexOf(endpoint2));
	 * 
	 * if (aGrouping == bGrouping) { return false; } else { for (int toCheck :
	 * groups) { if (toCheck == bGrouping) { toCheck = aGrouping;
	 * 
	 * } }
	 * 
	 * return true; }
	 * 
	 * }
	 * 
	 * public int getrange() { // TODO Auto-generated method stub return range;
	 * } }
	 * 
	 * 
	 * public boolean shouldAdd(ArrayList<String> connected) { boolean
	 * firstPoint = false; boolean secondPoint = false;
	 * 
	 * for (String s : connected) { if (!firstPoint) { firstPoint =
	 * s.equals(endpoint1); } if (!secondPoint) { secondPoint =
	 * s.equals(endpoint2); } if (firstPoint && secondPoint) { return false; } }
	 * 
	 * if (!firstPoint) { connected.add(endpoint1); } if (!secondPoint) {
	 * connected.add(endpoint2); }
	 * 
	 * return true; }
	 */
}