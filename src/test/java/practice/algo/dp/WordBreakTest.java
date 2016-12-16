package practice.algo.dp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class WordBreakTest {

	private String[] dict = new String[] { "dog", "cat", "ball", "bat", "tree" };

	@Test
	public void wordBreak_1() {

		String str = "balldog";
		assertTrue(WordBreak.wordBreak(str, dict));

	}

	@Test
	public void wordBreak_2() {

		String str = "balld";
		assertFalse(WordBreak.wordBreak(str, dict));

	}

	@Test
	public void wordBreak_3() {

		String str = "";
		assertFalse(WordBreak.wordBreak(str, dict));

	}

	@Test
	public void wordBreakIterative_1() {

		String str = "balldog";
		assertEquals(Arrays.asList("ball", "dog"), WordBreak.wordBreakIterative(str, dict));

	}

	@Test
	public void wordBreakIterative_2() {

		String str = "cattreeball";
		assertEquals(Arrays.asList("cat", "tree", "ball"), WordBreak.wordBreakIterative(str, dict));

	}

}
