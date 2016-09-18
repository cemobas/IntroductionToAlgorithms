package alg.nonrecursive.vonneumann;

public class VonNeumannMain {

	public static void main(String[] args) {
		int n = Integer.valueOf(args[0]);
		VonNeumannBoard board = new VonNeumannBoard(n);
		board.build();
		board.printBoard();
	}
}
