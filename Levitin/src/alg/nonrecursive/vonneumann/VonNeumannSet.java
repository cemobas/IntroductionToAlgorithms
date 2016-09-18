package alg.nonrecursive.vonneumann;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class VonNeumannSet {
	private Set<VonNeumannDot> vonNeuSet = new HashSet<VonNeumannDot>();

	public void addNewDot(int x, int y) {
		if(vonNeuSet.contains(new VonNeumannDot(x, y))) {
			System.out.println("Repeating step: " + x + ", " + y);
		}
		vonNeuSet.add(new VonNeumannDot(x, y));
	}
	
	public Iterator<VonNeumannDot> iterator() {
		return vonNeuSet.iterator();
	}
}
