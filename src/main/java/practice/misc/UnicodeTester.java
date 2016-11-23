package practice.misc;

public class UnicodeTester {
	public static void main(String[] args) {

		String t = "\uD801\uDC00";

		System.out.println(t);

		char[] arr = Character.toChars(0x10400);

		for (char c : arr) {
			System.out.println(Character.getNumericValue(c));
		}

		String hex = "00a5";
		int intValue = Integer.parseInt(hex, 16);
		System.out.println((char) intValue);

	}
}
