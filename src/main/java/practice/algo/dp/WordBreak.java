package practice.algo.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WordBreak {

	public static boolean wordBreak(String str, String[] dict) {

		if (str == null || str.length() == 0)
			return false;

		return wordBreakRecursive(str, dict);
	}

	private static boolean wordBreakRecursive(String str, String[] dict) {

		if (str.length() == 0) {
			return true;
		} else {

			for (String word : dict) {

				int len = word.length();

				if (len <= str.length()) {

					if (word.equals(str.substring(0, len))) {

						if (wordBreakRecursive(str.substring(len), dict)) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	public static List<String> wordBreakIterative(String str, String[] dict) {

		List<String> words = new ArrayList<String>();

		if (str == null || str.length() == 0)
			return words;

		int i = 0;
		while (i < str.length()) {

			int start = i;

			for (String word : dict) {

				int end = i + word.length();

				if (end > str.length())
					continue;

				if (word.equals(str.substring(start, end))) {

					i = end;
					words.add(word);
					break;
				}
			}

			if (start == i) {
				i += 1;
			}

		}

		if (i == str.length())
			return words;
		else
			return Collections.emptyList();

	}

}
