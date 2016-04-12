package labb3;

public class Road implements Comparable {

	private String endpoint1;
	private String endpoint2;
	private int range;

	public Road(String input) {
		dissasamble(input);
	}

	@Override
	public int compareTo(Object arg0) {
		int a = range - ((Road) arg0).range;
		if (a == 0) {
			return a;
		} else {
			return a / a;
		}
	}

	private void dissasamble(String info) {

		String[] firstsplit = info.split("--");
		String[] secondsplit = firstsplit[1].split(" ");
		endpoint1 = firstsplit[0];
		endpoint2 = secondsplit[0];

		range = Integer.parseInt(secondsplit[1].substring(1, secondsplit[1].length() - 1));

	}
}
