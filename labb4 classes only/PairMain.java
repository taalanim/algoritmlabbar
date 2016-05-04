package labb4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PairMain {
	List<Point> pointsByX;
	ArrayList<String> lines;

	public static void main(String[] args) {
		PairMain m = new PairMain();
		m.run("brd14051.tsp");
	}

	public ArrayList<String> trim(ArrayList<String> list) {
		ArrayList<String> temp = new ArrayList<String>();
		boolean skip = false;
		int counter = 0;
		String[] tool = new String[3];
		for (String s : list) {
			if (s.contains("NODE_COORD_SECTION")) {
				skip = true;
			} else if (s.contains("EOF")) {
				break;
			} else if (skip) {
				tool[counter] = s;
				counter = (counter + 1) % 3;
				if (counter == 0) {
					temp.add(tool[0] + " " + tool[1] + " " + tool[2]);
				}
			}
		}
		return temp;
	}

	public void run(String file) {
		pointsByX = new ArrayList<Point>();
		try {
			lines = Reader.readDoc(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		lines = trim(lines);
		parser(lines);
		Collections.sort(pointsByX, new Point());
		System.out.println(algorithm(pointsByX));
	}

	public double checkSmall(List<Point> points) {
		double temp = 0;
		if (points.size() == 3) {
			temp = points.get(0).distanceTo(points.get(1));
			if (points.get(1).distanceTo(points.get(2)) < temp) {
				temp = points.get(1).distanceTo(points.get(2));
			} else if (points.get(0).distanceTo(points.get(2)) < temp) {
				temp = points.get(0).distanceTo(points.get(2));
			}
		} else if (points.size() == 2) {
			temp = points.get(0).distanceTo(points.get(1));
		}
		return temp;
	}

	public double algorithm(List<Point> x) {
		if (Math.abs(x.size()) <= 3) {
			return checkSmall(x);
		}
		List<Point> qXPoint = new ArrayList<Point>();
		List<Point> rXPoint = new ArrayList<Point>();
		int n = x.size() / 2;
		for (int i = 0; i < n; i++) {
			qXPoint.add(x.get(i));
		}

		for (int i = n; i < x.size(); i++) {
			rXPoint.add(x.get(i));
		}
		double qMin = algorithm(qXPoint);
		double rMin = algorithm(rXPoint);
		double delta = (qMin < rMin) ? qMin : rMin;
		double xStar = qXPoint.get(qXPoint.size() - 1).getX();
		List<Point> sY = new ArrayList<Point>();
		for (Point p : x) {
			if (p.distCheck(delta, xStar)) {
				sY.add(p);
			}
		}
		double sYMinDist = Double.MAX_VALUE;
		for (int i = 0; i < sY.size(); i++) {
			Point yPoint = sY.get(i);
			for (int j = i + 1; j < sY.size(); j++) {
				Point pointToCheck = sY.get(j);
				if (yPoint.distanceTo(pointToCheck) < sYMinDist) {
					sYMinDist = yPoint.distanceTo(sY.get(j));
				}
			}
		}
		if (sYMinDist < delta) {
			return sYMinDist;
		} else if (qMin < rMin) {
			return qMin;
		} else {
			return rMin;
		}
	}

	public void parser(ArrayList<String> lines) {

		for (String s : lines) {
			String[] current = s.split(" ");
			int counter = 0;
			double x = 0;
			double y = 0;
			for (String s2 : current) {
				if (!s2.isEmpty()) {
					if (counter == 1) {
						x = Double.parseDouble(s2);
					} else if (counter == 2) {
						y = Double.parseDouble(s2);
					}
					counter++;
				}
			}
			pointsByX.add(new Point(x, y));
		}
	}

}
