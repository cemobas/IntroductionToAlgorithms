package alg.implementation.medium;

import java.util.ArrayList;
import java.util.Scanner;

public class BiggerIsGreater {

	private static final ArrayList<String> words = new ArrayList<String>();

	public static void main(String[] args) {
		console();
		for (String word : words) {
			String newWord = convertWord(word);
			System.out.println(newWord.equals(word) ? "no answer" : newWord);
		}
	}

	private static void console() {
		final Scanner s = new Scanner(System.in);
		int noOfWords = Integer.valueOf(s.nextLine());
		for (int i = 0; i < noOfWords; ++i) {
			words.add(s.nextLine());
		}
	}

	private static String convertWord(String word) {
		char[] letters = new char[word.length()];
		boolean insertionSort = true;
		for (int i = word.length() - 1; i >= 0; --i) {
			letters[i] = word.charAt(i);
			if (insertionSort) {
				int j;
				for (j = i; j + 1 < word.length(); ++j) {
					if (letters[j] > letters[j + 1]) {
						letters = swapChars(j, j + 1, letters);
					} else if (letters[j] == letters[j + 1]) {
						// do nothing
					} else {
						break;
					}
				}
				if (j + 1 < word.length()) {
					letters = shiftCharToHead(i, j + 1, letters);
					insertionSort = false;
				}
			}
		}
		if (insertionSort) {
			return "no answer";
		} else {
			return String.copyValueOf(letters);
		}
	}

	private static char[] swapChars(int a, int b, char[] letters) {
		char temp = letters[a];
		letters[a] = letters[b];
		letters[b] = temp;
		return letters;
	}

	private static char[] shiftCharToHead(int head, int index, char[] letters) {
		char temp = letters[index];
		for (int i = index; i > head; --i) {
			letters[i] = letters[i - 1];
		}
		letters[head] = temp;
		return letters;
	}

}
