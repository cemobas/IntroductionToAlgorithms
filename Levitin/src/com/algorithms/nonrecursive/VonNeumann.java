package com.algorithms.nonrecursive;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class VonNeumann {
	
	public static Set<Dot> vonNeu = new HashSet<Dot>();

	public static void main(String[] args) {
		int n = Integer.valueOf(args[0]);
		vonNeu.add(new Dot(0,0));
		for(int a=0; a<n+1; ++a) {
			for(int x=0; x<a; ++x) {
				vonNeu.add(new Dot(x, a-x));
				vonNeu.add(new Dot(-x, x-a));
				vonNeu.add(new Dot(a-x, -x));
				vonNeu.add(new Dot(x-a, x));
			}
		}
		printBoard(n);
	}

	public static void printBoard(int n) {
		int[][] board = new int[2*n+3][2*n+3];
		Dot dot;
		Iterator vonNeuIte = vonNeu.iterator();
		while(vonNeuIte.hasNext()) {
			dot = (Dot) vonNeuIte.next();
			board[dot.x+n+1][dot.y+n+1] = 1;
		}
		for(int i=0; i<2*n+3; ++i) {
			for(int j=0; j<2*n+3; ++j) {
				if(board[i][j]!=1){
					board[i][j] = 0;
				}
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
}

class Dot {
	public int x;
	public int y;
	public Dot(int x, int y) {
		this.x=x;
		this.y=y;
	}
	@Override
	public boolean equals(Object obj) {
		Dot dot = (Dot) obj;
		return dot.x == this.x && dot.y == this.y;
	}
	@Override
	public int hashCode() {
		return x*y;
	}
}
