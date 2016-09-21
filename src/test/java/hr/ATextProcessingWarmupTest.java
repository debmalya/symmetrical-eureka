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

import org.junit.Assert;
import org.junit.Test;

/**
 * @author debmalyajash
 *
 */
public class ATextProcessingWarmupTest {

	/**
	 * Test method for {@link hr.ATextProcessingWarmup#analyze(java.lang.String)}.
	 */
	@Test
	public void testAnalyze() {
		int[] expecteds = new int[]{1,0,4,0};
		int[] actuals = ATextProcessingWarmup.analyze("Delhi, is a metropolitan and the capital region of India which includes the national capital city, New Delhi. It is the second most populous metropolis in India after Mumbai and the largest city in terms of area.");
		Assert.assertArrayEquals(expecteds, actuals);
		
		expecteds = new int[]{1,0,5,0};
		actuals = ATextProcessingWarmup.analyze("Mumbai, also known as Bombay, is the capital city of the Indian state of Maharashtra. It is the most populous city in India, and the fourth most populous city in the world, with a total metropolitan area population of approximately 20.5 million.");
		Assert.assertArrayEquals(expecteds, actuals);
		
		expecteds = new int[]{1,0,6,1};
		actuals = ATextProcessingWarmup.analyze("The Indian Rebellion of 1857 began as a mutiny of sepoys of the East India Company's army on 10 May 1857, in the town of Meerut, and soon escalated into other mutinies and civilian rebellions largely in the upper Gangetic plain and central India, with the major hostilities confined to present-day Uttar Pradesh, Bihar, northern Madhya Pradesh, and the Delhi region.");
		Assert.assertArrayEquals(expecteds, actuals);
		
		expecteds = new int[]{4,1,13,1};
		actuals = ATextProcessingWarmup.analyze("The Boston Tea Party (referred to in its time simply as \"the destruction of the tea\" or by other informal names and so named until half a century later,[2]) was a political protest by the Sons of Liberty in Boston, a city in the British colony of Massachusetts, against the tax policy of the British government and the East India Company that controlled all the tea imported into the colonies. On December 16, 1773, after officials in Boston refused to return three shiploads of taxed tea to Britain, a group of colonists boarded the ships and destroyed the tea by throwing it into Boston Harbor. The incident remains an iconic event of American history, and other political protests often refer to it.");
	}

}
