package alg.nonrecursive.vonneumann;

public class VonNeumannDot {
	public final int x;
	public final int y;
	public VonNeumannDot(int x, int y) {
		this.x=x;
		this.y=y;
	}
	@Override
	public boolean equals(Object obj) {
		VonNeumannDot dot = (VonNeumannDot) obj;
		return dot.x == this.x && dot.y == this.y;
	}
	@Override
	public int hashCode() {
		return x*y;
	}
}
