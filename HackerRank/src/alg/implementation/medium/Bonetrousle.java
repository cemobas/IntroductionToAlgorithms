package alg.implementation.medium;

import java.util.Scanner;

public class Bonetrousle {

	private static long n[];
	private static long k[];
	private static int b[];
	private static int noOfVisits;
	private static long sum = 0;
	private static long boxes[];

	public static void main(String[] args) {
		console();
		runVisits();
	}

	private static void runVisits() {
		for (int i = 0; i < noOfVisits; ++i) {
			sum = b[i] * (b[i] + 1) / 2;
			boxes = new long[b[i]];
			operateVisit(n[i], k[i], b[i]);
		}
	}

	private static void operateVisit(long n, long k, int b) {
		shop(n, k, b - 1);
		apply(n);
	}

	private static void shop(long n, long k, int boxIndex) {
		for (long i = k; i > 0 && boxIndex >= 0 && i > boxIndex + 1; --i) {
			long tempSum = sum + i - boxIndex - 1;
			if (tempSum == n) {
				boxes[boxIndex--] = i;
				sum = tempSum;
				break;
			} else if (tempSum > n) {
				boxes[boxIndex] = boxIndex + 1;
			} else {
				boxes[boxIndex--] = i;
				sum = tempSum;
			}
		}
		while (boxIndex >= 0) {
			boxes[boxIndex] = 1 + (boxIndex--);
		}
	}

	private static void apply(long n) {
		if (sum == n) {
			for (int i = 0; i < boxes.length; ++i) {
				if (i < boxes.length - 1) {
					System.out.print(boxes[i] + " ");
				} else {
					System.out.print(boxes[i]);
				}
			}
			System.out.println();
		} else {
			System.out.println(-1);
		}
	}

	private static void console() {
		Scanner s = new Scanner(System.in);
		noOfVisits = Integer.valueOf(s.nextLine());
		n = new long[noOfVisits];
		k = new long[noOfVisits];
		b = new int[noOfVisits];
		String visit;
		String[] nkb;
		for (int i = 0; i < noOfVisits; ++i) {
			visit = s.nextLine();
			nkb = visit.split(" ");
			n[i] = Long.valueOf(nkb[0]);
			k[i] = Long.valueOf(nkb[1]);
			b[i] = Integer.valueOf(nkb[2]);
		}
	}

}
