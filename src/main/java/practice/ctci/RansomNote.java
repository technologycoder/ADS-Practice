package practice.ctci;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {

	Map<String, Integer> magazineMap;
	Map<String, Integer> noteMap;

	public RansomNote(String magazine, String note) {

		magazineMap = new HashMap<>();

		for (String magazineWord : magazine.split(" ")) {
			if (!magazineMap.containsKey(magazineWord)) {
				magazineMap.put(magazineWord, 0);
			}

			magazineMap.put(magazineWord, magazineMap.get(magazineWord) + 1);

		}

		noteMap = new HashMap<>();

		for (String noteWord : note.split(" ")) {
			if (!noteMap.containsKey(noteWord)) {
				noteMap.put(noteWord, 0);
			}

			noteMap.put(noteWord, noteMap.get(noteWord) + 1);
		}

	}

	public boolean solve() {

		for (String noteWord : noteMap.keySet()) {

			if (!magazineMap.containsKey(noteWord) || noteMap.get(noteWord) > magazineMap.get(noteWord)) {

				return false;

			}
		}

		return true;
	}

	public static void main(String[] args) {

		RansomNote ransomNote = new RansomNote("give me one grand today night", "give one grand today");

		System.out.println(ransomNote.solve());

		System.out.println("DONE");

	}

}
