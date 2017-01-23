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
package he;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author debmalyajash
 *
 */
public class VasyaNMathematicalAnalysisTest {

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**	
	 * Test method for {@link he.VasyaNMathematicalAnalysis#f(long)}.
	 */
	@Test
	public void testF() {
		Assert.assertEquals(1, VasyaNMathematicalAnalysis.f(2));
		Assert.assertEquals(2, VasyaNMathematicalAnalysis.f(4));
		Assert.assertEquals(1, VasyaNMathematicalAnalysis.f(5));
		Assert.assertEquals(3, VasyaNMathematicalAnalysis.f(6));
		Assert.assertEquals(3, VasyaNMathematicalAnalysis.f(9));
	}
	
	@Test
	public void testQ() {
//		long[] arr = new long[]{4,9,9,2};
//		Assert.assertEquals(18, VasyaNMathematicalAnalysis.q(arr, 0, 2));
//		int start = 2 >> 1;
//		System.out.println( start);
//		System.out.println( 5 >> 1);
//		
	}

}
