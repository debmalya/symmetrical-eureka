package cf;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class WordNumTest {
	
	WordNum wordNum = new WordNum();

	@Test
	public void testWord2Num() {
		assertEquals(100,wordNum.word2Num("one hundred"));
		assertEquals(144,wordNum.word2Num("One hundred forty four"));
		assertEquals(123456,wordNum.word2Num("One hundred Twenty three thousand, Four hundred and fifty-six"));
		assertEquals(987654321,wordNum.word2Num("Nine hundred eighty seven million six hundred fifty-four thousand three hundred and twenty one"));
	}

	@Test
	public void testEachWord() {
		assertEquals(1,wordNum.word2Num("One"));
	}

}
