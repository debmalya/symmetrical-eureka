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
package hr.machine.learning;

<<<<<<< HEAD:src/main/java/hr/machine/learning/DeterministicUrlHashTagSegmentationTest.java


import org.junit.Assert;
=======
import org.junit.BeforeClass;
>>>>>>> 98904c3c60f3058dcc4ad9e2a308238fd260d227:src/test/java/hr/machine/learning/DeterministicUrlHashTagSegmentationTest.java
import org.junit.Test;

/**
 * @author debmalyajash
 *
 */
public class DeterministicUrlHashTagSegmentationTest {
	
	@BeforeClass
	public  static void setUp(){
		DeterministicUrlHashTagSegmentation.setWordList();
	}

	/**
	 * Test method for {@link hr.machine.learning.DeterministicUrlHashTagSegmentation#getSegmenetation(java.lang.String)}.
	 */
	@Test
	public final void testGetSegmenetation() {
<<<<<<< HEAD:src/main/java/hr/machine/learning/DeterministicUrlHashTagSegmentationTest.java
		Assert.assertEquals("is it time", DeterministicUrlHashTagSegmentation.getSegmenetation("#isittime"));
=======
//		DeterministicUrlHashTagSegmentation.getSegmenetation("#isittime");
>>>>>>> 98904c3c60f3058dcc4ad9e2a308238fd260d227:src/test/java/hr/machine/learning/DeterministicUrlHashTagSegmentationTest.java
		DeterministicUrlHashTagSegmentation.getSegmenetation("www.whatismyname.com");
	}

}
