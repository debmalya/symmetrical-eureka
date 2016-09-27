/**
 * Copyright 2015-2016 Debmalya Jash
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package hr;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;


/**
 * @author debmalyajash
 *
 */
public class TwoCharactersTest {
	
	/**
	 * Generate String.
	 * Length should be 1000 characters.
	 * Eligible characters are a - z.
	 * @return
	 */
	private String generateString(){
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 1000; i++){
			int remainder = (int) ((Math.random()*26)%26);
			sb.append((char)('a'+remainder));
		}
		return sb.toString();
	}

	/**
	 * Test method for {@link hr.TwoCharacters#removeTwoSimilarAdjacentCharacters()}.
	 */
	@Test
	public void testRemoveTwoSimilarAdjacentCharacters() {
		TwoCharacters.setStr("beabeefead");
		TwoCharacters.removeTwoSimilarAdjacentCharacters();
		Assert.assertEquals("babfad", TwoCharacters.getStr());
		
		TwoCharacters.setStr("abeba");
		TwoCharacters.removeTwoSimilarAdjacentCharacters();
		Assert.assertEquals("abeba", TwoCharacters.getStr());
		
//		System.out.println(generateString());
	}
	
	@Test
	public void testGetLongestAlternateLength(){
		TwoCharacters.setStr("abeba");
		Assert.assertEquals(3, TwoCharacters.getLongestAlternateLength());
		
		TwoCharacters.setStr("beabeefeab");
		TwoCharacters.removeTwoSimilarAdjacentCharacters();
		Assert.assertEquals(5, TwoCharacters.getLongestAlternateLength());
		
		TwoCharacters.setStr("abcdefghijklmnopqrstuvwxyz");
		TwoCharacters.removeTwoSimilarAdjacentCharacters();
		Assert.assertEquals(0, TwoCharacters.getLongestAlternateLength());
		
		TwoCharacters.setStr("a");
		Assert.assertEquals(0, TwoCharacters.getLongestAlternateLength());
		
		TwoCharacters.setStr("pvmaigytciycvjdhovwiouxxylkxjjyzrcdrbmokyqvsradegswrezhtdyrsyhg");
//		Assert.assertEquals(6, TwoCharacters.getLongestAlternateLength());
		
		
	}
	
	@Test
	public void testIsAlternating() {
		Assert.assertTrue(TwoCharacters.altering("beb"));
		Assert.assertFalse(TwoCharacters.altering("bebo"));
	}

}
