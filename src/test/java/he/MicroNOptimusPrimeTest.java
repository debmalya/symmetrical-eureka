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

import java.util.Set;

import org.junit.After;
import org.junit.Test;

/**
 * @author debmalyajash
 *
 */
public class MicroNOptimusPrimeTest {

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link he.MicroNOptimusPrime#getPrimeFactors(int)}.
	 */
	@Test
	public void testGetPrimeFactors() {
		Set<Long> result = MicroNOptimusPrime.getPrimeFactors(2);
		System.out.println(result);
	}

}
