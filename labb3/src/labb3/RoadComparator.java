package labb3;

import java.util.Comparator;

public class RoadComparator implements Comparator<Road>{

	
	@Override
	public int compare(Road o1, Road o2) {
		return Integer.compare(o1.range, o2.range);
	}

}
