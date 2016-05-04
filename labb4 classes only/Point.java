package labb4;

import java.util.Comparator;

public class Point implements Comparator<Point>, Comparable<Point> {
	private double x;
	private double y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Point() {
		// :(
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public boolean distCheck(double delta, double xStar) {
		if (Math.abs(this.x - xStar) <= delta) {
			return true;
		} else {
			return false;
		}
	}

	public double distanceTo(Point other) {
		return Math.hypot(other.x - x, other.y - y);
	}

	public double distanceTo(double x, double y) {
		return Math.hypot(this.x - x, this.y - y);
	}

	public int compareTo(Point other) {
		if (other.getY() > y) {
			return -1;

		} else if (y > other.getY()) {
			return 1;
		} else {
			return 0;
		}
	}

	public int compare(Point current, Point other) {
		if (other.getX() > x) {
			return -1;

		} else if (x > other.getX()) {
			return 1;
		} else {
			return 0;
		}
	}
}
