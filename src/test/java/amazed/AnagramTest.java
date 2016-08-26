package amazed;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;



public class AnagramTest {

	@Test
	public void testIsAnagram() {
		
		List<String> wordList = new ArrayList<>();
		wordList.add("stop");
		wordList.add("tops");
		wordList.add("pots");
		Assert.assertTrue(Anagram.isAnagram(wordList));
		
		wordList.add("false");
		Assert.assertFalse(Anagram.isAnagram(wordList));
	}

}
